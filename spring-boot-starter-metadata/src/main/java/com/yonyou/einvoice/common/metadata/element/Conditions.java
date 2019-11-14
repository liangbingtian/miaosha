package com.yonyou.einvoice.common.metadata.element;

import com.yonyou.einvoice.common.metadata.enums.OperatorEnum;
import com.yonyou.einvoice.common.metadata.visitor.IMetaElement;
import com.yonyou.einvoice.common.metadata.visitor.IVisitor;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.springframework.util.CollectionUtils;


public class Conditions implements IMetaElement {

  /**
   * 前端通过graphql拼接的查询条件列表
   */
  @GraphQLNonNull
  List<Condition> conditionList = new ArrayList<>();


  /**
   * 权限认证相关condition。无需在accept中添加访问。
   * 该字段的值由PermissionVisitor添加
   */

  List<Condition> authConditions;

  @Override
  public void accept(IVisitor visitor) {
    if (CollectionUtils.isEmpty(conditionList)) {
      return;
    }
    /**
     * 此处只需对conditions添加访问者模式的判断。
     * authConditions为在其他visitor中添加的，无需在此处添加visit
     */
    conditionList.forEach(condition -> visitor.visit(condition));
  }

  public void setConditionList(List<Condition> conditionList) {
    this.conditionList = conditionList;
  }

  @GraphQLIgnore
  public void setAuthConditions(
      List<Condition> authConditions) {
    this.authConditions = authConditions;
  }

  @GraphQLIgnore
  public List<Condition> getAuthConditions() {
    return authConditions;
  }

  @GraphQLQuery
  public List<Condition> getConditionList() {
    return conditionList;
  }

  @GraphQLIgnore
  public static ConditionsBuilder builder() {
    return new ConditionsBuilder();
  }

  public static class ConditionsBuilder {

    private ConditionsBuilder() {

    }

    List<Condition> conditionList = new ArrayList<>();

    private Condition tmpCondition = null;

    private Stack<Condition> preConditionStack = new Stack<>();

    private Stack<OperatorEnum> operatorEnumStack = new Stack<>();

    public ConditionsBuilder andStart() {
      addCondition();
      operatorEnumStack.push(OperatorEnum.AND);
      tmpCondition = new Condition();
      tmpCondition.setOperator(OperatorEnum.AND);
      preConditionStack.push(tmpCondition);
      tmpCondition = null;
      return this;
    }

    public ConditionsBuilder andEnd() {
      addCondition();
      operatorEnumStack.pop();
      tmpCondition = preConditionStack.pop();
      addCondition();
      tmpCondition = null;
      return this;
    }

    public ConditionsBuilder orStart() {
      addCondition();
      operatorEnumStack.push(OperatorEnum.OR);
      tmpCondition = new Condition();
      tmpCondition.setOperator(OperatorEnum.OR);
      preConditionStack.push(tmpCondition);
      tmpCondition = null;
      return this;
    }

    public ConditionsBuilder orEnd() {
      addCondition();
      operatorEnumStack.pop();
      tmpCondition = preConditionStack.pop();
      addCondition();
      tmpCondition = null;
      return this;
    }

    /**
     * 拼接where条件的操作符前面部分。例如：t0.a != 1，则sourceAlias为t0，sourceField为a
     *
     * @param sourceAlias
     * @param sourceField
     * @return
     */
    public ConditionsBuilder fieldCondition(String sourceAlias, String sourceField) {
      addCondition();
      tmpCondition = new Condition();
      Field conditionField = new Field();
      conditionField.setSourceAlias(sourceAlias);
      conditionField.setField(sourceField);
      tmpCondition.setSourceField(conditionField);
      return this;
    }

    /**
     * condition条件判断类型
     *
     * @param operatorEnum
     * @return
     */
    public ConditionsBuilder operator(OperatorEnum operatorEnum) {
      tmpCondition.setOperator(operatorEnum);
      return this;
    }

    /**
     * in、not in语句等使用
     *
     * @param list
     * @return
     */
    public ConditionsBuilder listValue(List list) {
      Value val = new Value();
      val.setList(list);
      tmpCondition.setV1(val);
      return this;
    }

    /**
     * 用于where语句中添加表连接查询。如：where t0.id = t1.hid
     *
     * @param sourceAlias
     * @param sourceField
     * @return
     */
    public ConditionsBuilder fieldValue(String sourceAlias, String sourceField) {
      Field field = new Field();
      field.setSourceAlias(sourceAlias);
      field.setField(sourceField);
      Value value = new Value();
      value.setField(field);
      tmpCondition.setV1(value);
      return this;
    }

    /**
     * in一个子Source对象
     *
     * @param source
     * @return
     */
    public ConditionsBuilder sourceValue(Source source) {
      Value val = new Value();
      val.setSource(source);
      tmpCondition.setV1(val);
      return this;
    }

    /**
     * v1赋值
     *
     * @param v1
     * @return
     */
    public ConditionsBuilder strValue(String v1) {
      Value val = new Value();
      val.setVal(v1);
      tmpCondition.setV1(val);
      return this;
    }

    /**
     * v1、v2赋值，如between语句使用
     *
     * @param v1
     * @param v2
     * @return
     */
    public ConditionsBuilder strValue(String v1, String v2) {
      Value val1 = new Value();
      Value val2 = new Value();
      val1.setVal(v1);
      val2.setVal(v2);
      tmpCondition.setV1(val1);
      tmpCondition.setV2(val2);
      return this;
    }

    public Conditions build() {
      addCondition();
      Conditions conditions = new Conditions();
      conditions.setConditionList(this.conditionList);
      return conditions;
    }


    private void addCondition() {
      if (tmpCondition != null && preConditionStack.isEmpty()) {
        conditionList.add(tmpCondition);
      } else if (tmpCondition != null) {
        preConditionStack.peek().getConditionList().add(tmpCondition);
      }
    }
  }
}

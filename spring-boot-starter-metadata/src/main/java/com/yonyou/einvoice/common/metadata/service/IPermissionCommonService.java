package com.yonyou.einvoice.common.metadata.service;

import com.yonyou.einvoice.common.metadata.element.Condition;
import com.yonyou.einvoice.common.metadata.element.Conditions;
import com.yonyou.einvoice.common.metadata.element.SourceCondition;
import com.yonyou.einvoice.common.metadata.element.Value;
import com.yonyou.einvoice.common.metadata.enums.OperatorEnum;
import com.yonyou.einvoice.common.metadata.visitor.AbstractPermissionVisitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 访问权限控制的接口，部分方法添加了默认实现
 */
@FunctionalInterface
public interface IPermissionCommonService {

  /**
   * 获取authConditions。
   * 该Condition列表将被添加到Conditions对象的authConditions属性，进而实现权限认证
   * @return
   */
  default List<Condition> getAuthConditions() {
    Object[][] permissionPairArray = getPermissionPairArray();
    if(permissionPairArray == null || permissionPairArray.length == 0) {
      return null;
    }
    List<Condition> resultList = new ArrayList<>(permissionPairArray.length);
    for(Object[] permissionPair : permissionPairArray) {
      Condition condition = new Condition();
      com.yonyou.einvoice.common.metadata.element.Field field = new com.yonyou.einvoice.common.metadata.element.Field();
      // 首先默认设置为t0。在调用处根据entity的别名情况自行修改。
      // 若是SourceCondition中使用，则无需修改（默认为"t0"）
      field.setSourceAlias("t0");
      if (permissionPair[0] != null) {
        field.setField(permissionPair[0].toString());
      }
      condition.setSourceField(field);
      condition.setOperator(OperatorEnum.EQUAL);
      Value value = new Value();
      // 如果value是List类型
      if(permissionPair[1] instanceof List) {
        // 如果是列表类型，则使用IN操作
        condition.setOperator(OperatorEnum.IN);
        value.setList((List) permissionPair[1]);
      } else if (permissionPair[1] instanceof Conditions) {
        // 如果value是Conditions类型，则直接拼接进去
        resultList.addAll(((Conditions) permissionPair[1]).getConditionList());
        continue;
      } else if (permissionPair[1] != null){
        // 否则，将value设置为val。
        value.setVal(permissionPair[1].toString());
      } else {
        // 否则的话，拼接为is null
        condition.setOperator(OperatorEnum.ISNULL);
        resultList.add(condition);
        return resultList;
      }
      condition.setV1(value);
      resultList.add(condition);
    }
    return resultList;
  }

  /**
   * 用于添加访问权限的Conditions
   *
   * @param condition
   * @param permissionVisitors
   */
  default void addPermissionConditions(SourceCondition condition,
      Collection<AbstractPermissionVisitor> permissionVisitors) {
    Conditions conditions = condition.getConditions();
    if(conditions == null) {
      conditions = new Conditions();
    }
    conditions.setAuthConditions(getAuthConditions());
    condition.setConditions(conditions);
    permissionVisitors.forEach(permissionVisitor -> permissionVisitor.visit(condition));
  }

  /**
   * 用于添加权限相关的条件。
   * [0]为权限相关的key（数据库字段名）。
   * [1]为权限相关的value。
   * 可以根据多组字段添加查询条件
   * @return
   */
  Object[][] getPermissionPairArray();
}

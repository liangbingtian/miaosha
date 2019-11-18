package metadata.raw;

import com.alibaba.fastjson.JSON;
import com.yonyou.einvoice.common.metadata.element.Condition;
import com.yonyou.einvoice.common.metadata.element.Conditions;
import com.yonyou.einvoice.common.metadata.visitor.RawSqlVisitor;
import metadata.Utils;
import org.junit.Assert;
import org.junit.Test;

public class ConditionTest {

  @Test
  public void conditionTest() {
    Condition condition = Utils.getTObject("condition/condition1.json", Condition.class);
    RawSqlVisitor sqlVisitor = new RawSqlVisitor();
    sqlVisitor.visit(condition);
    Assert.assertEquals("t0.`name` = 'luck'", sqlVisitor.getSql());
    condition = Utils.getTObject("condition/condition2.json", Condition.class);
    sqlVisitor.reset();
    sqlVisitor.visit(condition);
    Assert.assertEquals("t0.`name` in ('1', '2', '3', '4', '5')", sqlVisitor.getSql());

    condition = Utils.getTObject("condition/condition3.json", Condition.class);
    sqlVisitor.reset();
    sqlVisitor.visit(condition);
    Assert.assertEquals("( t0.`id` = '234' and t0.`name` <> '456' )", sqlVisitor.getSql());
  }

  @Test
  public void betweenConditionTest() {
    Condition condition = condition = Utils.getTObject("condition/between1.json", Condition.class);
    RawSqlVisitor sqlVisitor = new RawSqlVisitor();
    sqlVisitor.visit(condition);
    Assert.assertEquals("t0.`ts` between '2018-01-01' and '2020-01-01'", sqlVisitor.getSql());
  }

  @Test
  public void conditionsTest() {
    Conditions conditions = Utils.getTObject("condition/conditions1.json", Conditions.class);
    RawSqlVisitor sqlVisitor = new RawSqlVisitor();
    sqlVisitor.visit(conditions);
    System.out.println(JSON.toJSONString(conditions));
    Assert.assertEquals("where t0.`name` = 'luck'", sqlVisitor.getSql());

    conditions = Utils.getTObject("condition/conditions2.json", Conditions.class);
    sqlVisitor.reset();
    ;
    sqlVisitor.visit(conditions);
    System.out.println(JSON.toJSONString(conditions));
    Assert.assertEquals("where t0.`name` in ('1', '2', '3', '4', '5')", sqlVisitor.getSql());

    conditions = Utils.getTObject("condition/conditions3.json", Conditions.class);
    sqlVisitor.reset();
    ;
    sqlVisitor.visit(conditions);
    System.out.println(JSON.toJSONString(conditions));
    Assert.assertEquals("where t0.`id` = '234' and t0.`name` <> '456'", sqlVisitor.getSql());

    conditions = Utils.getTObject("condition/conditions4.json", Conditions.class);
    sqlVisitor.reset();
    ;
    sqlVisitor.visit(conditions);
    System.out.println(JSON.toJSONString(conditions));
    Assert
        .assertEquals("where ( t0.`id` = '234' and t0.`name` <> '456' )", sqlVisitor.getSql());
  }

}

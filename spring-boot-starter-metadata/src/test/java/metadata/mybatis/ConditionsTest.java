package metadata.mybatis;

import com.yonyou.einvoice.common.metadata.element.Conditions;
import com.yonyou.einvoice.common.metadata.enums.OperatorEnum;
import com.yonyou.einvoice.common.metadata.visitor.MybatisSqlVisitor;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

public class ConditionsTest {

  @Test
  public void equalTest() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).strValue("123")
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals("where t0.`id` = #{_p1}", sqlVisitor.getSql());
    Assert.assertEquals("{_p1=123}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void equalNullTest() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).strValue(null)
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals("where t0.`id` is null", sqlVisitor.getSql());
    Assert.assertEquals("{}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void equalList1Test() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).listValue(Collections.emptyList())
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).listValue(null)
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).listValue(Arrays.asList(1, 2, 3))
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).strValue("1")
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where t0.`id` is null and t0.`id` is null and t0.`id` is null and t0.`id` = #{_p1}",
        sqlVisitor.getSql());
    Assert.assertEquals("{_p1=1}", sqlVisitor.getMybatisParamMap().toString());
  }


  @Test
  public void and1Test() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).strValue(null)
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).strValue(null)
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals("where t0.`id` is null and t0.`id` is null", sqlVisitor.getSql());
    Assert.assertEquals("{}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void and2Test() {
    Conditions conditions = Conditions.builder()
        .andStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).strValue(null)
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).strValue(null)
        .andEnd()
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals("where ( t0.`id` is null and t0.`id` is null )", sqlVisitor.getSql());
    Assert.assertEquals("{}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void and3Test() {
    Conditions conditions = Conditions.builder()
        .andStart()
        .andStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).strValue(null)
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).strValue(null)
        .andEnd()
        .orStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).strValue(null)
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).strValue(null)
        .orEnd()
        .andEnd()
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where ( ( t0.`id` is null and t0.`id` is null ) and ( t0.`id` is null or t0.`id` is null ) )",
        sqlVisitor.getSql());
    Assert.assertEquals("{}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void inEmptyTest() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.IN).listValue(null)
        .fieldCondition("t0", "id").operator(OperatorEnum.IN).listValue(Collections.emptyList())
        .fieldCondition("t0", "id").operator(OperatorEnum.IN).listValue(Arrays.asList("1", "2"))
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTIN).listValue(null)
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTIN).listValue(Collections.emptyList())
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTIN).listValue(Arrays.asList("3", "4"))
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where 1 <> 1 and 1 <> 1 and t0.`id` in (#{_p1},#{_p2}) and 1 <> 1 and 1 <> 1 and t0.`id` not in (#{_p3},#{_p4})",
        sqlVisitor.getSql());
    Assert.assertEquals("{_p2=2, _p1=1, _p4=4, _p3=3}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void betweenTest() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.BETWEEN).strValue("1", "2")
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals("where t0.`id` between #{_p1} and #{_p2}", sqlVisitor.getSql());
    Assert.assertEquals("{_p2=2, _p1=1}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test(expected = Exception.class)
  public void betweenException1Test() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.BETWEEN).strValue(null, "2")
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
  }

  @Test(expected = Exception.class)
  public void betweenException2Test() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.BETWEEN).strValue("1", null)
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
  }

  @Test(expected = Exception.class)
  public void betweenException3Test() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.BETWEEN).strValue(null, null)
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
  }

  @Test
  public void likeEmptyTest() {
    Conditions conditions = Conditions.builder()
        .fieldCondition("t0", "id").operator(OperatorEnum.LIKE).strValue(null)
        .fieldCondition("t0", "id").operator(OperatorEnum.LIKE).strValue("1")
        .fieldCondition("t0", "id").operator(OperatorEnum.LIKE).listValue(null)
        .fieldCondition("t0", "id").operator(OperatorEnum.LIKE).listValue(Collections.emptyList())
        .fieldCondition("t0", "id").operator(OperatorEnum.LIKE)
        .listValue(Arrays.asList("1", "2", "3"))
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where t0.`id` is null and t0.`id` like #{_p1} and t0.`id` is null and t0.`id` is null and t0.`id` is null",
        sqlVisitor.getSql());
    Assert.assertEquals("{_p1=1}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void or1Test() {
    Conditions conditions = Conditions.builder()
        .orStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .orEnd()
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where ( t0.`id` = t1.`hid` )",
        sqlVisitor.getSql());
    Assert.assertEquals("{}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void or2Test() {
    Conditions conditions = Conditions.builder()
        .orStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .orEnd()
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where ( t0.`id` = t1.`hid` or t0.`id` <> t1.`hid` )",
        sqlVisitor.getSql());
    Assert.assertEquals("{}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void or3Test() {
    Conditions conditions = Conditions.builder()
        .orStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .orEnd()
        .fieldCondition("t0", "id").operator(OperatorEnum.IN)
        .listValue(Arrays.asList("1", "2", "3"))
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where ( t0.`id` = t1.`hid` or t0.`id` <> t1.`hid` ) and t0.`id` in (#{_p1},#{_p2},#{_p3})",
        sqlVisitor.getSql());
    Assert.assertEquals("{_p2=2, _p1=1, _p3=3}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void or4Test() {
    Conditions conditions = Conditions.builder()
        .orStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .andStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .andEnd()
        .orEnd()
        .fieldCondition("t0", "id").operator(OperatorEnum.IN)
        .listValue(Arrays.asList("1", "2", "3"))
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where ( t0.`id` = t1.`hid` or t0.`id` <> t1.`hid` or ( t0.`id` = t1.`hid` and t0.`id` <> t1.`hid` ) ) and t0.`id` in (#{_p1},#{_p2},#{_p3})",
        sqlVisitor.getSql());
    Assert.assertEquals("{_p2=2, _p1=1, _p3=3}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void or5Test() {
    Conditions conditions = Conditions.builder()
        .orStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .andStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .andEnd()
        .andStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .andEnd()
        .orEnd()
        .fieldCondition("t0", "id").operator(OperatorEnum.IN)
        .listValue(Arrays.asList("1", "2", "3"))
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where ( t0.`id` = t1.`hid` or t0.`id` <> t1.`hid` or ( t0.`id` = t1.`hid` and t0.`id` <> t1.`hid` ) or ( t0.`id` = t1.`hid` and t0.`id` <> t1.`hid` ) ) and t0.`id` in (#{_p1},#{_p2},#{_p3})",
        sqlVisitor.getSql());
    Assert.assertEquals("{_p2=2, _p1=1, _p3=3}", sqlVisitor.getMybatisParamMap().toString());
  }

  @Test
  public void or6Test() {
    Conditions conditions = Conditions.builder()
        .orStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .andStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .andEnd()
        .orStart()
        .fieldCondition("t0", "id").operator(OperatorEnum.EQUAL).fieldValue("t1", "hid")
        .fieldCondition("t0", "id").operator(OperatorEnum.NOTEQUAL).fieldValue("t1", "hid")
        .orEnd()
        .orEnd()
        .fieldCondition("t0", "id").operator(OperatorEnum.IN)
        .listValue(Arrays.asList("1", "2", "3"))
        .build();
    MybatisSqlVisitor sqlVisitor = getSqlVisitor(conditions);
    Assert.assertEquals(
        "where ( t0.`id` = t1.`hid` or t0.`id` <> t1.`hid` or ( t0.`id` = t1.`hid` and t0.`id` <> t1.`hid` ) or ( t0.`id` = t1.`hid` or t0.`id` <> t1.`hid` ) ) and t0.`id` in (#{_p1},#{_p2},#{_p3})",
        sqlVisitor.getSql());
    Assert.assertEquals("{_p2=2, _p1=1, _p3=3}", sqlVisitor.getMybatisParamMap().toString());
  }

  /**
   * 生成sqlVisitor，并执行sql、paramMap生成方法
   *
   * @param conditions
   * @return
   */
  private MybatisSqlVisitor getSqlVisitor(Conditions conditions) {
    MybatisSqlVisitor sqlVisitor = new MybatisSqlVisitor();
    sqlVisitor.visit(conditions);
    System.out.println(sqlVisitor.getSql());
    System.out.println(sqlVisitor.getMybatisParamMap());
    return sqlVisitor;
  }

}

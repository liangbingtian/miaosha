package metadata.raw;

import com.yonyou.einvoice.common.metadata.element.Value;
import com.yonyou.einvoice.common.metadata.visitor.RawSqlVisitor;
import metadata.Utils;
import org.junit.Assert;
import org.junit.Test;

public class ValueTest {

  @Test
  public void valueTest() {
    Value value = Utils.getTObject("value/value1.json", Value.class);
    RawSqlVisitor sqlVisitor = new RawSqlVisitor();
    sqlVisitor.visit(value);
    Assert.assertEquals("('1', '2', '3', '4', '5')", sqlVisitor.getSql());

    value = Utils.getTObject("value/value2.json", Value.class);
    sqlVisitor.reset();
    sqlVisitor.visit(value);
    Assert.assertEquals("('a', 'b', 'c', 'd', 'e')", sqlVisitor.getSql());
  }

}

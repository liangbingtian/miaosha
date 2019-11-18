package metadata.raw;

import com.yonyou.einvoice.common.metadata.element.Source;
import com.yonyou.einvoice.common.metadata.visitor.RawSqlVisitor;
import metadata.Utils;
import org.junit.Assert;
import org.junit.Test;

public class SourceTest {

  @Test
  public void sourceTest() {
    Source source = Utils.getTObject("source/source1.json", Source.class);
    RawSqlVisitor sqlVisitor = new RawSqlVisitor();
    sqlVisitor.visit(source);
    Assert.assertEquals(
        "select sum(distinct t0.`id`) as s from invoice t0 where t0.`name` = 'einvoice' having t0.`name` = 'einvoice' order by t0.`id` asc",
        sqlVisitor.getSql());

  }

}

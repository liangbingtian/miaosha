package com.yonyou.einvoice.common.metadata.element;

import com.yonyou.einvoice.common.metadata.visitor.IMetaElement;
import com.yonyou.einvoice.common.metadata.visitor.IVisitor;
import io.leangen.graphql.annotations.GraphQLNonNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

/**
 * order by子句。
 */
@Setter
@Getter
public class Orderby implements IMetaElement {

  @GraphQLNonNull
  private List<Orderbyitem> orderbyitems;

  @Override
  public void accept(IVisitor visitor) {
    if (CollectionUtils.isEmpty(orderbyitems)) {
      return;
    }
    orderbyitems.forEach(orderbyitem -> {
      visitor.visit(orderbyitem);
    });
  }
}

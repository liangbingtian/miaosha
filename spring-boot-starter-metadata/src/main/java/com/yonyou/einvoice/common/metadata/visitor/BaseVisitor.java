package com.yonyou.einvoice.common.metadata.visitor;

import com.yonyou.einvoice.common.metadata.element.Condition;
import com.yonyou.einvoice.common.metadata.element.Conditions;
import com.yonyou.einvoice.common.metadata.element.Entity;
import com.yonyou.einvoice.common.metadata.element.Field;
import com.yonyou.einvoice.common.metadata.element.Fields;
import com.yonyou.einvoice.common.metadata.element.Groupby;
import com.yonyou.einvoice.common.metadata.element.Groupbyitem;
import com.yonyou.einvoice.common.metadata.element.Having;
import com.yonyou.einvoice.common.metadata.element.Join;
import com.yonyou.einvoice.common.metadata.element.Limit;
import com.yonyou.einvoice.common.metadata.element.On;
import com.yonyou.einvoice.common.metadata.element.Orderby;
import com.yonyou.einvoice.common.metadata.element.Orderbyitem;
import com.yonyou.einvoice.common.metadata.element.Source;
import com.yonyou.einvoice.common.metadata.element.SourceCondition;
import com.yonyou.einvoice.common.metadata.element.Value;

/**
 * 基本的访问者实现类。用于提供默认的访问策略
 *
 * @author liuqiangm
 */
public class BaseVisitor implements IVisitor {

  @Override
  public void visit(Conditions conditions) {
    conditions.accept(this);
  }

  @Override
  public void visit(Condition condition) {
    condition.accept(this);
  }

  @Override
  public void visit(Entity entity) {
    entity.accept(this);
  }

  @Override
  public void visit(Fields field) {
    field.accept(this);
  }

  @Override
  public void visit(Field field) {
    field.accept(this);
  }

  @Override
  public void visit(Groupby groupby) {
    groupby.accept(this);
  }

  @Override
  public void visit(Groupbyitem groupbyitem) {
    groupbyitem.accept(this);
  }

  @Override
  public void visit(Having having) {
    having.accept(this);
  }

  @Override
  public void visit(Join join) {
    join.accept(this);
  }

  @Override
  public void visit(Limit limit) {
    limit.accept(this);
  }

  @Override
  public void visit(On on) {
    on.accept(this);
  }

  @Override
  public void visit(Orderby orderby) {
    orderby.accept(this);
  }

  @Override
  public void visit(Orderbyitem orderbyitem) {
    orderbyitem.accept(this);
  }

  @Override
  public void visit(Value value) {
    value.accept(this);
  }

  @Override
  public void visit(Source source) {
    source.accept(this);
  }

  @Override
  public void visit(SourceCondition sourceCondition) {
    sourceCondition.accept(this);
  }
}

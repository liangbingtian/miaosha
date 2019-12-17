package com.imooc.miaosha.goods.permission;

import com.yonyou.einvoice.common.metadata.visitor.AbstractPermissionVisitor;
import java.util.Map;
import org.springframework.stereotype.Component;


/**
 * miaosha_goods
 * @author liangbingtian
 *
 */

@Component
public class MiaoshaGoodsPermissionVisitor extends AbstractPermissionVisitor {
  @Override
  public Map<String, Object[][]> getPermissionConditionMap() {
    return null;
  }
}
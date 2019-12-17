package com.imooc.miaosha.goods.permission;

import com.yonyou.einvoice.common.metadata.visitor.AbstractPermissionVisitor;
import java.util.Map;
import org.springframework.stereotype.Component;


/**
 * miaosha_user
 * @author liangbingtian
 *
 */

@Component
public class MiaoshaUserPermissionVisitor extends AbstractPermissionVisitor {
  @Override
  public Map<String, Object[][]> getPermissionConditionMap() {
    return null;
  }
}
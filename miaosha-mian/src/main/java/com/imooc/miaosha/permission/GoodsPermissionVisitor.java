package com.imooc.miaosha.permission;

import com.yonyou.einvoice.common.metadata.visitor.AbstractPermissionVisitor;
import java.util.Map;
import org.springframework.stereotype.Component;


/**
 * goods
 * @author liangbingtian
 *
 */

@Component
public class GoodsPermissionVisitor extends AbstractPermissionVisitor {
  @Override
  public Map<String, Object[][]> getPermissionConditionMap() {
    return null;
  }
}

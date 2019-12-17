package com.imooc.miaosha.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 2019/11/25 下午1:59
 *
 * @author liangbingtian
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {

  }

  @Override
  public void updateFill(MetaObject metaObject) {

  }
}

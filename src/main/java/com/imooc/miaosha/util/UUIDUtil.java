package com.imooc.miaosha.util;

import java.util.UUID;

/**
 * liangbingtian 2019/6/28 下午2:08
 */
public class UUIDUtil {

  public static String uuid() {
    return UUID.randomUUID().toString().replace("-", "");
  }

}

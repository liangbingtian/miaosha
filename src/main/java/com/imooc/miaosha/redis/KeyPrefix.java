package com.imooc.miaosha.redis;

/**
 * liangbingtian 2019/6/26 上午10:51
 */
public interface KeyPrefix {

  int expireSeconds();

  String getPrefix();

}

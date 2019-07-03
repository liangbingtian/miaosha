package com.imooc.miaosha.redis;

/**
 * liangbingtian 2019/6/26 上午11:08
 */
public class MiaoshaUserKey extends BasePrefix{

  public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

  private MiaoshaUserKey(int expireSeconds, String prefix) {

    super(expireSeconds, prefix);
  }

  public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");

}

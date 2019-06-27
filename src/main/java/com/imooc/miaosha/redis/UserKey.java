package com.imooc.miaosha.redis;

/**
 * liangbingtian 2019/6/26 上午11:08
 */
public class UserKey extends BasePrefix{

  private UserKey(String prefix) {
    super(prefix);
  }

  public static UserKey getById = new UserKey("id");
  public static UserKey getByName = new UserKey("name");

}

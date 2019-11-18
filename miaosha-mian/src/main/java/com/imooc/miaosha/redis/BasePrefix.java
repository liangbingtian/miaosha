package com.imooc.miaosha.redis;

/**
 * liangbingtian 2019/6/26 上午10:54
 */
public abstract class BasePrefix implements KeyPrefix{

  private int expireSeconds;

  private String prefix;


  BasePrefix(int expireSeconds, String prefix) {
    this.expireSeconds = expireSeconds;
    this.prefix = prefix;
  }

  BasePrefix(String prefix) {//0代表永不过期
    this(0, prefix);
  }



  @Override
  public int expireSeconds() {//默认0代表永不过期
    return expireSeconds;
  }

  @Override
  public String getPrefix() {
    String className = getClass().getSimpleName();
    return className + ":" + prefix;
  }
}

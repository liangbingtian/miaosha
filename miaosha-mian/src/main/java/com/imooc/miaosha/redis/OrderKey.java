package com.imooc.miaosha.redis;

/**
 * Created by liangbingtian on 2020/3/7 4:40 下午
 */
public class OrderKey extends BasePrefix{

  private OrderKey(int expireSeconds, String prefix) {
    super(expireSeconds, prefix);
  }

  public static OrderKey getMiaoshaOrderByUidGid = new OrderKey(0, "mo");

}

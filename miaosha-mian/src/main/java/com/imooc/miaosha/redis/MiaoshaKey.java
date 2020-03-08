package com.imooc.miaosha.redis;

/**
 * Created by liangbingtian on 2020/3/7 6:03 下午
 */
public class MiaoshaKey extends BasePrefix{

  private MiaoshaKey(int expireSeconds, String prefix) {
    super(expireSeconds, prefix);
  }

  public static MiaoshaKey isGoodsOver = new MiaoshaKey(0, "go");
  public static MiaoshaKey getMiaoshaPath = new MiaoshaKey(60, "mp");
}

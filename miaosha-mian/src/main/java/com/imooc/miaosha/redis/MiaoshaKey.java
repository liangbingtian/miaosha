package com.imooc.miaosha.redis;

/**
 * Created by liangbingtian on 2020/3/7 6:03 下午
 */
public class MiaoshaKey extends BasePrefix{

  private MiaoshaKey(String prefix) {
    super(prefix);
  }

  public static MiaoshaKey isGoodsOver = new MiaoshaKey("go");
}

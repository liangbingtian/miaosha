package com.imooc.miaosha.redis;

/**
 * 2019/8/11 下午6:00
 *
 * @author liangbingtian
 */
public class GoodsKey extends BasePrefix{

  private GoodsKey(int expireSeconds, String prefix) {
    super(expireSeconds, prefix);
  }

  public static GoodsKey getGoodsList = new GoodsKey(600,"gl");
  public static GoodsKey getGoodsDetail = new GoodsKey(60, "gd");
  public static GoodsKey getMiaoshaGoodsStock = new GoodsKey(0, "gs");

}

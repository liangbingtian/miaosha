package com.imooc.miaosha.service;

import com.imooc.miaosha.entity.MiaoshaOrder;
import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.entity.OrderInfo;
import com.imooc.miaosha.redis.MiaoshaKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.util.MD5Util;
import com.imooc.miaosha.util.UUIDUtil;
import com.imooc.miaosha.vo.GoodsVo;
import java.awt.image.BufferedImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2019/7/9 下午8:10
 *
 * @author liangbingtian
 */
@Service
public class MiaoshaService {

  @Autowired
  private GoodsService goodsService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private RedisService redisService;

  @Transactional(rollbackFor = Exception.class)
  public OrderInfo miaosha(MiaoshaUser user, GoodsVo goodsVo) {
    //减库存，下订单，写入秒杀订单
    boolean succe = goodsService.reduceStock(goodsVo);
    if (succe) {
      //order_info miaosha_order
      return orderService.createOrder(user, goodsVo);
    }else {
      setGoodsOver(goodsVo.getId());
    }
    return null;
  }

  private void setGoodsOver(Long goodsId) {
    redisService.set(MiaoshaKey.isGoodsOver, String.valueOf(goodsId), true);
  }

  public long getMiaoshaResult(Long userid, long goodsId) {
    MiaoshaOrder miaoshaOrder = orderService.getMiaoshaOrderByUserIdGoodsId(userid, goodsId);
    if (miaoshaOrder != null) {
      return miaoshaOrder.getOrderId();
    }else {
      boolean isOver = getGoodsOver(goodsId);
      if (isOver) {
        return -1;
      }else {
        return 0;
      }
    }
  }

  private boolean getGoodsOver(long goodsId) {
    return redisService.exists(MiaoshaKey.isGoodsOver, String.valueOf(goodsId));
  }

  public boolean checkPath(MiaoshaUser user, long goodsId, String path) {
    if (user == null || path == null) {
      return false;
    }
    String pathOld = redisService.get(MiaoshaKey.getMiaoshaPath,""+user.getId()+"_"+goodsId, String.class);
    return path.equals(pathOld);
  }

  public String createMiaoshaPath(MiaoshaUser user, long goodsId) {
    String str = MD5Util.md5(UUIDUtil.uuid()+"123456");
    redisService.set(MiaoshaKey.getMiaoshaPath, ""+user.getId()+"_"+goodsId, str);
    return str;
  }

  public BufferedImage createVerifyCode(MiaoshaUser user, long goodsId) {
    if (user == null || goodsId <=0) {
      return null;
    }
    return null;
  }
}

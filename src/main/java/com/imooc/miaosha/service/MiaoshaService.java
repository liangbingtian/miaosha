package com.imooc.miaosha.service;

import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.entity.OrderInfo;
import com.imooc.miaosha.vo.GoodsVo;
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

  @Transactional(rollbackFor = Exception.class)
  public OrderInfo miaosha(MiaoshaUser user, GoodsVo goodsVo) {
    //减库存，下订单，写入秒杀订单
    goodsService.reduceStock(goodsVo);
    //order_info miaosha_order
    return orderService.createOrder(user, goodsVo);
  }
}

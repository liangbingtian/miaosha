package com.imooc.miaosha.service;

import com.imooc.miaosha.entity.MiaoshaOrder;
import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.entity.OrderInfo;
import com.imooc.miaosha.exception.GlobalException;
import com.imooc.miaosha.repository.MiaoshaOrderMapper;
import com.imooc.miaosha.repository.OrderInfoMapper;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2019/7/9 上午11:40
 *
 * @author liangbingtian
 */
@Service
public class OrderService {

  @Autowired
  private OrderInfoMapper orderInfoMapper;

  @Autowired
  private MiaoshaOrderMapper miaoshaOrderMapper;

  public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userid, long goodsId) {

    return orderInfoMapper.getMiaoshaOrderByUserIdGoodsId(userid, goodsId);

  }

  @Transactional(rollbackFor = Exception.class)
  public OrderInfo createOrder(MiaoshaUser user, GoodsVo goodsVo) {
    //插入orderInfo
    OrderInfo orderInfo = OrderInfo.builder().deliveryAddrId(0L).goodsCount(1)
        .goodsId(goodsVo.getId()).goodsName(goodsVo.getGoodsName()).goodsPrice(goodsVo.getGoodsPrice())
        .orderChannel(1).status(0).id(user.getId()).build();
    int oResult = orderInfoMapper.insert(orderInfo);
    if (oResult != 1) {
      throw new GlobalException(CodeMsg.SERVER_ERROR);
    }
    //插入miaoshaOrder
    MiaoshaOrder miaoshaOrder = MiaoshaOrder.builder().orderId(orderInfo.getId())
        .userId(user.getId()).goodsId(goodsVo.getId()).build();
    int mResult = miaoshaOrderMapper.insert(miaoshaOrder);
    if (mResult != 1) {
      throw new GlobalException(CodeMsg.SERVER_ERROR);
    }
    return orderInfo;
  }
}

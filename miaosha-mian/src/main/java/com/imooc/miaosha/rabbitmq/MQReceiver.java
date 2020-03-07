package com.imooc.miaosha.rabbitmq;

import com.imooc.miaosha.entity.MiaoshaOrder;
import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.entity.OrderInfo;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaService;
import com.imooc.miaosha.service.OrderService;
import com.imooc.miaosha.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liangbingtian on 2020/3/5 9:40 下午
 */
@Component
public class MQReceiver {

  private static Logger logger = LoggerFactory.getLogger(MQReceiver.class);

  @Autowired
  private GoodsService goodsService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private MiaoshaService miaoshaService;

  @Autowired
  private RedisService redisService;

  /**
   * Direct模式 交换机Exchange
   * @param message
   */
  @RabbitListener(queues = "queue")
  public void receive(String message) {
    logger.info("receiveMessage" + message);
  }

  @RabbitListener(queues = MQConfig.TOPIC_QUEUE1)
  public void receiveTopic1(String message) {
    logger.info("topic queue1 message:"+message);
  }

  @RabbitListener(queues = MQConfig.TOPIC_QUEUE2)
  public void receiveTopic2(String message) {
    logger.info("topic queue2 message:"+message);
  }

  @RabbitListener(queues = MQConfig.HEADER_QUEUE)
  public void receiveTopic2(byte[] message) {
    logger.info("header queue message:"+new String(message));
  }

  @RabbitListener(queues = MQConfig.MIAOSHA_QUEUE)
  public void receiveMiaosha(String message){
    logger.info("receive message" + message);
    MiaoshaMessage mm = RedisService.stringToBean(message, MiaoshaMessage.class);
    MiaoshaUser user = mm.getUser();
    long goodsId = mm.getGoodsId();

    GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
    int stock = goodsVo.getStockCount();
    if (stock < 0) {
      return;
    }

    //判断是否已经秒杀到了,看有没有秒杀order
    MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
    if (order != null) {
      return;
    }

    //减库存 下订单 写入秒杀订单
    miaoshaService.miaosha(user, goodsVo);
  }

}

package com.imooc.miaosha.rabbitmq;

import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaService;
import com.imooc.miaosha.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.stereotype.Service;

/**
 * Created by liangbingtian on 2020/3/5 9:39 下午
 */
@Service
public class MQSender {

  private Logger logger = LoggerFactory.getLogger(MQSender.class);

  @Autowired
  private AmqpTemplate amqpTemplate;

  public void send(Object message) {
    String msg = RedisService.beanToString(message);
    logger.info("send message:" + msg);
    amqpTemplate.convertAndSend("queue", msg);
  }

  public void sendTopic(Object message) {
    String msg = RedisService.beanToString(message);
    logger.info("send topic message:"+message);
    amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key1", msg + "1");
    amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key2", msg + "2");
  }

  public void sendFanout(Object message) {
    String msg = RedisService.beanToString(message);
    logger.info("send fanout message:" + msg);
    amqpTemplate.convertAndSend(MQConfig.FANOUT_EXCHANGE,"",msg);
  }

  public void sendHeader(Object message) {
    String msg = RedisService.beanToString(message);
    logger.info("");
    MessageProperties properties = new MessageProperties();
    properties.setHeader("header1", "value1");
    properties.setHeader("header2", "value2");
    Message obj = new Message(msg.getBytes(), properties);
    amqpTemplate.convertAndSend(MQConfig.HEADERS_EXCHANGE, "", obj);
  }



  public void sendMiaoshaMessage(MiaoshaMessage mm) {
    String msg = RedisService.beanToString(mm);
    logger.info("send message:" + msg);
    amqpTemplate.convertAndSend(MQConfig.MIAOSHA_QUEUE, msg);
  }
}

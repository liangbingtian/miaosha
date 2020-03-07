package com.imooc.miaosha.rabbitmq;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liangbingtian on 2020/3/5 9:40 下午
 */
@Configuration
public class MQConfig {

  public static final String MIAOSHA_QUEUE = "miaosha.queue";
  public static final String TOPIC_QUEUE1 = "topic.queue1";
  public static final String TOPIC_QUEUE2 = "topic.queue2";
  public static final String HEADER_QUEUE = "header.queue";
  public static final String TOPIC_EXCHANGE = "topicExchange";
  public static final String ROUTING_KEY1 = "topic.key1";
  public static final String ROUTING_KEY2 = "topic.#";
  public static final String FANOUT_EXCHANGE = "fanoutxchage";
  public static final String HEADERS_EXCHANGE = "headersExchange";

  @Bean
  public Queue queue() {
    return new Queue("queue", true);
  }

  @Bean
  Queue topicQueue1() {
    return new Queue(TOPIC_QUEUE1,true);
  }

  @Bean
  Queue topicQueue2() {
    return new Queue(TOPIC_QUEUE2, true);
  }

  @Bean
  public TopicExchange topicExchange() {
    return new TopicExchange(TOPIC_EXCHANGE);
  }

  /**
   * 把Queue和交换机还有key绑定。暂时理解是发消息发送到某个交换机上，可以通过路由routingKey发送到交换机上。发送到交换机上后，交换机分发给不同的队列
   * @return
   */
  @Bean
  public Binding topicBinding1() {
    return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.key1");
  }

  @Bean
  public Binding topicBinding2() {
    return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.#");
  }

  /**
   * Fanout模式 交换机Exchange
   */
  @Bean
  public FanoutExchange fanoutExchange() {
    return new FanoutExchange(FANOUT_EXCHANGE);
  }

  @Bean
  public Binding FanoutBinding1() {
    return BindingBuilder.bind(topicQueue1()).to(fanoutExchange());
  }

  @Bean
  public Binding FanoutBinding2() {
    return BindingBuilder.bind(topicQueue2()).to(fanoutExchange());
  }

  /**
   * Header模式 交换机Exchange
   */
  @Bean
  public HeadersExchange headersExchange() {
    return new HeadersExchange(HEADERS_EXCHANGE);
  }

  @Bean
  public Queue headerQueue1() {
    return new Queue(HEADER_QUEUE, true);
  }

  @Bean
  public Binding headerBinding() {
    Map<String, Object> map = new HashMap<>();
    map.put("header1", "value1");
    map.put("header2", "value2");
    return BindingBuilder.bind(headerQueue1()).to(headersExchange()).whereAll(map).match();

  }

}

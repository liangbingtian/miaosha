package com.imooc.miaosha.controller;

import com.imooc.miaosha.rabbitmq.MQSender;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.MiaoshaUserKey;
import com.imooc.miaosha.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * liangbingtian 2019/6/20 下午7:45
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

  @Autowired
  private RedisService redisService;

  @Autowired
  private MQSender sender;

  @RequestMapping("/mq")
  @ResponseBody
  public Result<String> mq() {
    sender.send("hello,imooc");
    return Result.success("Hello, world");
  }

  @RequestMapping("/mq/topic")
  @ResponseBody
  public Result<String> topic() {
    sender.sendTopic("hello,imooc");
    return Result.success("Hello, world");
  }

  @RequestMapping("/mq/fanout")
  @ResponseBody
  public Result<String> fanout() {
    sender.sendFanout("hello,imooc");
    return Result.success("Hello, world");
  }

  @RequestMapping("/mq/header")
  @ResponseBody
  public Result<String> header() {
    sender.sendHeader("hello,imooc");
    return Result.success("Hello, world");
  }

  @RequestMapping("/thymeleaf")
  public String thymeleaf(Model model) {
    model.addAttribute("name", "joshua");
    return "hello";
  }

  @RequestMapping("/redis/get")
  @ResponseBody
  public Long redisGet() {
    Long v1 = redisService.get(MiaoshaUserKey.token,"1", Long.class);
    return v1;
  }

  @RequestMapping("/redis/set")
  @ResponseBody
  public String redisSet() {
    boolean v1 = redisService.set(MiaoshaUserKey.token,"1", "hello,imooc");
    String str = redisService.get(MiaoshaUserKey.token,"2", String.class);
    return str;
  }

}

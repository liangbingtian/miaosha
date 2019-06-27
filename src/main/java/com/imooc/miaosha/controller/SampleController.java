package com.imooc.miaosha.controller;

import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.UserKey;
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

  @RequestMapping("/thymeleaf")
  public String thymeleaf(Model model) {
    model.addAttribute("name", "joshua");
    return "hello";
  }

  @RequestMapping("/redis/get")
  @ResponseBody
  public Long redisGet() {
    Long v1 = redisService.get(UserKey.getById,"1", Long.class);
    return v1;
  }

  @RequestMapping("/redis/set")
  @ResponseBody
  public String redisSet() {
    boolean v1 = redisService.set(UserKey.getById,"1", "hello,imooc");
    String str = redisService.get(UserKey.getByName,"2", String.class);
    return str;
  }

}

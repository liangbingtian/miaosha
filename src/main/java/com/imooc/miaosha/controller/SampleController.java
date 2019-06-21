package com.imooc.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * liangbingtian 2019/6/20 下午7:45
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

  @RequestMapping("/thymeleaf")
  public String thymeleaf(Model model) {
    model.addAttribute("name", "joshua");
    return "hello";
  }



}

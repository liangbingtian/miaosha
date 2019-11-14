package com.imooc.miaosha.controller;

import com.imooc.miaosha.result.Result;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.vo.GoodsVo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * liangbingtian 2019/6/28 下午2:33
 * @author liangbingtian
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private GoodsService goodsService;

  @RequestMapping("/info")
  @ResponseBody
  public Result<MiaoshaUser> toList(MiaoshaUser miaoshaUser) {
    return Result.success(miaoshaUser);
  }


  @RequestMapping("/num")
  @ResponseBody
  public String getNum(@RequestParam(value = "num", defaultValue = "1", required = false) Integer num) {
    System.out.println(num);
    return String.valueOf(num);
  }

}

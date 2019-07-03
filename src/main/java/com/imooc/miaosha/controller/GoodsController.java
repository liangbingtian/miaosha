package com.imooc.miaosha.controller;

import com.imooc.miaosha.entity.MiaoshaUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * liangbingtian 2019/6/28 下午2:33
 * @author liangbingtian
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @RequestMapping("/to_list")
  public String toList(Model model, MiaoshaUserVO miaoshaUserVO) {
    logger.info("进入了接口了");
    model.addAttribute("user", miaoshaUserVO);
    return "goods_list";
  }

}

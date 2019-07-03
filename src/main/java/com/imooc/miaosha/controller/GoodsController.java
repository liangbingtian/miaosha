package com.imooc.miaosha.controller;

import com.imooc.miaosha.entity.MiaoshaUserVO;
import com.imooc.miaosha.service.MiaoshaUserService;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * liangbingtian 2019/6/28 下午2:33
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

  @Autowired
  private MiaoshaUserService miaoshaUserService;

  @RequestMapping("/to_list")
  public String toLogin(Model model,
      @CookieValue(value = MiaoshaUserService.COOKI_NAME_TOKEN, required = false) String cookieToken,
      @RequestParam(value = MiaoshaUserService.COOKI_NAME_TOKEN, required = false) String cookieParam,
      HttpServletResponse response) {
    if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(cookieParam)) {
      return "login";
    }
    String token = StringUtils.isNotEmpty(cookieParam)? cookieParam : cookieToken;
    MiaoshaUserVO miaoshaUserVO = miaoshaUserService.getByToken(response, token);
    model.addAttribute("user", miaoshaUserVO);
    return "goods_list";
  }

}

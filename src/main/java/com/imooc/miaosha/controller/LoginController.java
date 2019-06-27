package com.imooc.miaosha.controller;

import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.MiaoshaUserService;
import com.imooc.miaosha.util.ValidatorUtil;
import com.imooc.miaosha.vo.LoginVo;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * liangbingtian 2019/6/26 下午4:05
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

  @Autowired
  private MiaoshaUserService miaoshaUserService;

  private static Logger logger = LoggerFactory.getLogger(LoginController.class);

  @RequestMapping("/to_login")
  public String toLogin() {
    return "login";
  }

  @RequestMapping("/do_login")
  @ResponseBody
  public Result<String> doLogin(@Valid LoginVo loginVo) {
    logger.info(loginVo.toString());
    return miaoshaUserService.login(loginVo);
  }

}



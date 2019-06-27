package com.imooc.miaosha.service;

import com.imooc.miaosha.entity.MiaoshaUserVO;
import com.imooc.miaosha.repository.MiaoshaUserVOMapper;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.util.MD5Util;
import com.imooc.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * liangbingtian 2019/6/27 下午7:31
 */
@Service
public class MiaoshaUserService {

  @Autowired
  private MiaoshaUserVOMapper miaoshaUserVOMapper;


  public Result<String> login(LoginVo loginVo) {
    String mobile = loginVo.getMobile();
    String formPass = loginVo.getPassword();
    MiaoshaUserVO userVO = miaoshaUserVOMapper.selectById(Long.parseLong(mobile));

    //验证密码
    String dbPass = userVO.getPassword();
    String saltDB = userVO.getSalt();

    String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);

    if (!dbPass.equals(calcPass)) {
      return Result.error(CodeMsg.MOBILE_ERROR);
    }
    return Result.success("登录成功");
  }
}

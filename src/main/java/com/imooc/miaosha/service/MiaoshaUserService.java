package com.imooc.miaosha.service;

import com.imooc.miaosha.entity.MiaoshaUserVO;
import com.imooc.miaosha.entity.MiaoshaUserVOExample;
import com.imooc.miaosha.exception.GlobalException;
import com.imooc.miaosha.redis.MiaoshaUserKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.repository.MiaoshaUserVOMapper;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.util.MD5Util;
import com.imooc.miaosha.util.UUIDUtil;
import com.imooc.miaosha.vo.LoginVo;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * liangbingtian 2019/6/27 下午7:31
 */
@Service
public class MiaoshaUserService {

  public static final String COOKI_NAME_TOKEN = "token";

  @Autowired
  private MiaoshaUserVOMapper miaoshaUserVOMapper;

  @Autowired
  private RedisService redisService;


  public Result<String> login(LoginVo loginVo, HttpServletResponse response) {
    String mobile = loginVo.getMobile();
    String formPass = loginVo.getPassword();
    MiaoshaUserVOExample example = new MiaoshaUserVOExample();
    MiaoshaUserVOExample.Criteria criteria = example.createCriteria();
    MiaoshaUserVO userVO = miaoshaUserVOMapper.selectById(Long.parseLong(mobile));
    if (userVO == null) {
      throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
    }

    //验证密码
    String dbPass = userVO.getPassword();
    String saltDb = userVO.getSalt();

    String calcPass = MD5Util.formPassToDBPass(formPass, saltDb);

    if (!dbPass.equals(calcPass)) {
      throw new GlobalException(CodeMsg.PASSWORD_ERROR);
    }
    addCookie(response, userVO);
    return Result.success("登录成功");
  }

  public MiaoshaUserVO getByToken(HttpServletResponse response, String token) {
    if (StringUtils.isEmpty(token)) {
      return null;
    }
    MiaoshaUserVO userVO = redisService.get(MiaoshaUserKey.token, token, MiaoshaUserVO.class);
    //延长有效期
    if (userVO!=null){
      addCookie(response, userVO);
    }
    return userVO;
  }


  private void addCookie(HttpServletResponse response, MiaoshaUserVO userVO) {
    //生成token
    String token = UUIDUtil.uuid();
    redisService.set(MiaoshaUserKey.token, token, userVO);
    //生成cookie
    Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
    cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
    cookie.setPath("/");
    response.addCookie(cookie);
  }
}

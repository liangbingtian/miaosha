package com.imooc.miaosha.config;

import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.service.MiaoshaUserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 2019/7/3 上午9:58
 *
 * @author liangbingtian
 */
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

  @Autowired
  private MiaoshaUserService miaoshaUserService;

  @Override
  public boolean supportsParameter(MethodParameter methodParameter) {
    Class<?> clazz = methodParameter.getParameterType();
    return clazz == MiaoshaUser.class;
  }

  @Override
  public Object resolveArgument(MethodParameter methodParameter,
      ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest,
      WebDataBinderFactory webDataBinderFactory) throws Exception {
    HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
    HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);

    String paramToken = request.getParameter(MiaoshaUserService.COOKI_NAME_TOKEN);
    String cookieToken = getCookieValue(request, MiaoshaUserService.COOKI_NAME_TOKEN);

    if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
      return null;
    }

    String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
    return miaoshaUserService.getByToken(response, token);
  }

  private String getCookieValue(HttpServletRequest request, String cookiName) {
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals(cookiName)) {
        return cookie.getValue();
      }
    }
    return null;
  }
}

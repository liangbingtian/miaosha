package com.imooc.miaosha.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 2019/7/3 上午9:16
 * @author liangbingtian
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private UserArgumentResolver resolver;


  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(resolver);

  }

}

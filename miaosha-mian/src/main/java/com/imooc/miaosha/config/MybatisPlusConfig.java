package com.imooc.miaosha.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.yonyou.einvoice.common.metadata.mp.injector.DynamicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2019/11/22 下午1:36
 *
 * @author liangbingtian
 *
 */
@Configuration
public class MybatisPlusConfig {

  //mp的分页插件，不配置的mp的分页无效
  @Bean
  public PaginationInterceptor paginationInterceptor() {

    return new PaginationInterceptor();
  }

}

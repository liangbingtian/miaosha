package com.imooc.miaosha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * liangbingtian 2019/6/20 下午7:42
 */
@SpringBootApplication(scanBasePackages = "com.imooc.miaosha")
@MapperScan({"com.imooc.miaosha.**.repository","com.imooc.miaosha.**.mapper"})
public class MainApplication {

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
  }

}

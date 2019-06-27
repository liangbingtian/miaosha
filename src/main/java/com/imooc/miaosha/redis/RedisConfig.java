package com.imooc.miaosha.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * liangbingtian 2019/6/22 上午10:11
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

  private String host;

  private Integer port;

  private String timeout;

  private String password;

  @Value("${spring.redis.jedis.pool.max-idle}")
  private Integer maxIdle;

  @Value("${spring.redis.jedis.pool.max-wait}")
  private String maxWait;

  @Value("${spring.redis.jedis.pool.max-active}")
  private Integer maxActive;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getTimeout() {
    return timeout;
  }

  public void setTimeout(String timeout) {
    this.timeout = timeout;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMaxWait() {
    return maxWait;
  }

  public void setMaxWait(String maxWait) {
    this.maxWait = maxWait;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public Integer getMaxIdle() {
    return maxIdle;
  }

  public void setMaxIdle(Integer maxIdle) {
    this.maxIdle = maxIdle;
  }

  public Integer getMaxActive() {
    return maxActive;
  }

  public void setMaxActive(Integer maxActive) {
    this.maxActive = maxActive;
  }
}

package com.imooc.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * liangbingtian 2019/6/22 下午3:29
 */
@Service
public class RedisPoolFactory {

  @Autowired
  private RedisConfig redisConfig;

  @Bean
  public JedisPool JedisFactory() {
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    poolConfig.setMaxTotal(redisConfig.getMaxActive());
    poolConfig.setMaxIdle(redisConfig.getMaxIdle());
    poolConfig.setMaxWaitMillis(Integer.parseInt(redisConfig.getMaxWait().replace("s", "")) * 1000);
    JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),
        Integer.parseInt(redisConfig.getMaxWait().replace("s", "")) * 1000,
        redisConfig.getPassword(), 0);
    return jp;

  }

}

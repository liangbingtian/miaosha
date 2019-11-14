package com.imooc.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * liangbingtian 2019/6/22 下午1:55
 */
@Service
public class RedisService {

  @Autowired
  private JedisPool jedisPool;

  /**
   * 获取单个对象
   */
  public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
    Jedis jedis = null;
    try {
      jedis = jedisPool.getResource();
      //生成真正的key
      String realKey = prefix.getPrefix() + key;
      String str = jedis.get(realKey);
      T t = stringToBean(str, clazz);
      return t;
    } finally {
      returnToPool(jedis);
    }
  }

  /**
   * 设置对象
   */
  public <T> boolean set(KeyPrefix prefix, String key, T value) {
    Jedis jedis = null;
    try {
      jedis = jedisPool.getResource();
      String str = beanToString(value);
      if (str == null || str.length() <= 0) {
        return false;
      }
      //得到真正的key
      String realkey = prefix.getPrefix() + key;
      int seconds = prefix.expireSeconds();
      if (seconds <= 0){
        jedis.set(realkey, str);
      }else {
        jedis.setex(realkey, seconds, str);
      }
      return true;
    } finally {
      returnToPool(jedis);
    }
  }

  /**
   * 判断keys是否存在
   */
  public <T> boolean exists(KeyPrefix prefix, String key) {
    Jedis jedis = null;
    try {
      jedis = jedisPool.getResource();
      //得到真正的key
      String realkey = prefix.getPrefix() + key;
      return jedis.exists(realkey);
    } finally {
      returnToPool(jedis);
    }
  }

  /**
   * 增加值
   */
  public <T> Long incr(KeyPrefix prefix, String key) {
    Jedis jedis = null;
    try {
      jedis = jedisPool.getResource();
      //得到真正的key
      String realkey = prefix.getPrefix() + key;
      return jedis.incr(realkey);
    } finally {
      returnToPool(jedis);
    }
  }

  /**
   * 减少值
   */
  public <T> Long decr(KeyPrefix prefix, String key) {
    Jedis jedis = null;
    try {
      jedis = jedisPool.getResource();
      //得到真正的key
      String realkey = prefix.getPrefix() + key;
      return jedis.decr(realkey);
    } finally {
      returnToPool(jedis);
    }
  }

  private <T> String beanToString(T value) {
    if (value == null) {
      return null;
    }
    Class<?> clazz = value.getClass();
    if (clazz == int.class || clazz == Integer.class) {
      return ""+value;
    } else if (clazz == String.class) {
      return (String) value;
    } else if (clazz == long.class || clazz == Long.class) {
      return ""+value;
    } else {
      return JSON.toJSONString(value);
    }
  }

  @SuppressWarnings("unchecked")
  private <T> T stringToBean(String str, Class<T> clazz) {
    if (str == null || str.length()<=0 || clazz == null) {
      return null;
    }
    if (clazz == int.class || clazz == Integer.class) {
      return (T) Integer.valueOf(str);
    } else if (clazz == String.class) {
      return (T) str;
    } else if (clazz == long.class || clazz == Long.class) {
      return (T) Long.valueOf(str);
    } else {
      return JSON.toJavaObject(JSON.parseObject(str), clazz);
    }
  }

  private void returnToPool(Jedis jedis) {
    if (jedis != null) {
      jedis.close();
    }
  }

}

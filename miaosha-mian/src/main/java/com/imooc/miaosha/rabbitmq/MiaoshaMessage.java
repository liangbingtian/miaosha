package com.imooc.miaosha.rabbitmq;

import com.imooc.miaosha.entity.MiaoshaUser;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liangbingtian on 2020/3/7 4:15 下午
 */
@Getter
@Setter
public class MiaoshaMessage {
  private MiaoshaUser user;
  private long goodsId;
}

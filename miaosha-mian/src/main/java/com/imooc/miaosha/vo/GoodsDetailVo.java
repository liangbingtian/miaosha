package com.imooc.miaosha.vo;

import com.imooc.miaosha.entity.MiaoshaUser;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liangbingtian on 2020/3/1 4:25 下午
 */
@Getter
@Setter
public class GoodsDetailVo {
  private int miaoshaStatus = 0;
  private int remainSeconds = 0;
  private GoodsVo goodsVo;
  private MiaoshaUser miaoshaUser;



}

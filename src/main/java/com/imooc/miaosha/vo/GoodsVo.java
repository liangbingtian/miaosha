package com.imooc.miaosha.vo;

import com.imooc.miaosha.entity.Goods;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 2019/7/6 下午4:01
 *
 * @author liangbingtian
 */
@Getter
@Setter
public class GoodsVo extends Goods{

  private Integer stockCount;

  private Date startDate;

  private Date endDate;

  private BigDecimal miaoshaPrice;
}

package com.imooc.miaosha.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.*;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 的实体类
 * miaosha_goods
 * @author liuqiangm
 */
@Getter
@Setter
public class MiaoshaGoodsVO {


    /**
     * 主键
     * miaosha_goods.id
     */
    @JSONField(serialzeFeatures = {SerializerFeature.WriteNonStringValueAsString})
    private Long id;

    /**
     * 商品Id
     * miaosha_goods.goods_id
     */
    private Long goodsId;
  
    /**
     * 秒杀价
     * miaosha_goods.miaosha_price
     */
    private BigDecimal miaoshaPrice;
  
    /**
     * 库存数量
     * miaosha_goods.stock_count
     */
    private Integer stockCount;
  
    /**
     * 秒杀开始时间
     * miaosha_goods.start_date
     */
    private Date startDate;
  
    /**
     * 秒杀结束时间
     * miaosha_goods.end_date
     */
    private Date endDate;
  

}

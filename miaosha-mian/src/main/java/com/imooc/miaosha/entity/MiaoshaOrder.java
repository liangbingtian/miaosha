package com.imooc.miaosha.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.*;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 的实体类
 * miaosha_order
 * @author liuqiangm
 */
@Getter
@Setter
@Builder
public class MiaoshaOrder {


    /**
     * 主键
     * miaosha_order.id
     */
    @JSONField(serialzeFeatures = {SerializerFeature.WriteNonStringValueAsString})
    private Long id;

    /**
     * 用户ID
     * miaosha_order.user_id
     */
    private Long userId;
  
    /**
     * 订单ID
     * miaosha_order.order_id
     */
    private Long orderId;
  
    /**
     * 商品ID
     * miaosha_order.goods_id
     */
    private Long goodsId;
  

}

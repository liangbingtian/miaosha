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
 * order_info
 * @author liuqiangm
 */
@Getter
@Setter
@Builder
public class OrderInfo {


    /**
     * 主键
     * order_info.id
     */
    @JSONField(serialzeFeatures = {SerializerFeature.WriteNonStringValueAsString})
    private Long id;

    /**
     * 用户ID
     * order_info.user_id
     */
    private Long userId;
  
    /**
     * 商品ID
     * order_info.goods_id
     */
    private Long goodsId;
  
    /**
     * 收获地址ID
     * order_info.delivery_addr_id
     */
    private Long deliveryAddrId;
  
    /**
     * 冗余过来的商品名称
     * order_info.goods_name
     */
    private String goodsName;
  
    /**
     * 商品数量
     * order_info.goods_count
     */
    private Integer goodsCount;
  
    /**
     * 商品单价
     * order_info.goods_price
     */
    private BigDecimal goodsPrice;
  
    /**
     * 1pc，2android，3ios
     * order_info.order_channel
     */
    private Integer orderChannel;
  
    /**
     * 订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成
     * order_info.status
     */
    private Integer status;
  
    /**
     * 订单的创建时间
     * order_info.create_date
     */
    private Date createDate;
  
    /**
     * 支付时间
     * order_info.pay_date
     */
    private Date payDate;
  

}

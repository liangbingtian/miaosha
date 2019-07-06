package com.imooc.miaosha.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.*;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 的实体类
 * goods
 * @author liuqiangm
 */
@Getter
@Setter
public class GoodsVO {


    /**
     * 主键
     * goods.id
     */
    @JSONField(serialzeFeatures = {SerializerFeature.WriteNonStringValueAsString})
    private Long id;

    /**
     * 商品名称
     * goods.goods_name
     */
    private String goodsName;
  
    /**
     * 商品标题
     * goods.goods_title
     */
    private String goodsTitle;
  
    /**
     * 商品的图片
     * goods.goods_img
     */
    private String goodsImg;
  
    /**
     * 商品的详情介绍
     * goods.goods_detail
     */
    private DataTypeWithBLOBs.String goodsDetail;
  
    /**
     * 商品单价
     * goods.goods_price
     */
    private BigDecimal goodsPrice;
  
    /**
     * 商品库存，-1表示没有限制
     * goods.goods_stock
     */
    private Integer goodsStock;
  

}

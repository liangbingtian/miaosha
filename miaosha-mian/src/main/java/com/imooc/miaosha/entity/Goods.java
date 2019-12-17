package com.imooc.miaosha.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.yonyou.einvoice.common.metadata.entity.IMetaVO;
import com.yonyou.einvoice.common.metadata.mp.anno.InsertBatchIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.*;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 * goods
 * @author liangbingtian
 */
@TableName("goods")
@Getter
@Setter
@ToString
public class Goods implements IMetaVO {
    /**
     * goods.id
     * 商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * goods.goods_name
     * 商品名称
     */
    private String goodsName;
    /**
     * goods.goods_title
     * 商品标题
     */
    private String goodsTitle;
    /**
     * goods.goods_img
     * 商品的图片
     */
    private String goodsImg;
    /**
     * goods.goods_detail
     * 商品的详情介绍
     */
    private String goodsDetail;
    /**
     * goods.goods_price
     * 商品单价
     */
    private BigDecimal goodsPrice;
    /**
     * goods.goods_stock
     * 商品库存，-1表示没有限制
     */
    private Integer goodsStock;
    /**
     * goods.createtime
     * 创建时间
     */
    @InsertBatchIgnore
    private Date createtime;
    /**
     * goods.ts
     * 
     */
    @InsertBatchIgnore
    private Date ts;

//    //逻辑删除标识(0-未删除，1-已删除)一般设置全局
//    @TableLogic
    private Integer deleted;

    @GraphQLQuery(name = "id", description = "商品ID")
    public Long id() {
        return this.id;
    }
    @GraphQLQuery(name = "goodsName", description = "商品名称")
    public String goodsName() {
        return this.goodsName;
    }
    @GraphQLQuery(name = "goodsTitle", description = "商品标题")
    public String goodsTitle() {
        return this.goodsTitle;
    }
    @GraphQLQuery(name = "goodsImg", description = "商品的图片")
    public String goodsImg() {
        return this.goodsImg;
    }
    @GraphQLQuery(name = "goodsDetail", description = "商品的详情介绍")
    public String goodsDetail() {
        return this.goodsDetail;
    }
    @GraphQLQuery(name = "goodsPrice", description = "商品单价")
    public BigDecimal goodsPrice() {
        return this.goodsPrice;
    }
    @GraphQLQuery(name = "goodsStock", description = "商品库存，-1表示没有限制")
    public Integer goodsStock() {
        return this.goodsStock;
    }
    @GraphQLQuery(name = "createtime", description = "创建时间")
    public Date createtime() {
        return this.createtime;
    }
    @GraphQLQuery(name = "ts", description = "")
    public Date ts() {
        return this.ts;
    }
}

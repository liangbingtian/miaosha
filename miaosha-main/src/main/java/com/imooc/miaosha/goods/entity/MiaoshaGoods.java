package com.imooc.miaosha.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * miaosha_goods
 * @author liangbingtian
 */
@TableName("miaosha_goods")
@Getter
@Setter
@ToString
public class MiaoshaGoods implements IMetaVO {
    /**
     * miaosha_goods.id
     * 秒杀的商品表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * miaosha_goods.goods_id
     * 商品Id
     */
    private Long goodsId;
    /**
     * miaosha_goods.miaosha_price
     * 秒杀价
     */
    private BigDecimal miaoshaPrice;
    /**
     * miaosha_goods.stock_count
     * 库存数量
     */
    private Integer stockCount;
    /**
     * miaosha_goods.start_date
     * 秒杀开始时间
     */
    @InsertBatchIgnore
    private Date startDate;
    /**
     * miaosha_goods.end_date
     * 秒杀结束时间
     */
    @InsertBatchIgnore
    private Date endDate;
    /**
     * miaosha_goods.createtime
     * 创建时间
     */
    @InsertBatchIgnore
    private Date createtime;
    /**
     * miaosha_goods.ts
     * 更新时间
     */
    @InsertBatchIgnore
    private Date ts;

    @GraphQLQuery(name = "id", description = "秒杀的商品表")
    public Long id() {
        return this.id;
    }
    @GraphQLQuery(name = "goodsId", description = "商品Id")
    public Long goodsId() {
        return this.goodsId;
    }
    @GraphQLQuery(name = "miaoshaPrice", description = "秒杀价")
    public BigDecimal miaoshaPrice() {
        return this.miaoshaPrice;
    }
    @GraphQLQuery(name = "stockCount", description = "库存数量")
    public Integer stockCount() {
        return this.stockCount;
    }
    @GraphQLQuery(name = "startDate", description = "秒杀开始时间")
    public Date startDate() {
        return this.startDate;
    }
    @GraphQLQuery(name = "endDate", description = "秒杀结束时间")
    public Date endDate() {
        return this.endDate;
    }
    @GraphQLQuery(name = "createtime", description = "创建时间")
    public Date createtime() {
        return this.createtime;
    }
    @GraphQLQuery(name = "ts", description = "更新时间")
    public Date ts() {
        return this.ts;
    }
}
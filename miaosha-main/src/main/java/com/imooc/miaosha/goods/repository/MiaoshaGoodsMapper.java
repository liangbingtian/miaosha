package com.imooc.miaosha.goods.repository;

import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import com.imooc.miaosha.goods.entity.MiaoshaGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * miaosha_goods
 * @author liangbingtian
 *
 */
@Mapper
@Repository
public interface MiaoshaGoodsMapper extends IMetaMapper<MiaoshaGoods> {
  
}
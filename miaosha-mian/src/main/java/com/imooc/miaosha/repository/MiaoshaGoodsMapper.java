package com.imooc.miaosha.repository;

import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import java.util.*;
import com.imooc.miaosha.entity.MiaoshaGoods;
import com.imooc.miaosha.entity.MiaoshaGoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 的mapper
 * @author liuqiangm
 * miaosha_goods
 *
 */
@Mapper
@Repository
public interface MiaoshaGoodsMapper extends IMetaMapper<MiaoshaGoods> {
  
}

package com.imooc.miaosha.repository;

import com.imooc.miaosha.entity.Goods;
import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * goods
 * @author liangbingtian
 *
 */
@Mapper
@Repository
public interface GoodsMapper extends IMetaMapper<Goods> {
  
}

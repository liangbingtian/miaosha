package com.imooc.miaosha.goods.repository;

import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import com.imooc.miaosha.goods.entity.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * miaosha_user
 * @author liangbingtian
 *
 */
@Mapper
@Repository
public interface MiaoshaUserMapper extends IMetaMapper<MiaoshaUser> {
  
}
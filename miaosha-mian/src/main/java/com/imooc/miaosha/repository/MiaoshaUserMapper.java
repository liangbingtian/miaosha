package com.imooc.miaosha.repository;

import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import java.util.*;
import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.entity.MiaoshaUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 的mapper
 * @author liuqiangm
 * miaosha_user
 *
 */
@Mapper
@Repository
public interface MiaoshaUserMapper extends IMetaMapper<MiaoshaUser> {
  
}

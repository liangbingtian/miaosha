package com.imooc.miaosha.repository;

import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import java.util.*;
import com.imooc.miaosha.entity.MiaoshaOrder;
import com.imooc.miaosha.entity.MiaoshaOrderExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 的mapper
 * @author liuqiangm
 * miaosha_order
 *
 */
@Mapper
@Repository
public interface MiaoshaOrderMapper extends IMetaMapper<MiaoshaOrder> {
  
}

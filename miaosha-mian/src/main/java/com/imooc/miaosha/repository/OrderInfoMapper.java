package com.imooc.miaosha.repository;

import com.imooc.miaosha.entity.MiaoshaOrder;
import com.yonyou.einvoice.common.metadata.mp.repository.IMetaMapper;
import java.util.*;
import com.imooc.miaosha.entity.OrderInfo;
import com.imooc.miaosha.entity.OrderInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * 的mapper
 * 
 * @author liuqiangm order_info
 *
 */
@Mapper
@Repository
public interface OrderInfoMapper extends IMetaMapper<OrderInfo> {

}

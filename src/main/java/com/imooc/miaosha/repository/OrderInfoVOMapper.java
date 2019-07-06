package com.imooc.miaosha.repository;

import java.util.*;
import com.imooc.miaosha.entity.OrderInfoVO;
import com.imooc.miaosha.entity.OrderInfoVOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 的mapper
 * @author liuqiangm
 * order_info
 *
 */
@Mapper
@Repository
public interface OrderInfoVOMapper {

    int countByExample(OrderInfoVOExample example);

    int deleteByExample(OrderInfoVOExample example);

    int insert(OrderInfoVO record);

    int insertSelective(OrderInfoVO record);

    int insertOrderInfoVOList(List<OrderInfoVO> list);
	
    OrderInfoVO selectById(Long id);

    List<OrderInfoVO> selectByExample(OrderInfoVOExample example);

    int updateByExampleSelective(@Param("record") OrderInfoVO record, @Param("example") OrderInfoVOExample example);

    int updateByExample(@Param("record") OrderInfoVO record, @Param("example") OrderInfoVOExample example);

    int updateOrderInfoVOList(@Param("recordList") List<OrderInfoVO> recordList, @Param("example") OrderInfoVOExample example);
  
}

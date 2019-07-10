package com.imooc.miaosha.repository;

import com.imooc.miaosha.entity.MiaoshaOrder;
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
public interface OrderInfoMapper {

  int countByExample(OrderInfoExample example);

  int deleteByExample(OrderInfoExample example);

  int insert(OrderInfo record);

  int insertSelective(OrderInfo record);

  int insertOrderInfoVOList(List<OrderInfo> list);

  OrderInfo selectById(Long id);

  List<OrderInfo> selectByExample(OrderInfoExample example);

  int updateByExampleSelective(@Param("record") OrderInfo record,
      @Param("example") OrderInfoExample example);

  int updateByExample(@Param("record") OrderInfo record,
      @Param("example") OrderInfoExample example);

  int updateOrderInfoVOList(@Param("recordList") List<OrderInfo> recordList,
      @Param("example") OrderInfoExample example);

  @Select("select * from miaosha_order where user_id = #{userid} and goods_id = #{goodsId}")
  MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(@Param("userid") long userid, @Param("goodsId") long goodsId);
}

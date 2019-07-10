package com.imooc.miaosha.repository;

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
public interface MiaoshaOrderMapper {

    int countByExample(MiaoshaOrderExample example);

    int deleteByExample(MiaoshaOrderExample example);

    int insert(MiaoshaOrder record);

    int insertSelective(MiaoshaOrder record);

    int insertMiaoshaOrderVOList(List<MiaoshaOrder> list);
	
    MiaoshaOrder selectById(Long id);

    List<MiaoshaOrder> selectByExample(MiaoshaOrderExample example);

    int updateByExampleSelective(@Param("record") MiaoshaOrder record, @Param("example") MiaoshaOrderExample example);

    int updateByExample(@Param("record") MiaoshaOrder record, @Param("example") MiaoshaOrderExample example);

    int updateMiaoshaOrderVOList(@Param("recordList") List<MiaoshaOrder> recordList, @Param("example") MiaoshaOrderExample example);
  
}

package com.imooc.miaosha.repository;

import java.util.*;
import com.imooc.miaosha.entity.MiaoshaOrderVO;
import com.imooc.miaosha.entity.MiaoshaOrderVOExample;
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
public interface MiaoshaOrderVOMapper {

    int countByExample(MiaoshaOrderVOExample example);

    int deleteByExample(MiaoshaOrderVOExample example);

    int insert(MiaoshaOrderVO record);

    int insertSelective(MiaoshaOrderVO record);

    int insertMiaoshaOrderVOList(List<MiaoshaOrderVO> list);
	
    MiaoshaOrderVO selectById(Long id);

    List<MiaoshaOrderVO> selectByExample(MiaoshaOrderVOExample example);

    int updateByExampleSelective(@Param("record") MiaoshaOrderVO record, @Param("example") MiaoshaOrderVOExample example);

    int updateByExample(@Param("record") MiaoshaOrderVO record, @Param("example") MiaoshaOrderVOExample example);

    int updateMiaoshaOrderVOList(@Param("recordList") List<MiaoshaOrderVO> recordList, @Param("example") MiaoshaOrderVOExample example);
  
}

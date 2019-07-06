package com.imooc.miaosha.repository;

import java.util.*;
import com.imooc.miaosha.entity.MiaoshaGoodsVO;
import com.imooc.miaosha.entity.MiaoshaGoodsVOExample;
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
public interface MiaoshaGoodsVOMapper {

    int countByExample(MiaoshaGoodsVOExample example);

    int deleteByExample(MiaoshaGoodsVOExample example);

    int insert(MiaoshaGoodsVO record);

    int insertSelective(MiaoshaGoodsVO record);

    int insertMiaoshaGoodsVOList(List<MiaoshaGoodsVO> list);
	
    MiaoshaGoodsVO selectById(Long id);

    List<MiaoshaGoodsVO> selectByExample(MiaoshaGoodsVOExample example);

    int updateByExampleSelective(@Param("record") MiaoshaGoodsVO record, @Param("example") MiaoshaGoodsVOExample example);

    int updateByExample(@Param("record") MiaoshaGoodsVO record, @Param("example") MiaoshaGoodsVOExample example);

    int updateMiaoshaGoodsVOList(@Param("recordList") List<MiaoshaGoodsVO> recordList, @Param("example") MiaoshaGoodsVOExample example);
  
}

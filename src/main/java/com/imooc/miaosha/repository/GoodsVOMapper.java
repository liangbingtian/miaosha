package com.imooc.miaosha.repository;

import java.util.*;
import com.imooc.miaosha.entity.GoodsVO;
import com.imooc.miaosha.entity.GoodsVOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 的mapper
 * @author liuqiangm
 * goods
 *
 */
@Mapper
@Repository
public interface GoodsVOMapper {

    int countByExample(GoodsVOExample example);

    int deleteByExample(GoodsVOExample example);

    int insert(GoodsVO record);

    int insertSelective(GoodsVO record);

    int insertGoodsVOList(List<GoodsVO> list);
	
    GoodsVO selectById(Long id);

    List<GoodsVO> selectByExample(GoodsVOExample example);

    int updateByExampleSelective(@Param("record") GoodsVO record, @Param("example") GoodsVOExample example);

    int updateByExample(@Param("record") GoodsVO record, @Param("example") GoodsVOExample example);

    int updateGoodsVOList(@Param("recordList") List<GoodsVO> recordList, @Param("example") GoodsVOExample example);
  
}

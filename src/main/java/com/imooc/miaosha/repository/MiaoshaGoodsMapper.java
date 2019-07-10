package com.imooc.miaosha.repository;

import java.util.*;
import com.imooc.miaosha.entity.MiaoshaGoods;
import com.imooc.miaosha.entity.MiaoshaGoodsExample;
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
public interface MiaoshaGoodsMapper {

    int countByExample(MiaoshaGoodsExample example);

    int deleteByExample(MiaoshaGoodsExample example);

    int insert(MiaoshaGoods record);

    int insertSelective(MiaoshaGoods record);

    int insertMiaoshaGoodsVOList(List<MiaoshaGoods> list);
	
    MiaoshaGoods selectById(Long id);

    List<MiaoshaGoods> selectByExample(MiaoshaGoodsExample example);

    int updateByExampleSelective(@Param("record") MiaoshaGoods record, @Param("example") MiaoshaGoodsExample example);

    int updateByExample(@Param("record") MiaoshaGoods record, @Param("example") MiaoshaGoodsExample example);

    int updateMiaoshaGoodsVOList(@Param("recordList") List<MiaoshaGoods> recordList, @Param("example") MiaoshaGoodsExample example);
  
}

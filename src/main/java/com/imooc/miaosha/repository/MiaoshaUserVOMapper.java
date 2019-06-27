package com.imooc.miaosha.repository;

import java.util.*;
import com.imooc.miaosha.entity.MiaoshaUserVO;
import com.imooc.miaosha.entity.MiaoshaUserVOExample;
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
public interface MiaoshaUserVOMapper {

    int countByExample(MiaoshaUserVOExample example);

    int deleteByExample(MiaoshaUserVOExample example);

    int insert(MiaoshaUserVO record);

    int insertSelective(MiaoshaUserVO record);

    int insertMiaoshaUserVOList(List<MiaoshaUserVO> list);
	
    MiaoshaUserVO selectById(Long id);

    List<MiaoshaUserVO> selectByExample(MiaoshaUserVOExample example);

    int updateByExampleSelective(@Param("record") MiaoshaUserVO record, @Param("example") MiaoshaUserVOExample example);

    int updateByExample(@Param("record") MiaoshaUserVO record, @Param("example") MiaoshaUserVOExample example);

    int updateMiaoshaUserVOList(@Param("recordList") List<MiaoshaUserVO> recordList, @Param("example") MiaoshaUserVOExample example);
  
}

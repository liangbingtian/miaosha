package com.imooc.miaosha.repository;

import java.util.*;
import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.entity.MiaoshaUserExample;
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
public interface MiaoshaUserMapper {

    int countByExample(MiaoshaUserExample example);

    int deleteByExample(MiaoshaUserExample example);

    int insert(MiaoshaUser record);

    int insertSelective(MiaoshaUser record);

    int insertMiaoshaUserVOList(List<MiaoshaUser> list);
	
    MiaoshaUser selectById(Long id);

    List<MiaoshaUser> selectByExample(MiaoshaUserExample example);

    int updateByExampleSelective(@Param("record") MiaoshaUser record, @Param("example") MiaoshaUserExample example);

    int updateByExample(@Param("record") MiaoshaUser record, @Param("example") MiaoshaUserExample example);

    int updateMiaoshaUserVOList(@Param("recordList") List<MiaoshaUser> recordList, @Param("example") MiaoshaUserExample example);
  
}

package com.imooc.miaosha.repository;


import com.imooc.miaosha.entity.Goods;
import com.imooc.miaosha.entity.GoodsExample;
import com.imooc.miaosha.vo.GoodsVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * 的mapper
 * @author liuqiangm
 * goods
 *
 */
@Mapper
@Repository
public interface GoodsMapper {

    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int insert(Goods record);

    int insertSelective(Goods record);

    int insertGoodsVOList(List<Goods> list);
	
    Goods selectById(Long id);

    List<Goods> selectByExample(GoodsExample example);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateGoodsVOList(@Param("recordList") List<Goods> recordList, @Param("example") GoodsExample example);

    @Select("select mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date, g.* from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    List<GoodsVo> selectGoodsList();

    @Select("select mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date, g.* from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);
}

package com.imooc.miaosha.service;

import com.imooc.miaosha.entity.Goods;
import com.imooc.miaosha.repository.GoodsMapper;
import com.imooc.miaosha.util.BeanUtils;
import com.imooc.miaosha.vo.GoodsVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2019/7/6 下午3:21
 *
 * @author liangbingtian
 */
@Service
public class GoodsService {

  @Autowired
  private GoodsMapper goodsMapper;


  public List<GoodsVo> listGoodsVo() {
    List<Goods> goodsList = goodsMapper.selectList(null);
    return BeanUtils.batchTransform(GoodsVo.class, goodsList);
  }

  public GoodsVo getGoodsVoByGoodsId(long goodsId) {
    Goods goods = goodsMapper.selectById(goodsId);
    return BeanUtils.transfrom(GoodsVo.class, goods);
  }

  @Transactional(rollbackFor = Exception.class)
  public void reduceStock(GoodsVo goodsVo) {
    Goods g = new Goods();
    g.setId(goodsVo.getId());
    g.setGoodsStock(goodsVo.getGoodsStock() - 1);
    goodsMapper.updateById(g);

  }
}

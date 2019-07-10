package com.imooc.miaosha.service;

import com.imooc.miaosha.entity.Goods;
import com.imooc.miaosha.entity.GoodsExample;
import com.imooc.miaosha.repository.GoodsMapper;
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
    return goodsMapper.selectGoodsList();
  }

  public GoodsVo getGoodsVoByGoodsId(long goodsId) {
    return goodsMapper.getGoodsVoByGoodsId(goodsId);
  }

  @Transactional(rollbackFor = Exception.class)
  public void reduceStock(GoodsVo goodsVo) {
    Goods g = new Goods();
    g.setGoodsStock(goodsVo.getGoodsStock() - 1);
    GoodsExample goodsExample = new GoodsExample();
    GoodsExample.Criteria criteria = goodsExample.createCriteria();
    criteria.andIdEqualTo(goodsVo.getId());
    goodsMapper.updateByExampleSelective(g, goodsExample);
  }
}

package com.imooc.miaosha.goods.service.impl;

import com.yonyou.einvoice.common.metadata.service.AbstractMybatisService;
import com.imooc.miaosha.goods.entity.MiaoshaGoods;
import com.imooc.miaosha.goods.repository.MiaoshaGoodsMapper;
import com.imooc.miaosha.goods.service.IMiaoshaGoodsService;
import org.springframework.stereotype.Service;


/**
 * miaosha_goods
 * @author liangbingtian
 *
 */

@Service
public class MiaoshaGoodsServiceImpl
    extends AbstractMybatisService<MiaoshaGoods, MiaoshaGoodsMapper> 
    implements IMiaoshaGoodsService {
  
}
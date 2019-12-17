package com.imooc.miaosha.goods.service.impl;

import com.yonyou.einvoice.common.metadata.service.AbstractMybatisPermissionService;
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
public class MiaoshaGoodsPermissionServiceImpl
    extends AbstractMybatisPermissionService<MiaoshaGoods, MiaoshaGoodsMapper> 
    implements IMiaoshaGoodsService {
}
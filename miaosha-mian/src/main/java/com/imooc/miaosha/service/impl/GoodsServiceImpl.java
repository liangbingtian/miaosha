package com.imooc.miaosha.service.impl;

import com.yonyou.einvoice.common.metadata.service.AbstractMybatisService;
import com.imooc.miaosha.entity.Goods;
import com.imooc.miaosha.repository.GoodsMapper;
import com.imooc.miaosha.service.IGoodsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * goods
 * @author liangbingtian
 *
 */

@Service("goodsServiceImpl")
public class GoodsServiceImpl
    extends AbstractMybatisService<Goods, GoodsMapper> 
    implements IGoodsService {


}

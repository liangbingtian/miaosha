package com.imooc.miaosha.service.impl;

import com.yonyou.einvoice.common.metadata.service.AbstractMybatisPermissionService;
import com.imooc.miaosha.entity.Goods;
import com.imooc.miaosha.repository.GoodsMapper;
import com.imooc.miaosha.service.IGoodsService;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 * goods
 * @author liangbingtian
 *
 */

@Service("goodsPermissionServiceImpl")
public class GoodsPermissionServiceImpl
    extends AbstractMybatisPermissionService<Goods, GoodsMapper> 
    implements IGoodsService {

}

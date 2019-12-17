package com.imooc.miaosha.goods.service.impl;

import com.yonyou.einvoice.common.metadata.service.AbstractMybatisPermissionService;
import com.imooc.miaosha.goods.entity.MiaoshaUser;
import com.imooc.miaosha.goods.repository.MiaoshaUserMapper;
import com.imooc.miaosha.goods.service.IMiaoshaUserService;
import org.springframework.stereotype.Service;


/**
 * miaosha_user
 * @author liangbingtian
 *
 */

@Service
public class MiaoshaUserPermissionServiceImpl
    extends AbstractMybatisPermissionService<MiaoshaUser, MiaoshaUserMapper> 
    implements IMiaoshaUserService {
}
package com.imooc.miaosha;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.imooc.miaosha.entity.Goods;
import com.imooc.miaosha.service.IGoodsService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 2019/11/23 下午1:49
 *
 * @author liangbingtian
 *
 * 用来测试mp的通用service层
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CommonServiceTest {

  @Autowired
  @Qualifier("goodsServiceImpl")
  private IGoodsService goodsService;

  @Test
  public void testSelect() {
    //直接用service查询goods
    Goods goods = goodsService.selectOne(Wrappers.<Goods>lambdaQuery().eq(Goods::getGoodsName, "iphone11"));
    //直接用service查询list
    List<Goods> goodsList = goodsService.selectList(null);
  }

  @Test
  public void testChain() {
    Page<Goods> goodsPage = new Page<>(1, 2);
    IPage<Goods> goodsIPage = goodsService.selectPage(goodsPage, Wrappers.<Goods>lambdaQuery()
        .isNull(Goods::getCreatetime).lt(Goods::getId, 4));
    log.info("总数为:{}", goodsIPage.getTotal());
    log.info("当前记录:{}", goodsIPage.getRecords().toString());
//    goodsService
//        .update(null, Wrappers.<Goods>lambdaUpdate()
//            .eq(Goods::getGoodsName, "iphone11").set(Goods::getGoodsName, "iphone12"));
  }

  @Test
  public void testDelete() {
    int rows = goodsService.deleteById(4L);
    List<Goods> goodsList = goodsService.selectList(null);
  }

}

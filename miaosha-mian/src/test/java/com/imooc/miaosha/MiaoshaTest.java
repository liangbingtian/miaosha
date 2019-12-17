package com.imooc.miaosha;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.imooc.miaosha.entity.Goods;
import com.imooc.miaosha.repository.GoodsMapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * liangbingtian 2019/7/2 下午5:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoshaTest {

  private static final Pattern MOBILE_PATTERN = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");

  @Autowired
  private GoodsMapper goodsMapper;

  @Test
  public void test1() {
    String src = "17610402560";
    Matcher m = MOBILE_PATTERN.matcher(src);
    boolean result = m.matches();
    if (result) {
      System.out.println("成功");
    }

  }

  /**
   * selectByMap
   */
  @Test
  public void test2() {
    Map<String, Object> columnMap = new HashMap<>();
    columnMap.put("goods_name","iphoneX");
    List<Goods> goodsList = goodsMapper.selectByMap(columnMap);
  }

  /**
   * 条件构造器的查询
   */
  @Test
  public void test3() {
    //创建QueryWrapper方法1
    QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
    //创建QueryWrapper方法2
//    QueryWrapper<Goods> queryWrapper1 = Wrappers.query();
    queryWrapper.like("goods_name","华为").lt("id", 5);
    goodsMapper.selectList(queryWrapper);

    queryWrapper.like("goods_name","华为").between("id", 1, 5).isNotNull("goods_img");
    goodsMapper.selectList(queryWrapper);

    //名字为iphone开头或者id大于等于2，按照id降序排列，id相同按照升序排列。
    queryWrapper.likeRight("goods_name","iphone")
        .or().ge("id",2).orderByDesc("id")
        .orderByAsc("goods_price");
  }

  /**
   * 条件构造器查询2
   */
  @Test
  public void test4() {
    //创建日期为2019年2月14日并且直属上级为名字为王姓
    //date_format(create_time,%Y-%m-%d) and manager_id in (select id from user where name like '王%')
    QueryWrapper<Goods> queryWrapper =Wrappers.query();
    queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-02-14 or true")
        .inSql("manager_id","select id from user where name like '王%'");
    goodsMapper.selectList(queryWrapper);

    //姓名为王姓并且（年龄小于40或邮箱不为空）
    //name like '王%' and (age<40 or email is not null)
    queryWrapper.likeRight("name", "王").and(wq->wq.lt("age",40).or().isNotNull("email"));
    List<Goods> goodsList = goodsMapper.selectList(queryWrapper);

  }

  /**
   * 条件构造器3
   */
  @Test
  public void test5() {
    //名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
    QueryWrapper<Goods> queryWrapper = Wrappers.query();
    queryWrapper.likeRight("name","王").or(wq->wq.lt("age",40).gt("age",20).isNotNull("email"));
    List<Goods> goodsList = goodsMapper.selectList(queryWrapper);

    //（年龄小于40或邮箱不为空）并且名字为王姓
    queryWrapper.nested(wq->wq.lt("age",40).or().isNotNull("email")).likeRight("name","王");

    //年龄为(30,31,34,35)
    queryWrapper.in("age", Arrays.asList(30,31,34,35)).last("limit 1");
    goodsMapper.selectList(queryWrapper);
  }

  /**
   * select相关
   */
  @Test
  public void test6() {
    QueryWrapper<Goods> queryWrapper = Wrappers.query();
    //字段少。直接列字段
    queryWrapper.select("id","name").like("name","雨").lt("age",40);
    //进行搜索,并且过滤字段
    queryWrapper.select(Goods.class,info->!info.getColumn().equals("create_time")&&!info.getColumn().equals("manage_id"))
    .like("name", "雨").lt("age",40);
    List<Goods> goodsList = goodsMapper.selectList(queryWrapper);
    //进行搜索，加入condition条件
    String name = "";
    queryWrapper.like(StringUtils.isNotEmpty(name) ,"name" ,name);

    //实体作为条件构造器构造方法的参数。与查询语句互不干扰
    Goods goods = new Goods();
    goods.setGoodsName("1231");
    goods.setGoodsDetail("liangbingtian");
    QueryWrapper<Goods> queryWrapper1 = Wrappers.query(goods);
    List<Goods> goodsList1 = goodsMapper.selectList(queryWrapper1);
  }

  /**
   * alleq
   */
  @Test
  public void test7() {
    QueryWrapper<Goods> queryWrapper = Wrappers.query();
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("id", 1);
    paramMap.put("goods_name","iphoneX");
//    paramMap.put("createtime", null);
//    queryWrapper.allEq(paramMap,false);
//    goodsMapper.selectList(queryWrapper);

    //对键进行过滤
    queryWrapper.allEq((k,v)->!k.equals("goods_name"), paramMap);
    goodsMapper.selectList(queryWrapper);

  }

  /**
   * 其他条件构造查询
   */
  @Test
  public void test8() {
    QueryWrapper<Goods> queryWrapper = Wrappers.query();
    queryWrapper.select("id","goods_name").like("goods_name", "iphoneX").lt("id", 1);
    List<Map<String, Object>> mapList = goodsMapper.selectMaps(queryWrapper);
    //按照直属上级分组，查询每组的平均年龄，最大年龄，最小年龄。并且只取年龄总和小于500的组
    //select avg(age) avg_age,min(age) min_age, max(age) max_age from user group by manager_id having sum(age)<500
    queryWrapper.select("avg(age) avg_age","min(age) min_age","max(age) max_age").groupBy("manager_id")
        .having("sum(age)<{0}", 500);
    List<Map<String, Object>> mapList1 = goodsMapper.selectMaps(queryWrapper);

    List<Object> objectList = goodsMapper.selectObjs(queryWrapper);

    Integer count = goodsMapper.selectCount(queryWrapper);
  }

  /**
   * lambda条件构造器
   */
  @Test
  public void test9() {
    LambdaQueryWrapper<Goods> lambda = new QueryWrapper<Goods>().lambda();
    LambdaQueryWrapper<Goods> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    LambdaQueryWrapper<Goods> lambdaQuery = Wrappers.lambdaQuery();
    lambdaQuery.like(Goods::getGoodsName, "iphoneX").lt(Goods::getId, 5);
    goodsMapper.selectList(lambdaQuery);
    //名字为王姓并且(年龄小于40或邮箱不为空)
    lambdaQuery.likeRight(Goods::getGoodsName,"王").and(lq->lq.lt(Goods::getId,40).or().isNotNull(Goods::getCreatetime));
    goodsMapper.selectList(lambdaQuery);

    //直接使用链式调用
    List<Goods> goodsList = new LambdaQueryChainWrapper<Goods>(goodsMapper).likeRight(Goods::getGoodsName, "王")
        .and(lq->lq.lt(Goods::getId, 40).or().isNotNull(Goods::getCreatetime)).list();
    goodsList.forEach(System.out::println);
  }

  /**
   * 单表分页
   */
  @Test
  public void test10() {
    LambdaQueryWrapper<Goods> lambdaQueryWrapper = Wrappers.lambdaQuery();
    lambdaQueryWrapper.likeRight(Goods::getGoodsName, "王")
        .and(lq->lq.lt(Goods::getId, 40).or().isNotNull(Goods::getCreatetime));
    //添加分页和分页查询(实际上就是物理分页。执行了一条limit的sql又执行了一个查询总数的sql)
    Page<Goods> page = new Page<Goods>(1, 2);
    IPage<Goods> iPage = goodsMapper.selectPage(page, lambdaQueryWrapper);
    System.out.println("总页数:"+iPage.getPages()+"\n总记录数:"+iPage.getTotal());
    //记录
    List<Goods> goodsList = iPage.getRecords();
  }

  /**
   * 更新操作
   */
  @Test
  public void test11() {
//    Goods goods = new Goods();
//    goods.setId((long) 1);
//    goods.setGoodsName("iphone");
//    goodsMapper.updateById(goods);

    //条件更新嘛
    LambdaUpdateWrapper<Goods> lambdaUpdateWrapper = Wrappers.lambdaUpdate();
    lambdaUpdateWrapper.eq(Goods::getId, 1);
    Goods goods1 = new Goods();
    goods1.setGoodsName("iphoneXS");
    goods1.setGoodsTitle(null);
    goodsMapper.update(goods1, lambdaUpdateWrapper);

    //把实体传入条件中可以直接更新
    Goods whereGoods = new Goods();
    UpdateWrapper<Goods> updateWrapper = Wrappers.update(whereGoods);
    goodsMapper.update(goods1,updateWrapper);

  }

  /**
   * 用wrapper的set去更新少量的字段
   */
  @Test
  public void test12() {
    LambdaUpdateWrapper<Goods> goodsLambdaUpdateWrapper = Wrappers.lambdaUpdate();
    goodsLambdaUpdateWrapper.eq(Goods::getId, 1).set(Goods::getGoodsName, "iphone11");
    goodsMapper.update(null, goodsLambdaUpdateWrapper);

    //链式构造器,返回true和false
    boolean result = new LambdaUpdateChainWrapper<Goods>(goodsMapper).eq(Goods::getId, 40)
        .set(Goods::getGoodsName, "iphone9").update();
  }

  /**
   * 删除方法
   */
  @Test
  public void test13() {
    goodsMapper.deleteBatchIds(Arrays.asList(4,5,6));
    //带条件构造器的删除,使用queryWrapper
    goodsMapper.delete(new LambdaQueryWrapper<Goods>()
        .eq(Goods::getGoodsName, "iphone").or().le(Goods::getId, 4));
  }

  /**
   * lambdaQueryWrapper测试
   */
  @Test
  public void lambdaQueryWrapperTest() {
//    List<Goods> goodsList = new LambdaQueryChainWrapper<Goods>(goodsMapper).likeRight(Goods::getGoodsName, "iphone").in(Goods::getId, Arrays.asList(1,2,3,4)).list();

    List<Goods> goodsList1 = goodsMapper.selectList(new LambdaQueryWrapper<Goods>().likeRight(Goods::getGoodsName, "iphone").in(Goods::getId, Arrays.asList(1,2,3,4)));
  }



}

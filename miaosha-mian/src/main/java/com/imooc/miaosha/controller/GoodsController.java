package com.imooc.miaosha.controller;

import com.imooc.miaosha.entity.Goods;
import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.redis.GoodsKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.IGoodsService;
import com.imooc.miaosha.util.BeanUtils;
import com.imooc.miaosha.vo.GoodsDetailVo;
import com.imooc.miaosha.vo.GoodsVo;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.context.webflux.SpringWebFluxContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * liangbingtian 2019/6/28 下午2:33
 * 
 * @author liangbingtian
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  @Qualifier("goodsServiceImpl")
  private IGoodsService goodsService;

  @Autowired
  private RedisService redisService;

  @Autowired
  private ThymeleafViewResolver thymeleafViewResolver;

  @Autowired
  private ApplicationContext applicationContext;

  @RequestMapping(value = "/to_list", produces = "text/html")
  @ResponseBody
  public String toList(HttpServletRequest request, HttpServletResponse response,
      Model model, MiaoshaUser miaoshaUser) {
    logger.info("进入了接口了");
    model.addAttribute("user", miaoshaUser);
    // 取缓存
    String html = redisService.get(GoodsKey.getGoodsList, "", String.class);
    if (!StringUtils.isEmpty(html)) {
      return html;
    }

    List<Goods> goodsVoList = goodsService.selectList(null);
    model.addAttribute("goodsList", BeanUtils.batchTransform(GoodsVo.class, goodsVoList));

    // return "goods_list";

    //手动渲染
    WebContext ctx = new WebContext(request, response, request.getServletContext()
        , request.getLocale(), model.asMap());
    html = thymeleafViewResolver.getTemplateEngine().process("goods_list", ctx);
    if (!StringUtils.isEmpty(html)) {
      redisService.set(GoodsKey.getGoodsList, "", html);
    }
    return html;
  }


  @RequestMapping(value = "/to_detail1/{goodsId}", produces = "text/html")
  @ResponseBody
  public String detail1(HttpServletRequest request, HttpServletResponse response,
      Model model, MiaoshaUser miaoshaUser, @PathVariable("goodsId") long goodsId) {
    logger.info("进入了接口了");
    // 用snowflack生成id主键
    model.addAttribute("user", miaoshaUser);
    //取缓存
    String html = redisService.get(GoodsKey.getGoodsDetail,""+goodsId,String.class);
    if (!StringUtils.isEmpty(html)) {
      return html;
    }

    GoodsVo goodsVo = BeanUtils.transfrom(GoodsVo.class ,goodsService.selectById(goodsId));
    model.addAttribute("goods", goodsVo);

    // 获取开始时间和结束时间
    int miaoshaStatus = 0;
    int remainSeconds = 0;

    long startAt = goodsVo.getStartDate().getTime();
    long endAt = goodsVo.getEndDate().getTime();
    long now = System.currentTimeMillis();

    // 秒杀的过程
    if (now < startAt) {
      // 秒杀还没开始,倒计时
      miaoshaStatus = 0;
      remainSeconds = (int) ((startAt - now) / 1000);
    } else if (now > endAt) {
      // 秒杀已经结束
      miaoshaStatus = 2;
      remainSeconds = -1;
    } else {
      // 秒杀进行中
      miaoshaStatus = 1;
      remainSeconds = 0;
    }

    model.addAttribute("miaoshaStatus", miaoshaStatus);
    model.addAttribute("remainSeconds", remainSeconds);

    //手动渲染
    WebContext ctx = new WebContext(request, response, request.getServletContext()
        , request.getLocale(), model.asMap());
    html = thymeleafViewResolver.getTemplateEngine().process("goods_detail", ctx);
    if (!StringUtils.isEmpty(html)) {
      redisService.set(GoodsKey.getGoodsDetail, ""+goodsId, html);
    }
    return html;
  }

  @RequestMapping(value = "/to_detail/{goodsId}", produces = "text/html")
  @ResponseBody
  public Result<GoodsDetailVo> detail(HttpServletRequest request, HttpServletResponse response,
      Model model, MiaoshaUser miaoshaUser, @PathVariable("goodsId") long goodsId) {
    logger.info("进入了接口了");
    // 用snowflack生成id主键
    GoodsVo goodsVo = BeanUtils.transfrom(GoodsVo.class ,goodsService.selectById(goodsId));

    // 获取开始时间和结束时间
    int miaoshaStatus = 0;
    int remainSeconds = 0;

    long startAt = goodsVo.getStartDate().getTime();
    long endAt = goodsVo.getEndDate().getTime();
    long now = System.currentTimeMillis();

    // 秒杀的过程
    if (now < startAt) {
      // 秒杀还没开始,倒计时
      miaoshaStatus = 0;
      remainSeconds = (int) ((startAt - now) / 1000);
    } else if (now > endAt) {
      // 秒杀已经结束
      miaoshaStatus = 2;
      remainSeconds = -1;
    } else {
      // 秒杀进行中
      miaoshaStatus = 1;
      remainSeconds = 0;
    }

    model.addAttribute("miaoshaStatus", miaoshaStatus);
    model.addAttribute("remainSeconds", remainSeconds);

    GoodsDetailVo vo = new GoodsDetailVo();
    vo.setGoodsVo(goodsVo);
    vo.setMiaoshaUser(miaoshaUser);
    vo.setRemainSeconds(remainSeconds);
    vo.setMiaoshaStatus(miaoshaStatus);
    return Result.success(vo);
  }

}

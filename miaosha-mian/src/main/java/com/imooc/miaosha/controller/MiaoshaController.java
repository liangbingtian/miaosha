package com.imooc.miaosha.controller;

import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.entity.OrderInfo;
import com.imooc.miaosha.rabbitmq.MiaoshaMessage;
import com.imooc.miaosha.rabbitmq.MQSender;
import com.imooc.miaosha.redis.GoodsKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaService;
import com.imooc.miaosha.service.OrderService;
import com.imooc.miaosha.vo.GoodsVo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 2019/7/9 上午11:30
 *
 * @author liangbingtian
 */
@Controller
@RequestMapping("/miaosha")
public class MiaoshaController implements InitializingBean {

  @Autowired
  private GoodsService goodsService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private MiaoshaService miaoshaService;

  @Autowired
  private RedisService redisService;

  @Autowired
  private MQSender mqSender;

  private static Map<Long, Boolean> localOverMap = new HashMap<>();

  /**
   * 系统初始化
   * @throws Exception
   */
  @Override
  public void afterPropertiesSet() throws Exception {
    List<GoodsVo> goodsVoList = goodsService.listGoodsVo();
    if (CollectionUtils.isEmpty(goodsVoList)) {
      return;
    }
    goodsVoList.forEach(data->{
      redisService.set(GoodsKey.getMiaoshaGoodsStock,""+data.getId(), data.getStockCount());
      localOverMap.put(data.getId(), false);
    });
  }

  @RequestMapping(value = "/do_miaosha", method = RequestMethod.POST)
  @ResponseBody
  public Result<Integer> list(Model model, MiaoshaUser user,
      @RequestParam("goodsId") long goodsId) {
    model.addAttribute("user", user);
    if (user == null) {
      return Result.error(CodeMsg.SESSION_ERROR);
    }
    //利用内存标记来减少redis的访问
    boolean over = localOverMap.get(goodsId);
    if (over) {
      return Result.error(CodeMsg.MIAO_SHA_OVER);
    }
    //遇减库存
    long stock = redisService.decr(GoodsKey.getMiaoshaGoodsStock,""+goodsId);
    if (stock < 0) {
      localOverMap.put(goodsId, true);
      return Result.error(CodeMsg.MIAOSHA_FAIL);
    }

    //入队， 入完队之后客户端去轮训
    MiaoshaMessage mm = new MiaoshaMessage();
    mm.setUser(user);
    mm.setGoodsId(goodsId);
    mqSender.sendMiaoshaMessage(mm);
    return Result.success(0);//排队中


//    GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
//    int stock = goodsVo.getStockCount();
//    if (stock <= 0) {
//      return Result.error(CodeMsg.MIAO_SHA_OVER);
//    }
//
//    //判断是否已经秒杀到了,看有没有秒杀order
//    MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
//    if (order != null) {
//      return Result.error(CodeMsg.REPEATE_MIAOSHA);
//    }
//
//    //减库存 下订单 写入秒杀订单
//    OrderInfo orderInfo = miaoshaService.miaosha(user, goodsVo);
//    model.addAttribute("orderInfo", orderInfo);
//    model.addAttribute("goods", goodsVo);
//
//    return Result.success(orderInfo);


  }

  /**
   * 返回orderId:表示秒杀成功
   * 返回-1:表示库存不足
   * 0:排队中
   */
  @RequestMapping(value = "/result", method = RequestMethod.GET)
  @ResponseBody
  public Result<Long> miaoshaResult(Model model, MiaoshaUser user,
      @RequestParam("goodsId") long goodsId) {
    if (user == null) {
      return Result.error(CodeMsg.SESSION_ERROR);
    }
    long result = miaoshaService.getMiaoshaResult(user.getId(), goodsId);
    return Result.success(result);
  }


}

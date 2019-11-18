package com.imooc.miaosha.controller;

import com.imooc.miaosha.entity.MiaoshaOrder;
import com.imooc.miaosha.entity.MiaoshaUser;
import com.imooc.miaosha.entity.OrderInfo;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaService;
import com.imooc.miaosha.service.OrderService;
import com.imooc.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 2019/7/9 上午11:30
 *
 * @author liangbingtian
 */
@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

  @Autowired
  private GoodsService goodsService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private MiaoshaService miaoshaService;

  @RequestMapping("/do_miaosha")
  public String list(Model model, MiaoshaUser user,
      @RequestParam("goodsId") long goodsId) {
    model.addAttribute("user", user);
    if (user == null) {
      return "login";
    }

    GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
    int stock = goodsVo.getStockCount();
    if (stock <= 0) {
      model.addAttribute("errmsg", CodeMsg.MIAO_SHA_OVER.getMsg());
      return "miaosha_fail";
    }

    //判断是否已经秒杀到了,看有没有秒杀order
    MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
    if (order != null) {
      model.addAttribute("errmsg", CodeMsg.REPEATE_MIAOSHA.getMsg());
      return "miaosha_fail";
    }

    //减库存 下订单 写入秒杀订单
    OrderInfo orderInfo = miaoshaService.miaosha(user, goodsVo);
    model.addAttribute("orderInfo", orderInfo);
    model.addAttribute("goods", goodsVo);

    return "order_detail";
  }

}

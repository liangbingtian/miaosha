package com.imooc.miaosha;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 * liangbingtian 2019/7/2 下午5:01
 */
public class MiaoshaTest {

  private static final Pattern MOBILE_PATTERN = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");

  @Test
  public void test1() {
    String src = "17610402560";
    Matcher m = MOBILE_PATTERN.matcher(src);
    boolean result = m.matches();
    if (result) {
      System.out.println("成功");
    }

  }

}

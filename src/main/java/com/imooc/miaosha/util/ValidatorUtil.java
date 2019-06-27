package com.imooc.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * liangbingtian 2019/6/27 下午4:56
 */
public class ValidatorUtil {

  private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

  public static boolean isMobile(String src) {
    if (StringUtils.isEmpty(src)) {
      return false;
    }
    Matcher m = mobile_pattern.matcher(src);
    return m.matches();
  }

}

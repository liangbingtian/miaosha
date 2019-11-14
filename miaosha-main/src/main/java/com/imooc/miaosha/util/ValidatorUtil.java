package com.imooc.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * liangbingtian 2019/6/27 下午4:56
 * @author liangbingtian
 */
public class ValidatorUtil {

  private static final Pattern MOBILE_PATTERN = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");

  public static boolean isMobile(String src) {
    if (StringUtils.isEmpty(src)) {
      return false;
    }
    Matcher m = MOBILE_PATTERN.matcher(src);
    return m.matches();
  }

}

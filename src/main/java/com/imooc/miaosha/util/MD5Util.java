package com.imooc.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * liangbingtian 2019/6/26 下午3:15
 */
public class MD5Util {

  public static String md5(String src) {
    return DigestUtils.md5Hex(src);
  }

  private static final String salt = "1a2b3c4d";

  public static String inputPassToFormPass(String inputPass) {
    String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
    return md5(str);
  }

  public static String formPassToDBPass(String formPass, String salt) {
    String str = salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
    return md5(str);
  }

  public static String inputPassToDbPass(String input, String salt) {
    String formPass = inputPassToFormPass(input);
    return formPassToDBPass(formPass, salt);
  }

  public static void main(String[] args) {
    System.out.println(formPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9","1a2b3c4d"));
  }
}

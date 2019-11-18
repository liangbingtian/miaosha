package com.imooc.miaosha.vo;

import com.imooc.miaosha.validator.IsMobile;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * liangbingtian 2019/6/27 上午10:56
 */
public class LoginVo {

  @NotNull
  @IsMobile
  private String mobile;

  @Length(min = 32)
  private String password;

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "LoginVo{" +
        "mobile='" + mobile + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}

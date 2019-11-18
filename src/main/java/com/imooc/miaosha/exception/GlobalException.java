package com.imooc.miaosha.exception;

import com.imooc.miaosha.result.CodeMsg;
import lombok.Getter;

/**
 * liangbingtian 2019/6/28 下午1:52
 * @author liangbingtian
 */
@Getter
public class GlobalException extends RuntimeException{

  private static final long serialVersionUID = 1L;

  private CodeMsg codeMsg;

  public GlobalException(CodeMsg codeMsg) {
    super(codeMsg.toString());
    this.codeMsg = codeMsg;
  }

}

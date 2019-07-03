package com.imooc.miaosha.exception;

import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * liangbingtian 2019/6/27 下午9:10
 * @author liangbingtian
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
    if (e instanceof GlobalException) {
      GlobalException globalException = (GlobalException) e;
      return Result.error(globalException.getCodeMsg());
    } else if (e instanceof BindException) {
      BindException ex = (BindException) e;
      List<ObjectError> errors = ex.getAllErrors();
      ObjectError objectError = errors.get(0);
      String msg = objectError.getDefaultMessage();
      return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
    } else {
      return Result.error(CodeMsg.SERVER_ERROR);
    }

  }

}

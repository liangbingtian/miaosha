package com.yonyou.einvoice.common.metadata.enums;

import com.yonyou.einvoice.common.metadata.element.Source;
import java.util.List;

public enum TypeEnum {
  SOURCE("source"),
  CONSTANT("constant"),
  LIST("list");

  String code;

  TypeEnum(String code) {
    this.code = code;
  }

  public static TypeEnum getType(Object obj) {
    if(obj == null) {
      return CONSTANT;
    }
    if(obj instanceof Source) {
      return SOURCE;
    }
    if(obj instanceof List) {
      return LIST;
    }
    // 默认类型
    return CONSTANT;
  }

}

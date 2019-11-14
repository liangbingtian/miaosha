package com.yonyou.einvoice.common.metadata.enums;

import lombok.Getter;

@Getter
public enum DirectionEnum {
  ASC("asc"),
  DESC("desc");
  String code;

  DirectionEnum(String code) {
    this.code = code;
  }
}

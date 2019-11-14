package com.yonyou.einvoice.common.metadata.enums;

import lombok.Getter;

@Getter
public enum AggrEnum {
  SUM("sum"), COUNT("count");
  private String code;

  AggrEnum(String code) {
    this.code = code;
  }
}

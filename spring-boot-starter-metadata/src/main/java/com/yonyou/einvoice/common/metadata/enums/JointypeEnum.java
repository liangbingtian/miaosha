package com.yonyou.einvoice.common.metadata.enums;

import lombok.Getter;

@Getter
public enum JointypeEnum {
  LEFTJOIN("left join"),
  RIGHTJOIN("right join"),
  INNERJOIN("inner join"),
  FULLJOIN("full join");

  String code;

  JointypeEnum(String code) {
    this.code = code;
  }
}

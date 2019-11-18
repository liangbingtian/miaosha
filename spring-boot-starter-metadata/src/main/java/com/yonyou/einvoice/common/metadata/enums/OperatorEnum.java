package com.yonyou.einvoice.common.metadata.enums;

import lombok.Getter;

@Getter
public enum OperatorEnum {
  EQUAL("="),
  NOTEQUAL("<>"),
  GREATER(">"),
  LESS("<"),
  GREATEREQUAL(">="),
  LESSEQUAL("<="),
  LIKE("like"),
  IN("in"),
  NOTIN("not in"),
  ISNULL("is null"),
  ISNOTNULL("is not null"),
  AND("and"),
  BETWEEN("between"),
  OR("or");

  String code;

  OperatorEnum(String code) {
    this.code = code;
  }

}

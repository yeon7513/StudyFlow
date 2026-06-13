package com.project.sf.common.searchFilter.constance.enums.reservation;

public enum CanceledReasonEnum {
  SIMPLE_CHANGE("단순 변심", "simple_change"),
  MISTAKE("예약 정보 오입력", "mistake"),
  OTHER_SERVICE("타 서비스 발견", "other_service"),
  WAITING_TOO_LONG("출시 대기 지루함", "waiting_too_long"),
  EXTRA("기타", "extra");

  private final String label;
  private final String value;

  CanceledReasonEnum(String label, String value) {
    this.label = label;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public String getValue() {
    return value;
  }
}

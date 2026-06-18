package com.project.sf.common.enums.reservation;

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

  // 영문을 한글로 -> value를 label로
  public static String changeValueToLabel(String value) {
    for (CanceledReasonEnum canceledReasonEnum : CanceledReasonEnum.values()) {
      if (canceledReasonEnum.getValue().equals(value)) {
        return canceledReasonEnum.getLabel();
      }
    }
    return "알 수 없음";
  }

  public String getLabel() {
    return label;
  }

  public String getValue() {
    return value;
  }
}

package com.project.sf.common.enums.inquiry;

public enum InquiryCategoryEnum {
  RESERVATION("예약관련", "reservation"),
  LAUNCH("정식출시문의", "launch"),
  MATCHING("매칭관련", "matching"),
  SERVICE("서비스문의", "service"),
  EXTRA("기타문의", "extra");

  private final String label;
  private final String value;

  InquiryCategoryEnum(String label, String value) {
    this.label = label;
    this.value = value;
  }

  public static String changeValueToLabel(String value) {
    for (InquiryCategoryEnum inquiryCategoryEnum : InquiryCategoryEnum.values()) {
      if (inquiryCategoryEnum.getValue().equals(value)) {
        return inquiryCategoryEnum.getLabel();
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

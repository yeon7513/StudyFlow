package com.project.sf.common.searchFilter.constance.enums.reservation;

public enum ReserveStateEnum {
  ACTIVE("예약중", "active"),
  CANCELED("예약 취소", "canceled"),
  ALL("전체", "all");

  private final String label;
  private final String value;

  ReserveStateEnum(String label, String value) {
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

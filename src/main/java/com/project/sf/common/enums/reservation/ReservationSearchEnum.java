package com.project.sf.common.enums.reservation;

public enum ReservationSearchEnum {
  RSV_NO("예약 번호", "rsvNo"),
  EMAIL("이메일", "email"),
  NAME("예약자명", "name"),
  USER_IP("아이피", "userIp");

  private final String label;
  private final String value;

  ReservationSearchEnum(String label, String value) {
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

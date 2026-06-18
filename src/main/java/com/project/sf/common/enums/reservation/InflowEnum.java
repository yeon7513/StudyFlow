package com.project.sf.common.enums.reservation;

public enum InflowEnum {
  INSTAGRAM("인스타그램", "instagram"),
  SEARCH_ENGINE("검색 엔진", "search_engine"),
  RECOMMEND("지인 추천", "recommend"),
  COMMUNITY("커뮤니티", "community"),
  FACEBOOK("페이스북", "facebook"),
  EXTRA("기타", "extra");

  private final String label;
  private final String value;

  InflowEnum(String label, String value) {
    this.label = label;
    this.value = value;
  }

  // 영문을 한글로 -> value를 label로
  public static String changeValueToLabel(String value) {
    for (InflowEnum inflowEnum : InflowEnum.values()) {
      if (inflowEnum.getValue().equals(value)) {
        return inflowEnum.getLabel();
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

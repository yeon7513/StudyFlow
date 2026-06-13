package com.project.sf.common.searchFilter.constance.enums.reservation;

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

  public String getLabel() {
    return label;
  }

  public String getValue() {
    return value;
  }
}

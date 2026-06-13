package com.project.sf.common.searchFilter.constance.enums.inquiry;

public enum AnswerStateEnum {
  WAITING("답변 대기", "waiting"),
  ANSWERED("답변 완료", "answered"),
  ALL("전체", "all");

  private final String label;
  private final String value;

  AnswerStateEnum(String label, String value) {
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

package com.project.sf.common.enums.reservation;

public enum StudyLevelEnum {
  BEGINNER("입문", "beginner"),
  NOVICE("초급", "novice"),
  INTERMEDIATE("중급", "intermediate"),
  ADVANCED("고급", "advanced");

  private final String label;
  private final String value;

  StudyLevelEnum(String label, String value) {
    this.label = label;
    this.value = value;
  }

  // 영문을 한글로 -> value를 label로
  public static String changeValueToLabel(String value) {
    for (StudyLevelEnum studyLevelEnum : StudyLevelEnum.values()) {
      if (studyLevelEnum.getValue().equals(value)) {
        return studyLevelEnum.getLabel();
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

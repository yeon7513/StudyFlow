package com.project.sf.common.enums.operator;

import java.util.ArrayList;
import java.util.List;

public enum AdminRoleEnum {
  SUPER("최고 관리자", "ROLE_SUPER"),
  RESERVE("예약 관리", "ROLE_RESERVE"),
  INQUIRY("문의 관리", "ROLE_INQUIRY"),
  INTEREST("관심 분야 관리", "ROLE_INTEREST"),
  BLACKLIST("블랙리스트 관리", "ROLE_BLACKLIST");

  private final String label;
  private final String value;

  AdminRoleEnum(String label, String value) {
    this.label = label;
    this.value = value;
  }

  // 여러 권한이 합쳐진 문자열을 한글로 변환
  public static List<String> changeValueToLabel(String roleValue) {
    List<String> labels = new ArrayList<>();

    if (roleValue == null || roleValue.trim().isEmpty()) {
      labels.add("권한 없음");
      return labels;
    }

    String[] values = roleValue.split(",");

    for (String value : values) {
      for (AdminRoleEnum adminRoleEnum : AdminRoleEnum.values()) {
        if (adminRoleEnum.getValue().equals(value.trim())) {
          labels.add(adminRoleEnum.getLabel());
          break;
        }
      }
    }

    // 한글로 반환
    return labels;
  }

  public String getLabel() {
    return label;
  }

  public String getValue() {
    return value;
  }

}

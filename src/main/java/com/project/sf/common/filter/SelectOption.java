package com.project.sf.common.filter;

// select의 name, value용
public class SelectOption {
  private final String label;
  private final String value;
  private boolean isSelected = false;

  private SelectOption(String label, String value, boolean isSelected) {
    this.label = label;
    this.value = value;
    this.isSelected = isSelected;
  }

  // 기본 옵션
  public static SelectOption of(String label, String value) {
    return new SelectOption(label, value, false);
  }

  // 선택된 옵션
  public static SelectOption selected(String label, String value) {
    return new SelectOption(label, value, true);
  }

  public String getLabel() {
    return label;
  }

  public String getValue() {
    return value;
  }

  public boolean isSelected() {
    return isSelected;
  }

}

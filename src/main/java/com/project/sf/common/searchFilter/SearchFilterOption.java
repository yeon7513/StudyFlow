package com.project.sf.common.searchFilter;

// select의 name, value용
public class SearchFilterOption {
  private final String label;
  private final String value;
  private boolean isSelected = false;

  private SearchFilterOption(String label, String value, boolean isSelected) {
    this.label = label;
    this.value = value;
    this.isSelected = isSelected;
  }

  // 기본 옵션
  public static SearchFilterOption of(String label, String value) {
    return new SearchFilterOption(label, value, false);
  }

  // 선택된 옵션
  public static SearchFilterOption selected(String label, String value) {
    return new SearchFilterOption(label, value, true);
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

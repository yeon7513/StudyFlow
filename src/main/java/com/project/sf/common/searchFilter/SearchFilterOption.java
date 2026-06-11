package com.project.sf.common.searchFilter;

// select의 name, value용
public class SearchFilterOption {
  private final String label;
  private final String value;
  private boolean isSelected = false;

  public SearchFilterOption(String label, String value) {
    this.label = label;
    this.value = value;
  }

  public SearchFilterOption(String label, String value, boolean isSelected) {
    this.label = label;
    this.value = value;
    this.isSelected = isSelected;
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

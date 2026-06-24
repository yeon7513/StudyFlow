package com.project.sf.admin.interest.model;

public class AdminInterestKeywordStats {
  // 통계용 필드
  private int selectionCount; // 관심 사용자 수
  private int selectionRatio; // 카테고리 내 점유율
  private int totalKeywordInCategory; // 해당 카테고리에 등록된 전체 키워드 수

  // getter, setter
  public int getSelectionCount() {
    return selectionCount;
  }

  public void setSelectionCount(int selectionCount) {
    this.selectionCount = selectionCount;
  }

  public int getSelectionRatio() {
    return selectionRatio;
  }

  public void setSelectionRatio(int selectionRatio) {
    this.selectionRatio = selectionRatio;
  }

  public int getTotalKeywordInCategory() {
    return totalKeywordInCategory;
  }

  public void setTotalKeywordInCategory(int totalKeywordInCategory) {
    this.totalKeywordInCategory = totalKeywordInCategory;
  }
}

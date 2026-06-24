package com.project.sf.admin.interest.model;

// 대시보드 - 관심 분야 관리 위젯
public class AdminInterestWidget {
  private int totalCategory; // 전체 카테고리 수
  private int emptyCategory; // 빈 카테고리 수
  private int activeCategory; // 활성 카테고리 수
  private int inactiveCategory; // 비활성 카테고리 수

  private int totalKeyword; // 전체 키워드 수
  private int activeKeyword; // 활성 키워드 수
  private int inactiveKeyword; // 비활성 키워드 수

  // getter, setter
  public int getTotalCategory() {
    return totalCategory;
  }

  public void setTotalCategory(int totalCategory) {
    this.totalCategory = totalCategory;
  }

  public int getEmptyCategory() {
    return emptyCategory;
  }

  public void setEmptyCategory(int emptyCategory) {
    this.emptyCategory = emptyCategory;
  }

  public int getTotalKeyword() {
    return totalKeyword;
  }

  public void setTotalKeyword(int totalKeyword) {
    this.totalKeyword = totalKeyword;
  }

  public int getActiveKeyword() {
    return activeKeyword;
  }

  public void setActiveKeyword(int activeKeyword) {
    this.activeKeyword = activeKeyword;
  }

  public int getInactiveKeyword() {
    return inactiveKeyword;
  }

  public void setInactiveKeyword(int inactiveKeyword) {
    this.inactiveKeyword = inactiveKeyword;
  }

  public int getActiveCategory() {
    return activeCategory;
  }

  public void setActiveCategory(int activeCategory) {
    this.activeCategory = activeCategory;
  }

  public int getInactiveCategory() {
    return inactiveCategory;
  }

  public void setInactiveCategory(int inactiveCategory) {
    this.inactiveCategory = inactiveCategory;
  }
}

package com.project.sf.admin.interest.model;

public class AdminInterestKeyword {
  private Long no; // 키워드 고유 번호
  private Long cateNo; // 카테고리 고유 번호
  private String adminId; // 등록한 관리자
  private String name; // 키워드명
  private String description; // 키워드 설명
  private boolean isActive; // 키워드 활성 여부
  private String createdAt; // 생성일
  private String updatedAt; // 수정일

  // 조인용 필드
  private String categoryName; // 카테고리명

  // getter, setter
  public Long getNo() {
    return no;
  }

  public void setNo(Long no) {
    this.no = no;
  }

  public Long getCateNo() {
    return cateNo;
  }

  public void setCateNo(Long cateNo) {
    this.cateNo = cateNo;
  }

  public String getAdminId() {
    return adminId;
  }

  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}

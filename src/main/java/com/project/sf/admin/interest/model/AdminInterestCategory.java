package com.project.sf.admin.interest.model;

import java.util.List;
import java.util.Map;

public class AdminInterestCategory {
  private Long no; // 카테고리 고유 번호
  private String adminId; // 카테고리를 생성한 관리자
  private String name; // 카테고리명
  private boolean isActive; // 카테고리 활성 상태
  private String createdAt; // 카테고리 생성일
  private String updatedAt; // 카테고리 수정일

  // 조인용 필드 - 키워드명, 키워드 상세 설명, 키워드 등록 관리자, 키워드 등록일, 키워드 수정일, 활성 상태
  private List<Map<String, String>> keywordInfo;

  // getter, setter
  public Long getNo() {
    return no;
  }

  public void setNo(Long no) {
    this.no = no;
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

  public List<Map<String, String>> getKeywordInfo() {
    return keywordInfo;
  }

  public void setKeywordInfo(List<Map<String, String>> keywordInfo) {
    this.keywordInfo = keywordInfo;
  }
}

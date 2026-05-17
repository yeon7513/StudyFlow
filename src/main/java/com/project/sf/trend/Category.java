package com.project.sf.trend;

import java.util.List;
import java.util.Map;

public class Category {
  private Long no;
  private String name;
  private String adminId;
  private boolean isActive;
  private String createdAt;
  private String updatedAt;

  // 렌더링용 필드 (키워드명 리스트)
  private List<Map<String, String>> keywordInfo;

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Long getNo() {
    return no;
  }

  public void setNo(Long no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAdminId() {
    return adminId;
  }

  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public List<Map<String, String>> getKeywordInfo() {
    return keywordInfo;
  }

  public void setKeywordInfo(List<Map<String, String>> keywordInfo) {
    this.keywordInfo = keywordInfo;
  }

}

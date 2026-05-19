package com.project.sf.preorder;

import java.util.List;
import com.project.sf.trend.SelectedKeyword;

public class Reservation {
  private String email;
  private String userIp;
  private String name;
  private String phone;
  private String createdAt;

  // 선택한 키워드용 필드 (INSERT 및 JOIN용)
  private List<SelectedKeyword> selectedKeywords;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getUserIp() {
    return userIp;
  }

  public void setUserIp(String userIp) {
    this.userIp = userIp;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public List<SelectedKeyword> getSelectedKeywords() {
    return selectedKeywords;
  }

  public void setSelectedKeywords(List<SelectedKeyword> selectedKeywords) {
    this.selectedKeywords = selectedKeywords;
  }

}

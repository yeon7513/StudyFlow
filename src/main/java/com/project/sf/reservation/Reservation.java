package com.project.sf.reservation;

import java.util.List;

public class Reservation {
  private Long no; // 예약 고유 번호
  private String email; // 예약자 이메일
  private String userIp; // 예약자 IP 주소
  private String password; // 비밀번호 (예약 조회 시 사용)
  private String name; // 예약자명
  private String phone; // 예약자 연락처
  private String region; // 지역
  private String inflow; // 유입경로
  private String createdAt; // 예약일
  private boolean isCanceled; // 취소 여부
  private String canceledReason; // 취소 사유
  private String canceledAt; // 취소일

  // 선택한 키워드용 필드 (INSERT 및 JOIN용)
  private List<SelectedKeyword> selectedKeywords;

  public Long getNo() {
    return no;
  }

  public void setNo(Long no) {
    this.no = no;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserIp() {
    return userIp;
  }

  public void setUserIp(String userIp) {
    this.userIp = userIp;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getInflow() {
    return inflow;
  }

  public void setInflow(String inflow) {
    this.inflow = inflow;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public boolean isCanceled() {
    return isCanceled;
  }

  public void setCanceled(boolean isCanceled) {
    this.isCanceled = isCanceled;
  }

  public String getCanceledReason() {
    return canceledReason;
  }

  public void setCanceledReason(String canceledReason) {
    this.canceledReason = canceledReason;
  }

  public String getCanceledAt() {
    return canceledAt;
  }

  public void setCanceledAt(String canceledAt) {
    this.canceledAt = canceledAt;
  }

  public List<SelectedKeyword> getSelectedKeywords() {
    return selectedKeywords;
  }

  public void setSelectedKeywords(List<SelectedKeyword> selectedKeywords) {
    this.selectedKeywords = selectedKeywords;
  }

}

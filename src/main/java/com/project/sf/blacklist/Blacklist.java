package com.project.sf.blacklist;

public class Blacklist {
  private Long no;
  private Long postNo;
  private String blockedIp;
  private String adminId;
  private String reason;
  private String createdAt;

  public Long getNo() {
    return no;
  }

  public void setNo(Long no) {
    this.no = no;
  }

  public Long getPostNo() {
    return postNo;
  }

  public void setPostNo(Long postNo) {
    this.postNo = postNo;
  }

  public String getBlockedIp() {
    return blockedIp;
  }

  public void setBlockedIp(String blockedIp) {
    this.blockedIp = blockedIp;
  }

  public String getAdminId() {
    return adminId;
  }

  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
}

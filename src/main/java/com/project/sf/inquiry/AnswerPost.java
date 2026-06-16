package com.project.sf.inquiry;

public class AnswerPost {
  private Long postNo;
  private String adminId;
  private String answeredText;
  private String answeredAt;

  public Long getPostNo() {
    return postNo;
  }

  public void setPostNo(Long postNo) {
    this.postNo = postNo;
  }

  public String getAdminId() {
    return adminId;
  }

  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }

  public String getAnsweredText() {
    return answeredText;
  }

  public void setAnsweredText(String answeredText) {
    this.answeredText = answeredText;
  }

  public String getAnsweredAt() {
    return answeredAt;
  }

  public void setAnsweredAt(String answeredAt) {
    this.answeredAt = answeredAt;
  }
}

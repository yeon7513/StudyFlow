package com.project.sf.qna.board;

public class Board {
  private Long no;
  private String writerIp;
  private String postPw;
  private String title;
  private String text;
  private boolean isActive;
  private String createdAt;
  private boolean isAnswered;
  private String adminId;
  private String answeredText;
  private String answeredAt;

  public Long getNo() {
    return no;
  }

  public void setNo(Long no) {
    this.no = no;
  }

  public String getWriterIp() {
    return writerIp;
  }

  public void setWriterIp(String writerIp) {
    this.writerIp = writerIp;
  }

  public String getPostPw() {
    return postPw;
  }

  public void setPostPw(String postPw) {
    this.postPw = postPw;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  public boolean isAnswered() {
    return isAnswered;
  }

  public void setAnswered(boolean isAnswered) {
    this.isAnswered = isAnswered;
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

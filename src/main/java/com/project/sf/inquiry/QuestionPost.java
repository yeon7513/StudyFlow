package com.project.sf.inquiry;

public class QuestionPost {
  private Long no;
  private String writerIp;
  private String postPw;
  private String category;
  private String title;
  private String text;
  private boolean isAnswered;
  private boolean isActive;
  private String createdAt;
  private String updatedAt;

  // 답변
  private AnswerPost answerPost;

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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public AnswerPost getAnswerPost() {
    return answerPost;
  }

  public void setAnswerPost(AnswerPost answerPost) {
    this.answerPost = answerPost;
  }

  public boolean isAnswered() {
    return isAnswered;
  }

  public void setAnswered(boolean isAnswered) {
    this.isAnswered = isAnswered;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}

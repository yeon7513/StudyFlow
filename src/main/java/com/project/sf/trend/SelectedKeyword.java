package com.project.sf.trend;

public class SelectedKeyword {
  private Long kwdNo;
  private String rsvEmail;
  private String userIp;
  private String studyLevel;
  private String createdAt;

  private String keywordName;

  public String getRsvEmail() {
    return rsvEmail;
  }

  public void setRsvEmail(String rsvEmail) {
    this.rsvEmail = rsvEmail;
  }

  public Long getKwdNo() {
    return kwdNo;
  }

  public void setKwdNo(Long kwdNo) {
    this.kwdNo = kwdNo;
  }

  public String getStudyLevel() {
    return studyLevel;
  }

  public void setStudyLevel(String studyLevel) {
    this.studyLevel = studyLevel;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUserIp() {
    return userIp;
  }

  public void setUserIp(String userIp) {
    this.userIp = userIp;
  }

  public String getKeywordName() {
    return keywordName;
  }

  public void setKeywordName(String keywordName) {
    this.keywordName = keywordName;
  }

}

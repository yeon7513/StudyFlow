package com.project.sf.reservation;

public class SelectedKeyword {
  private Long kwdNo; // 키워드 고유 번호
  private String rsvNo; // 예약자 고유 번호
  private String studyLevel; // 선택한 실력(레벨)
  private String createdAt; // 등록일

  private String keywordName;

  public Long getKwdNo() {
    return kwdNo;
  }

  public void setKwdNo(Long kwdNo) {
    this.kwdNo = kwdNo;
  }

  public String getRsvNo() {
    return rsvNo;
  }

  public void setRsvNo(String rsvNo) {
    this.rsvNo = rsvNo;
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

  public String getKeywordName() {
    return keywordName;
  }

  public void setKeywordName(String keywordName) {
    this.keywordName = keywordName;
  }

}

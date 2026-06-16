package com.project.sf.common.enums.inquiry;

public enum InquirySearchEnum {
  CONTENTS("제목+내용", "contents"),
  POST_NO("문의 번호", "postNo"),
  WRITER_IP("작성자 아이피", "writerIp"),
  ADMIN_ID("답변한 관리자", "adminId");

  private final String label;
  private final String value;

  InquirySearchEnum(String label, String value) {
    this.label = label;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public String getValue() {
    return value;
  }
}

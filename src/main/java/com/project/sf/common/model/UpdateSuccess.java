package com.project.sf.common.model;

// 업데이트 성공 여부와 메시지, 수정일만 모아서 화면에 렌더링하기 위한 DTO
public class UpdateSuccess {
  private boolean isSuccess;
  private String message;
  private String updatedAt;

  // getter, setter
  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}

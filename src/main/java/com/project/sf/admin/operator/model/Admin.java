package com.project.sf.admin.operator.model;

import java.util.List;

public class Admin {
  private String id; // 관리자 아이디
  private String pw; // 비밀번호
  private String name; // 이름
  private String role; // 권한
  private boolean isActive; // 활성 상태
  private String createdAt; // 생성일
  private String updatedAt; // 수정일

  // 화면에 렌더링 할 권한 리스트
  private List<String> rolesWithLabel;

  // 계정 등록 & 수정에 사용할 권한 리스트 필드
  private List<String> roles;

  // 요청 시 받은 권한들을 DB용 문자열로 변환하는 메소드
  // -> 리스트로 들어온 권한을 문자열로 포맷팅
  public void getConvertRoleToDBFormat() {
    if (this.roles != null && !this.roles.isEmpty()) {
      // 권한 리스트에 SUPER가 포함되어있다면
      if (this.roles.contains("ROLE_SUPER")) {
        // 다른 권한을 지저분하게 끼워넣지않고 오직 SUPER만
        this.role = "ROLE_SUPER";
      } else {
        // 다른 일반 권한이면 쉼표를 이어붙인 문자열로 변환
        this.role = String.join(",", this.roles);
      }
    } else {
      // 아무것도 없으면 빈 값 (권한 X)
      this.role = null;
    }
  }

  // getter, setter
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
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

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<String> getRolesWithLabel() {
    return rolesWithLabel;
  }

  public void setRolesWithLabel(List<String> rolesWithLabel) {
    this.rolesWithLabel = rolesWithLabel;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }
}

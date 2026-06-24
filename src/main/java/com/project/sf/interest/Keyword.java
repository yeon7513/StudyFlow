package com.project.sf.interest;

public class Keyword {
    private Long no;
    private Long cateNo;
    private String name;
    private String description;
    private String adminId;
    private boolean isActive;
    private String createdAt;
    private String updatedAt;

    // 조인용 필드
    private String category;
    private int countKeyword;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public Long getCateNo() {
        return cateNo;
    }

    public void setCateNo(Long cateNo) {
        this.cateNo = cateNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCountKeyword() {
        return countKeyword;
    }

    public void setCountKeyword(int countKeyword) {
        this.countKeyword = countKeyword;
    }

}

package com.bluemoon.model;

/**
 * Thực thể Người dùng (Ánh xạ bảng users - Hỗ trợ RBAC và khóa sai 5 lần).
 */
public class User {
    private int id;
    private String username;
    private String passwordHash;
    private String fullName;
    private String roleCode; // ADMIN_BQT, THU_QUY, CU_DAN
    private Integer householdId;
    private int failedAttempts;
    private boolean locked;
    private boolean active;

    public User() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getRoleCode() { return roleCode; }
    public void setRoleCode(String roleCode) { this.roleCode = roleCode; }
    public Integer getHouseholdId() { return householdId; }
    public void setHouseholdId(Integer householdId) { this.householdId = householdId; }
    public int getFailedAttempts() { return failedAttempts; }
    public void setFailedAttempts(int failedAttempts) { this.failedAttempts = failedAttempts; }
    public boolean isLocked() { return locked; }
    public void setLocked(boolean locked) { this.locked = locked; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}

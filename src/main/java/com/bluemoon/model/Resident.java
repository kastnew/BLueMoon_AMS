package com.bluemoon.model;

import java.time.LocalDate;

/**
 * Thực thể Nhân khẩu (Ánh xạ bảng residents).
 */
public class Resident {
    private int id;
    private int householdId;
    private String fullName;
    private String cccd;
    private LocalDate dateOfBirth;
    private String gender;
    private String relationshipToHead;
    private String residenceStatus; // THUONG_TRU, TAM_TRU, TAM_VANG
    private boolean active;

    public Resident() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getHouseholdId() { return householdId; }
    public void setHouseholdId(int householdId) { this.householdId = householdId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getRelationshipToHead() { return relationshipToHead; }
    public void setRelationshipToHead(String relationshipToHead) { this.relationshipToHead = relationshipToHead; }
    public String getResidenceStatus() { return residenceStatus; }
    public void setResidenceStatus(String residenceStatus) { this.residenceStatus = residenceStatus; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}

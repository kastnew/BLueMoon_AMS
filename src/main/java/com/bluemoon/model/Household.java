package com.bluemoon.model;

import java.time.LocalDate;

/**
 * Thực thể Hộ gia đình (Ánh xạ bảng households).
 */
public class Household {
    private int id;
    private String householdCode;
    private int apartmentId;
    private String headOfHousehold;
    private String phoneNumber;
    private LocalDate moveInDate;
    private boolean active;

    public Household() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getHouseholdCode() { return householdCode; }
    public void setHouseholdCode(String householdCode) { this.householdCode = householdCode; }
    public int getApartmentId() { return apartmentId; }
    public void setApartmentId(int apartmentId) { this.apartmentId = apartmentId; }
    public String getHeadOfHousehold() { return headOfHousehold; }
    public void setHeadOfHousehold(String headOfHousehold) { this.headOfHousehold = headOfHousehold; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public LocalDate getMoveInDate() { return moveInDate; }
    public void setMoveInDate(LocalDate moveInDate) { this.moveInDate = moveInDate; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}

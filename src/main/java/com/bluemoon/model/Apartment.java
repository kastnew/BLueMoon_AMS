package com.bluemoon.model;

import java.math.BigDecimal;

/**
 * Thực thể Căn hộ (Ánh xạ bảng apartments).
 * Lưu ý: Diện tích (areaM2) dùng BigDecimal để tính phí chính xác 100% (NFR-03).
 */
public class Apartment {
    private int id;
    private String apartmentCode;
    private int floorNumber;
    private BigDecimal areaM2;
    private String status; // OCCUPIED, VACANT
    private boolean active;

    public Apartment() {}

    public Apartment(int id, String apartmentCode, int floorNumber, BigDecimal areaM2, String status, boolean active) {
        this.id = id;
        this.apartmentCode = apartmentCode;
        this.floorNumber = floorNumber;
        this.areaM2 = areaM2;
        this.status = status;
        this.active = active;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getApartmentCode() { return apartmentCode; }
    public void setApartmentCode(String apartmentCode) { this.apartmentCode = apartmentCode; }
    public int getFloorNumber() { return floorNumber; }
    public void setFloorNumber(int floorNumber) { this.floorNumber = floorNumber; }
    public BigDecimal getAreaM2() { return areaM2; }
    public void setAreaM2(BigDecimal areaM2) { this.areaM2 = areaM2; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}

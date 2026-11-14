package com.bluemoon.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Thực thể Danh mục Khoản thu (Ánh xạ bảng fee_categories).
 * Hỗ trợ khoản thu bắt buộc (theo m2 / cố định) và quỹ tự nguyện (RAW-013, RAW-025).
 */
public class FeeCategory {
    private int id;
    private String feeName;
    private String feeType; // BAT_BUOC_M2, BAT_BUOC_CO_DINH, TU_NGUYEN
    private BigDecimal unitPrice;
    private LocalDate dueDate;
    private boolean active;

    public FeeCategory() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFeeName() { return feeName; }
    public void setFeeName(String feeName) { this.feeName = feeName; }
    public String getFeeType() { return feeType; }
    public void setFeeType(String feeType) { this.feeType = feeType; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}

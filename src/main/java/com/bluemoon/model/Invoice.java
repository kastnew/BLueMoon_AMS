package com.bluemoon.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Thực thể Hóa đơn kỳ thu phí (Ánh xạ bảng invoices).
 */
public class Invoice {
    private int id;
    private int householdId;
    private int feeCategoryId;
    private String billingPeriod; // YYYY-MM
    private BigDecimal totalAmount;
    private BigDecimal paidAmount;
    private String status; // UNPAID, PARTIAL, PAID
    private boolean closed;
    private LocalDateTime createdAt;

    public Invoice() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getHouseholdId() { return householdId; }
    public void setHouseholdId(int householdId) { this.householdId = householdId; }
    public int getFeeCategoryId() { return feeCategoryId; }
    public void setFeeCategoryId(int feeCategoryId) { this.feeCategoryId = feeCategoryId; }
    public String getBillingPeriod() { return billingPeriod; }
    public void setBillingPeriod(String billingPeriod) { this.billingPeriod = billingPeriod; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public BigDecimal getPaidAmount() { return paidAmount; }
    public void setPaidAmount(BigDecimal paidAmount) { this.paidAmount = paidAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public boolean isClosed() { return closed; }
    public void setClosed(boolean closed) { this.closed = closed; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

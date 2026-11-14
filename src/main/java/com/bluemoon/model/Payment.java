package com.bluemoon.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Thực thể Giao dịch Nộp tiền (Ánh xạ bảng payments).
 * Tự động lưu ngày giờ thực tế nộp tiền (paidAt) phục vụ đối soát quỹ (RAW-026).
 */
public class Payment {
    private int id;
    private int invoiceId;
    private BigDecimal amount;
    private String paymentMethod; // CASH, BANK_TRANSFER
    private int collectedBy;
    private LocalDateTime paidAt;
    private String note;

    public Payment() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public int getCollectedBy() { return collectedBy; }
    public void setCollectedBy(int collectedBy) { this.collectedBy = collectedBy; }
    public LocalDateTime getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}

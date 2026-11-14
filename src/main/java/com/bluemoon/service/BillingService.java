package com.bluemoon.service;

import com.bluemoon.dao.FeeDAO;
import com.bluemoon.model.Payment;
import com.bluemoon.util.DatabaseConnection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;

/**
 * Tầng Service xử lý Tính phí tự động, Ghi nhận thu phí (Transaction) & Chốt sổ (UC004-UC006).
 */
public class BillingService {
    private final FeeDAO feeDAO = new FeeDAO();

    /**
     * Tính phí quản lý/dịch vụ theo diện tích căn hộ bằng BigDecimal (chính xác 100% - NFR-03).
     */
    public BigDecimal calculateAreaBasedFee(BigDecimal areaM2, BigDecimal unitPrice, BigDecimal previousDebt) {
        if (areaM2 == null || areaM2.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Diện tích căn hộ phải lớn hơn 0.");
        }
        if (unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Đơn giá không hợp lệ.");
        }
        BigDecimal debt = previousDebt != null ? previousDebt : BigDecimal.ZERO;
        return areaM2.multiply(unitPrice).add(debt).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Ghi nhận nộp tiền trong Database Transaction (đảm bảo Rollback nếu lỗi - NFR-03).
     */
    public void recordPayment(Payment payment) throws Exception {
        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Số tiền nộp phải lớn hơn 0.");
        }
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                feeDAO.insertPayment(conn, payment);
                // TODO: Cập nhật paid_amount & status trong bảng invoices + ghi AuditLog + gửi thông báo
                conn.commit();
            } catch (Exception ex) {
                conn.rollback();
                throw ex;
            }
        }
    }
}

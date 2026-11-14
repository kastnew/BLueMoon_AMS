package com.bluemoon.dao;

import com.bluemoon.model.Invoice;
import com.bluemoon.model.Payment;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Tầng DAO quản lý Danh mục khoản thu, Hóa đơn & Giao dịch nộp tiền (Module 1).
 */
public class FeeDAO {
    public void insertInvoicesBatch(Connection conn, List<Invoice> invoices) throws SQLException {
        // TODO: Batch Insert tối ưu cho 500 - 1.000 hộ dân (<= 30s - NFR-01)
    }

    public void insertPayment(Connection conn, Payment payment) throws SQLException {
        // TODO: Lưu giao dịch nộp tiền kèm timestamp trong DB Transaction (NFR-03)
    }

    public List<Invoice> findUnpaidByPeriod(String billingPeriod) {
        // TODO: Xuất danh sách hộ còn nợ phí (RAW-024)
        return Collections.emptyList();
    }
}

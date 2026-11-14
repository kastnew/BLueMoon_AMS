package com.bluemoon.service;

import java.time.LocalDate;
import java.time.Period;

/**
 * Tầng Service xử lý Nghiệp vụ Hộ gia đình, Nhân khẩu, Maker-Checker & Báo cáo Chính quyền (UC002, UC003, UC007).
 */
public class HouseholdService {
    /**
     * Kiểm tra công dân đủ tuổi bầu cử (>= 18 tuổi) tính chính xác đến ngày bầu cử (RAW-027).
     */
    public boolean isEligibleVoter(LocalDate dateOfBirth, LocalDate electionDate) {
        if (dateOfBirth == null || electionDate == null || dateOfBirth.isAfter(electionDate)) {
            return false;
        }
        return Period.between(dateOfBirth, electionDate).getYears() >= 18;
    }
}

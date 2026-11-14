package com.bluemoon.dao;

import com.bluemoon.model.Household;
import com.bluemoon.model.Resident;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Tầng DAO quản lý Căn hộ, Hộ gia đình, Nhân khẩu & Trích xuất báo cáo Chính quyền (Module 3).
 */
public class HouseholdDAO {
    public List<Household> searchHouseholds(String keyword) {
        // TODO: Tìm kiếm nhanh theo mã căn hộ hoặc tên chủ hộ (<= 2s - NFR-01)
        return Collections.emptyList();
    }

    public List<Resident> findEligibleVoters(LocalDate electionDate) {
        // TODO: Lọc nhân khẩu có tuổi >= 18 tính đến electionDate (RAW-027, RAW-030)
        return Collections.emptyList();
    }
}

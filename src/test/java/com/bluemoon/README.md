# Bộ Kiểm thử Phần mềm (`src/test/java/com/bluemoon/`)

## 1. Mục tiêu Kiểm thử (Theo Kế hoạch Chất lượng & DoD)
Đảm bảo hệ thống **BlueMoon AMS v1.0** đáp ứng 100% các kịch bản *Acceptance Criteria (Given-When-Then)* và các chỉ tiêu phi chức năng (`NFR-01` $\rightarrow$ `NFR-05`):

1. **Kiểm thử Chính xác Tài chính (`NFR-03` – `BillingServiceTest.java`):**
   - Kiểm tra thuật toán tính phí quản lý/dịch vụ (`Diện tích × Đơn giá` bằng `BigDecimal`) đạt độ chính xác **100%** không sai số làm tròn.
   - Kiểm tra cộng dồn nợ kỳ trước và xử lý đóng một phần / đóng quỹ tự nguyện linh hoạt.
   - Kiểm tra `DB Transaction` tự động Rollback khi phát sinh lỗi giữa chừng.
2. **Kiểm thử Bảo mật & Phân quyền (`NFR-02` – `AuthServiceTest.java`):**
   - Kiểm tra băm mật khẩu `BCrypt`.
   - Kiểm tra tự động khóa tài khoản sau **5 lần** đăng nhập sai liên tiếp.
   - Kiểm tra phân quyền RBAC: Cư dân chỉ xem được dữ liệu hộ gia đình của chính mình (Nghị định 13/2023/NĐ-CP).
3. **Kiểm thử Nghiệp vụ Hành chính (`HouseholdServiceTest.java`):**
   - Kiểm tra hàm tính tuổi cử tri ($\ge 18$ tuổi chính xác theo ngày/tháng/năm sinh đến ngày bầu cử).
   - Kiểm tra cơ chế *Maker-Checker*: Cư dân đề xuất sửa nhân khẩu không ghi đè trực tiếp dữ liệu gốc trước khi BQT duyệt.

## 2. Chạy Kiểm thử
```bash
mvn test
```

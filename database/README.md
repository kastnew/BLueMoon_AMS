# Thư mục Cơ sở dữ liệu MySQL (`database/`)

## 1. Mục đích
Lưu trữ kịch bản khởi tạo cấu trúc Cơ sở dữ liệu (Schema), các chỉ mục tối ưu hiệu năng (`Index`) và dữ liệu khởi tạo ban đầu cho hệ thống **BlueMoon AMS v1.0**.

## 2. Các nguyên tắc thiết kế bắt buộc (Theo NFR & SRS)
1. **Chính xác tuyệt đối về tiền tệ (`NFR-03`):** Toàn bộ các cột lưu số tiền (`unit_price`, `total_amount`, `paid_amount`, `amount`) **bắt buộc dùng kiểu `DECIMAL(15,2)`**, tuyệt đối không dùng `FLOAT` hoặc `DOUBLE` để tránh sai số làm tròn.
2. **Bảo mật thông tin (`NFR-02`, Nghị định 13/2023/NĐ-CP):**
   - Mật khẩu người dùng lưu dưới dạng chuỗi băm `BCrypt` (`password_hash`).
   - Hỗ trợ khóa tài khoản tự động sau 5 lần đăng nhập sai (`failed_attempts`, `is_locked`).
   - Chỉ lưu trữ mềm (`is_active = FALSE` hoặc `deleted_at`) để bảo toàn lịch sử thanh toán tối thiểu **5 năm** (`NFR-014`).
3. **Truy vết & Kiểm toán (`Audit Trail` – `RAW-015`):** Mọi thao tác Thêm/Sửa/Xóa quan trọng trên nhân khẩu, khoản thu, hóa đơn, thanh toán phải được ghi vào bảng `audit_logs` (lưu rõ `user_id`, `action`, `table_name`, `old_value`, `new_value`, `created_at`).
4. **Hiệu năng (`NFR-01`):** Đánh `INDEX` cho các cột tìm kiếm thường xuyên (`apartment_code`, `cccd`, `date_of_birth`, `billing_period`, `status`) để đảm bảo thời gian tra cứu $\le 2$ giây với quy mô 1.000 hộ dân.
5. **Sao lưu & Phục hồi (`NFR-05`):** Hỗ trợ sao lưu tự động hàng ngày bằng `mysqldump` và phục hồi trong $\le 1\text{ – }2$ giờ.

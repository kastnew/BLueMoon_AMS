# Tầng Xử lý Nghiệp vụ (`src/main/java/com/bluemoon/service/`)

## 1. Nhiệm vụ
Là trái tim của hệ thống **BlueMoon AMS**, xử lý toàn bộ quy tắc nghiệp vụ, kiểm tra phân quyền **RBAC**, quản lý **Database Transaction** và ghi nhận **Audit Log** trước khi gọi xuống tầng `DAO`.

## 2. Các nghiệp vụ trọng tâm theo SRS
- **`AuthService.java` (`UC001`):** Xác thực đăng nhập bằng `BCrypt`, khóa tài khoản sau **5 lần** nhập sai liên tiếp, sinh menu động theo vai trò (`ADMIN_BQT`, `THU_QUY`, `CU_DAN`).
- **`HouseholdService.java` (`UC002`, `UC003`, `UC007`):**
  - Quản lý căn hộ, hộ gia đình, nhân khẩu, tạm trú/tạm vắng.
  - Cơ chế **Maker-Checker**: Cư dân gửi đề xuất cập nhật nhân khẩu $\rightarrow$ tạo Ticket `PENDING` $\rightarrow$ BQT phê duyệt mới cập nhật bảng `residents`.
  - Lọc chính xác danh sách cử tri đủ tuổi ($\ge 18$ tuổi tính đến ngày bầu cử), danh sách sự kiện/tiêm phòng.
- **`BillingService.java` (`UC004`, `UC005`, `UC006`):**
  - Tự động tính phí hàng tháng (`Diện tích × Đơn giá` dùng `BigDecimal`) cộng dồn nợ kỳ trước.
  - Ghi nhận nộp tiền trong `DB Transaction` (`setAutoCommit(false)` $\rightarrow$ `commit()` / `rollback()`), tự lưu `timestamp`, ghi `AuditLog` và gửi thông báo xác nhận.
  - Chốt sổ cuối tháng và xuất danh sách hộ còn nợ phí.
- **`NotificationTicketService.java` (`UC008`):** Phát hành nội quy, thông báo điện tử và quản lý quy trình xử lý Ticket phản ánh của cư dân.

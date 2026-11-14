# Thư mục Tiện ích Dùng chung (`src/main/java/com/bluemoon/util/`)

## 1. Nhiệm vụ
Cung cấp các lớp tiện ích hạ tầng dùng chung cho toàn hệ thống **BlueMoon AMS v1.0**:

| Tên lớp | Chức năng chính | Yêu cầu đáp ứng |
| :--- | :--- | :--- |
| `DatabaseConnection.java` | Quản lý kết nối JDBC tới MySQL (`utf8mb4`, cấu hình TLS/SSL). | `NFR-02`, `NFR-05` |
| `PasswordHasher.java` | Băm mật khẩu (`BCrypt.hashpw`) và kiểm tra khớp mật khẩu (`BCrypt.checkpw`). | `NFR-02` |
| `AuditLogger.java` | Ghi nhận nhật ký thay đổi (`Old_Value`, `New_Value`, `User_ID`, `Timestamp`) vào bảng `audit_logs`. | `RAW-015`, `NFR-03`, `NFR-015` |
| `BackupManager.java` | Thực thi sao lưu CSDL MySQL tự động hàng ngày (`mysqldump`) và hỗ trợ phục hồi nhanh $\le 1\text{ – }2$ giờ. | `RAW-020`, `NFR-05`, `NFR-007`, `NFR-008` |

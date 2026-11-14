# Tầng Thực thể Dữ liệu (`src/main/java/com/bluemoon/model/`)

## 1. Nhiệm vụ
Chứa các lớp Java POJO / Entity ánh xạ trực tiếp 1-1 với các bảng trong Cơ sở dữ liệu MySQL (`database/bluemoon_schema.sql`), phục vụ truyền tải dữ liệu xuyên suốt giữa 3 tầng `DAO` $\leftrightarrow$ `Service` $\leftrightarrow$ `UI`.

## 2. Quy ước bắt buộc
- **Tiền tệ & Diện tích (`NFR-03`):** Bắt buộc sử dụng kiểu **`java.math.BigDecimal`** cho các thuộc tính tiền (`unitPrice`, `totalAmount`, `paidAmount`, `amount`) và diện tích (`areaM2`). Tuyệt đối không dùng `float` hay `double`.
- **Thời gian:** Sử dụng `java.time.LocalDate` (ngày sinh, hạn nộp, tạm trú) và `java.time.LocalDateTime` (`paidAt`, `createdAt`).

## 3. Danh sách lớp khung thuộc 3 Module
- **Module 1 (Thu phí):** `FeeCategory.java`, `Invoice.java`, `Payment.java`
- **Module 2 (Người dùng & Hệ thống):** `User.java`, `Role.java`, `Notification.java`, `Ticket.java`, `AuditLog.java`
- **Module 3 (Hộ gia đình & Nhân khẩu):** `Apartment.java`, `Household.java`, `Resident.java`, `TemporaryResidence.java`

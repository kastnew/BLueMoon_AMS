# Tầng Giao diện Người dùng (`src/main/java/com/bluemoon/ui/`)

## 1. Nhiệm vụ
Hiển thị giao diện tương tác với 03 nhóm người dùng (**Ban Quản trị**, **Thủ quỹ/Kế toán**, **Cư dân/Chủ hộ**) và chuyển tiếp yêu cầu xử lý xuống tầng `Service` (tuyệt đối không viết logic nghiệp vụ hay câu lệnh SQL trong tầng UI).

## 2. Tiêu chuẩn Giao diện & Khả dụng (`NFR-04`, Mục 4.1 SRS)
1. **100% Thuần Việt & Dễ đọc:** Sử dụng tiếng Việt rõ nghĩa, cỡ chữ tối thiểu **$\ge 12\text{pt}\text{ – }14\text{pt}$**, thân thiện với người lớn tuổi (BQT, Tổ trưởng dân phố).
2. **Căn lề chuẩn:** Số liệu (Diện tích, Số tiền VNĐ) **căn phải**; Văn bản (Họ tên, Địa chỉ, Tên khoản thu) **căn trái**.
3. **Thao tác tinh gọn (`NFR-010`):** Luồng ghi nhận nộp tiền tại quầy của Thủ quỹ hoàn tất trong **tối đa $\le 3$ bước click chuột**; hướng tới điểm hài lòng **SUS $\ge 70$**.

## 3. Phân chia Màn hình theo 3 Module
- `LoginFrame.java` – Màn hình đăng nhập, đổi mật khẩu & điều hướng menu động RBAC.
- `FeeManagementPanel.java` – **Module 1:** Cấu hình khoản thu, Tạo kỳ thu phí tự động, Thu phí nhanh ($\le 3$ bước), Chốt sổ nợ & Thống kê quỹ.
- `UserSystemPanel.java` – **Module 2:** Quản trị tài khoản/RBAC, Thông báo & Nội quy, Duyệt Ticket phản ánh, Tra cứu Audit Log & Backup/Restore.
- `HouseholdResidentPanel.java` – **Module 3:** Quản lý căn hộ, hộ gia đình, nhân khẩu, tạm trú/tạm vắng & Xuất báo cáo Chính quyền (Cử tri, Sự kiện).

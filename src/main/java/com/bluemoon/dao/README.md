# Tầng Truy cập Dữ liệu (`src/main/java/com/bluemoon/dao/`)

## 1. Nhiệm vụ
Chịu trách nhiệm giao tiếp trực tiếp với Hệ quản trị CSDL **MySQL** thông qua JDBC (`PreparedStatement`), thực thi các câu lệnh CRUD, tìm kiếm, thống kê và trích xuất dữ liệu báo cáo.

## 2. Quy ước bắt buộc
1. **Chống SQL Injection:** 100% truy vấn sử dụng `PreparedStatement` có tham số `?`, không nối chuỗi SQL trực tiếp.
2. **Hỗ trợ Database Transaction (`NFR-03`):** Các phương thức ghi nhận nộp phí, duyệt cập nhật nhân khẩu nhận `Connection` từ tầng `Service` để đảm bảo chạy trong cùng 1 Transaction (`commit`/`rollback` nguyên tố).
3. **Hiệu năng (`NFR-01`):** Tối ưu hóa truy vấn với phân trang (`LIMIT/OFFSET`) và sử dụng Batch Insert khi tạo kỳ thu phí cho 500–1.000 căn hộ ($\le 30$ giây).

## 3. Danh sách DAO khung
- `UserDAO.java` – Truy vấn người dùng, vai trò RBAC, cập nhật số lần đăng nhập sai / khóa tài khoản.
- `HouseholdDAO.java` – CRUD căn hộ, hộ gia đình, nhân khẩu, tạm trú/tạm vắng & lọc danh sách cử tri ($\ge 18$ tuổi).
- `FeeDAO.java` – CRUD danh mục khoản thu, tạo hóa đơn hàng loạt, ghi nhận thanh toán (`Payment`) & xuất danh sách nợ.
- `SystemDAO.java` – Quản lý thông báo, Ticket phản ánh, ghi nhận & tra cứu `AuditLog`.

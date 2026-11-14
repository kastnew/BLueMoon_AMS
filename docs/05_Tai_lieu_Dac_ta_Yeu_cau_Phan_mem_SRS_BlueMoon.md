# TÀI LIỆU ĐẶC TẢ YÊU CẦU PHẦN MỀM (SOFTWARE REQUIREMENT SPECIFICATION – SRS)
**TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI**  
**Viện Công nghệ thông tin và Truyền thông (SoICT)**  
**Phiên bản:** 1.0  
**TIÊU ĐỀ BÀI TẬP LỚN:** Xây dựng phần mềm quản lý và thu phí ở chung cư Blue Moon (`BlueMoon v1.0`)  
**Môn:** Nhập môn Công nghệ Phần mềm  
**Ngày ban hành:** 14/11/2026  

---

## 1. Giới thiệu

### 1.1. Mục đích
Tài liệu Đặc tả Yêu cầu Phần mềm (SRS) này đưa ra mô tả chi tiết cho toàn bộ hệ thống **Phần mềm Quản lý và Thu phí Chung cư Blue Moon (BlueMoon v1.0)**, bao gồm 03 phân hệ cốt lõi: *Quản lý thu phí*, *Quản lý người dùng & hệ thống*, và *Quản lý hộ gia đình & nhân khẩu*. Tài liệu mô tả mục đích, các tính năng, tác nhân, quy trình nghiệp vụ, đặc tả chi tiết các Use Case cùng dữ liệu đầu vào/đầu ra và các ràng buộc phi chức năng mà hệ thống cần đáp ứng.

Tài liệu dành cho các bên liên quan (Ban Quản trị Chung cư Blue Moon, Thủ quỹ/Kế toán, đại diện Cư dân, Tổ trưởng dân phố) và đội ngũ phát triển phần mềm (BA, Developers, QA/Tester).

### 1.2. Phạm vi
Hiện tại, công tác quản lý hộ gia đình, nhân khẩu và thu phí tại chung cư Blue Moon (quy mô 500 – 1.000 hộ dân) đang thực hiện thủ công bằng sổ sách giấy, biên lai 2 liên viết tay, máy tính Casio và file Excel rời rạc, dẫn đến sai sót khi tính phí, ùn tắc giờ cao điểm, chậm chốt sổ công nợ (3–5 ngày) và rủi ro mất dữ liệu.

Phần mềm **BlueMoon v1.0** được xây dựng nhằm số hóa và tự động hóa các nghiệp vụ sau:
- Quản lý danh sách căn hộ, hộ gia đình (hộ khẩu), nhân khẩu và đăng ký tạm trú/tạm vắng.
- Quản lý danh mục khoản thu (phí quản lý, phí dịch vụ bắt buộc tính theo diện tích căn hộ và các đợt vận động quyên góp tự nguyện linh hoạt).
- Tự động tính phí hàng tháng, ghi nhận thu tiền (lưu vết thời gian thực tế `timestamp`), chốt sổ công nợ cuối kỳ và cho phép cư dân tra cứu chi tiết phí/nợ.
- Quản lý tài khoản, phân quyền động theo vai trò (RBAC), gửi thông báo điện tử, công bố nội quy, tiếp nhận/duyệt Ticket phản ánh của cư dân, lưu vết nhật ký (Audit Log) và sao lưu/phục hồi dữ liệu tự động.
- Trích xuất báo cáo thống kê cho Chính quyền địa phương (danh sách cử tri đủ tuổi bầu cử, danh sách dân cư sự kiện/tiêm phòng, báo cáo tạm trú/tạm vắng, báo cáo quỹ từ thiện).
*(Các tính năng mở rộng như quản lý phí gửi xe, thu hộ điện/nước/internet, khách vãng lai & sự cố an ninh được quy hoạch cho lộ trình BlueMoon v2.0).*

### 1.3. Từ điển thuật ngữ

| Thuật ngữ / Ký hiệu | Giải thích trong nghiệp vụ dự án BlueMoon |
| :--- | :--- |
| **BQT (Ban Quản trị)** | Cơ quan đại diện quản lý vận hành chung cư Blue Moon, đóng vai trò Quản trị viên hệ thống và Product Owner. |
| **Hộ gia đình (Hộ khẩu)** | Tập hợp các nhân khẩu cùng sinh sống trong một căn hộ tại chung cư Blue Moon, có một Chủ hộ đại diện. |
| **Nhân khẩu** | Từng cá nhân/cư dân sinh sống tại chung cư (bao gồm thường trú và tạm trú). |
| **Khoản thu bắt buộc** | Các khoản phí định kỳ hàng tháng (phí quản lý, phí dịch vụ) được tính tự động dựa trên `Diện tích căn hộ × Đơn giá`. |
| **Quỹ tự nguyện** | Các đợt vận động quyên góp, từ thiện không có mức đóng cố định, Thủ quỹ nhập số tiền linh hoạt theo từng hộ đóng góp. |
| **RBAC** | *Role-Based Access Control* – Cơ chế kiểm soát truy cập dựa trên vai trò (Ban Quản trị, Thủ quỹ/Kế toán, Cư dân). |
| **Maker – Checker** | Cơ chế kiểm duyệt 2 bước: Cư dân (Maker) gửi đề xuất cập nhật nhân khẩu/phản ánh $\rightarrow$ BQT (Checker) phê duyệt trước khi cập nhật CSDL chính thức. |
| **Audit Log** | Nhật ký lưu vết tự động các thao tác quan trọng (thêm, sửa, xóa dữ liệu tài chính/nhân khẩu), ghi rõ người thực hiện và thời điểm. |

### 1.4. Tài liệu tham khảo
1. Tài liệu Tuyên ngôn Dự án (*Project Charter – Bài 4.1*), Dự án BlueMoon, 2026.
2. Tài liệu Kế hoạch Dự án (*WBS & Gantt Chart – Bài 4.2*) và Kế hoạch Quản lý Rủi ro (*Bài 4.3*), 2026.
3. Tài liệu Tìm hiểu, Khảo sát và Phân tích Yêu cầu (`04_Tai_lieu_Tim_hieu_Khao_sat_Yeu_cau_BlueMoon.md`) & Hồ sơ Khai phá Yêu cầu (`Raw Features Collection.xlsx`: `RAW-001` $\rightarrow$ `RAW-030`, `NFR-01` $\rightarrow$ `NFR-05`).
4. Nghị định số `13/2023/NĐ-CP` của Chính phủ về Bảo vệ dữ liệu cá nhân.

---

## 2. Mô tả tổng quan

### 2.1. Các tác nhân (Actors)
Hệ thống BlueMoon v1.0 có **05 tác nhân** tương tác trực tiếp:
1. **Khách (Chưa đăng nhập):** Người dùng khi chưa xác thực vào hệ thống; chỉ được phép Đăng nhập hoặc yêu cầu Quên/Đặt lại mật khẩu.
2. **Cư dân / Chủ hộ:** Người dùng cuối đại diện hộ gia đình sau khi đăng nhập; có quyền tra cứu thông tin hộ/nhân khẩu nhà mình, gửi đề xuất cập nhật/đăng ký tạm trú, xem chi tiết phí/lịch sử đóng/công nợ, nhận thông báo, xem nội quy và gửi Ticket phản ánh.
3. **Thủ quỹ / Kế toán:** Nhân sự phụ trách tài chính; có quyền tra cứu nhanh hộ dân, tạo kỳ thu phí tự động, ghi nhận thu tiền ($\le 3$ bước), chốt sổ công nợ hàng tháng và xuất danh sách hộ còn nợ.
4. **Ban Quản trị (Admin / Product Owner):** Quản trị viên cao nhất; quản lý căn hộ, hộ gia đình, nhân khẩu, tạm trú/tạm vắng, danh mục khoản thu, duyệt Ticket phản ánh/cập nhật, phân quyền RBAC, tra cứu Audit Log và quản lý Backup/Restore.
5. **Chính quyền / Tổ dân phố:** Tác nhân tiếp nhận các báo cáo hành chính trích xuất từ hệ thống (Danh sách cử tri đủ tuổi bầu cử, danh sách sự kiện/tiêm phòng, báo cáo tạm trú/tạm vắng, báo cáo thu chi quỹ từ thiện).

### 2.2. Biểu đồ Use Case tổng quan
Biểu đồ dưới đây mô tả bức tranh tổng thể các tác nhân và 13 nhóm Use Case chính của hệ thống BlueMoon v1.0:

![Biểu đồ Use Case tổng quan](file:///D:/CNPM/diagrams/02_Use_Case_Tong_quan.png)

### 2.3. Biểu đồ Use Case phân rã

#### 2.3.1. Phân rã Use Case “Quản lý Căn hộ, Hộ gia đình & Nhân khẩu”
![Biểu đồ Use Case phân rã Hộ gia đình và Nhân khẩu](file:///D:/CNPM/diagrams/03_Use_Case_Phan_ra_Ho_gia_dinh.png)

#### 2.3.2. Phân rã Use Case “Quản lý Danh mục khoản thu, Tính phí & Thu phí”
![Biểu đồ Use Case phân rã Thu phí](file:///D:/CNPM/diagrams/04_Use_Case_Phan_ra_Thu_phi.png)

#### 2.3.3. Phân rã Use Case “Quản lý Người dùng, Thông báo & Hệ thống”
![Biểu đồ Use Case phân rã Người dùng và Hệ thống](file:///D:/CNPM/diagrams/05_Use_Case_Phan_ra_Nguoi_dung_Bao_cao.png)

### 2.4. Quy trình nghiệp vụ

#### 2.4.1. Quy trình Tính phí tự động, Ghi nhận thu phí & Chốt sổ công nợ
![Quy trình nghiệp vụ Tính phí và Thu phí](file:///D:/CNPM/diagrams/06_Quy_trinh_nghiep_vu_Tinh_va_Thu_phi.png)

#### 2.4.2. Quy trình Cập nhật nhân khẩu, Đăng ký tạm trú & Xử lý phản ánh (Maker-Checker)
![Quy trình nghiệp vụ Nhân khẩu và Tạm trú](file:///D:/CNPM/diagrams/07_Quy_trinh_nghiep_vu_Nhan_khau_Tam_tru.png)

---

## 3. Đặc tả các chức năng

*(Lưu ý: Theo hướng dẫn của mẫu SRS SoICT/HUST, các chức năng CRUD thông thường có luồng tương đồng như CRUD Căn hộ, CRUD Hộ gia đình, CRUD Nhân khẩu, CRUD Khoản thu được chuẩn hóa theo cấu trúc `UC002`; các chức năng nghiệp vụ đặc thù được đặc tả chi tiết dưới đây).*

### 3.1. Đặc tả Use Case `UC001` “Đăng nhập & Tạo menu theo vai trò (RBAC)”

| Thuộc tính | Nội dung chi tiết |
| :--- | :--- |
| **Mã Use case** | `UC001` |
| **Tên Use case** | Đăng nhập & Tạo menu theo vai trò (RBAC) |
| **Tác nhân** | Khách (Chưa đăng nhập) |
| **Tiền điều kiện** | Tài khoản đã được Ban Quản trị cấp phát và đang ở trạng thái hoạt động (`is_locked = false`). |
| **Luồng sự kiện chính (Thành công)** | 1. Khách chọn chức năng **Đăng nhập** trên giao diện hệ thống.<br>2. Hệ thống hiển thị giao diện Đăng nhập.<br>3. Khách nhập Tên đăng nhập/Email và Mật khẩu (*mô tả bảng `*` bên dưới*).<br>4. Khách bấm nút **Đăng nhập**.<br>5. Hệ thống kiểm tra xem khách đã nhập đầy đủ các trường bắt buộc hay chưa.<br>6. Hệ thống kiểm tra trạng thái khóa của tài khoản (`failed_attempts < 5`).<br>7. Hệ thống băm mật khẩu nhập vào và đối chiếu với mật khẩu lưu trong CSDL (`bcrypt`/`PBKDF2`).<br>8. Hệ thống đặt lại số lần sai về 0, truy vấn vai trò (BQT / Thủ quỹ / Cư dân) và sinh giao diện Menu chứa đúng các chức năng được phân quyền. |
| **Luồng sự kiện thay thế** | • **5a.** Hệ thống thông báo lỗi: *"Vui lòng nhập đầy đủ Tên đăng nhập và Mật khẩu"* nếu khách nhập thiếu.<br>• **6a.** Hệ thống thông báo lỗi: *"Tài khoản đã bị khóa do nhập sai quá 5 lần hoặc bị Admin vô hiệu hóa"* nếu tài khoản đang bị khóa.<br>• **7a.** Hệ thống tăng biến đếm `failed_attempts` thêm 1 và thông báo: *"Tên đăng nhập hoặc mật khẩu chưa đúng"* nếu thông tin không khớp. Nếu `failed_attempts == 5`, hệ thống tự động khóa tài khoản và gửi cảnh báo tới BQT (`RAW-021`). |
| **Hậu điều kiện** | Phiên làm việc (Session) được khởi tạo; người dùng truy cập được đúng phân hệ theo vai trò RBAC. |

*\* Dữ liệu đầu vào khi Đăng nhập:*

| STT | Trường dữ liệu | Mô tả | Bắt buộc? | Điều kiện hợp lệ | Ví dụ |
| :---: | :--- | :--- | :---: | :--- | :--- |
| 1 | Tên đăng nhập / Email | Tài khoản định danh của người dùng | Có | Chuỗi ký tự không rỗng, tồn tại trong hệ thống | `bqt_bluemoon@gmail.com` |
| 2 | Mật khẩu | Mật khẩu bảo mật của tài khoản | Có | Ít nhất 8 ký tự (gồm chữ hoa, chữ thường, số, ký tự đặc biệt) | `BlueMoon@2026` |

---

### 3.2. Đặc tả Use Case `UC002` “Quản lý Hộ gia đình, Nhân khẩu & Tạm trú/Tạm vắng (CRUD)”

| Thuộc tính | Nội dung chi tiết |
| :--- | :--- |
| **Mã Use case** | `UC002` |
| **Tên Use case** | Quản lý Hộ gia đình, Nhân khẩu & Tạm trú/Tạm vắng |
| **Tác nhân** | Ban Quản trị (và Thủ quỹ đối với thao tác Xem/Tra cứu) |
| **Tiền điều kiện** | Tác nhân đã đăng nhập thành công với vai trò Ban Quản trị (hoặc Thủ quỹ để tra cứu). |
| **Luồng sự kiện chính (Thành công)** | **• Xem / Tra cứu (Read):**<br>1. BQT/Thủ quỹ chọn chức năng Quản lý Hộ gia đình & Nhân khẩu.<br>2. Hệ thống hiển thị danh sách hộ gia đình kèm thanh tìm kiếm theo Mã căn hộ, Tên chủ hộ, Số CCCD.<br>3. Người dùng nhập từ khóa tìm kiếm và xem chi tiết danh sách nhân khẩu, trạng thái tạm trú/tạm vắng trong vòng $\le 2$ giây (*bảng `**`*).<br>**• Thêm mới / Chỉnh sửa (Create / Update):**<br>1. BQT chọn **Thêm nhân khẩu / Đăng ký tạm trú** (hoặc chọn **Sửa** trên hồ sơ sẵn có).<br>2. Hệ thống hiển thị biểu mẫu nhập liệu (*bảng `*`*).<br>3. BQT nhập thông tin nhân khẩu/tạm trú và bấm **Lưu**.<br>4. Hệ thống kiểm tra các trường bắt buộc và tính duy nhất của số CCCD.<br>5. Hệ thống lưu dữ liệu vào CSDL MySQL trong `DB Transaction`, ghi nhận lịch sử vào bảng `AuditLog` (`RAW-015`) và thông báo thành công. |
| **Luồng sự kiện thay thế** | • **4a.** Hệ thống thông báo lỗi cụ thể nếu nhập thiếu trường bắt buộc hoặc ngày sinh/ngày kết thúc tạm trú không hợp lệ (`Từ ngày > Đến ngày`).<br>• **4b.** Hệ thống thông báo lỗi: *"Số CCCD đã tồn tại trong hệ thống"* nếu nhập trùng số CCCD.<br>• **5a.** Nếu mất kết nối CSDL, hệ thống thực hiện Rollback và thông báo lỗi kết nối hệ thống. |
| **Hậu điều kiện** | Dữ liệu căn hộ, hộ gia đình, nhân khẩu hoặc tạm trú/tạm vắng được lưu chính xác và đồng bộ cho việc tính phí và trích xuất báo cáo. |

*\* Dữ liệu đầu vào khi Thêm/Sửa Nhân khẩu & Tạm trú:*

| STT | Trường dữ liệu | Mô tả | Bắt buộc? | Điều kiện hợp lệ | Ví dụ |
| :---: | :--- | :--- | :---: | :--- | :--- |
| 1 | Mã căn hộ / Mã hộ | Căn hộ mà nhân khẩu cư trú | Có | Tồn tại trong danh mục Căn hộ | `B1205` |
| 2 | Họ và tên | Họ tên đầy đủ theo CCCD | Có | Chuỗi ký tự 2–100 ký tự | `Nguyễn Văn Minh` |
| 3 | Số CCCD / CMND | Số định danh cá nhân | Có *(với $\ge 14$ tuổi)* | Đúng 12 chữ số, duy nhất trên toàn hệ thống | `001095012345` |
| 4 | Ngày sinh | Ngày tháng năm sinh | Có | Định dạng `dd/mm/yyyy`, $\le$ ngày hiện tại | `15/08/1995` |
| 5 | Quan hệ với chủ hộ | Vai trò trong hộ gia đình | Có | Chọn từ danh sách (`Chủ hộ`, `Vợ/Chồng`, `Con`, `Khách tạm trú`...) | `Chủ hộ` |
| 6 | Thời hạn tạm trú | Từ ngày – Đến ngày *(nếu là tạm trú)* | Có *(khi chọn Tạm trú)* | `Từ ngày ≤ Đến ngày` | `01/11/2026 – 30/11/2026` |

*\*\* Dữ liệu đầu ra khi hiển thị Danh sách Hộ gia đình / Nhân khẩu:* Mã hộ | Mã căn hộ | Diện tích ($\text{m}^2$) | Chủ hộ | Số nhân khẩu | Trạng thái cư trú (Thường trú / Tạm trú).

---

### 3.3. Đặc tả Use Case `UC003` “Cư dân tự tra cứu & Đề xuất cập nhật nhân khẩu (Maker-Checker)”

| Thuộc tính | Nội dung chi tiết |
| :--- | :--- |
| **Mã Use case** | `UC003` |
| **Tên Use case** | Cư dân tự tra cứu & Đề xuất cập nhật thông tin hộ gia đình / nhân khẩu |
| **Tác nhân** | Cư dân / Chủ hộ, Ban Quản trị |
| **Tiền điều kiện** | Cư dân đã đăng nhập thành công; tài khoản được gắn với một `Household_ID` cụ thể. |
| **Luồng sự kiện chính (Thành công)** | 1. Cư dân chọn chức năng **Thông tin Hộ gia đình của tôi**.<br>2. Hệ thống truy vấn và chỉ hiển thị thông tin căn hộ, thành viên của đúng hộ gia đình mà Cư dân thuộc về.<br>3. Cư dân chọn **Đề xuất thêm/sửa thành viên** hoặc **Đăng ký tạm trú**, điền thông tin thay đổi và bấm **Gửi yêu cầu**.<br>4. Hệ thống lưu yêu cầu dưới dạng Ticket ở trạng thái `Chờ duyệt (Pending)` (không ghi đè trực tiếp dữ liệu gốc) và gửi thông báo tới BQT.<br>5. BQT mở danh sách yêu cầu, kiểm tra thông tin và bấm **Phê duyệt**.<br>6. Hệ thống cập nhật dữ liệu nhân khẩu chính thức trong `DB Transaction`, ghi `AuditLog` và gửi thông báo kết quả cho Cư dân. |
| **Luồng sự kiện thay thế** | • **5a.** Nếu thông tin đề xuất chưa chính xác, BQT chọn **Từ chối** và nhập lý do $\rightarrow$ Hệ thống giữ nguyên dữ liệu gốc và gửi thông báo kèm lý do cho Cư dân. |
| **Hậu điều kiện** | Dữ liệu nhân khẩu được cập nhật an toàn có kiểm duyệt, đảm bảo quyền riêng tư giữa các hộ theo Nghị định 13/2023/NĐ-CP. |

---

### 3.4. Đặc tả Use Case `UC004` “Quản lý Danh mục Khoản thu (Bắt buộc & Tự nguyện)”

| Thuộc tính | Nội dung chi tiết |
| :--- | :--- |
| **Mã Use case** | `UC004` |
| **Tên Use case** | Quản lý Danh mục Khoản thu (Bắt buộc theo diện tích & Quyên góp tự nguyện) |
| **Tác nhân** | Ban Quản trị |
| **Tiền điều kiện** | Ban Quản trị đã đăng nhập thành công. |
| **Luồng sự kiện chính (Thành công)** | 1. BQT chọn chức năng **Quản lý Danh mục Khoản thu** và bấm **Thêm khoản thu mới**.<br>2. Hệ thống hiển thị biểu mẫu cấu hình khoản thu (*bảng `*`*).<br>3. BQT nhập Tên khoản thu, chọn Loại khoản thu (`Bắt buộc theo diện tích` / `Bắt buộc cố định` / `Quyên góp tự nguyện`), nhập Đơn giá (`DECIMAL`) và Thời hạn thu.<br>4. Hệ thống kiểm tra tính hợp lệ (Đơn giá $\ge 0$ đối với khoản thu bắt buộc; tên khoản thu không trùng trong cùng kỳ).<br>5. Hệ thống lưu danh mục khoản thu mới, ghi `AuditLog` và thông báo thành công. |
| **Luồng sự kiện thay thế** | • **4a.** Hệ thống thông báo lỗi nếu nhập đơn giá âm hoặc thiếu tên khoản thu.<br>• **4b.** Đối với loại `Quyên góp tự nguyện`, hệ thống cho phép bỏ trống đơn giá cố định (`0` hoặc linh hoạt) để Thủ quỹ nhập theo thực tế đóng góp của từng hộ. |
| **Hậu điều kiện** | Khoản thu sẵn sàng được áp dụng để tạo kỳ thu phí hàng tháng. |

*\* Dữ liệu đầu vào Khoản thu:*

| STT | Trường dữ liệu | Mô tả | Bắt buộc? | Điều kiện hợp lệ | Ví dụ |
| :---: | :--- | :--- | :---: | :--- | :--- |
| 1 | Tên khoản thu | Tên loại phí hoặc đợt quyên góp | Có | Chuỗi 3–150 ký tự | `Phí quản lý chung cư T11/2026` |
| 2 | Loại khoản thu | Phân loại cách tính tiền | Có | `Bắt buộc theo m²` / `Cố định` / `Tự nguyện` | `Bắt buộc theo m²` |
| 3 | Đơn giá (VNĐ) | Mức thu trên 1 $\text{m}^2$ hoặc 1 hộ | Có *(nếu bắt buộc)* | Kiểu `DECIMAL(15,2)`, giá trị $\ge 0$ | `7000.00` |
| 4 | Hạn nộp | Ngày hết hạn đóng phí | Có | Định dạng `dd/mm/yyyy` | `15/11/2026` |

---

### 3.5. Đặc tả Use Case `UC005` “Tự động Tính phí Hàng tháng & Ghi nhận Thu phí”

| Thuộc tính | Nội dung chi tiết |
| :--- | :--- |
| **Mã Use case** | `UC005` |
| **Tên Use case** | Tự động Tính phí Hàng tháng & Ghi nhận Thu phí |
| **Tác nhân** | Thủ quỹ / Kế toán |
| **Tiền điều kiện** | Đã có danh sách Căn hộ (có diện tích), Hộ gia đình và Danh mục khoản thu đang hiệu lực. |
| **Luồng sự kiện chính (Thành công)** | **• Phần A – Tự động tạo kỳ thu phí toàn tòa nhà:**<br>1. Thủ quỹ chọn **Tạo kỳ thu phí tháng**, chọn Tháng/Năm và các khoản thu áp dụng, bấm **Tính phí tự động**.<br>2. Hệ thống quét toàn bộ căn hộ đang có hộ ở, thực hiện công thức `Số tiền = Diện tích × Đơn giá` (kiểu `DECIMAL`) cộng dồn số nợ kỳ trước (nếu có) và tạo Hóa đơn hàng loạt trong $\le 30\text{ – }60$ giây (`NFR-002`).<br>3. Hệ thống tự động gửi thông báo có khoản phí mới tới từng tài khoản Cư dân (`RAW-007`).<br>**• Phần B – Ghi nhận thu phí tại quầy/chuyển khoản ($\le 3$ bước click):**<br>1. Thủ quỹ nhập Mã căn hộ hoặc Tên chủ hộ vào ô tìm kiếm nhanh (Click 1).<br>2. Hệ thống hiển thị danh sách các khoản phí chưa đóng của hộ đó (và ô nhập tiền nếu là quỹ tự nguyện).<br>3. Thủ quỹ tích chọn khoản nộp/nhập số tiền thực thu và bấm **Xác nhận đã thu** (Click 2–3).<br>4. Hệ thống mở **DB Transaction**: Lưu giao dịch kèm thời gian thực tế (`timestamp = NOW()` – `RAW-026`), cập nhật số tiền đã đóng & công nợ hóa đơn, ghi `AuditLog`, và gửi thông báo *"Đóng tiền thành công"* cho Cư dân. |
| **Luồng sự kiện thay thế** | • **A2a.** Nếu kỳ thu Tháng/Năm đã được tạo trước đó, hệ thống cảnh báo không cho tạo trùng.<br>• **B4a.** Nếu số tiền nhập $\le 0$ hoặc vượt quá số nợ (đối với phí bắt buộc), hệ thống báo lỗi.<br>• **B4b.** Nếu có lỗi hệ thống khi lưu, **DB Transaction tự động Rollback** toàn bộ, đảm bảo không mất tiền hoặc sai lệch công nợ (`NFR-03`). |
| **Hậu điều kiện** | Công nợ của hộ gia đình được cập nhật chính xác 100% theo thời gian thực; lịch sử giao dịch được lưu trữ tối thiểu 05 năm (`NFR-014`). |

---

### 3.6. Đặc tả Use Case `UC006` “Chốt sổ Công nợ & Tra cứu Công nợ Cư dân”

| Thuộc tính | Nội dung chi tiết |
| :--- | :--- |
| **Mã Use case** | `UC006` |
| **Tên Use case** | Chốt sổ Công nợ cuối tháng & Tra cứu chi tiết phí/nợ |
| **Tác nhân** | Thủ quỹ / Kế toán, Cư dân / Chủ hộ |
| **Tiền điều kiện** | Kỳ thu phí đã được phát hành và có dữ liệu ghi nhận thu tiền. |
| **Luồng sự kiện chính (Thành công)** | 1. Cuối tháng, Thủ quỹ chọn chức năng **Chốt sổ công nợ**, chọn kỳ thu phí và bấm **Chốt sổ**.<br>2. Hệ thống khóa chỉnh sửa trực tiếp các giao dịch trong kỳ đã chốt, tổng hợp tổng số tiền phải thu, đã thu và còn nợ của từng hộ.<br>3. Hệ thống xuất danh sách các hộ còn dư nợ (`Số tiền còn nợ > 0`) ra tệp Excel/PDF và tự động gửi thông báo nhắc nợ tới các hộ này (`RAW-024`).<br>4. Về phía Cư dân: Cư dân đăng nhập, chọn mục **Công nợ & Lịch sử nộp phí** để xem rõ chi tiết từng khoản thu theo tháng, số tiền đã đóng và số tiền còn nợ (`RAW-003`, `005`, `006`). |
| **Luồng sự kiện thay thế** | • **3a.** Nếu không có hộ nào còn nợ trong kỳ, hệ thống hiển thị thông báo: *"100% các hộ đã hoàn thành nghĩa vụ nộp phí trong kỳ"*. |
| **Hậu điều kiện** | Sổ công nợ được chốt chính xác, số dư nợ chưa đóng được tự động kết chuyển sang kỳ thu tiếp theo. |

---

### 3.7. Đặc tả Use Case `UC007` “Thống kê & Xuất Báo cáo Hành chính cho Chính quyền”

| Thuộc tính | Nội dung chi tiết |
| :--- | :--- |
| **Mã Use case** | `UC007` |
| **Tên Use case** | Thống kê & Xuất Báo cáo Hành chính (Cử tri, Sự kiện, Tạm trú/Tạm vắng, Quỹ từ thiện) |
| **Tác nhân** | Ban Quản trị (cung cấp cho Chính quyền / Tổ dân phố) |
| **Tiền điều kiện** | BQT đã đăng nhập; CSDL có thông tin nhân khẩu (ngày sinh chính xác) và lịch sử thu quỹ. |
| **Luồng sự kiện chính (Thành công)** | 1. BQT chọn chức năng **Báo cáo & Thống kê Hành chính**.<br>2. BQT chọn loại báo cáo cần xuất:<br>   - *Danh sách Cử tri đủ tuổi bầu cử:* Nhập ngày bầu cử mốc (`dd/mm/yyyy`) $\rightarrow$ Hệ thống lọc các nhân khẩu đang cư trú có tuổi tính chính xác đến ngày bầu cử $\ge 18$ tuổi (`RAW-027`, `RAW-030`).<br>   - *Danh sách Dân cư sự kiện (Trung thu / Tiêm phòng):* Nhập khoảng độ tuổi cần lọc (`RAW-028`).<br>   - *Báo cáo Tạm trú / Tạm vắng:* Chọn khoảng thời gian (`RAW-030`).<br>   - *Báo cáo Tổng hợp Thu – Chi Quỹ từ thiện:* Chọn đợt vận động (`RAW-029`).<br>3. Hệ thống truy xuất và hiển thị bảng kết quả trong $\le 10$ giây (`NFR-01`).<br>4. BQT bấm **Xuất file (Excel/PDF)** để nộp Chính quyền. Đối với báo cáo quỹ từ thiện công khai, hệ thống ẩn thông tin nhạy cảm (số CCCD, SĐT) theo Nghị định 13/2023/NĐ-CP. |
| **Luồng sự kiện thay thế** | • **3a.** Nếu không có bản ghi nào thỏa mãn điều kiện lọc, hệ thống thông báo *"Không có dữ liệu phù hợp"*. |
| **Hậu điều kiện** | File báo cáo chính xác được xuất ra đúng định dạng hành chính. |

---

### 3.8. Đặc tả Use Case `UC008` “Quản lý Thông báo Điện tử, Nội quy & Xử lý Ticket Phản ánh”

| Thuộc tính | Nội dung chi tiết |
| :--- | :--- |
| **Mã Use case** | `UC008` |
| **Tên Use case** | Quản lý Thông báo Điện tử, Nội quy chung cư & Xử lý Ticket Phản ánh |
| **Tác nhân** | Ban Quản trị, Cư dân / Chủ hộ |
| **Tiền điều kiện** | Tác nhân đã đăng nhập thành công. |
| **Luồng sự kiện chính (Thành công)** | 1. **Công bố Nội quy / Thông báo:** BQT soạn thảo điều luật/nội quy hoặc thông báo mới và bấm **Phát hành** $\rightarrow$ Hệ thống lưu và đẩy thông báo tới toàn bộ Cư dân (`RAW-007`, `RAW-016`).<br>2. **Gửi & Xử lý Phản ánh (Ticket):** Cư dân chọn **Gửi phản ánh / Yêu cầu**, nhập tiêu đề, phân loại (Sai sót phí / Sai thông tin nhân khẩu / Yêu cầu khác) và nội dung $\rightarrow$ Hệ thống tạo Ticket trạng thái `Mới` và thông báo BQT (`RAW-008`, `RAW-009`).<br>3. BQT mở Ticket, kiểm tra đối chiếu, cập nhật trạng thái (`Đang xử lý` $\rightarrow$ `Đã giải quyết`) và nhập nội dung phản hồi $\rightarrow$ Hệ thống gửi thông báo kết quả tới Cư dân (`RAW-017`). |
| **Luồng sự kiện thay thế** | • **2a.** Nếu Cư dân bỏ trống tiêu đề hoặc nội dung phản ánh, hệ thống yêu cầu nhập đầy đủ trước khi gửi. |
| **Hậu điều kiện** | Thông báo và nội quy được truyền đạt đồng bộ; mọi phản ánh của cư dân được lưu vết và xử lý triệt để. |

---

## 4. Các yêu cầu khác

### 4.1. Chức năng chung (Functionality)
- Trong các chuỗi sự kiện của tất cả các Use Case, mọi bước có thao tác với Cơ sở dữ liệu MySQL, nếu phát sinh lỗi kết nối hoặc lỗi truy vấn, hệ thống bắt buộc hiển thị thông báo lỗi kỹ thuật rõ ràng bằng tiếng Việt để tác nhân biết là lỗi liên quan đến hệ thống/CSDL (không phải lỗi nhập liệu của người dùng).
- Các Use Case nghiệp vụ của Ban Quản trị, Thủ quỹ và Cư dân chỉ được phép thực thi sau khi người dùng đã đăng nhập thành công và vượt qua kiểm tra phân quyền **RBAC** ở cả tầng giao diện (UI) lẫn tầng xử lý dịch vụ (Service/Backend).
- Định dạng hiển thị dữ liệu chuẩn trên toàn hệ thống:
  - Dữ liệu số (Diện tích, Số tiền VNĐ, Số lượng): **Căn phải** và phân tách hàng nghìn rõ ràng.
  - Dữ liệu văn bản (Họ tên, Địa chỉ, Tên khoản thu): **Căn trái**.
  - Kiểu chữ rõ ràng, thống nhất (Font `Arial` / `Segoe UI`, cỡ chữ $\ge 12\text{pt}\text{ – }14\text{pt}$, màu đen trên nền trắng tương phản cao).

### 4.2. Tính dễ dùng (Usability – `NFR-04`, `NFR-009`, `NFR-010`)
- Giao diện 100% thuần Việt, thiết kế trực quan, thân thiện với người dùng không chuyên IT hoặc người lớn tuổi (BQT, Tổ trưởng dân phố).
- Có hướng dẫn và thông báo lỗi cụ thể giúp người dùng định vị đúng trường bị sai và biết cách khắc phục ngay.
- Quy trình ghi nhận khoản nộp phí tại quầy hoàn thành trong **tối đa $\le 3$ bước click chuột**.
- Người dùng mới có thể tự thao tác các luồng chính sau **$\le 30$ phút** hướng dẫn; điểm hài lòng người dùng (**System Usability Scale – SUS**) khi nghiệm thu UAT đạt **$\ge 70$ điểm**.

### 4.3. Các yêu cầu phi chức năng khác

| Nhóm Yêu cầu | Tiêu chí đo lường cụ thể (Metrics) |
| :--- | :--- |
| **Hiệu năng & Chịu tải** (`NFR-01`, `NFR-001`, `NFR-002`, `NFR-011`) | • Hỗ trợ quy mô **500 – 1.000 hộ dân** (lưu trữ 5 năm dữ liệu) và **$\ge 200$ user truy cập đồng thời** vào giờ cao điểm đầu/cuối tháng.<br>• Thời gian phản hồi chuyển trang / tìm kiếm tra cứu: **$\le 2\text{ – }3$ giây**.<br>• Thời gian tự động tính phí toàn tòa nhà: **$\le 30\text{ – }60$ giây**.<br>• Thời gian kết xuất báo cáo thống kê 5 năm dữ liệu & danh sách cử tri: **$\le 10$ giây**. |
| **Bảo mật & Pháp lý** (`NFR-02`, `NFR-003..005`, `NFR-014`) | • Mật khẩu băm bằng thuật toán `bcrypt`/`PBKDF2`; tự động khóa tài khoản sau **5 lần** đăng nhập sai liên tiếp.<br>• Kết nối truyền tải và CSDL mã hóa `TLS`/`HTTPS`.<br>• Tuân thủ tuyệt đối **Nghị định 13/2023/NĐ-CP** về bảo vệ dữ liệu cá nhân (chỉ người có quyền mới được xem/xuất dữ liệu; cư dân chỉ xem được thông tin hộ mình).<br>• Lưu trữ lịch sử thanh toán tối thiểu **05 năm** (`NFR-014`). |
| **Toàn vẹn & Chính xác dữ liệu** (`NFR-03`, `NFR-015`) | • Thuật toán tính phí theo diện tích và công nợ đúng **100%**.<br>• Các trường tiền tệ bắt buộc dùng kiểu **`DECIMAL`** (cấm dùng `Float`/`Double`).<br>• Thao tác ghi nhận nộp tiền bắt buộc dùng **Database Transaction** (rollback nếu lỗi).<br>• Có **Audit Trail (Audit Log)** lưu vết mọi thao tác Thêm/Sửa/Xóa quan trọng (`RAW-015`). |
| **Độ tin cậy, Tương thích & Bảo trì** (`NFR-05`, `NFR-006..008`, `NFR-013`, `NFR-016`) | • Thời gian hoạt động (**Uptime**) **$\ge 99\%$**.<br>• Tự động sao lưu (**Auto Backup**) MySQL hàng ngày; phục hồi dữ liệu (**Restore**) thử nghiệm **$\le 1\text{ – }2$ giờ**; RPO $\le 24$ giờ.<br>• Kiến trúc phân tầng rõ ràng (**UI – Service – DAO**); tương thích Windows 10+ / Java LTS và các trình duyệt phổ biến (Chrome, Edge, Safari). |

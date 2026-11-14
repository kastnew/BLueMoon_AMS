# Hệ thống Quản lý và Thu phí Chung cư BlueMoon (`BlueMoon_AMS v1.0`)

**Mã dự án:** `CNPM-BLUEMOON-2026` | **Học phần:** Nhập môn Công nghệ Phần mềm – SoICT / HUST  
**Kho lưu trữ:** [github.com/kastnew/BLueMoon_AMS](https://github.com/kastnew/BLueMoon_AMS)

---

## 1. Giới thiệu chung

**BlueMoon AMS** là hệ thống phần mềm quản lý vận hành và thu phí tập trung cho Chung cư BlueMoon (quy mô **500 – 1.000 hộ dân**), được xây dựng nhằm thay thế hoàn toàn quy trình thủ công bằng sổ giấy, máy tính cầm tay Casio, biên lai 2 liên và các tệp Excel rời rạc.

### Các bên sử dụng chính (Actors)
1. **Ban Quản trị (Admin / Product Owner):** Quản lý căn hộ, hộ gia đình, nhân khẩu, tạm trú/tạm vắng; thiết lập danh mục khoản thu; phê duyệt đề xuất cập nhật của cư dân; phân quyền RBAC; tra cứu Audit Log và sao lưu/phục hồi dữ liệu.
2. **Thủ quỹ / Kế toán:** Tự động tính phí hàng tháng theo diện tích; ghi nhận nộp phí ($\le 3$ bước click); chốt sổ công nợ và xuất danh sách hộ còn nợ.
3. **Cư dân / Chủ hộ:** Tự tra cứu thông tin hộ gia đình & nhân khẩu; gửi yêu cầu cập nhật (*Maker-Checker*); xem chi tiết khoản thu, lịch sử đã đóng & công nợ; nhận thông báo điện tử, xem nội quy và gửi phản ánh (*Ticket*).
4. **Chính quyền / Tổ dân phố:** Tiếp nhận báo cáo trích xuất nhanh (Danh sách cử tri $\ge 18$ tuổi, danh sách sự kiện/tiêm phòng, báo cáo tạm trú/tạm vắng và báo cáo quỹ từ thiện).

---

## 2. Phạm vi Chức năng (03 Module Cốt lõi – `BlueMoon v1.0`)

| Module | Nhóm chức năng chính | Yêu cầu liên quan |
| :--- | :--- | :--- |
| **Module 1: Quản lý Thu phí & Thống kê** | • Tạo danh mục khoản thu bắt buộc (theo $\text{m}^2$) & quỹ quyên góp tự nguyện<br>• Tự động tính phí toàn tòa nhà & cộng dồn nợ kỳ trước<br>• Ghi nhận thu tiền ($\le 3$ bước), tự động lưu `timestamp` & `DB Transaction`<br>• Chốt sổ công nợ cuối tháng & Thống kê thu chi quỹ từ thiện | `RAW-003`, `005`, `006`, `013`, `023` $\rightarrow$ `026`, `029`, `NFR-03` |
| **Module 2: Quản lý Người dùng & Hệ thống** | • Đăng nhập, đổi mật khẩu (`bcrypt`), khóa sau 5 lần sai, tạo menu động **RBAC**<br>• Thông báo điện tử (phí mới, hạn đóng, xác nhận nộp tiền) & Nội quy chung cư<br>• Tiếp nhận & duyệt **Ticket** phản ánh / yêu cầu của Cư dân<br>• Nhật ký **Audit Log**, cảnh báo truy cập trái phép & **Auto Backup / Restore** | `RAW-007` $\rightarrow$ `009`, `014` $\rightarrow$ `017`, `020`, `021`, `NFR-02`, `NFR-05` |
| **Module 3: Quản lý Hộ gia đình & Nhân khẩu** | • Quản lý danh sách căn hộ (diện tích, trạng thái) & hồ sơ hộ gia đình<br>• Quản lý nhân khẩu, đăng ký tạm trú/tạm vắng<br>• Cư dân tự tra cứu & đề xuất cập nhật nhân khẩu (*Maker-Checker*)<br>• Xuất danh sách cử tri đủ tuổi bầu cử ($\ge 18$), sự kiện & tạm trú/tạm vắng | `RAW-001`, `002`, `004`, `010` $\rightarrow$ `012`, `022`, `027`, `028`, `030` |

> **Định hướng mở rộng (`BlueMoon v2.0` – Ngoài phạm vi v1.0):** Quản lý phí gửi xe, thu hộ tiền điện/nước/internet, kiểm soát khách vãng lai & ghi nhận sự cố an ninh (`RAW-018`, `RAW-019`).

---

## 3. Kiến trúc & Công nghệ

- **Kiến trúc phân tầng rõ ràng:** **`UI` (Giao diện) $\rightarrow$ `Service` (Nghiệp vụ) $\rightarrow$ `DAO` (Truy cập dữ liệu)** kết hợp `Model` và `Util`.
- **Ngôn ngữ & Nền tảng:** Java 17 LTS (Maven), tương thích Windows 10+.
- **Cơ sở dữ liệu:** MySQL 8.x (`DECIMAL(15,2)` cho toàn bộ dữ liệu tiền tệ, `DB Transaction` cho ghi nhận nộp tiền, đánh Index tối ưu truy vấn $\le 2\text{s}$).
- **Bảo mật & Tuân thủ pháp lý:** Mã hóa mật khẩu `BCrypt`, phân quyền RBAC tại tầng Service, lưu vết `Audit Trail`, tuân thủ **Nghị định 13/2023/NĐ-CP** về bảo vệ dữ liệu cá nhân, lưu trữ lịch sử thanh toán tối thiểu **5 năm**.

---

## 4. Cấu trúc Thư mục Dự án (Project Skeleton)

Mỗi thư mục đều có tệp `README.md` riêng giải thích chi tiết nhiệm vụ, quy ước code và phân công thực hiện:

```text
BLueMoon_AMS/
├── README.md                                  # Tài liệu tổng quan chung của toàn dự án
├── pom.xml                                    # Cấu hình Maven, thư viện MySQL, BCrypt, JUnit 5
├── .gitignore                                 # Quy tắc loại trừ file build, IDE, log, backup
├── docs/                                      # Bộ hồ sơ Tài liệu Dự án & Sơ đồ phân tích
│   ├── README.md                              # Giải thích hệ thống tài liệu dự án
│   ├── 01_Tai_lieu_Tuyen_ngon_Du_an_BlueMoon.md
│   ├── 02_Tai_lieu_Ke_hoach_Du_an_BlueMoon.md
│   ├── 03_Tai_lieu_Quan_ly_Rui_ro_Du_an_BlueMoon.md
│   ├── 04_Tai_lieu_Tim_hieu_Khao_sat_Yeu_cau_BlueMoon.md
│   ├── 05_Tai_lieu_Dac_ta_Yeu_cau_Phan_mem_SRS_BlueMoon.md
│   └── diagrams/                              # 07 ảnh sơ đồ FOD, Use Case, Quy trình nghiệp vụ
├── database/                                  # Thiết kế & Khởi tạo CSDL MySQL
│   ├── README.md                              # Giải thích lược đồ bảng, DECIMAL, Transaction, Backup
│   └── bluemoon_schema.sql                    # Script SQL tạo 13 bảng chuẩn + Index + Seed cơ bản
└── src/
    ├── main/java/com/bluemoon/
    │   ├── Main.java                          # Điểm khởi chạy ứng dụng BlueMoon AMS
    │   ├── model/                             # Thực thể dữ liệu (Entity/DTO) + README.md
    │   ├── dao/                               # Tầng truy cập CSDL MySQL (JDBC) + README.md
    │   ├── service/                           # Tầng xử lý nghiệp vụ, Transaction, RBAC + README.md
    │   ├── ui/                                # Tầng giao diện thuần Việt (3 Module) + README.md
    │   └── util/                              # Tiện ích (DB, BCrypt, AuditLogger, Backup) + README.md
    └── test/java/com/bluemoon/                # Bộ kiểm thử Unit Test & Integration Test + README.md
```

---

## 5. Lộ trình Thực hiện & Cột mốc Nghiệm thu (Quý IV/2026)

| Giai đoạn / Mốc | Thời gian | Nội dung trọng tâm |
| :--- | :---: | :--- |
| **Giai đoạn 0: Khởi động & Elicitation** | `01/10 – 25/10/2026` | Tuyên ngôn, WBS/Gantt, Rủi ro, Khảo sát IPO, SRS & Thiết kế CSDL |
| **Sprint 1 – 3: Phát triển 3 Module** | `26/10 – 29/11/2026` | Cài đặt `UI – Service – DAO` cho Quản lý Hộ dân, Thu phí, Người dùng |
| **Mốc UAT 1 (Thử nghiệm)** | `30/11/2026` | Bàn giao bản thử nghiệm cho BQT, Thủ quỹ & Cư dân dùng thử |
| **Mốc UAT 2 (Chính thức)** | `15/12/2026` | Hoàn thiện sửa lỗi, tối ưu UX (SUS $\ge 70$), kiểm thử chịu tải ($\ge 200$ CCU) |
| **Nghiệm thu & Bàn giao cuối** | `30/12/2026` | Đóng gói bộ cài Windows, Hướng dẫn sử dụng & Kết thúc dự án |

---

## 6. Hướng dẫn Cài đặt & Chạy Khung Dự án

1. **Khởi tạo Cơ sở dữ liệu MySQL:**
   ```sql
   SOURCE database/bluemoon_schema.sql;
   ```
2. **Biên dịch và chạy kiểm thử với Maven (Java 17+):**
   ```bash
   mvn clean test
   mvn exec:java -Dexec.mainClass="com.bluemoon.Main"
   ```
3. **Chi tiết từng tầng:** Xem thêm trong các file `README.md` tại từng thư mục `docs/`, `database/`, `model/`, `dao/`, `service/`, `ui/`, `util/` và `test/`.

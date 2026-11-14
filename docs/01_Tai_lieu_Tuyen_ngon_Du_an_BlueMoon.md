# BÀI 4.1: TÀI LIỆU TUYÊN NGÔN DỰ ÁN (PROJECT CHARTER)
*Học phần: Nhập môn Công nghệ Phần mềm – Khoa Khoa học và Kỹ thuật Máy tính (SoICT/HUST)*

---

## BẢNG TUYÊN NGÔN DỰ ÁN (PROJECT CHARTER)

### 1. Thông tin chung

| Hạng mục | Nội dung chi tiết |
| :--- | :--- |
| **Tên dự án:** | **Xây dựng phần mềm quản lý và thu phí ở chung cư Blue Moon (BlueMoon v1.0)** |
| **Nhà tài trợ dự án:** | Ông Nguyễn Văn C – Trưởng Ban quản trị tòa nhà Blue Moon |
| **Cơ quan tài trợ:** | Ban Quản trị Chung cư Blue Moon & Công ty Phần mềm ABC |
| **Mức độ ảnh hưởng của dự án:** | Phần mềm nội bộ và cổng thông tin cư dân, thay đổi toàn diện cách thức quản lý thông tin thu phí, công nợ, thông tin hộ gia đình – nhân khẩu (tạm trú/tạm vắng), phản ánh cư dân và trích xuất báo cáo hành chính ở chung cư Blue Moon (quy mô 500 – 1.000 hộ dân). |

---

### 2. Đội ngũ thực hiện

| Vai trò | Họ và tên | Nơi công tác | Điện thoại | E-mail |
| :--- | :--- | :--- | :--- | :--- |
| **Người quản lý dự án:** | Nguyễn Văn An (PM / Scrum Master) | Nhóm dự án CNPM – SoICT/HUST | 0912.345.101 | `an.nv@sis.hust.edu.vn` |
| **Thành viên dự án:** | Trần Thị Bình (Trưởng nhóm BA) | Nhóm dự án CNPM – SoICT/HUST | 0912.345.102 | `binh.tt@sis.hust.edu.vn` |
| **Thành viên dự án:** | Lê Hoàng Cường (Tech Lead / Backend) | Nhóm dự án CNPM – SoICT/HUST | 0912.345.103 | `cuong.lh@sis.hust.edu.vn` |
| **Thành viên dự án:** | Phạm Minh Đức (Backend / Database Dev) | Nhóm dự án CNPM – SoICT/HUST | 0912.345.104 | `duc.pm@sis.hust.edu.vn` |
| **Thành viên dự án:** | Hoàng Thu Hà (Frontend / UI-UX Dev) | Nhóm dự án CNPM – SoICT/HUST | 0912.345.105 | `ha.ht@sis.hust.edu.vn` |
| **Thành viên dự án:** | Vũ Quốc Khánh (QA / Tester Lead) | Nhóm dự án CNPM – SoICT/HUST | 0912.345.106 | `khanh.vq@sis.hust.edu.vn` |

---

### 3. Các bên liên quan khác *(vai trò, trách nhiệm của các cá nhân và đơn vị tham gia chính trong dự án)*

- **Đại diện khách hàng (Product Owner):** Ông Nguyễn Văn C, Trưởng Ban quản trị tòa nhà Blue Moon – Phê duyệt yêu cầu, xác nhận phạm vi phiên bản v1.0, quản lý danh sách căn hộ/hộ dân (`RAW-011`, `RAW-012`), thiết lập danh mục khoản thu (`RAW-013`), phân quyền (`RAW-014`), duyệt yêu cầu cư dân (`RAW-017`) và nghiệm thu sản phẩm.
- **Đại diện người dùng cuối (Bộ phận Tài chính – Kế toán):** Bà Phạm Thị A, Kế toán / Thủ quỹ Ban quản trị tòa nhà Blue Moon – Cung cấp nghiệp vụ tính phí theo diện tích căn hộ (`RAW-023`), thu phí bắt buộc và quỹ đóng góp tự nguyện (`RAW-025`), đối soát ngày giờ nộp tiền (`RAW-026`) và chốt sổ công nợ hàng tháng (`RAW-024`).
- **Đại diện người dùng cuối (Cư dân):** Ông Trần Văn D, Đại diện các chủ hộ sinh sống tại chung cư Blue Moon – Tham gia khảo sát nhu cầu tự tra cứu và cập nhật nhân khẩu (`RAW-001`, `RAW-002`, `RAW-004`), xem chi tiết phí/công nợ hàng tháng (`RAW-003`, `RAW-005`, `RAW-006`), nhận thông báo và gửi phản ánh trực tuyến (`RAW-007` – `RAW-010`).
- **Đại diện cơ quan quản lý địa phương:** Ông Đỗ Văn E, Tổ trưởng tổ dân phố / Đại diện Công an phường – Cung cấp quy định pháp lý về quản lý tạm trú/tạm vắng và mẫu trích xuất danh sách cử tri đủ tuổi bầu cử, danh sách dân cư sự kiện/tiêm phòng, báo cáo quỹ từ thiện (`RAW-027` – `RAW-030`).
- **Đại diện bộ phận kinh doanh:** Ông Lê Văn B, Nhân viên kinh doanh Công ty ABC – Phối hợp quản lý hợp đồng, ngân sách và bàn giao sản phẩm cho chung cư Blue Moon.

---

### 4. Tuyên bố phạm vi dự án

#### **Bối cảnh và động cơ** *(Mô tả bối cảnh, động cơ thực hiện dự án)*
Hiện tại, Ban quản trị (BQT) chung cư BlueMoon đang quản lý hộ khẩu, nhân khẩu và việc thu phí theo phương thức thủ công (sổ bìa cứng, biên lai giấy 2 liên viết tay, máy tính cầm tay Casio) kết hợp với một số file Excel rời rạc nhưng hiệu quả quản lý chưa cao và phát sinh nhiều bất cập (*As-Is Scenario*):
- Cư dân phải lên trực tiếp văn phòng trong giờ hành chính để nộp bản photo CCCD, khai báo tạm trú hoặc viết đơn phản ánh; BQT phải nhập liệu 2 lần (ghi sổ tay rồi gõ lại vào Excel) rất tốn thời gian và dễ sai sót.
- Kế toán phải bấm máy Casio tính phí theo diện tích từng căn hộ và viết tay giấy báo phí; Thủ quỹ viết biên lai giấy gây ùn tắc giờ cao điểm và mất từ 3 – 5 ngày cuối tháng để gạch nợ, chốt sổ công nợ (dẫn đến việc cư dân đóng tiền rồi vẫn bị nhắc nợ nhầm).
- Khi Chính quyền yêu cầu danh sách cử tri đủ tuổi bầu cử, danh sách tạm trú/tạm vắng hay báo cáo quỹ từ thiện, BQT phải lật sổ và lọc tay hàng giờ; dữ liệu lưu trên máy cá nhân không có sao lưu (Backup) tự động nên có nguy cơ mất trắng hoặc rò rỉ dữ liệu cá nhân.
Do đó, Ban quản trị có nhu cầu cấp thiết xây dựng phần mềm quản lý và thu phí tập trung tại chung cư BlueMoon để tự động hóa nghiệp vụ và minh bạch hóa thông tin.

#### **Mục đích của dự án** *(Mô tả các nhu cầu nghiệp vụ cần giải quyết)*
Xây dựng phần mềm hỗ trợ Ban quản trị, Thủ quỹ và Cư dân chung cư BlueMoon:
- Quản lý tập trung thông tin căn hộ, hộ gia đình (hộ khẩu), nhân dân (nhân khẩu) đang sinh sống tại chung cư và các biến động nhân khẩu (thêm/sửa thành viên, đăng ký tạm trú, tạm vắng) (`RAW-001`, `RAW-002`, `RAW-004`, `RAW-010` – `RAW-012`).
- Quản lý danh mục các loại phí cần đóng góp (phí quản lý chung cư, phí dịch vụ tính theo diện tích căn hộ, các quỹ vận động quyên góp tự nguyện linh hoạt), tự động tính phí hàng tháng, ghi nhận thu tiền kèm mốc thời gian thực tế (`timestamp`) và chốt sổ công nợ (`RAW-013`, `RAW-022` – `RAW-026`).
- Hỗ trợ cư dân tra cứu lịch sử đóng tiền, công nợ còn lại, nhận thông báo điện tử, xem nội quy chung cư và gửi phản ánh/yêu cầu phê duyệt trực tuyến (`RAW-003`, `RAW-005` – `RAW-009`, `RAW-016`, `RAW-017`).
- Trích xuất nhanh chóng các báo cáo thống kê công nợ, báo cáo quỹ từ thiện, danh sách cử tri đủ tuổi bầu cử và danh sách nhân khẩu phục vụ Chính quyền địa phương (`RAW-027` – `RAW-030`).

#### **Mục tiêu** *(Mô tả các kết quả mong muốn đạt được theo cách có thể đo lường được)*
Phần mềm **BlueMoon v1.0** phải đạt được các chỉ số đo lường cụ thể sau:
- **Về chức năng & nghiệp vụ:**
  - Quản lý được **100%** các loại phí cần thu (phí quản lý, phí dịch vụ bắt buộc theo diện tích và các quỹ đóng góp tự nguyện) với độ chính xác tính toán đạt **100%** (sử dụng kiểu dữ liệu `DECIMAL` và giao dịch `DB Transaction` – `NFR-03`).
  - Quản lý được **100%** thông tin về các căn hộ, hộ gia đình (quy mô **500 – 1.000 hộ dân**) và các biến động nhân khẩu (tạm trú/tạm vắng) liên quan đến từng căn hộ (`NFR-011`).
  - Truy vết được **$\ge 80\%$** (mục tiêu 100%) yêu cầu từ *Client's Wish List* (`RAW-001` $\rightarrow$ `RAW-030`) sang *Epic*, *Feature*, *User Story* và *Acceptance Criteria* (`OBJ-01` $\rightarrow$ `OBJ-08`).
- **Về hiệu năng, khả dụng & độ tin cậy (`NFR-01` $\rightarrow$ `NFR-05`):**
  - Thời gian phản hồi tra cứu/chuyển trang **$\le 2\text{ – }3$ giây**; tự động tính phí hàng tháng cho toàn tòa nhà ($\sim 500$ hộ) trong **$\le 30\text{ – }60$ giây**; kết xuất báo cáo thống kê 5 năm dữ liệu trong **$\le 10$ giây**; hỗ trợ **$\ge 200$ người dùng** truy cập đồng thời giờ cao điểm (`NFR-01`, `NFR-001`, `NFR-002`).
  - Quy trình ghi nhận nộp phí hoàn thành trong **$\le 3$ bước click chuột**; người dùng mới thao tác thành thạo sau **$\le 30$ phút** hướng dẫn; điểm hài lòng người dùng (**SUS**) khi nghiệm thu UAT đạt **$\ge 70$ điểm** (`NFR-04`, `NFR-009`, `NFR-010`).
  - Đảm bảo thời gian hoạt động (**Uptime**) **$\ge 99\%$**; lưu trữ lịch sử thanh toán tối thiểu **05 năm**; tự động sao lưu (**Backup**) hàng ngày và phục hồi dữ liệu (**Restore**) khi có sự cố trong **$\le 1\text{ – }2$ giờ**; tuân thủ **Nghị định 13/2023/NĐ-CP** về bảo vệ dữ liệu cá nhân (`NFR-02`, `NFR-05`, `NFR-006` – `NFR-008`, `NFR-014`).

#### **Sản phẩm bàn giao** *(Liệt kê danh sách các đầu mục sản phẩm cần bàn giao)*
- **Cho khách hàng (Ban Quản trị Chung cư Blue Moon):**
  - Bộ cài đặt / Hệ thống phần mềm hoàn chỉnh **BlueMoon v1.0** hoạt động trên các máy tính cá nhân sử dụng hệ điều hành Windows 10+ và trình duyệt Web phổ biến (Chrome, Edge, Safari – `NFR-013`, `NFR-05`).
  - Chứng nhận Bản quyền phần mềm.
  - Tài liệu Hướng dẫn sử dụng (dành cho Ban quản trị, Thủ quỹ/Kế toán và Cư dân).
  - Tài liệu Hướng dẫn cài đặt, cấu hình sao lưu tự động (Backup) và phục hồi dữ liệu (Restore).
- **Cho chủ đầu tư (Công ty ABC & Bộ môn CNPM):**
  - Mã nguồn phần mềm hoàn chỉnh (theo kiến trúc phân tầng `UI – Service – DAO`) và kịch bản khởi tạo Cơ sở dữ liệu MySQL.
  - Các tài liệu kỹ thuật:
    - Bộ hồ sơ Khai phá & Đặc tả yêu cầu: *Client's Wish List*, *As-Is Scenario*, *Visionary Scenario*, *Danh sách NFR*, *Raw Log*, *Danh sách Epic & Feature*, *User Stories (INVEST) + Acceptance Criteria (GWT)*, *Product Backlog (MoSCoW)*, *Traceability Matrix*.
    - Tài liệu Phân tích và Thiết kế hệ thống (Kiến trúc, Biểu đồ Use Case/Class/Sequence, Thiết kế giao diện UI, Thiết kế CSDL ERD).
    - Tài liệu Kiểm thử (Test Plan, Test Cases, Báo cáo kết quả kiểm thử & biên bản UAT), Tài liệu mô tả cấu trúc mã nguồn, API docs.
  - Các tài liệu quản lý dự án: *Tài liệu tuyên ngôn dự án*, *Tài liệu kế hoạch dự án (WBS, Gantt Chart)*, *Tài liệu quản lý rủi ro dự án*.

#### **Phạm vi** *(Liệt kê những gì dự án sẽ làm hoặc không làm)*
- **Phạm vi dự án (Project Scope):**
  - **Sẽ làm (In-Scope):** Bao gồm toàn bộ các công việc Khai phá yêu cầu (Elicitation), Đặc tả yêu cầu, Phân tích, Thiết kế, Lập trình, Kiểm thử (Unit Test, Integration Test, System Test, UAT), Triển khai phần mềm và Đào tạo hướng dẫn sử dụng ban đầu.
  - **Không làm (Out-of-Scope):** Không bao gồm việc nhập liệu thủ công toàn bộ thông tin đầu vào lịch sử trên giấy (như gõ lại từng sổ hộ khẩu giấy, biên lai giấy cũ của các năm trước) mà chỉ cung cấp biểu mẫu/công cụ hỗ trợ import dữ liệu chuẩn hóa; không bao gồm mua sắm phần cứng máy chủ/máy trạm cho tòa nhà.
- **Phạm vi sản phẩm (Product Scope):**
  - **Phiên bản BlueMoon v1.0 (Thực hiện trong dự án này)** gồm **03 Module lớn** (tương ứng các nhóm tính năng cốt lõi):
    1. **Module 1 – Quản lý thu phí và báo cáo thống kê:** Quản lý danh mục khoản thu (phí quản lý, phí dịch vụ theo diện tích, quỹ đóng góp tự nguyện); Tự động tính phí hàng tháng; Ghi nhận thu phí & lưu vết thời gian thực tế (`timestamp`); Chốt sổ công nợ cuối tháng & nhắc nợ; Tra cứu lịch sử đóng tiền/công nợ cho cư dân; Thống kê các khoản đóng góp và xuất báo cáo quỹ từ thiện (`RAW-003`, `RAW-005`, `RAW-006`, `RAW-013`, `RAW-023` – `RAW-026`, `RAW-029`).
    2. **Module 2 – Quản lý người dùng và hệ thống:** Đăng nhập, đổi mật khẩu, khóa tài khoản khi nhập sai quá 5 lần; Quản lý tài khoản và phân quyền theo vai trò (RBAC: Ban quản trị, Thủ quỹ/Kế toán, Cư dân); Quản lý thông báo điện tử, nội quy chung cư & xử lý Ticket phản ánh/yêu cầu của cư dân; Ghi nhật ký hoạt động (Audit Log), cảnh báo truy cập bất thường và sao lưu/phục hồi dữ liệu tự động (`RAW-007` – `RAW-009`, `RAW-014` – `RAW-017`, `RAW-020`, `RAW-021`).
    3. **Module 3 – Quản lý hộ gia đình và nhân khẩu:** Quản lý danh sách căn hộ & diện tích; Quản lý thông tin hộ gia đình (hộ khẩu) và thành viên trong hộ (nhân khẩu); Quản lý đăng ký tạm trú / tạm vắng; Cư dân tự tra cứu và gửi yêu cầu cập nhật thông tin gia đình; Trích xuất danh sách cử tri đủ tuổi bầu cử, danh sách dân cư sự kiện/tiêm phòng và báo cáo tạm trú/tạm vắng cho Chính quyền (`RAW-001`, `RAW-002`, `RAW-004`, `RAW-010` – `RAW-012`, `RAW-022`, `RAW-027`, `RAW-028`, `RAW-030`).
  - **Định hướng mở rộng BlueMoon v2.0 (Won't-have trong v1.0 – Đưa vào Roadmap tương lai):** Quản lý phương tiện và phí gửi xe; Quản lý thu hộ tiền điện, nước, internet; Quản lý khách vãng lai ra vào sảnh bảo vệ và ghi nhận biên bản sự cố an ninh (`RAW-018`, `RAW-019`).

#### **Ngân sách**
Ngân sách của dự án là **100.000.000 đồng** *(Một trăm triệu đồng chẵn)*, bao gồm toàn bộ kinh phí khảo sát yêu cầu, xây dựng phần mềm, kiểm thử, quản lý dự án và kinh phí dự phòng (10%).

#### **Lịch trình thực hiện** *(Các mốc thời gian chính (bắt đầu, kết thúc) cho các pha trong dự án và các mốc khác)*
Dự án được thực hiện trong **Quý IV năm 2026** (kéo dài 12 tuần, từ **01/10/2026** đến **30/12/2026**):
- **Khởi tạo dự án & Hoàn thành Khai phá yêu cầu (Elicitation & Product Backlog):** 01/10/2026 – 15/10/2026 (Mốc D+1 $\rightarrow$ D+8).
- **Hoàn thành Phân tích, Thiết kế kiến trúc & CSDL:** 16/10/2026 – 25/10/2026.
- **Phát triển & Kiểm thử các phân đoạn (Sprint 1 – Sprint 3):** 26/10/2026 – 29/11/2026.
- **Bàn giao phiên bản thử nghiệm (First user acceptance test – UAT 1):** **30/11/2026**.
- **Bàn giao phiên bản chính thức (Second user acceptance test – UAT 2):** **15/12/2026**.
- **Thời gian hoàn thành & Tổng kết nghiệm thu dự án:** **30/12/2026**.

#### **Rủi ro và giả định** *(Liệt kê các trở ngại có thể khiến dự án thất bại)*

| Rủi ro / Giả định | Xác suất xảy ra | Tác động |
| :--- | :---: | :---: |
| **Rủi ro kỹ thuật:**<br>- Sai số làm tròn khi tính phí diện tích căn hộ hoặc lỗi gián đoạn khi ghi nhận giao dịch nộp tiền (`NFR-03`).<br>- Hiệu năng chậm vào kỳ cao điểm thu phí đầu/cuối tháng ($\ge 200$ user đồng thời, tính phí 500–1.000 hộ > 60 giây – `NFR-01`).<br>- Rò rỉ dữ liệu cá nhân cư dân hoặc phân quyền RBAC chưa chặt chẽ (`NFR-02`). | Vừa (2) | Cao (3) |
| **Rủi ro chi phí & tiến độ:**<br>- Ước tính thời gian và chi phí quá lạc quan dẫn đến nguy cơ chậm mốc UAT 1 (30/11/2026).<br>- Nhân sự trong nhóm phải tham gia nhiều dự án/môn học cùng lúc. | Vừa (2) | Vừa (2) |
| **Rủi ro phạm vi & yêu cầu:**<br>- Các bên liên quan thay đổi yêu cầu hoặc đề xuất đưa các tính năng của phiên bản v2.0 (phí gửi xe, thu hộ điện/nước, quản lý khách vãng lai `RAW-018`, sự cố an ninh `RAW-019`) vào phiên bản v1.0. | Vừa (2) | Vừa (2) |
| **Rủi ro dữ liệu & nghiệm thu:**<br>- Dữ liệu lịch sử trên sổ giấy và file Excel cũ của BQT không đồng nhất, trùng số CCCD hoặc lệch công nợ.<br>- Người dùng lớn tuổi (BQT, Tổ dân phố) gặp khó khăn khi thao tác nếu giao diện phức tạp (`NFR-04`). | Thấp (1) | Vừa (2) |
| **Giả định về nhân lực:**<br>- Toàn bộ 06 thành viên đội dự án cam kết dành tối thiểu 15–20 giờ/tuần cho dự án và nắm vững quy trình Scrum cũng như kiến trúc phân tầng `UI – Service – DAO`. | — | — |
| **Giả định về máy móc thiết bị:**<br>- Văn phòng Ban quản trị chung cư BlueMoon có sẵn máy tính chạy Windows 10+ và kết nối mạng ổn định để cài đặt, vận hành hệ thống và thực hiện sao lưu dữ liệu hàng ngày. | — | — |
| **Giả định về khách hàng:**<br>- Đại diện BQT, Thủ quỹ và Cư dân sẵn sàng tham gia các buổi phỏng vấn Elicitation, Workshop đồng bộ và sẽ dùng thử phần mềm phiên bản thử nghiệm (30/11/2026), đóng góp ý kiến để hoàn thiện phiên bản chính thức (15/12/2026). | — | — |
| **Giả định về phạm vi:**<br>- Phạm vi dự án BlueMoon v1.0 sẽ không thay đổi sau khi các bên liên quan đã thống nhất Product Backlog (MoSCoW) và ký kết Tuyên ngôn dự án; các tính năng mở rộng sẽ được chuyển sang lộ trình v2.0. | — | — |

#### **Ràng buộc** *(Liệt kê bất kỳ điều kiện nào có thể hạn chế các lựa chọn của nhóm dự án liên quan đến nguồn lực, nhân sự hoặc lịch trình)*
- **Về thời gian & nhân sự:** Dự án sẽ không kéo dài quá **3 – 4 tháng** (hoàn thành chậm nhất ngày 30/12/2026). Nếu chậm tiến độ ở các pha giữa, có thể tính đến phương án tăng ca hoặc bổ sung/điều phối lại nhân lực thực hiện giữa các module nếu không vượt quá ngân sách dự án.
- **Về ngân sách:** Ngân sách dự án (100.000.000 đồng) đã dự tính kinh phí dự phòng trong trường hợp có chi phí vượt mức, vì vậy **không được phép vượt quá ngân sách** vì bất kỳ lý do gì.
- **Về pháp lý & kỹ thuật (`NFR-02`, `NFR-03`, `NFR-05`):** Phần mềm bắt buộc tuân thủ **Nghị định 13/2023/NĐ-CP** về bảo vệ dữ liệu cá nhân, lưu trữ lịch sử thanh toán tối thiểu **5 năm**, sử dụng kiểu dữ liệu `DECIMAL` cho tiền tệ và đảm bảo giao dịch nguyên tố (`DB Transaction`).

#### **Các yếu tố phụ thuộc bên ngoài** *(Liệu sự thành công của dự án có phụ thuộc vào sự phối hợp nỗ lực giữa nhóm dự án và các bên liên quan khác không? Các bên liên quan có đồng ý phối hợp không?)*
- Sự thành công của dự án phụ thuộc chặt chẽ vào sự phối hợp giữa Nhóm dự án với:
  1. **Ban Quản trị và Kế toán/Thủ quỹ tòa nhà BlueMoon** trong việc cung cấp quy trình thực tế, bảng biểu Excel hiện hành, mẫu biên lai thu tiền, công thức tính phí diện tích và tham gia kiểm thử nghiệm thu (UAT).
  2. **Tổ trưởng tổ dân phố / Chính quyền địa phương** trong việc cung cấp biểu mẫu chuẩn về danh sách cử tri đủ tuổi bầu cử và quy định khai báo tạm trú, tạm vắng.
  3. **Đại diện các hộ cư dân** trong việc tham gia khảo sát nhu cầu và đánh giá trải nghiệm người dùng (điểm SUS $\ge 70$).
- Tất cả các bên liên quan nêu trên đã thống nhất và **đồng ý cam kết phối hợp** theo lịch trình dự án.

---

### 5. Chiến lược truyền thông *(cách người quản lý dự án sẽ liên lạc với nhà tài trợ dự án, nhóm dự án và các bên liên quan)*

- **Báo cáo tiến độ tuần:** Người quản lý dự án gửi báo cáo tiến độ dự án, tình trạng Product Backlog và danh sách rủi ro hàng tuần (vào chiều Thứ Sáu) cho Nhà tài trợ dự án, Đại diện khách hàng (BQT) và đội dự án qua Email.
- **Họp nhanh hàng ngày (Daily Standup Meeting):** Họp nhanh 15 phút với các thành viên đội dự án vào đầu giờ sáng hàng ngày (08:30 – 08:45) để rà soát tiến độ công việc và gỡ bỏ các vướng mắc kỹ thuật.
- **Kênh trao đổi tức thời:** Thiết lập nhóm trao đổi trực tiếp qua Zalo / Microsoft Teams giữa đại diện Khách hàng (BQT, Thủ quỹ) với Nhóm phát triển để làm rõ ngay các câu hỏi nghiệp vụ phát sinh.
- **Họp đánh giá các mốc (Milestone & Sprint Review):** Tổ chức họp đánh giá kết quả và chạy thử nghiệm (Demo) sản phẩm tại mỗi mốc thời gian theo lịch trình thực hiện (Chốt Backlog 15/10, UAT 1 ngày 30/11, UAT 2 ngày 15/12 và Nghiệm thu 30/12) với sự tham gia của Khách hàng, Nhà tài trợ và Đội thực hiện dự án.

---

### 6. Phê duyệt

| Vai trò | Họ và tên | Chữ ký | Ngày |
| :--- | :--- | :---: | :---: |
| **Nhà tài trợ dự án** | Ông Nguyễn Văn C | *(Đã ký)* | 01/10/2026 |
| **Cơ quan tài trợ dự án** | Ông Lê Văn B (Đại diện Công ty ABC) | *(Đã ký)* | 01/10/2026 |
| **Người quản lý dự án** | Nguyễn Văn An | *(Đã ký)* | 01/10/2026 |

---

### 7. Ghi chú
- Tài liệu Tuyên ngôn dự án này là cơ sở pháp lý nội bộ để triển khai **Bài 4.2 (Lập kế hoạch dự án – WBS & Gantt Chart)** và **Bài 4.3 (Lập kế hoạch quản lý rủi ro)** cho dự án Hệ thống Quản lý và Thu phí Chung cư BlueMoon.
- Mọi đề xuất thay đổi phạm vi sau ngày ký duyệt phải tuân thủ quy trình kiểm soát thay đổi (Change Request) và được Nhà tài trợ dự án phê duyệt bằng văn bản.

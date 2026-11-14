# TÀI LIỆU TÌM HIỂU, KHẢO SÁT VÀ PHÂN TÍCH YÊU CẦU PHẦN MỀM
**Dự án:** Hệ thống Quản lý và Thu phí Chung cư BlueMoon (BlueMoon v1.0)  
**Mã dự án:** CNPM-BLUEMOON-2026  
**Giai đoạn:** 02 – Phân tích Yêu cầu Phần mềm  

---

## 1. TỔNG HỢP KẾT QUẢ KHẢO SÁT & TÌM HIỂU YÊU CẦU (ELICITATION FINDINGS)

### 1.1. Danh sách Yêu cầu Chức năng thô (Client's Wish List: `RAW-001` $\rightarrow$ `RAW-030`)
*(Trích xuất từ kết quả phỏng vấn Ban Quản trị, quan sát Thủ quỹ, khảo sát Cư dân và tham vấn Chính quyền địa phương)*

| Mã RAW | Nguồn | Nhóm chức năng | Tóm tắt mong muốn thô của khách hàng |
| :---: | :--- | :--- | :--- |
| `RAW-001` | Cư dân | Hộ gia đình & Nhân khẩu | Tự tra cứu thông tin hộ gia đình và nhân khẩu của nhà mình, không phải lên văn phòng hỏi BQT. |
| `RAW-002` | Cư dân | Hộ gia đình & Nhân khẩu | Tự cập nhật/đề xuất sửa thông tin cá nhân hoặc căn hộ khi có thay đổi. |
| `RAW-003` | Cư dân | Thu phí & Công nợ | Xem danh sách các khoản phí nhà mình phải đóng theo từng tháng để chuẩn bị tiền. |
| `RAW-004` | Cư dân | Hộ gia đình & Nhân khẩu | Tự thêm và chỉnh sửa thông tin thành viên trong gia đình trên hệ thống khi có biến động. |
| `RAW-005` | Cư dân | Thu phí & Công nợ | Biết rõ nhà mình đã đóng bao nhiêu tiền và còn nợ bao nhiêu. |
| `RAW-006` | Cư dân | Thu phí & Công nợ | Xem chi tiết từng khoản thu (tên khoản thu, số tiền, kỳ thu) để biết đang đóng cho cái gì. |
| `RAW-007` | Cư dân | Thông báo & Tương tác | Nhận thông báo ngay khi có khoản phí mới, hạn đóng tiền, xác nhận đóng thành công và quyết định mới của chung cư. |
| `RAW-008` | Cư dân | Thông báo & Tương tác | Gửi phản ánh trực tuyến khi thông tin cư dân hoặc khoản phí bị sai. |
| `RAW-009` | Cư dân | Thông báo & Tương tác | Gửi yêu cầu quan trọng qua hệ thống và chờ BQT phê duyệt thay vì viết đơn giấy. |
| `RAW-010` | Cư dân | Hộ gia đình & Nhân khẩu | Đăng ký tạm trú nhanh chóng cho người thân đến ở lại vài tuần và lưu chính xác trên hệ thống. |
| `RAW-011` | Ban quản trị | Hộ gia đình & Nhân khẩu | Quản lý danh sách các hộ gia đình trong khu dân cư tập trung ở một chỗ, tra cứu nhanh. |
| `RAW-012` | Ban quản trị | Hộ gia đình & Nhân khẩu | Quản lý danh sách các căn hộ (mã căn, diện tích, hộ đang ở). |
| `RAW-013` | Ban quản trị | Danh mục khoản thu | Tự tạo và quản lý danh mục các khoản thu, thiết lập đơn giá thu. |
| `RAW-014` | Ban quản trị | Quản trị & Bảo mật | Quản lý tài khoản người dùng và phân quyền truy cập rõ ràng (ai được xem, ai được sửa). |
| `RAW-015` | Ban quản trị | Quản trị & Bảo mật | Tra cứu lịch sử cập nhật dữ liệu và các hoạt động quan trọng (Audit Log: ai sửa gì, lúc nào). |
| `RAW-016` | Ban quản trị | Thông báo & Tương tác | Quản lý và công bố các điều luật, nội quy khu dân cư cho mọi người cùng biết. |
| `RAW-017` | Ban quản trị | Thông báo & Tương tác | Quản lý và xử lý ngay các yêu cầu/phản ánh do cư dân gửi lên, không bỏ sót. |
| `RAW-018` | Ban quản trị | An ninh *(v2.0)* | Ghi nhận thông tin khách đến thăm khu dân cư để tra cứu khi cần *(Định hướng BlueMoon v2.0)*. |
| `RAW-019` | Ban quản trị | An ninh *(v2.0)* | Ghi nhận và theo dõi các sự cố an ninh xảy ra trong khu dân cư *(Định hướng BlueMoon v2.0)*. |
| `RAW-020` | Ban quản trị | Quản trị & Bảo mật | Tự động sao lưu (Backup) dữ liệu định kỳ và khôi phục (Restore) khi hỏng máy. |
| `RAW-021` | Ban quản trị | Quản trị & Bảo mật | Cảnh báo ngay cho BQT khi có hoạt động bất thường hoặc truy cập trái phép. |
| `RAW-022` | Thủ quỹ | Hộ gia đình & Nhân khẩu | Tra cứu nhanh thông tin hộ gia đình và cư dân khi đi thu phí để thu đúng nhà, đúng người. |
| `RAW-023` | Thủ quỹ | Thu phí & Công nợ | Tự động tính tổng tiền phí quản lý và phí dịch vụ dựa trên diện tích căn hộ và đơn giá cài sẵn. |
| `RAW-024` | Thủ quỹ | Thu phí & Công nợ | Chốt sổ hàng tháng và xuất danh sách các hộ còn nợ phí để đôn đốc thu hồi nợ. |
| `RAW-025` | Thủ quỹ | Danh mục khoản thu | Nhập số tiền đóng góp linh hoạt theo từng người đối với các đợt vận động quyên góp tự nguyện. |
| `RAW-026` | Thủ quỹ | Thu phí & Công nợ | Tự động ghi lại ngày giờ thực tế (`timestamp`) mỗi lần cư dân nộp tiền để đối soát quỹ. |
| `RAW-027` | Chính quyền | Báo cáo hành chính | Xuất danh sách cử tri đủ tuổi bầu cử đang sinh sống tại BlueMoon. |
| `RAW-028` | Chính quyền | Báo cáo hành chính | Cung cấp thông tin dân cư phục vụ sự kiện cộng đồng (Trung thu, tiêm phòng). |
| `RAW-029` | Chính quyền | Báo cáo hành chính | Báo cáo tổng hợp thu chi các quỹ vận động từ thiện và bảo đảm giữ bí mật thông tin cư dân. |
| `RAW-030` | Chính quyền | Báo cáo hành chính | Xuất báo cáo danh sách tạm trú, tạm vắng và danh sách cử tri phục vụ kiểm tra hành chính. |

### 1.2. Tổng hợp Yêu cầu Phi chức năng (NFR Summary: `NFR-01` $\rightarrow$ `NFR-05`)
- **`NFR-01` (Hiệu năng & Chịu tải):** Hỗ trợ $\ge 200$ user đồng thời giờ cao điểm; quy mô 500 – 1.000 hộ dân (5 năm dữ liệu); phản hồi tra cứu $\le 2\text{ – }3$ giây; tạo kỳ thu phí toàn tòa nhà $\le 30\text{ – }60$ giây; xuất báo cáo 5 năm $\le 10$ giây.
- **`NFR-02` (Bảo mật, Phân quyền & Pháp lý):** Đăng nhập bắt buộc, mật khẩu băm `bcrypt`/`PBKDF2`, khóa tài khoản sau 5 lần sai; phân quyền RBAC; kết nối mã hóa `TLS`/`HTTPS`; tuân thủ **Nghị định 13/2023/NĐ-CP** về bảo vệ dữ liệu cá nhân.
- **`NFR-03` (Toàn vẹn & Chính xác dữ liệu):** Tính phí đúng 100%; tiền tệ bắt buộc dùng kiểu `DECIMAL`; ghi nhận nộp tiền dùng `DB Transaction` (rollback khi lỗi); có `Audit Trail` lưu vết mọi thao tác sửa/xóa; lưu trữ lịch sử thanh toán tối thiểu 5 năm.
- **`NFR-04` (Khả dụng UI/UX):** Giao diện thuần Việt, font $\ge 12\text{pt}$; thao tác nộp phí hoàn tất trong $\le 3$ bước click; user mới thao tác được sau $\le 30$ phút hướng dẫn; điểm SUS khi UAT $\ge 70$.
- **`NFR-05` (Tin cậy, Bảo trì & Mở rộng):** Uptime $\ge 99\%$; tự động Backup MySQL hàng ngày; Restore $\le 1\text{ – }2$ giờ (RPO $\le 24\text{h}$); kiến trúc 3 tầng `UI – Service – DAO` sẵn sàng mở rộng v2.0.

---

## 2. PHÂN TÍCH IPO (INPUT – PROCESS – OUTPUT) CHI TIẾT

Bảng phân tích **IPO (Input – Process – Output)** dưới đây chuẩn hóa đầu vào, quy tắc xử lý nghiệp vụ và đầu ra cho **11 nhóm chức năng cốt lõi** thuộc 3 Module của BlueMoon v1.0:

| Mã CN | Tên Chức năng | Đầu vào (Input) | Quy trình Xử lý (Process) | Đầu ra (Output) |
| :---: | :--- | :--- | :--- | :--- |
| **IPO-01** | **Đăng nhập, Đổi mật khẩu & Tạo menu RBAC** (`RAW-014`, `NFR-02`) | • Tên đăng nhập / Email<br>• Mật khẩu<br>• (Khi đổi MK: MK cũ, MK mới, Xác nhận MK mới) | 1. Kiểm tra trường bắt buộc và trạng thái khóa tài khoản.<br>2. So khớp mật khẩu với chuỗi băm `bcrypt` trong DB.<br>3. Nếu sai $\ge 5$ lần liên tiếp $\rightarrow$ tự động khóa tài khoản (`is_locked = true`).<br>4. Nếu đúng $\rightarrow$ reset đếm sai, truy vấn vai trò (BQT / Thủ quỹ / Cư dân) và danh sách quyền được cấp, sinh Session/Token và menu tương ứng. | • Phiên đăng nhập hợp lệ + Menu chức năng theo vai trò RBAC.<br>• Thông báo lỗi cụ thể hoặc cảnh báo khóa tài khoản.<br>• Ghi log đăng nhập. |
| **IPO-02** | **Quản lý Căn hộ & Hồ sơ Hộ gia đình** (`RAW-011`, `012`, `022`) | • Mã căn hộ (VD: `B1205`), Tầng, Diện tích ($\text{m}^2$ > 0), Trạng thái<br>• Mã hộ khẩu, Tên chủ hộ, SĐT, Ngày chuyển đến | 1. Kiểm tra tính hợp lệ (diện tích > 0, mã căn hộ duy nhất).<br>2. Kiểm tra ràng buộc 1 căn hộ chỉ gắn tối đa 1 hộ gia đình đang cư trú tại 1 thời điểm.<br>3. Lưu/cập nhật vào bảng `Apartments` và `Households`, ghi `AuditLog`. | • Danh sách căn hộ và hộ gia đình được cập nhật.<br>• Kết quả tìm kiếm nhanh theo Mã căn, Tên chủ hộ (< 2s). |
| **IPO-03** | **Quản lý Nhân khẩu & Tạm trú / Tạm vắng** (`RAW-010`, `022`) | • Họ tên, Ngày sinh, Giới tính, Số CCCD (12 số), Quan hệ với chủ hộ<br>• Thông tin tạm trú/tạm vắng (Loại, Từ ngày, Đến ngày, Lý do) | 1. Kiểm tra định dạng & tính duy nhất của số CCCD.<br>2. Kiểm tra ngày đến $\le$ ngày đi đối với tạm trú/tạm vắng.<br>3. Thực hiện lưu mềm (`is_active`) để bảo toàn lịch sử cư trú; tự động cảnh báo các hồ sơ tạm trú sắp hết hạn. | • Hồ sơ nhân khẩu thuộc hộ gia đình.<br>• Danh sách tạm trú/tạm vắng và cảnh báo hết hạn. |
| **IPO-04** | **Cư dân tự tra cứu & Đề xuất cập nhật nhân khẩu (Maker-Checker)** (`RAW-001`, `002`, `004`, `009`, `017`) | • `User_ID` của Cư dân đang đăng nhập<br>• Nội dung đề xuất thêm/sửa thành viên hoặc đăng ký tạm trú + ảnh giấy tờ đính kèm | 1. Lọc dữ liệu chỉ theo `Household_ID` của chính cư dân đăng nhập (tuân thủ NĐ 13/2023/NĐ-CP).<br>2. Khi cư dân gửi đề xuất sửa/thêm, hệ thống **không ghi đè trực tiếp** mà tạo Ticket trạng thái `Pending` gửi BQT.<br>3. Khi BQT bấm **Phê duyệt**, hệ thống mới cập nhật bảng `Residents` trong `DB Transaction`, ghi `AuditLog` và thông báo cho cư dân. | • Thông tin hộ gia đình của chính cư dân.<br>• Ticket yêu cầu cập nhật và trạng thái duyệt (`Chờ duyệt` / `Đã duyệt` / `Từ chối`). |
| **IPO-05** | **Quản lý Danh mục Khoản thu (Bắt buộc & Tự nguyện)** (`RAW-013`, `023`, `025`) | • Tên khoản thu, Loại khoản thu (`Bắt buộc theo m²` / `Cố định` / `Quyên góp tự nguyện`), Đơn giá (`DECIMAL`), Kỳ áp dụng, Hạn nộp | 1. Kiểm tra đơn giá $\ge 0$ (nếu là quỹ tự nguyện cho phép để trống đơn giá cố định để nhập linh hoạt khi thu).<br>2. Lưu cấu hình vào bảng `FeeCategories` và ghi nhận `AuditLog`. | • Danh mục các khoản thu đang hiệu lực dùng cho kỳ tính phí. |
| **IPO-06** | **Tự động Tính phí Hàng tháng & Cộng dồn Công nợ** (`RAW-023`, `NFR-002`, `NFR-03`) | • Kỳ thu phí (Tháng/Năm)<br>• Danh sách khoản thu áp dụng<br>• Dữ liệu diện tích căn hộ & nợ tồn kỳ trước | 1. Khóa tránh tạo trùng kỳ thu đã tồn tại.<br>2. Với mỗi hộ đang ở: `Phí = Diện tích (m²) × Đơn giá` (kiểu `DECIMAL(15,2)`).<br>3. Cộng dồn số dư nợ chưa thanh toán từ kỳ trước.<br>4. Chạy Batch Insert tạo hóa đơn cho 500–1.000 hộ trong $\le 30\text{ – }60$ giây, đồng thời đẩy thông báo phí mới tới từng hộ. | • Bảng Hóa đơn chi tiết theo từng căn hộ cho kỳ thu.<br>• Thông báo điện tử gửi tới tài khoản Cư dân. |
| **IPO-07** | **Ghi nhận Thu phí & Đối soát Thời gian thực** (`RAW-025`, `026`, `NFR-03`, `NFR-010`) | • Mã hộ / Mã hóa đơn<br>• Khoản thu (bắt buộc hoặc số tiền quyên góp tự nguyện nhập tay)<br>• Số tiền thực nộp (`DECIMAL`), Hình thức (Tiền mặt/CK) | 1. Thủ quỹ chọn hộ và tích khoản nộp (tối đa $\le 3$ bước click).<br>2. Mở **DB Transaction**: Lưu bản ghi `Payments` kèm `timestamp` hệ thống tự sinh (`NOW()`), cập nhật số tiền đã đóng & trạng thái hóa đơn (`Đã đóng` / `Nợ một phần`). Nếu lỗi $\rightarrow$ Rollback toàn bộ.<br>3. Ghi `AuditLog` và gửi thông báo *"Đóng tiền thành công"* cho Cư dân. | • Giao dịch nộp tiền có dấu thời gian thực tế (`timestamp`).<br>• Trạng thái công nợ cập nhật tức thời.<br>• Thông báo xác nhận cho Cư dân. |
| **IPO-08** | **Chốt sổ Công nợ Cuối kỳ & Tra cứu Cư dân** (`RAW-003`, `005`, `006`, `024`) | • Kỳ thu phí cần chốt sổ<br>• Bộ lọc tra cứu của Cư dân/Thủ quỹ | 1. Khóa chỉnh sửa giao dịch kỳ cũ sau khi chốt sổ.<br>2. Tổng hợp tổng phải thu, tổng đã thu, tổng còn nợ của từng hộ.<br>3. Xuất danh sách các hộ có `Số dư nợ > 0` và gửi thông báo nhắc nợ tự động. | • Báo cáo chốt sổ công nợ tháng.<br>• Danh sách hộ còn nợ phí (Excel/PDF) để Thủ quỹ đôn đốc. |
| **IPO-09** | **Quản lý Thông báo, Nội quy & Ticket Phản ánh** (`RAW-007`, `008`, `016`, `017`) | • Tiêu đề, Nội dung thông báo / Nội quy chung cư<br>• Nội dung phản ánh sai sót của Cư dân | 1. BQT đăng nội quy/quyết định mới $\rightarrow$ hệ thống phát thông báo tới toàn bộ tài khoản Cư dân.<br>2. Cư dân gửi phản ánh $\rightarrow$ tạo Ticket gắn mã, ngày giờ gửi và trạng thái `Mới` $\rightarrow$ BQT tiếp nhận, xử lý và phản hồi kết quả. | • Bảng tin Nội quy & Thông báo điện tử.<br>• Danh sách Ticket phản ánh theo dõi xuyên suốt. |
| **IPO-10** | **Xuất Báo cáo Hành chính cho Chính quyền** (`RAW-027` $\rightarrow$ `RAW-030`) | • Loại báo cáo (Cử tri / Sự kiện / Tạm trú-Tạm vắng / Quỹ từ thiện)<br>• Ngày mốc tính tuổi bầu cử hoặc khoảng thời gian | 1. **Cử tri:** Lọc nhân khẩu đang cư trú có `Tuổi tính đến ngày bầu cử ≥ 18 tuổi`.<br>2. **Sự kiện/Tiêm phòng:** Lọc nhân khẩu theo độ tuổi/nhóm.<br>3. **Quỹ từ thiện:** Tổng hợp thu/chi theo đợt vận động, ẩn thông tin nhạy cảm cá nhân theo NĐ 13/2023/NĐ-CP. | • File báo cáo chuẩn (Excel/PDF) xuất trong $\le 10$ giây phục vụ Chính quyền địa phương. |
| **IPO-11** | **Giám sát Audit Log, Cảnh báo & Backup/Restore** (`RAW-015`, `020`, `021`) | • Bộ lọc nhật ký (User, Thời gian, Bảng dữ liệu)<br>• Lịch sao lưu định kỳ / File backup `.sql` | 1. Mọi thao tác Thêm/Sửa/Xóa quan trọng tự động ghi `Old_Value`, `New_Value`, `User_ID`, `Timestamp`.<br>2. Phát hiện đăng nhập sai liên tiếp hoặc truy cập trái phép $\rightarrow$ gửi cảnh báo cho BQT.<br>3. Cron Job chạy `mysqldump` hàng ngày và hỗ trợ Restore $\le 1\text{ – }2$ giờ. | • Nhật ký Audit Log không thể chỉnh sửa.<br>• Cảnh báo bảo mật.<br>• Bản sao lưu an toàn hàng ngày. |

---

## 3. SƠ ĐỒ PHÂN RÃ CHỨC NĂNG (FUNCTIONAL DECOMPOSITION DIAGRAM – FOD)

Sơ đồ phân rã chức năng dưới đây mô tả cấu trúc 3 tầng từ hệ thống tổng thể đến 03 Module chính và 12 nhóm chức năng chi tiết của **BlueMoon v1.0**:

![Sơ đồ phân rã chức năng FOD](file:///D:/CNPM/diagrams/01_So_do_phan_ra_chuc_nang_FOD.png)

---

## 4. QUY TRÌNH NGHIỆP VỤ CHUẨN HÓA (BUSINESS PROCESS FLOWS)

### 4.1. Quy trình Nghiệp vụ: Tính phí Tự động, Thu phí & Chốt sổ Công nợ
Quy trình này số hóa toàn bộ Bước 2 và Bước 3 trong hiện trạng (*As-Is Scenario*), loại bỏ việc bấm máy tính Casio và viết tay biên lai giấy 2 liên:

![Quy trình nghiệp vụ Tính phí và Thu phí](file:///D:/CNPM/diagrams/06_Quy_trinh_nghiep_vu_Tinh_va_Thu_phi.png)

### 4.2. Quy trình Nghiệp vụ: Cập nhật Nhân khẩu, Đăng ký Tạm trú & Phản ánh (Cơ chế Maker-Checker)
Quy trình này giải quyết triệt để mâu thuẫn giữa nhu cầu tự cập nhật của Cư dân (`RAW-002`, `RAW-004`) và yêu cầu kiểm soát dữ liệu pháp lý của BQT (`RAW-009`, `RAW-010`, `RAW-017`):

![Quy trình nghiệp vụ Nhân khẩu và Tạm trú](file:///D:/CNPM/diagrams/07_Quy_trinh_nghiep_vu_Nhan_khau_Tam_tru.png)

---

## 5. CHUẨN HÓA SCRUM ARTEFACTS & MA TRẬN TRUY VẾT (PRODUCT BACKLOG & TRACEABILITY MATRIX)

### 5.1. Product Backlog Ưu tiên theo MoSCoW

| Mã Hạng mục | Tên Epic / User Story tóm tắt | Nguồn RAW | Ưu tiên (MoSCoW) | Release |
| :---: | :--- | :--- | :---: | :---: |
| `EPIC-06` (`US-01`) | Đăng nhập, đổi mật khẩu, khóa sai 5 lần & phân quyền RBAC | `RAW-014`, `NFR-02` | **Must-have** | R1 |
| `EPIC-01` (`US-02`) | Quản lý danh sách căn hộ (diện tích), hộ gia đình & nhân khẩu | `RAW-011`, `012`, `022` | **Must-have** | R1 |
| `EPIC-01` (`US-03`) | Đăng ký và quản lý tạm trú / tạm vắng | `RAW-010` | **Must-have** | R1 |
| `EPIC-02` (`US-04`) | Tạo & quản lý danh mục khoản thu bắt buộc (theo $\text{m}^2$) và tự nguyện | `RAW-013`, `025` | **Must-have** | R1 |
| `EPIC-03` (`US-05`) | Tự động tính phí hàng tháng cho toàn tòa nhà & cộng dồn nợ cũ | `RAW-023`, `NFR-03` | **Must-have** | R2 |
| `EPIC-03` (`US-06`) | Ghi nhận nộp phí ($\le 3$ bước), tự lưu `timestamp` & DB Transaction | `RAW-025`, `026`, `NFR-010` | **Must-have** | R2 |
| `EPIC-03` (`US-07`) | Chốt sổ cuối tháng & xuất danh sách các hộ còn nợ phí | `RAW-024` | **Must-have** | R2 |
| `EPIC-04` (`US-08`) | Xuất báo cáo cử tri, sự kiện, tạm trú/tạm vắng & quỹ từ thiện | `RAW-027` $\rightarrow$ `030` | **Must-have** | R2 |
| `EPIC-01` (`US-09`) | Cư dân tự tra cứu & gửi yêu cầu cập nhật hộ gia đình/nhân khẩu | `RAW-001`, `002`, `004` | **Should-have** | R3 |
| `EPIC-03` (`US-10`) | Cư dân xem chi tiết từng khoản thu, số đã đóng & công nợ | `RAW-003`, `005`, `006` | **Should-have** | R3 |
| `EPIC-05` (`US-11`) | Đẩy thông báo điện tử, quản lý nội quy & xử lý Ticket phản ánh | `RAW-007`..`009`, `016`, `017` | **Should-have** | R3 |
| `EPIC-06` (`US-12`) | Tra cứu Audit Log, cảnh báo truy cập trái phép & Auto Backup/Restore | `RAW-015`, `020`, `021` | **Could-have** | R4 |
| `EPIC-07` (`US-13`) | Quản lý khách vãng lai, sự cố an ninh, phí gửi xe & thu hộ điện/nước | `RAW-018`, `019` | **Won't-have (v1.0)** | v2.0 |

### 5.2. Ma trận Truy vết Yêu cầu (Traceability Matrix – Đạt 100% độ phủ v1.0)

| Nhóm RAW ID | Epic | Feature / Use Case SRS | User Story & Tiêu chuẩn kiểm thử (AC / NFR) |
| :--- | :--- | :--- | :--- |
| `RAW-014` | `EPIC-06` | `UC001`: Đăng nhập & Tạo menu RBAC | `US-01` – Kiểm thử đăng nhập sai 5 lần khóa, băm `bcrypt`, menu đúng vai trò (`NFR-02`). |
| `RAW-011`, `012`, `022` | `EPIC-01` | `UC002`: Quản lý Căn hộ, Hộ gia đình & Nhân khẩu | `US-02` – Kiểm thử CRUD căn hộ/hộ dân, duy nhất CCCD, tìm kiếm $\le 2\text{s}$ (`NFR-01`). |
| `RAW-010` | `EPIC-01` | `UC002`: Quản lý Tạm trú / Tạm vắng | `US-03` – Kiểm thử ngày đến $\le$ ngày đi, lưu hồ sơ tạm trú chính xác. |
| `RAW-001`, `002`, `004` | `EPIC-01` | `UC003`: Cư dân tra cứu & Đề xuất cập nhật | `US-09` – Kiểm thử cư dân chỉ xem hộ mình (NĐ 13/2023) & luồng BQT duyệt cập nhật. |
| `RAW-013`, `025` | `EPIC-02` | `UC004`: Tạo danh mục khoản thu | `US-04` – Kiểm thử tạo khoản thu bắt buộc theo $\text{m}^2$ & đợt quyên góp tự nguyện. |
| `RAW-023`, `026` | `EPIC-03` | `UC005`: Tự động tính phí & Ghi nhận thu phí | `US-05`, `US-06` – Kiểm thử tính phí `DECIMAL` đúng 100% ($\le 30\text{s}$), nộp tiền $\le 3$ click, `DB Transaction`. |
| `RAW-024`, `003`, `005`, `006` | `EPIC-03` | `UC006`: Chốt sổ công nợ & Tra cứu phí cư dân | `US-07`, `US-10` – Kiểm thử chốt sổ, lọc chính xác danh sách nợ > 0 & chi tiết kỳ thu. |
| `RAW-027` $\rightarrow$ `030` | `EPIC-04` | `UC007`: Thống kê & Báo cáo Chính quyền | `US-08` – Kiểm thử lọc cử tri $\ge 18$ tuổi chính xác đến ngày bầu cử, xuất báo cáo $\le 10\text{s}$. |
| `RAW-007`..`009`, `016`, `017` | `EPIC-05` | `UC008`: Thông báo, Nội quy & Ticket phản ánh | `US-11` – Kiểm thử đẩy thông báo khi có phí mới / nộp thành công & luồng duyệt Ticket. |
| `RAW-015`, `020`, `021` | `EPIC-06` | Giám sát Audit Log & Auto Backup/Restore | `US-12` – Kiểm thử ghi nhận `Old/New Value` khi sửa/xóa & diễn tập Restore $\le 1\text{h}$ (`NFR-05`). |

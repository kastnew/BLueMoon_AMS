# BÀI 4.3: TÀI LIỆU QUẢN LÝ RỦI RO DỰ ÁN (PROJECT RISK MANAGEMENT PLAN)
*Học phần: Nhập môn Công nghệ Phần mềm – Khoa Khoa học và Kỹ thuật Máy tính (SoICT/HUST)*  
**Dự án:** Xây dựng phần mềm quản lý và thu phí ở chung cư Blue Moon (BlueMoon v1.0)

---

## 1. BẢNG MÔ TẢ VÀ PHÒNG NGỪA RỦI RO DỰ ÁN (BẢNG 4-1)

Bảng dưới đây nhận diện, đánh giá mức độ rủi ro và đề xuất hành động ngăn ngừa cụ thể cho dự án **Phần mềm quản lý và thu phí ở chung cư Blue Moon** theo đúng chuẩn mẫu của Bộ môn Công nghệ phần mềm (SoICT/HUST), kết hợp sát thực tế tập yêu cầu `RAW-001` $\rightarrow$ `RAW-030` và `NFR-01` $\rightarrow$ `NFR-05`:

### Bảng 4-1: Mô tả rủi ro dự án

| STT | Mô tả | Xác suất | Tác động | Mức độ rủi ro cho dự án | Hành động ngăn ngừa rủi ro |
| :---: | :--- | :---: | :---: | :---: | :--- |
| **1** | Nhân sự phải tham gia nhiều dự án / môn học cùng lúc hoặc rời dự án | Thấp (1) | Vừa (2) | **Mức 2 (Minor)** | - Chia đều các gói công việc quan trọng của 3 Module cho các thành viên.<br>- Chuẩn bị nhân sự dự phòng (cặp lập trình chéo Backup Member giữa các module).<br>- Chuẩn bị phương án phân chia lại khối lượng công việc cho các thành viên khi có người bận đột xuất.<br>- Đảm bảo mọi nhân sự trong dự án nắm được yêu cầu cụ thể về hiệu suất cá nhân và kiến trúc chung `UI – Service – DAO`. |
| **2** | Các bên liên quan (BQT, Cư dân) thay đổi yêu cầu hoặc bổ sung yêu cầu mới (như phí gửi xe, điện/nước, quản lý khách vãng lai `RAW-018`, sự cố an ninh `RAW-019`) sau khi dự án bắt đầu | Vừa (2) | Thấp (1) | **Mức 2 (Minor)** | - Có hợp đồng, Tuyên ngôn dự án và văn bản chấp thuận Product Backlog (phân loại ưu tiên MoSCoW) cụ thể của các bên liên quan.<br>- Quy hoạch rõ các tính năng gửi xe, điện/nước, an ninh vào lộ trình phiên bản **BlueMoon v2.0 (Won't-have ở v1.0)**.<br>- Xây dựng quy trình xử lý thay đổi (Change Request) chặt chẽ và đàm phán lại về thời gian hoàn thành nếu phát sinh yêu cầu mới. |
| **3** | Các tài liệu kỹ thuật (Đặc tả yêu cầu, Traceability Matrix) và tài liệu thiết kế kèm theo mã nguồn chưa hoàn thiện hoặc thiếu đồng bộ | Thấp (1) | Cao (3) | **Mức 3 (Vừa)** | - Theo dõi, kiểm tra sản phẩm giao nộp trung gian tại từng mốc (Mốc D+6, D+7, D+8 cho bộ tài liệu Elicitation và mốc thiết kế 25/10), xử lý kịp thời các vấn đề.<br>- Áp dụng Definition of Done (DoD): chỉ nghiệm thu tính năng khi đã cập nhật đầy đủ Traceability Matrix ($\ge 80\%$) và tài liệu API/thiết kế. |
| **4** | Thiếu sự tương tác, trao đổi đa chiều giữa nhóm phát triển với BQT, Thủ quỹ và Cư dân dẫn đến hiểu lầm nghiệp vụ tính phí hoặc bất đồng quan điểm (VD: cư dân muốn tự sửa nhân khẩu trực tiếp `RAW-002`, `RAW-004` trong khi BQT cần kiểm duyệt `RAW-009`, `RAW-017`) | Vừa (2) | Vừa (2) | **Mức 3 / 4 (Vừa)** | - Tổ chức các cuộc họp Workshop đồng bộ và Refinement Session giữa các bên liên quan để gỡ rối các vấn đề hiện tại, thống nhất luồng "Cư dân gửi yêu cầu cập nhật $\rightarrow$ BQT phê duyệt".<br>- Xây dựng bản mẫu giao diện (Prototype) và gợi ý về tình huống sử dụng giả định (*Visionary Scenario*) cho khách hàng xem sớm.<br>- Thiết lập thêm kênh trao đổi trực tiếp giữa khách hàng với nhóm phát triển (qua Zalo, điện thoại, họp đánh giá mỗi mốc). |
| **5** | Sự chậm trễ trong các giai đoạn dự án trước đó (chậm thu thập yêu cầu thô hoặc chậm thiết kế CSDL ảnh hưởng đến các Sprint lập trình) | Thấp (1) | Vừa (2) | **Mức 2 (Minor)** | - Sắp xếp công việc theo thứ tự trước sau (WBS) và thứ tự ưu tiên MoSCoW (*Must-have* làm trước ở Sprint 1–2).<br>- Tổ chức hội thảo công bố kế hoạch dự án, biểu đồ Gantt và cấu trúc phân chia công việc rõ ràng ngay từ tuần đầu tiên. |
| **6** | Hành động pháp lý trì hoãn hoặc tạm dừng dự án; hoặc vi phạm quy định bảo vệ dữ liệu cá nhân cư dân và quỹ từ thiện (`RAW-029`, Nghị định 13/2023/NĐ-CP – `NFR-02`) | Thấp (1) | Vừa (2) | **Mức 2 (Minor)** | - Kiểm tra kỹ các điều khoản hợp đồng và quy định pháp lý (Nghị định 13/2023/NĐ-CP, quy định quản lý cư trú/bầu cử của Chính quyền) trước khi thiết kế.<br>- Áp dụng phân quyền RBAC chặt chẽ, mã hóa mật khẩu `bcrypt` và kết nối `TLS/HTTPS`; báo cáo cấp trên/nhà tài trợ ngay khi có vướng mắc pháp lý. |
| **7** | Khách hàng (BQT, Thủ quỹ, Cư dân) từ chối nghiệm thu sản phẩm tại mốc UAT 1 (30/11) hoặc UAT 2 (15/12) do sai lệch số liệu tính phí hoặc giao diện khó dùng cho người lớn tuổi | Thấp (1) | Vừa (2) | **Mức 2 (Minor)** | - Kiểm tra kỹ các điều khoản về bàn giao sản phẩm trước khi ký hợp đồng.<br>- Thiết lập và thỏa thuận với khách hàng về các tiêu chí nghiệm thu sản phẩm một cách định lượng ngay từ đầu (Acceptance Criteria theo chuẩn Given-When-Then, tính phí đúng 100% với kiểu `DECIMAL`, nộp phí $\le 3$ bước, điểm SUS $\ge 70$).<br>- Kiểm thử kỹ với dữ liệu mẫu 500 – 1.000 hộ dân sát với thực tế của chung cư BlueMoon trước khi bàn giao UAT. |
| **8** | Cắt giảm ngân sách bất ngờ hoặc phát sinh chi phí vượt dự kiến | Thấp (1) | Thấp (1) | **Mức 1 (Trivial)** | - Phân bổ sẵn khoản ngân sách dự phòng (trong tổng ngân sách 100.000.000 đồng) và ưu tiên sử dụng các công nghệ/hệ quản trị CSDL mã nguồn mở ổn định (Java LTS, MySQL, Git). |
| **9** | Ước tính thời gian và chi phí quá lạc quan (đặc biệt ở các tính năng phức tạp như tự động tính phí diện tích + cộng dồn nợ kỳ trước `RAW-023` và trích xuất báo cáo cử tri/hành chính `RAW-027`..`030`) | Vừa (2) | Vừa (2) | **Mức 3 / 4 (Vừa)** | - Cần phải họp kỹ (Sprint Planning & Estimation), tham khảo ý kiến nhiều bên (Tech Lead, BA, Thủ quỹ) để đưa ra ước tính thời gian và chi phí phù hợp.<br>- Dành khoảng thời gian đệm (Buffer time) 15 ngày giữa mốc UAT 1 (30/11/2026) và UAT 2 (15/12/2026) để kịp thời hiệu chỉnh. |
| **10** | Sai số làm tròn tiền tệ, lỗi gián đoạn khi ghi nhận nộp tiền hoặc mất dữ liệu lịch sử thanh toán 5 năm khi máy tính gặp sự cố (`RAW-020`, `RAW-026`, `NFR-03`, `NFR-05`) | Vừa (2) | Cao (3) | **Mức 4 (Đáng kể)** | - Bắt buộc dùng kiểu dữ liệu `DECIMAL` cho mọi trường tiền tệ và sử dụng `DB Transaction` (tự động Rollback nếu lỗi) khi ghi nhận thu phí.<br>- Lưu vết toàn bộ thao tác sửa/xóa vào bảng `Audit Log` (`RAW-015`).<br>- Thiết lập cơ chế tự động sao lưu (Auto Backup) CSDL MySQL hàng ngày và diễn tập phục hồi dữ liệu (Restore) đảm bảo thời gian khôi phục $\le 1\text{ – }2$ giờ (`NFR-007`, `NFR-008`). |
| **11** | Dữ liệu hiện trạng từ sổ giấy và file Excel cũ của BQT không đồng nhất (trùng số CCCD, thiếu ngày sinh cử tri, lệch số dư nợ cũ) gây khó khăn khi chuyển đổi sang phần mềm mới (*As-Is Scenario*) | Vừa (2) | Vừa (2) | **Mức 3 (Vừa)** | - Phân tích kỹ cấu trúc file Excel và sổ hộ khẩu hiện tại ngay trong giai đoạn Elicitation.<br>- Xây dựng biểu mẫu Excel chuẩn hóa kèm công cụ kiểm tra dữ liệu đầu vào (kiểm tra trùng CCCD, định dạng ngày sinh, diện tích > 0) để hỗ trợ BQT làm sạch dữ liệu. |
| **12** | Quá tải hoặc chậm hiệu năng vào kỳ cao điểm thu phí đầu/cuối tháng ($\ge 200$ người dùng đồng thời; tạo kỳ thu phí toàn tòa nhà hoặc xuất báo cáo 5 năm bị chậm – `NFR-01`) | Thấp (1) | Cao (3) | **Mức 3 (Vừa)** | - Đánh chỉ mục (Index) cho các trường tìm kiếm chính (Mã căn hộ, Mã hộ, CCCD, Kỳ thu, Ngày sinh) và xử lý tính phí hàng loạt theo lô (Batch Processing) để đảm bảo thời gian tính phí toàn tòa nhà $\le 30\text{ – }60$ giây và phản hồi tra cứu $\le 2$ giây. |

---

## 2. PHƯƠNG PHÁP ĐÁNH GIÁ XÁC SUẤT VÀ TÁC ĐỘNG RỦI RO (BẢNG 4-2 & BẢNG 4-3)

Trong đó, xác suất rủi ro được đánh giá theo 3 mức như sau:

### Bảng 4-2: Đánh giá xác suất rủi ro dự án

| Xác suất | Giải thích |
| :---: | :--- |
| **Thấp (1)** *(Xanh)* | Rất hiếm khi xảy ra hoặc được cho là sẽ không xảy ra. |
| **Vừa (2)** *(Vàng)* | Đã xảy ra thỉnh thoảng hoặc có lý do hợp lý nhưng không hoàn toàn cơ hội dự kiến xảy ra trong tương lai. |
| **Cao (3)** *(Đỏ)* | Cho thấy dấu hiệu rủi ro cao, đã xảy ra thường xuyên, có ảnh hưởng rất lớn cơ hội xảy ra trong tương lai. |

---

Tác động của rủi ro được đánh giá theo 3 mức như dưới đây:

### Bảng 4-3: Đánh giá tác động rủi ro dự án

| Tác động | Về phạm vi | Về chất lượng | Về chi phí |
| :---: | :--- | :--- | :--- |
| **Thấp (1)** *(Xanh)* | $< 5\%$ quy mô dự án bị ảnh hưởng<br>Hoặc Các khu vực nhỏ trong phạm vi dự án bị ảnh hưởng. | Hiệu suất chất lượng giảm $< 5\%$ Mục tiêu. | $< 5\%$ nỗ lực dự án / tăng chi phí. |
| **Vừa (2)** *(Vàng)* | $5\% - 10\%$ quy mô dự án bị ảnh hưởng. | Giảm chất lượng yêu cầu sự chấp thuận của nhà tài trợ<br>Hoặc Hiệu suất chất lượng giảm $5\% - 10\%$ Mục tiêu. | Giảm chất lượng yêu cầu sự chấp thuận của nhà tài trợ Hoặc Hiệu suất chất lượng giảm $5\% - 10\%$ Mục tiêu. |
| **Cao (3)** *(Đỏ)* | $> 10\%$ quy mô dự án bị ảnh hưởng. | Giảm chất lượng không thể chấp nhận để tài trợ<br>Hoặc Hiệu suất chất lượng giảm $> 10\%$ Mục tiêu. | $> 10\%$ nỗ lực dự án / tăng chi phí. |

---

## 3. SẮP XẾP THỨ TỰ ƯU TIÊN VÀ MA TRẬN XÁC SUẤT – TÁC ĐỘNG

**Sắp xếp các rủi ro theo thứ tự ưu tiên:** Sau khi ước lượng xác suất và tác động, các rủi ro được sắp xếp thứ tự ưu tiên theo mức độ ảnh hưởng của chúng đến các mục tiêu của dự án.

Như được mô tả trong bảng ma trận xác suất và tác động bên dưới, sự kết hợp giữa xác suất và tác động dẫn đến rủi ro được xếp thành **5 mức từ 1 – 5**, trong đó **Mức 5** là nghiêm trọng nhất:
- **Mức 5 (Đỏ):** Không thể tiếp tục thực hiện dự án.
- **Mức 4 (Cam):** Tác động đáng kể đến dự án, một số công việc của dự án không thực hiện được.
- **Mức 3 (Vàng):** Tác động đến dự án, nhưng dự án vẫn thực hiện được.
- **Mức 2 (Xanh lá):** Không ảnh hưởng đáng kể đến dự án.
- **Mức 1 (Xanh lá):** Hầu như không ảnh hưởng hoặc ảnh hưởng không rõ ràng.

### Bảng Ma trận Xác suất và Ảnh hưởng

| Xác suất \ Ảnh hưởng | Thấp (1) | Vừa (2) | Cao (3) |
| :---: | :---: | :---: | :---: |
| **Thấp (1)** | 🟢 **Mức 1** *(RR số 8)* | 🟢 **Mức 2** *(RR số 1, 5, 6, 7)* | 🟡 **Mức 3** *(RR số 3, 12)* |
| **Vừa (2)** | 🟢 **Mức 2** *(RR số 2)* | 🟡 **Mức 3 / 4** *(RR số 4, 9, 11)* | 🟠 **Mức 4** *(RR số 10)* |
| **Cao (3)** | 🟡 **Mức 3** | 🟠 **Mức 4** | 🔴 **Mức 5** |

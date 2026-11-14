-- ============================================================================
-- HỆ THỐNG QUẢN LÝ VÀ THU PHÍ CHUNG CƯ BLUEMOON (BLUEMOON AMS v1.0)
-- Cơ sở dữ liệu: MySQL 8.x | Encoding: utf8mb4
-- Tuân thủ NFR-02 (Bảo mật), NFR-03 (DECIMAL & Audit Trail), NFR-014 (5 năm)
-- ============================================================================

CREATE DATABASE IF NOT EXISTS bluemoon_ams
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE bluemoon_ams;

-- 1. Bảng Vai trò (RBAC)
CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_code VARCHAR(30) NOT NULL UNIQUE, -- ADMIN_BQT, THU_QUY, CU_DAN
    role_name VARCHAR(100) NOT NULL
);

-- 2. Bảng Căn hộ
CREATE TABLE apartments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    apartment_code VARCHAR(20) NOT NULL UNIQUE, -- VD: B1205
    floor_number INT NOT NULL,
    area_m2 DECIMAL(10, 2) NOT NULL CHECK (area_m2 > 0),
    status VARCHAR(30) NOT NULL DEFAULT 'OCCUPIED', -- OCCUPIED, VACANT
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

-- 3. Bảng Hộ gia đình (Hộ khẩu)
CREATE TABLE households (
    id INT AUTO_INCREMENT PRIMARY KEY,
    household_code VARCHAR(30) NOT NULL UNIQUE,
    apartment_id INT NOT NULL,
    head_of_household VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20),
    move_in_date DATE,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (apartment_id) REFERENCES apartments(id)
);

-- 4. Bảng Người dùng (Tài khoản & Khóa sai 5 lần)
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL, -- BCrypt hash
    full_name VARCHAR(100) NOT NULL,
    role_id INT NOT NULL,
    household_id INT NULL, -- NULL đối với BQT / Thủ quỹ
    failed_attempts INT NOT NULL DEFAULT 0,
    is_locked BOOLEAN NOT NULL DEFAULT FALSE,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (household_id) REFERENCES households(id)
);

-- 5. Bảng Nhân khẩu
CREATE TABLE residents (
    id INT AUTO_INCREMENT PRIMARY KEY,
    household_id INT NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    cccd VARCHAR(20) UNIQUE,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    relationship_to_head VARCHAR(50) NOT NULL,
    residence_status VARCHAR(30) NOT NULL DEFAULT 'THUONG_TRU', -- THUONG_TRU, TAM_TRU, TAM_VANG
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (household_id) REFERENCES households(id)
);

-- 6. Bảng Đăng ký Tạm trú / Tạm vắng
CREATE TABLE temporary_residences (
    id INT AUTO_INCREMENT PRIMARY KEY,
    resident_id INT NOT NULL,
    type VARCHAR(20) NOT NULL, -- TAM_TRU, TAM_VANG
    from_date DATE NOT NULL,
    to_date DATE NOT NULL,
    reason VARCHAR(255),
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    FOREIGN KEY (resident_id) REFERENCES residents(id)
);

-- 7. Bảng Danh mục Khoản thu (Bắt buộc theo m2 / Cố định / Tự nguyện)
CREATE TABLE fee_categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fee_name VARCHAR(150) NOT NULL,
    fee_type VARCHAR(30) NOT NULL, -- BAT_BUOC_M2, BAT_BUOC_CO_DINH, TU_NGUYEN
    unit_price DECIMAL(15, 2) NOT NULL DEFAULT 0.00, -- Bắt buộc DECIMAL
    due_date DATE,
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

-- 8. Bảng Hóa đơn theo Kỳ thu phí (Tháng/Năm)
CREATE TABLE invoices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    household_id INT NOT NULL,
    fee_category_id INT NOT NULL,
    billing_period VARCHAR(7) NOT NULL, -- Định dạng YYYY-MM
    total_amount DECIMAL(15, 2) NOT NULL,
    paid_amount DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    status VARCHAR(20) NOT NULL DEFAULT 'UNPAID', -- UNPAID, PARTIAL, PAID
    is_closed BOOLEAN NOT NULL DEFAULT FALSE, -- Chốt sổ cuối kỳ
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (household_id) REFERENCES households(id),
    FOREIGN KEY (fee_category_id) REFERENCES fee_categories(id)
);

-- 9. Bảng Giao dịch Nộp tiền (Lưu timestamp tự động phục vụ đối soát)
CREATE TABLE payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_id INT NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    payment_method VARCHAR(30) NOT NULL DEFAULT 'CASH', -- CASH, BANK_TRANSFER
    collected_by INT NOT NULL,
    paid_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    note VARCHAR(255),
    FOREIGN KEY (invoice_id) REFERENCES invoices(id),
    FOREIGN KEY (collected_by) REFERENCES users(id)
);

-- 10. Bảng Thông báo Điện tử & Nội quy
CREATE TABLE notifications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    noti_type VARCHAR(30) NOT NULL, -- PHI_MOI, XAC_NHAN_NOP, NOI_QUY, CANH_BAO
    target_user_id INT NULL, -- NULL = Gửi toàn chung cư
    is_read BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (target_user_id) REFERENCES users(id)
);

-- 11. Bảng Ticket Phản ánh & Yêu cầu Cập nhật (Maker-Checker)
CREATE TABLE tickets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    household_id INT NOT NULL,
    created_by INT NOT NULL,
    ticket_type VARCHAR(30) NOT NULL, -- CAP_NHAT_NHAN_KHAU, TAM_TRU, PHAN_ANH_PHI
    title VARCHAR(200) NOT NULL,
    payload_json TEXT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING', -- PENDING, APPROVED, REJECTED, RESOLVED
    reviewed_by INT NULL,
    review_note VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (household_id) REFERENCES households(id),
    FOREIGN KEY (created_by) REFERENCES users(id),
    FOREIGN KEY (reviewed_by) REFERENCES users(id)
);

-- 12. Bảng Nhật ký Kiểm toán (Audit Log - NFR-03, NFR-015)
CREATE TABLE audit_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NULL,
    action VARCHAR(30) NOT NULL, -- CREATE, UPDATE, DELETE, LOGIN_FAIL, LOCK_ACCOUNT
    table_name VARCHAR(50) NOT NULL,
    record_id VARCHAR(50),
    old_value TEXT,
    new_value TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Chỉ mục tối ưu hiệu năng tra cứu <= 2s (NFR-01)
CREATE INDEX idx_apt_code ON apartments(apartment_code);
CREATE INDEX idx_res_cccd ON residents(cccd);
CREATE INDEX idx_res_dob ON residents(date_of_birth);
CREATE INDEX idx_inv_period ON invoices(billing_period, status);
CREATE INDEX idx_audit_time ON audit_logs(created_at);

-- Dữ liệu vai trò mặc định
INSERT INTO roles (role_code, role_name) VALUES
('ADMIN_BQT', 'Ban Quản trị Chung cư'),
('THU_QUY', 'Thủ quỹ / Kế toán'),
('CU_DAN', 'Cư dân / Chủ hộ');

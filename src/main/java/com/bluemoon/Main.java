package com.bluemoon;

import com.bluemoon.ui.LoginFrame;

/**
 * Điểm khởi chạy chính của Hệ thống Quản lý và Thu phí Chung cư BlueMoon (v1.0).
 * Kiến trúc phân tầng: UI -> Service -> DAO (MySQL).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Đang khởi động Hệ thống Quản lý Chung cư BlueMoon AMS v1.0...");
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.show();
    }
}

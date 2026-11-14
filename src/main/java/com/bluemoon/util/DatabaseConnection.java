package com.bluemoon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Tiện ích quản lý kết nối Cơ sở dữ liệu MySQL (NFR-02, NFR-05).
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bluemoon_ams?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Cấu hình qua biến môi trường hoặc file local.properties

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

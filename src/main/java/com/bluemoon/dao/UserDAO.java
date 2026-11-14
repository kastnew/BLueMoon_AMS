package com.bluemoon.dao;

import com.bluemoon.model.User;
import com.bluemoon.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Tầng DAO xử lý truy vấn Người dùng và Phân quyền RBAC.
 */
public class UserDAO {
    public User findByUsername(String username) throws SQLException {
        // TODO: Thực thi SELECT kết hợp bảng roles bằng PreparedStatement
        return null;
    }

    public void updateFailedAttempts(int userId, int attempts, boolean lockAccount) throws SQLException {
        String sql = "UPDATE users SET failed_attempts = ?, is_locked = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, attempts);
            ps.setBoolean(2, lockAccount);
            ps.setInt(3, userId);
            ps.executeUpdate();
        }
    }
}

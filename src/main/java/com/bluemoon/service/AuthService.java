package com.bluemoon.service;

import com.bluemoon.dao.UserDAO;
import com.bluemoon.model.User;
import com.bluemoon.util.PasswordHasher;

/**
 * Tầng Service xử lý Đăng nhập, Khóa sai 5 lần và Phân quyền RBAC (UC001).
 */
public class AuthService {
    private static final int MAX_FAILED_ATTEMPTS = 5;
    private final UserDAO userDAO = new UserDAO();

    public User login(String username, String plainPassword) throws Exception {
        if (username == null || username.isBlank() || plainPassword == null || plainPassword.isBlank()) {
            throw new IllegalArgumentException("Vui lòng nhập đầy đủ Tên đăng nhập và Mật khẩu.");
        }
        User user = userDAO.findByUsername(username.trim());
        if (user == null) {
            throw new SecurityException("Tên đăng nhập hoặc mật khẩu chưa đúng.");
        }
        if (user.isLocked()) {
            throw new SecurityException("Tài khoản đã bị khóa do nhập sai quá 5 lần hoặc bị BQT vô hiệu hóa.");
        }
        if (!PasswordHasher.verify(plainPassword, user.getPasswordHash())) {
            int nextAttempts = user.getFailedAttempts() + 1;
            boolean shouldLock = nextAttempts >= MAX_FAILED_ATTEMPTS;
            userDAO.updateFailedAttempts(user.getId(), nextAttempts, shouldLock);
            throw new SecurityException("Tên đăng nhập hoặc mật khẩu chưa đúng.");
        }
        userDAO.updateFailedAttempts(user.getId(), 0, false);
        return user;
    }
}

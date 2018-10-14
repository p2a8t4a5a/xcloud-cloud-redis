package com.xuan.erp.auth;

import com.xuan.erp.model.User;

public interface AuthService {
	User register(User user);
    String login(String username, String password);
    String refresh(String token);
}

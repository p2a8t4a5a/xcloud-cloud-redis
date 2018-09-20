package com.matech.erp.auth;

import com.matech.erp.model.User;

public interface AuthService {
	User register(User user);
    String login(String username, String password);
    String refresh(String token);
}

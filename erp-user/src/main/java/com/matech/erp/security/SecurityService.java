package com.matech.erp.security;

public interface SecurityService {
	
	/**
	 * 
	 * @return
	 */
    String findLoggedInUsername();

    /**
     * 登录系统
     * 
     * @param username 用户名
     * @param password 密码
     */
    void login(String username, String password);
}

package com.matech.erp.test;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPasswordEncoder {

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encode = passwordEncoder.encode("123456");
		System.out.println("加密后的密码:" + encode);
		System.out.println("bcrypt密码对比:" + passwordEncoder.matches("password", encode));
		String md5Password = "{MD5}88e2d8cd1e92fd5544c8621508cd706b";// MD5加密前的密码为:password
		System.out.println("MD5密码对比:" + passwordEncoder.matches("password", encode));
	}

}

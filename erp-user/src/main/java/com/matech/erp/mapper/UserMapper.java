package com.matech.erp.mapper;

import java.util.List;

import com.matech.erp.model.Role;
import com.matech.erp.model.User;
import com.matech.erp.mybatis.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
	
	User getUserByName(String username);
	
	List<Role> getUserRoles(String userid);
}
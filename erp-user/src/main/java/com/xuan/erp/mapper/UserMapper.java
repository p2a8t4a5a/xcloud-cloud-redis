package com.xuan.erp.mapper;

import java.util.List;

import com.xuan.erp.model.Role;
import com.xuan.erp.model.User;
import com.xuan.erp.mybatis.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
	
	User getUserByName(String username);
	
	List<Role> getUserRoles(String userid);
}
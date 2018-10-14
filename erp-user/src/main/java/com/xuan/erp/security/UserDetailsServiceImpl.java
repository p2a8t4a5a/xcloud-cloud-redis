package com.xuan.erp.security;

import com.xuan.erp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xuan.erp.model.Role;
import com.xuan.erp.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
	@Autowired
    UserMapper userDao;
	
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	// 根据用户名查找用户
        User user = userDao.getUserByName(username);
        if (user == null) 
        	return null;
        
        // 获取用户权限
        List<Role> roles = userDao.getUserRoles(user.getId().toString());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));            
        }
                
        // 返回Spring的User对象
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), grantedAuthorities);
    }
}

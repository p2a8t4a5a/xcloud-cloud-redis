package com.xuan.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RestController;

import com.xuan.erp.mapper.UserMapper;
import com.xuan.erp.model.User;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/hello")
public class HelloController {

	private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	UserMapper userDao;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	//@Resource
	//private SessionFactory sessionFactory;

	@RequestMapping("/index")
	public String index() {
		logger.info("Hello controller index.");
		ValueOperations<String, String> cache = stringRedisTemplate.opsForValue();
		String value = cache.get("key1");
		return "Spring Boot cache:" + value;
	}

	@RequestMapping("/cache")
	public String cache() {
		try {
			User user = userDao.getUserByName("lwx");
			System.out.println(user.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
		valueOperations.set("key1", "random1=" + Math.random());		
		System.out.println(valueOperations.get("key1"));
		return "cache set key1.";
	}

	@RequestMapping("/cache2")
	public String cache2() {
		try {
			return "hello jrebel 2";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "test jrebel";
	}

	/*
	@RequestMapping("test")
	public void test(HttpServletResponse response){
		Session session = sessionFactory.getCurrentSession();
		NativeQuery sqlQuery = session.createNativeQuery("select * from sys_user");
		List list = sqlQuery.list();
		System.out.printf(list.size()+"");
		try {
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"msg\":\"调用成功\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
}

package com.xuan.erp.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xuan.erp.mapper.UserMapper;

@Controller
@RequestMapping("/jsp")
public class JspController {

	private final static Logger logger = LoggerFactory.getLogger(JspController.class);

	@Autowired
	UserMapper userDao;

	@RequestMapping(value = {"/","/index"})
    public String index(Map<String, Object> model){
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.jsp
        model.put("time", new Date());
        model.put("message", "test");
        return "index";
    }	
}
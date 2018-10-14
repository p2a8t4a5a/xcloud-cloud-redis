package com.xuan.erp;

import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class RestTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void get() throws Exception {
        Map<String,String> multiValueMap = new HashMap<>();
        multiValueMap.put("username","lake");//传值，但要在url上配置相应的参数
        String result = testRestTemplate.getForObject("/hello/index?username={username}",String.class,multiValueMap);
        Assert.assertEquals(result,"hello");
    }

}

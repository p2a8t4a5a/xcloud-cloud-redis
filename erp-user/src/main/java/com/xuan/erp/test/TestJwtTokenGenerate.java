package com.xuan.erp.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TestJwtTokenGenerate {
	
	public static void main(String[] args) {
		
		Map<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("type", "1");
		String payload = "{\"user_id\":\"1341137\", \"expire_time\":\"2018-01-01 0:00:00\"}";
		String compactJws = Jwts.builder().setHeader(stringObjectMap)
		.setPayload(payload).signWith(SignatureAlgorithm.HS256, "test").compact();

		//System.out.println("jwt key:" + new String(KEY.getEncoded()));
		System.out.println("jwt payload:" + payload);
		System.out.println("jwt encoded:" + compactJws);

		
	    Map<String,Object> claims = new HashMap<>();
	    claims.put("username","wang");
	    claims.put("userid",12);
	    
	      String SecretKey = "secretkey";
	        //获取当前的时间
	        Calendar calendar = Calendar.getInstance();
	        Date date = new Date(System.currentTimeMillis());
	        calendar.setTime(date);
	        //向后退后的秒数
	        Date endTime = calendar.getTime();
	        String issuer = "JWT_ISSUER";
	        String aud = "JWT_AUD";
	        JwtBuilder builder = Jwts.builder().setClaims(claims)
	                .signWith(SignatureAlgorithm.HS256,SecretKey)
	                .setClaims(claims)
	                .setSubject((String)claims.get("username"))
	                .setIssuedAt(new Date())
	                .setExpiration(endTime)
	                .setIssuer(issuer)
	                .setAudience(aud);
	        String token  = builder.compact();
	        System.out.println(token);
	    
	}

}

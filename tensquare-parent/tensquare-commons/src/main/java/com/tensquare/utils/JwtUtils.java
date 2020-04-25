package com.tensquare.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@ConfigurationProperties("jwt.config")
public class JwtUtils {
	private String key;
	
	private String ttl;
	
	
	public String createJwt(String id,String subject) {
		//创建当前的毫秒数
//		long currentTimeMillis = System.currentTimeMillis();
		JwtBuilder signWith = Jwts.builder().setId(id)//
		.setSubject(subject)//
		.setIssuedAt(new Date())
		.signWith(SignatureAlgorithm.ES256,key);
		
		System.out.println(signWith.compact());
		//生成的tocker return 出去
		return signWith.compact();
	}
	
	public Claims parseJwt(String tocker) {
		Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(tocker).getBody();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD  HH:mm:ss");
		Date issuedAt = body.getIssuedAt();
		System.out.println(simpleDateFormat.format(issuedAt));
		return body;
	}
}

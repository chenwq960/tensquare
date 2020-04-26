package com.test;
import java.util.Date;

import javax.swing.Spring;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SpringBootTest
public class CreateJwT {
	@Test
	public void Te(){
		Spring key;
		long nowMinllis = System.currentTimeMillis();
		System.out.println(nowMinllis+"------------------");
		Date now = new Date();
		System.out.println(now);
		JwtBuilder jwtBuilder = Jwts.builder().setId("111")//  token的唯一表示
			.setSubject("杨元庆")//	  jwt的主题
			.setIssuedAt(new Date())//  jwt签发时间
//			.setExpiration(new Date(exp)) //设置令牌的失效时间
			
			//登录成功之后返回的toker
			.claim("role","admin")			//登录成功之后，还需要从数据获取用户的角色，和授权的信息
			.claim("logo", "http:www.baidu.com")		//登录成功之后返回前台数据，的一个封装
            .signWith(SignatureAlgorithm.HS512, "bawei");//使用的算法，   参数加的👁盐
			
		
		  String compact = jwtBuilder.compact();//生成一个令牌
	      System.out.println(compact);


	}

}

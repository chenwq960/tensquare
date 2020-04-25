package com.test;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@SpringBootTest
public class GreateModel {
	@Test
	public void model() {
	        String token="eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxMTEiLCJzdWIiOiLmnajlhYPluoYiLCJpYXQiOjE1ODc3OTc2NTYsInJvbGUiOiJhZG1pbiIsImxvZ28iOiJodHRwOnd3dy5iYWlkdS5jb20ifQ.xOKQueNpagJzMWyjIDfUWu4I36O0ZWN_NKs62RHEHJd0BY-6G4DoZ9GWKhBQo0fqFB_fpMBqvYJCNQwTTIu1MQ";
	        Claims _claim = Jwts.parser().setSigningKey("bawei").parseClaimsJws(token).getBody();
	        System.out.println(_claim);
//	        System.out.println(_claim.getId());
//	        System.out.println(_claim.getId());
	        System.out.println(_claim.get("logo"));
	        System.out.println(_claim.get("role"));
	        System.out.println(_claim.getIssuer());
	        System.out.println(_claim.getSubject());
	        
	        SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-DD HH:ss:mm");
	        System.out.println(date.format(_claim.getIssuedAt()));

	}
	
}

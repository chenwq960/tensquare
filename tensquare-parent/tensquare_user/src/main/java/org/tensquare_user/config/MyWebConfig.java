package org.tensquare_user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MyWebConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll()// 所有路径都放行
				.antMatchers("/**").permitAll() // 所有路径放行
				.anyRequest().authenticated() // 给予所有权限
				.and().csrf().disable(); // 浏览器 csrf 防范失效

		// TODO Auto-generated method stub
		super.configure(http);
	}
}

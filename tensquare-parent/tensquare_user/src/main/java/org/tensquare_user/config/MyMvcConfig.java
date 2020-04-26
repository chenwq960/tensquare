package org.tensquare_user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.tensquare_user.intercepotor.MyHandlerInterceptor;

@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport{
	@Autowired
	private MyHandlerInterceptor myHandlerInterceptor;
	
	//自定义拦截器
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myHandlerInterceptor)//
			.addPathPatterns("/**") //所有请求都要经过拦截器
			.excludePathPatterns("/user/login");//不拦截的请求
		super.addInterceptors(registry);
	}
}

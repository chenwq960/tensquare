package org.tensquare_user.intercepotor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tensquare.utils.JwtUtils;

import io.jsonwebtoken.Claims;

//加入jwt 工具类
@Component
public class MyHandlerInterceptor implements HandlerInterceptor{
	@Resource
	private JwtUtils jwtUtils;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取tocken
			//获取http中的头部信息
		String header = request.getHeader("Authorization").substring(7);
		System.out.println(header+"--------------头部信息");
		//判断 是否又token令牌
		if(header==null && !("".equals(header))) {
			System.out.println("令牌错误---------------");
			//return false;
			
		}
		
		//比较 token 是否一致
		Claims claims = jwtUtils.parseJwt(header);
		System.out.println(claims+"-----令牌内容");
		
		//角色信息
		String role = claims.get("role").toString();
		//根据角色信息request 设置相关的属性
		request.setAttribute("admin_claims",role);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}

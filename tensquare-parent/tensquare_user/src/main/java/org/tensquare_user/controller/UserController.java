package org.tensquare_user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tensquare_user.pojo.User;
import org.tensquare_user.service.UserService;

import com.tensquare.entity.HpptCode;
import com.tensquare.entity.Result;
import com.tensquare.utils.JwtUtils;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private JwtUtils jwtUtils;
	@Resource
	private UserService userService;
	
	/**
	 * 注册验证码
	 * @param tel
	 * @return
	 */
	@GetMapping("/send/{tel}")
	public Result sendMessage(@PathVariable String tel) {
		userService.sendMessage(tel);
		return new Result(true,HpptCode.OK,"注册成功");
	}
	
	/**
	 * 注册的具体逻辑方法
	 * @param user
	 * @return
	 */
	@PostMapping("/select/list")
	public Result selectList(@RequestBody User user) {
		//SearchParam searchParam = new SearchParam();
		int count = userService.save(user);
		if(count > 0) {
			return new Result(true,HpptCode.OK,"注册成功");
		}else {
			return new Result(false,HpptCode.IDERROR,"注册失败");
		}
	}
	
	/**
	 *  登录逻辑  并且比较验证码
	 * @return 
	 */
	@GetMapping("/login")
	public Result login(@RequestBody User user) {
			User login = userService.login(user);
			//登录成功 之后生成令牌
			System.out.println(login.getId());
			System.out.println(login.getLoginname());
			String tocker = jwtUtils.createJwt(login.getId(),login.getLoginname(),"user");
			System.out.println(tocker+"------------");
			return new Result(true,HpptCode.OK,tocker);
	}
	/*
	 *删除逻辑
	 */
	@Resource
	private HttpServletRequest request;
	
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable String id) {
		
		String attribute = (String) request.getAttribute("admin_claims");
		if(attribute.equals("user")) {
			try {
				userService.delte(id);
				return new Result(true,HpptCode.OK,"删除成功");
			} catch (Exception e) {
				return new Result(true,HpptCode.GRAMMARERROR,"删除失败");
			}
		}else {
			System.out.println("没有删除权限");
			return new Result(true,HpptCode.GRAMMARERROR,"删除失败");
		}
		
		
	}
	
}

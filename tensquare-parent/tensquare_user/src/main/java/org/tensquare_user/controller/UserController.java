package org.tensquare_user.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tensquare_user.form.SearchParam;
import org.tensquare_user.pojo.User;
import org.tensquare_user.service.UserService;

import com.tensquare.entity.HpptCode;
import com.tensquare.entity.Result;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@GetMapping("/send/{tel}")
	public Result sendMessage(@PathVariable String tel) {
		userService.sendMessage(tel);
		return new Result(true,HpptCode.OK,"注册成功");
	}
	
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
	 * 登录逻辑
	 */
	@GetMapping("/login")
	public void login(@RequestBody User user) {
		int count = userService.login(user);
	}
}

package com.edu.spring.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @GetMapping、@PostMapping 是spring4.3中的新特性
 *
 */
@Controller
public class UserController {

	@RequestMapping(value = "/user/home", method=RequestMethod.GET)
	@ResponseBody
	public String home(){
		return "user home";
	}
	
	@ResponseBody
	@GetMapping("/user/show")
	public String show(){
		return "user show";
	}
	
	/**
	 * 注入servlet的api 
	 */
	@ResponseBody
	@GetMapping("/user/ip")
	public String edit(HttpServletRequest req){
		return "user edit " + req.getRemoteHost();
	}
	
	/**
	 *  获取url的参数 /user/1, /user/2
	 */
	@ResponseBody
	@GetMapping("/user/{id}")
	public String display(@PathVariable("id") String id){
		return "user display id= " + id;
	}
	
	/**
	 * @RequestParam 注解默认是参数必须提供值
	 * defaultValue 设置默认值
	 */
	@ResponseBody
	@PostMapping("/user/create")
	public String create(@RequestParam(value="username",defaultValue="admin") String username, @RequestParam(value="password", required=false) String password){
		return "user create, username = " + username + ", passowrd = " + password;
	}
}

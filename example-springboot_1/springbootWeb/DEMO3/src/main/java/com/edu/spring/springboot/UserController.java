package com.edu.spring.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user/home")
	public String home(){
		System.out.println("----user home----");
		return "user home";
	}
	
	@GetMapping("/user/help")
	public String help(){
		throw new IllegalArgumentException("args is empty");
	}
	
	@GetMapping("/user/null")
	public String empty(){
		throw new NullPointerException("args is empty");
	}
}

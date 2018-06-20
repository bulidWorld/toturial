package com.edu.spring.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 在spring boot中使用freemarker的步骤
 * 1：在pom.xml里面加入如下依赖
 * <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-freemarker</artifactId>
		</dependency>
	2：默认的 freemarker的模板文件在classpath:/templates/ ，默认的文件扩展名为：.ftl
	spring.freemarker.templateLoaderPath 用于配置模板的路径，多个用逗号隔开
 *
 */
@Controller
public class AccountController {

	@GetMapping("/reg")
	public String reg(){
		return "reg";
	}
	
	@GetMapping("/logout")
	public String logout(Model model){
		model.addAttribute("username", "admin");
		model.addAttribute("logout", "true");
		return "logout";
	}
}

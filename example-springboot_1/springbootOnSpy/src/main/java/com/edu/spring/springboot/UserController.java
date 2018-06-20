package com.edu.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private GaugeService gaugeService;

	@GetMapping("/user/home")
	public String home(@RequestParam("error") String error){
		if("true".equals(error)){
			throw new NullPointerException();
		}
		counterService.increment("user.home.request.count");
		return "home";
	}
	
	@GetMapping("/mp3/price")
	public String price(@RequestParam("name") double price){
		gaugeService.submit("product.mp3.price", price);
		return "mp3 price";
	}
}

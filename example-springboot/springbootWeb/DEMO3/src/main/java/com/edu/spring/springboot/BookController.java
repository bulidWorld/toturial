package com.edu.spring.springboot;

import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@ExceptionHandler(value=Exception.class)
	public String error(Exception e){
		return "found exception : " + e.getMessage();
	}
	
	@GetMapping("/book/error1")
	public String error1() throws FileNotFoundException {
		throw new FileNotFoundException("book.txt not found");
	}
	
	@GetMapping("/book/error2")
	public String error2() throws ClassNotFoundException {
		throw new ClassNotFoundException("Book class not found");
	}
}

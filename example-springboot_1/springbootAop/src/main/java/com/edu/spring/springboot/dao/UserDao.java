package com.edu.spring.springboot.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao implements IUserDao {
	public void add(String username, String password){
		System.out.println("add [username: "+username+", password: " + password + "]");
	}
}

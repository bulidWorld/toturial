package com.edu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//业务逻辑层
@Service
public class UserService {

	@Autowired
	@Qualifier("createUserDao")
	private UserDao userDao;

	public String toString() {
		return "UserService [userDao=" + userDao + "]";
	}
}

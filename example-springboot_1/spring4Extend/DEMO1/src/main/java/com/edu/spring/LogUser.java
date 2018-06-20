package com.edu.spring;

public class LogUser extends User {

	public void show(){
		System.out.println("log start ..");
		super.show();
		System.out.println("log end ..");
	}
}

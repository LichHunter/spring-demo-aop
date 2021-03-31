package com.luv2code.springdemo.springdemoaop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public String addAccount(String s, boolean b) {
		if (s == null) throw new NullPointerException("S is equal to null");
		System.out.println(getClass() + ": doing some work");
		return "Hello world";
	}
}

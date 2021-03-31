package com.luv2code.springdemo.springdemoaop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount(String s, boolean b) {
		System.out.println(getClass() + ": doing some work");
	}
}

package com.luv2code.springdemo.springdemoaop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass() + " doing some work");
	}
}

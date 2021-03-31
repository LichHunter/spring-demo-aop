package com.luv2code.springdemo.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AnalyticsAspect {
	@Before("execution(public void addAccount())")
	public void analytics() {
		System.out.println("Performing analytics");
	}
}

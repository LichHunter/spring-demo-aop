package com.luv2code.springdemo.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLoggingAspect {
	@Before("execution(public void addAccount())")
	public void logging() {
		System.out.println("Cloud logging");
	}
}

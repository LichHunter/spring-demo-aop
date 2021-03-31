package com.luv2code.springdemo.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting before method addAccount");
	}
}
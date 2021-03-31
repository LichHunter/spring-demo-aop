package com.luv2code.springdemo.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(public void com.luv2code.springdemo.springdemoaop.dao.*.*())")
	private void forDaoPackage() {
	}

	@Pointcut("execution(public void com.luv2code.springdemo.springdemoaop.*.*.*(..))")
	private void forAllClasses() {
	}


	//execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
	// method-name-pattern(param-pattern) throws-pattern?)
	// method-name-pattern(*(one any argument)/..(any number of parameters))
	@Before("forDaoPackage() || !forAllClasses()")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting before method addAccount");
	}
}

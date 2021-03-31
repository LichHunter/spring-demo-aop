package com.luv2code.springdemo.springdemoaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
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
//	@Before("forDaoPackage() || !forAllClasses()")
//	@Before("forDaoPackage()")
	@Before("execution(public void addAccount(String, boolean))")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("Params:");
		for (Object object : joinPoint.getArgs()) {
			System.out.println(object);
		}

		System.out.println("Method signature: " + joinPoint.getSignature());

		System.out.println("Executing before method addAccount");
	}

	@AfterReturning(pointcut = "execution(public String addAccount(String, boolean))",
			returning = "result")
	public String afterReturningAddAccountAdvice(JoinPoint joinPoint, String result) {
		System.out.println("After returning addAccount");
		System.out.println("Result: " + result);
		result = result.concat(" Me");
		System.out.println("Modified result: " + result);
		return result;
	}

	@AfterThrowing(pointcut = "execution(public String addAccount(String, boolean))",
			throwing = "exception")
	public void afterThrowingAddAccountAdvice(Throwable exception) {
		System.out.println("Exception logged:" + exception.getMessage());
	}

	@Around("execution(public String addAccount(String, boolean))")
	public Object aroundAddAccountAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = null;

		System.out.println("Around advice start");
		try {
			result = proceedingJoinPoint.proceed();
		} catch (NullPointerException e) {
			System.out.println("Had null pointer exception");
			result = "Exception";
		}
		System.out.println("Around advice after");
		return result;
	}
}

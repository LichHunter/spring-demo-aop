package com.luv2code.springdemo.springdemoaop;

import com.luv2code.springdemo.springdemoaop.dao.AccountDAO;
import com.luv2code.springdemo.springdemoaop.dao.MembershipDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDemoAopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDemoAopApplication.class, args);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		try {
			System.out.println(accountDAO.addAccount(null, true));
		} catch (NullPointerException ignore) {

		}
		membershipDAO.addAccount();
	}
}

package com.byteslounge.spring.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.byteslounge.spring.tx.model.User;
import com.byteslounge.spring.tx.user.UserManager;

public class SaveUser {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");
	
	User user = new User();
	user.setUsername("johndoe");
	user.setName("John Doe");
	
	userManager.insertUser(user);
	
	System.out.println("User inserted!");
}
}

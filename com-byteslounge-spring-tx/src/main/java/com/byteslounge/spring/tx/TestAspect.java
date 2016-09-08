package com.byteslounge.spring.tx;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class TestAspect {

	@Before("execution(* com.byteslounge.spring.tx.user.impl.UserManagerImpl.insertUser(..) )")
	public void testOrder(){
	try {
		System.out.println("Afeter Returning");
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

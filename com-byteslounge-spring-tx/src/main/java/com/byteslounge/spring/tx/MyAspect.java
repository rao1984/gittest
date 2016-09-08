package com.byteslounge.spring.tx;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.core.Ordered;
import org.springframework.dao.PessimisticLockingFailureException;

public class MyAspect implements Ordered {
	   public MyAspect(){
		   System.out.println("MyAspect created");
	   }
	   private static final int DEFAULT_MAX_RETRIES = 2;

	   private int maxRetries = DEFAULT_MAX_RETRIES;
	   private int order = 1;

	   public void setMaxRetries(int maxRetries) {
	      this.maxRetries = maxRetries;
	   }
	   
	   public int getOrder() {
	      return this.order;
	   }
	   
	   public void setOrder(int order) {
	      this.order = order;
	   }
	   
	   @Around("execution(* com.byteslounge.spring.tx.user.impl.UserManagerImpl.insertUser(..) )")
	   public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable { 
	      int numAttempts = 0;
	      System.out.println("myas");
	      PessimisticLockingFailureException lockFailureException;
	      do {
	         numAttempts++;
	         try { 
	            return pjp.proceed();
	         }
	         catch(PessimisticLockingFailureException ex) {
	            lockFailureException = ex;
	         }
	      }
	      while(numAttempts <= this.maxRetries);
	      throw lockFailureException;
	   }
}
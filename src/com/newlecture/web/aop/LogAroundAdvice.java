package com.newlecture.web.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogAroundAdvice implements MethodInterceptor { //두번째꺼로 Import (org.alliance.interceptor)

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		// TODO Auto-generated method stub
		
		StopWatch sw = new StopWatch();
		
		System.out.println("(시간체크) 호출시작");
		sw.start();
		
		Object result =  method.proceed();   //실제 왕자님을 호출하는 Join Point
		
		System.out.println("(시간체크) 호출 끝");
		sw.stop();
		
		System.out.println("[TimeLog] Method "+method.getMethod().getName()+" is finished");
		System.out.println("[TimeLog] Process "+sw.getTotalTimeMillis());
		
		return result;
	}

}

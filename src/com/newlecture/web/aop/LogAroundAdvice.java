package com.newlecture.web.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogAroundAdvice implements MethodInterceptor { //�ι�°���� Import (org.alliance.interceptor)

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		// TODO Auto-generated method stub
		
		StopWatch sw = new StopWatch();
		
		System.out.println("(�ð�üũ) ȣ�����");
		sw.start();
		
		Object result =  method.proceed();   //���� ���ڴ��� ȣ���ϴ� Join Point
		
		System.out.println("(�ð�üũ) ȣ�� ��");
		sw.stop();
		
		System.out.println("[TimeLog] Method "+method.getMethod().getName()+" is finished");
		System.out.println("[TimeLog] Process "+sw.getTotalTimeMillis());
		
		return result;
	}

}

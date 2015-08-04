package com.newlecture.web;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;

public class Program {
	
	static{ 
		SqlNewlecSessionFactory factory = new SqlNewlecSessionFactory();
		try {
			factory.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*NoticeDao noticeDao = new MybatisNoticeDao();
				
		NoticeConsole console = new NoticeConsole();
		console.setNoticeDao(noticeDao); //injection
*/		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/Spring_Context.xml");
		NoticeConsole console = (NoticeConsole) context.getBean("console"); 
			    
		console.Print();
	}

}

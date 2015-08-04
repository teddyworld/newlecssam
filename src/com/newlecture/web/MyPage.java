package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;


@WebServlet("/MyPage")
public class MyPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		 response.setCharacterEncoding("UTF-8");  
		 response.setContentType("text/html; charset = UTF-8");
		 
		 ServletContext application = request.getServletContext();
		 HttpSession session = request.getSession();
		 
		 PrintWriter out = response.getWriter();
			
		 int app = 0;
		 int ss = 0;
		 int ck = 0;
		 
		 
		 Object _a =  application.getAttribute("a");
		 Object _s =  session.getAttribute("s");
		 
		 Cookie[] cookies = request.getCookies();
		 String _c = null;
		 
		 if (cookies != null)
			 for (Cookie cookie : cookies)
				 if("C".equals(cookie.getName()))
				 _c = cookie.getValue();
				 
		 
		 if(_a != null)
			 app = (int) _a;
		 
		 if(_s != null)
			 ss = (int) _s;
		 if(_c != null)
			 ck = Integer.parseInt(_c);
		 
		 out.printf("Application : %d <br/>",app);
		 out.printf("Session : %d  <br/>",ss);
		 out.printf("Cookie : %d <br/>",ck);
		 out.println("<a href=\"add\">계산하기</a>");
		 
			
		
			
	}


}

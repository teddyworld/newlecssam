package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Nana
 */

@WebServlet("/hello")
public class Nana extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	  response.setCharacterEncoding("UTF-8");  //실제 출력할때 명령(한글사용하기위함)
	  response.setContentType("text/html; charset = UTF-8");  //사용할 것이 무언인지 설정
		
	  PrintWriter out = response.getWriter();
	  
	  String _cnt = request.getParameter("cnt");
	  int cnt = 10;
	  
	  
	  
	  if(_cnt != null && _cnt.equals(""))
		  cnt = Integer.parseInt(_cnt);
		  
	  
	  for(int i=0; i<cnt; i++)
	  out.println("<b>안녕</b> Servlet!!<br/>");
	    	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String _x = request.getParameter("x");;
		String _y = request.getParameter("y");;
		
		int x = 0;
		int y = 0;
		
		if(_x !=null && !_x.equals(""))
		     x = Integer.parseInt(_x);
			 
		if(_y !=null && !_y.equals(""))
			y = Integer.parseInt(_y);
			
		 response.setCharacterEncoding("UTF-8");  
		 response.setContentType("text/html; charset = UTF-8");
		 
		 PrintWriter out = response.getWriter();
			
			int result = x + y;
	 
	    	out.printf("<form action= \"hello\" method= \"post\">");
			out.printf("<ul>");
			out.printf("<li><label for=\"x\">X:</label><input name = \"x\"/></li>");
			out.printf("<li><label for=\"y\">Y:</label><input name = \"y\"/></li>");
			out.printf("</ul>");
			out.printf("<p><input type=\"submit\" value=\"덧셈\"/></p>");
			out.printf("</form>");
		
			out.printf("결과 = %d <br />",result);
			 
		
		}

	}



package com.newlecture.web.controller.joinus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.valves.rewrite.RewriteValve;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.mybatis.MybatisMemberDao;
import com.newlecture.web.vo.Member;

@WebServlet("/joinus/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getMethod().equals("POST"))
		{
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			
			MemberDao memberdao = new MybatisMemberDao();
			Member member = memberdao.getMember(uid);
			
			if(member == null)
			{
			  	// ID오류 메시지
				request.setAttribute("error", "ID or PW가 잘못되었습니다");

			}
			
			else if(!member.getPwd().equals(pwd))
			{
				// PW오류 메시지
				request.setAttribute("error", "ID or PW가 잘못되었습니다");

			}
			else
			{
				// 인증성공
				HttpSession session = request.getSession();
				session.setAttribute("uid",uid);
				
				response.sendRedirect("../customer/notice");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
			dispatcher.forward(request, response);
			
		}
		
		else
		{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
		dispatcher.forward(request, response);
		}
		
	
	}

}

package com.newlecture.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.vo.Notice;

//@WebServlet("/customer/noticeDetail")
public class NoticeDetailController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if(session.getAttribute("uid") == null)
		  response.sendRedirect("notice?error=1");
			
		NoticeDao noticeDao = new MybatisNoticeDao();
		String code = request.getParameter("c");  //'c'라는 코드를 넘겨받아야함 notice.jsp에서 받아옴
		Notice n = noticeDao.getNotice(code);
		request.setAttribute("n",n);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeDetail.jsp");
		dispatcher.forward(request, response);
		
	}

}

package com.newlecture.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.vo.Notice;


// public class SpringNoticeController extends HttpServlet{  서블릿방식

public class SpringNoticeController implements Controller{
	
	
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)  //서블릿방식의 서비스
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	  	NoticeDao noticeDao = new MybatisNoticeDao();
		List<Notice> list = noticeDao.getNotices();
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
		dispatcher.forward(request, response);
		
	}*/

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		NoticeDao noticeDao = new MybatisNoticeDao();
		List<Notice> list = noticeDao.getNotices();
		request.setAttribute("list", list);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/view/customer/notice.jsp");
		mv.addObject("list",list);
		
		return mv;
		
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
		dispatcher.forward(request, response);*/
		
	}

}

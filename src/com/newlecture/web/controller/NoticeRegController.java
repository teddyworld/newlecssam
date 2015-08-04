package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

//@WebServlet("/customer/noticeReg")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 5,    // 파일 최대크기르 5메가로 정함
		maxRequestSize = 1024 * 1024 * 5 * 5 // 5메가를 5개까지
		)
public class NoticeRegController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
				
		if(request.getMethod().equals("POST"))
		{
			
			Part part = request.getPart("file");
			ServletContext application = request.getServletContext();

			String url = "/customer/upload";
			String path = application.getRealPath(url); //저장경로
			String temp = part.getSubmittedFileName(); //저장된 파일이름
			String fname = temp.substring(temp.lastIndexOf("\\")+1); 
			String fpath = path + "\\" + fname;
			response.getWriter().println(fpath);
			
			InputStream ins = part.getInputStream();
			OutputStream outs = new FileOutputStream(fpath);
			
			byte[] 대야 = new byte[1024];
			int len = 0;
			
			while((len = ins.read(대야, 0, 1024)) >=0)
			outs.write(대야, 0, len);
			
			outs.flush();
			outs.close();
			ins.close();
			
			
			String title = request.getParameter("title");
			String file = request.getParameter("file");
			String content = request.getParameter("content");
			
			Notice notice = new Notice();
			NoticeFile noticeFile = new NoticeFile();
			
			notice.setTitle(title);
			notice.setWriter("드ragon");
			notice.setContent(content);
			response.getWriter().println("<br />"+title);
					
			NoticeDao noticeDao = new MybatisNoticeDao();
			noticeDao.addNotice(notice);
			
			NoticeFileDao noticeFileDao = new MybatisNoticeFileDao();
			noticeFile.setName(fname);
			noticeFile.setNoticeCode(noticeDao.getLastCode());
			
			noticeFileDao.addNoticeFile(noticeFile);
			
			response.sendRedirect("notice");
		}
		
		else
		{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeReg.jsp");
		dispatcher.forward(request, response);
		}
		
	}

}

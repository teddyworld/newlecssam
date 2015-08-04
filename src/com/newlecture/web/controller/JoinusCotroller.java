package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/joinus/*")
public class JoinusCotroller {
	
	@RequestMapping("login")
	public String login(){
		
		return  "/WEB-INF/view/joinus/login.jsp";
	}

}

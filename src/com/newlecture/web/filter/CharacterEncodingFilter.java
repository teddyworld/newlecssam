package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter (
	filterName = "CharacterEncodingFilter",
	urlPatterns = {"/*"},
    initParams = {@WebInitParam(name = "encoding", value = "UTF-8")}
)

public class CharacterEncodingFilter implements Filter {  //어노테이션방법
	
	private String encoding;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		encoding = config.getInitParameter("encoding");
	}

}

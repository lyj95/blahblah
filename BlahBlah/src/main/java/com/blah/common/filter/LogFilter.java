package com.blah.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LogFilter implements Filter  {
	//Appender에게 메세지를 전달
	private Logger logger = 
				LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req =  (HttpServletRequest)request;
		
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String refere = req.getHeader("referer");
		String agent =  req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append("remoteAddr: " + remoteAddr+"\n")
			.append("uri: " +uri+"\n")
			.append("url: " +url+"\n")
			.append("queryString: " + queryString + "\n")
			.append("referer: "+refere+"\n")
			.append("agent: " + agent);
		
		logger.info("[[[ LOG FILTER ]]]\n"+sb);
		
		chain.doFilter(req, response);
		
	}
	@Override
	public void destroy() {
	}

	
	
	
	
	
	
	
}

package com.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.user.entity.user;
public class loginfilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		Subject subject = SecurityUtils.getSubject();
		user u=(user) subject.getSession().getAttribute("user");
		 String url=request.getRequestURL().toString();
		if(u==null){
			if(url.contains("login.do")||url.contains("sign.do")||url.contains("validateCode.do")){
				arg2.doFilter(request, response);
			}
			else{
				response.sendRedirect("/sign.do");
				//response.setStatus(911);
				return;
			}
		}
		else{
			arg2.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

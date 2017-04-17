package com.medusa.bhsq.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptors implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object o) throws Exception {
		request.setCharacterEncoding("UTF-8");//传值编码
		response.setContentType("text/html;charset=UTF-8");//设置传输编码
	/*	if(request.getSession().getAttribute("admin")==null)
		{
			response.sendRedirect("login.jsp");
			return false;
		}
		if(request.getHeader("X-Requested-With")!=null)
		{
			System.out.println("异步请求");
			return true;
		}
		else
		{
			System.out.println("同步请求");
			return true;
		}*/
		return true;
	}

}

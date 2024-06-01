package com.multi.servlet.e_practice;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Monday extends HttpServlet {
	
	String temp;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("객체 생성됨");
		temp = config.getInitParameter("temp");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		System.out.println("get 요청을 받음.");
		PrintWriter out = response.getWriter();
		out.println("get~~parameter values >> " + temp);
		out.close();
	}
	

}
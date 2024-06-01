package com.multi.el.controller;

import com.multi.el.model.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/test4")
public class TestFourServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO requestMember = new MemberDTO("로운", 20, "010-1234-5678", "k@uni.com");
		MemberDTO sessionMember = new MemberDTO("유재석", 19, "010-5678-9012", "y@uni.com");
		
		HttpSession session = request.getSession();
		
		request.setAttribute("member", requestMember);
		session.setAttribute("member", sessionMember);
		
		RequestDispatcher view = request.getRequestDispatcher("views/el/testEl4.jsp");
		view.forward(request, response);
		
	}

}

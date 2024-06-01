package com.multi.jsp.controller;

import com.google.gson.Gson;
import com.multi.jsp.model.dao.MemberDAO;
import com.multi.jsp.model.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/chap03/selectList")
public class MemberListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		MemberDAO dao = new MemberDAO();
		
		ArrayList<MemberDTO> members = dao.selectMemberList();
		
		System.out.println(members);
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(members, response.getWriter());
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
	}
}
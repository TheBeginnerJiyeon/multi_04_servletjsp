package com.multi.jsp.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.multi.jsp.model.dao.MemberDAO;
import com.multi.jsp.model.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


@WebServlet("/chap03/insert")
public class MemberinsertServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		
		String jsonFilePath = getServletContext().getRealPath("/data/MOCK_DATA.json");
		
		System.out.println(jsonFilePath);
		
		String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		
		Gson gson = new Gson();
		// JSON 문자열을 ArrayList<MemberDTO> 객체로 변환
		
		Type listType = new TypeToken<ArrayList<MemberDTO>>(){}.getType();
		ArrayList<MemberDTO> members = gson.fromJson(json, listType);
		
		MemberDAO dao = new MemberDAO();
		System.out.println(members.get(0).toString());
		int result = dao.insertMembers(members);
		
		response.getWriter().print(result);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
	}
}
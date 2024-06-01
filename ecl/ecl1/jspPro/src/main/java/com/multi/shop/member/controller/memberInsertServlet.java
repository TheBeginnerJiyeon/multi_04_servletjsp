package com.multi.shop.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.member.model.dto.MemberDTO;
import com.multi.shop.member.service.MemberService;
import com.multi.shop.member.service.MemberServiceImpl;

/**
 * Servlet implementation class memberInsertServlet
 */
/* @WebServlet("/member/insert") */
public class memberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService memberService = new MemberServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String path = "/WEB-INF/views/member/signUp.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		memberDTO.setTel(tel);
		
		String path = "";
		
		try {
			int result = memberService.insertMember(memberDTO);
			
			
			
			if (result>0) {
				System.out.println("Member insert successful");
				
				
			}else {
				System.out.println("회원가입 실패..");
				path = "";
			}
			
			path = "/WEB-INF/views/main/main.jsp";
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원가입 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}

}

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
 * Servlet implementation class MemberRegisterServlet
 */
@WebServlet("/member/insert")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/insert.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String page="";
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		memberDTO.setTel(tel);
		
		try {
			int result = memberService.insertMember(memberDTO);
			System.out.println(result);
			System.out.println(memberDTO);
			
			if (result > 0) {

				page = "/WEB-INF/views/common/success.jsp";

				request.setAttribute("successCode", "insertMember");

			} else {

				page = "/WEB-INF/views/common/failed.jsp";

				request.setAttribute("message", "회원 가입 실패! result =0");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			page = "/WEB-INF/views/common/errorPage.jsp";

			request.setAttribute("message", "회원 가입 실패!");
		}
		
		
		
		request.getRequestDispatcher(page).forward(request, response);
		
		
		
		
		
		
		
	}

}

package com.multi.shop.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.board.model.dto.BoardDTO;
import com.multi.shop.board.service.BoardService;
import com.multi.shop.board.service.BoardServiceImpl;
import com.multi.shop.member.model.dto.MemberDTO;


@WebServlet("/board/update")
public class BoardIUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();

	public BoardIUpdateServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/board/updateform.jsp").forward(request, response);

		System.out.println(request.getSession().getAttribute("b"));

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path="";
		
		
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		MemberDTO loginMemberDTO = (MemberDTO) request.getSession().getAttribute("loginMember");
		String writer = loginMemberDTO.getId();
		
		BoardDTO boardDTO = (BoardDTO) request.getSession().getAttribute("b");	
	
		
		boardDTO.setCategoryCode(categoryCode);
		boardDTO.setTitle(title);
		boardDTO.setContent(content);		
		
		
		try {
			// result 따라 더 나누기. 성공하면 success로 가도롥..
			// path = "/WEB-INF/views/common/success.jsp"
			// request.setAttribute("successCode", "insertBoard");
			
			int result= boardService.updateBoard(boardDTO);
			
			
			if (result>0) {
			
				request.setAttribute("successCode", "updateBoard");
				
				
				path = "/WEB-INF/views/common/success.jsp";	
				
			}else {
				request.setAttribute("message", "게시판 글 수정 실패");
				path = "/WEB-INF/views/common/failed.jsp";
			}
			
			// 오류 처리 내용도 자세히 넣기!!
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시물 작성 실패!");
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);
		
		

	}

}

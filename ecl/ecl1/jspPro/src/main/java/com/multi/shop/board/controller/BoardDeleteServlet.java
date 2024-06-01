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

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();

	public BoardDeleteServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getSession().getAttribute("b"));

		String path = "";

		BoardDTO boardDTO = (BoardDTO) request.getSession().getAttribute("b");

		try {
			// result 따라 더 나누기. 성공하면 success로 가도롥..
			// path = "/WEB-INF/views/common/success.jsp"
			// request.setAttribute("successCode", "insertBoard");

			int result = boardService.deleteBoard(boardDTO);

			request.setAttribute("successCode", "deleteBoard");

			path = "/WEB-INF/views/common/success.jsp";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시물 삭제 실패!");
		}

		request.getRequestDispatcher(path).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

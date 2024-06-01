package com.multi.shop.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.board.model.dto.BoardDTO;
import com.multi.shop.board.service.BoardService;
import com.multi.shop.board.service.BoardServiceImpl;
import com.multi.shop.product.model.dto.ProductDTO;
import com.multi.shop.product.service.ProductService;
import com.multi.shop.product.service.ProductServiceImpl;

@WebServlet("/product/delete")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductServiceImpl();

	public ProductDeleteServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request.getParameter('productId')"+request.getParameter("productId"));

		String path = "";

		int productId = Integer.parseInt((String) request.getParameter("productId"));

		try {

			int result = productService.deleteProduct(productId);

			request.setAttribute("successCode", "deleteProduct");

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

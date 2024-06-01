package com.multi.shop.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.product.model.dto.ProductDTO;

@WebServlet("/product/basket")
public class BasketServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ProductDTO> basket = (ArrayList<ProductDTO>) request.getSession().getAttribute("basket");
		if (basket == null) {
		    basket = new ArrayList<ProductDTO>();
		    request.getSession().setAttribute("basket", basket);
		}
		String path = "/WEB-INF/views/product/basket.jsp";

		request.getRequestDispatcher(path).forward(request, response);

	}

}

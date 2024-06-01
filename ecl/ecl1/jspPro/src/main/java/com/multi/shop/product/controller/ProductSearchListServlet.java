package com.multi.shop.product.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;
import com.multi.shop.product.service.ProductService;
import com.multi.shop.product.service.ProductServiceImpl;

@WebServlet("/product/searchList")
public class ProductSearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductServiceImpl();

	public ProductSearchListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "";
		CompanyDTO companyDTO = new CompanyDTO();
		ProductDTO productDTO = new ProductDTO();

		int id;
		if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()
				&& !request.getParameter("id").equals("")) {
				id = Integer.parseInt(request.getParameter("id"));
				productDTO.setId(id);
				System.out.println("ID: " + id);
			}

			String name = request.getParameter("name");

			int price;
			if (request.getParameter("price") != null
					&& !request.getParameter("price").isEmpty() & !request.getParameter("price").equals("")) {
				price = Integer.parseInt(request.getParameter("price"));
				productDTO.setPrice(price);
				System.out.println("Price: " + price);
			}

			String companyId = request.getParameter("companyId");

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date createdDate = null;
			String dateString = request.getParameter("createdDate");

			try {
				if (dateString != null && !dateString.isEmpty()) {
					createdDate = dateFormat.parse(dateString);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// Debugging output
			System.out.println("Parameters:");

			System.out.println("Name: " + name);

			System.out.println("Company ID: " + companyId);
			System.out.println("Created Date: " + createdDate);

			companyDTO.setId(companyId);

			/*
			 * WHERE 1 = 1
			 * 
			 * AND A.ID = ?
			 * 
			 * 
			 * 
			 * AND A.PRICE = ?
			 * 
			 * 
			 * AND A.COMPANY_ID = ?
			 * 
			 * 지금 아이디, 가격 계속 잡혀서 고쳐야하고 컴퍼니 이름 안되는 거 봐서 컴퍼니.네임이 지금 안 먹는 거임 >> 고침
			 * 
			 * SELECT A.ID, A.NAME, A.PRICE, A.COMPANY_ID, A.CREATED_DATE, A.CREATED_PERSON,
			 * A.MODIFIED_DATE FROM PRODUCT A WHERE 1 = 1 AND A.ID = 0 AND A.PRICE = 0 AND
			 * A.COMPANY_ID = 'c100' ORDER BY A.ID DESC ???? ChatGPT The generated SQL query
			 * indicates that the parameters for ID and PRICE are being set to 0, which is
			 * likely why the query is returning an empty result set. To resolve this issue,
			 * ensure that the parameters are only included in the query if they are
			 * provided by the user.
			 * 
			 */

			productDTO.setName(name);

			productDTO.setCompany(companyDTO);
			productDTO.setCreatedDate(createdDate);

			try {
				ArrayList<ProductDTO> list = productService.selectSearchList(productDTO);
				request.setAttribute("list", list);
				System.out.println("Search Results: " + list);
				path = "/WEB-INF/views/product/list.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				path = "/WEB-INF/views/common/errorPage.jsp";
				request.setAttribute("msg", "Failed to retrieve product list based on search conditions.");
			}

			request.getRequestDispatcher(path).forward(request, response);

		}

	

}



package com.multi.shop.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.multi.shop.member.model.dto.MemberDTO;
import com.multi.shop.product.model.dto.AttachmentDTO;
import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;
import com.multi.shop.product.service.ProductService;
import com.multi.shop.product.service.ProductServiceImpl;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/product/insert")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductServiceImpl();

	String path = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("/WEB-INF/views/product/insertform.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * System.out.println("이름들"); Enumeration<String> parameterNames =
		 * request.getParameterNames(); while (parameterNames.hasMoreElements()) {
		 * String paramName = parameterNames.nextElement(); String[] paramValues =
		 * request.getParameterValues(paramName); System.out.println("Parameter Name: "
		 * + paramName); for (String paramValue : paramValues) {
		 * System.out.println("    Value: " + paramValue); } }
		 * 
		 */

		if (ServletFileUpload.isMultipartContent(request)) {

			String rootLocation = request.getSession().getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";

			System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
			System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
			System.out.println("인코딩 방식 : " + encodingType);

			// 여기 고치기,.,.. 루트가 웹 컨텐트가 나와야함.
			// Default, Eclipse uses
			// /workspace/.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
			// path
			// to deploy web application.
			String fileUploadDirectory = rootLocation + "/resources/upload/original/";
			String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";

			File directory = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);

			if (!directory.exists() || !directory2.exists()) {

				System.out.println("폴더 생성 : " + directory.mkdirs());
				System.out.println("폴더 생성 : " + directory2.mkdirs());

			}

			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();

			/* 파일을 업로드할 시 최대 크기나 임시 저장할 폴더의 경로 등을 포함하기 위한 인스턴스이다. */
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);

			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);

				for (FileItem fileItem : fileItems) {
					/* 폼 데이터는 isFormField 속성이 true이고, 파일은 isFormField 속성이 false이다. */
					System.out.println(fileItem);
				}

				for (int i = 0; i < fileItems.size(); i++) {
					FileItem item = fileItems.get(i);

					if (!item.isFormField()) { // 파일 데이터인 경우

						if (item.getSize() > 0) {

							String filedName = item.getFieldName();
							String originFileName = item.getName();

							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);

							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;

							System.out.println(randomFileName);

							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);

							item.write(storeFile);

							/* 필요한 정보를 Map에 담는다. */
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("filedName", filedName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);

							/* 제목 사진과 나머지 사진을 구분하고 썸네일도 생성한다. */
							int width = 0;
							int height = 0;
							if ("thumbnailImg1".equals(filedName)) {
								fileMap.put("fileType", "TITLE");

								/* 썸네일로 변환 할 사이즈를 지정한다. */
								width = 350;
								height = 200;
							} else {
								fileMap.put("fileType", "BODY");

								width = 120;
								height = 100;
							}

							/* 썸네일로 변환 후 저장한다. */
							Thumbnails.of(fileUploadDirectory + randomFileName).size(width, height)
									.toFile(thumbnailDirectory + "thumbnail_" + randomFileName);

							/* 나중에 웹서버에서 접근 가능한 경로 형태로 썸네일의 저장 경로도 함께 저장한다. */
							// 경로 주의하기...
							fileMap.put("thumbnailPath",
									"/resources/upload/thumbnail/thumbnail_" + randomFileName);

							fileList.add(fileMap);

						}

					} else {
						/*
						 * 전송된 폼의 name은 getFiledName()으로 받아오고, 해당 필드의 value는 getString()으로 받아온다. 하지만 인코딩
						 * 설정을 하더라도 전송되는 파라미터는 ISO-8859-1로 처리된다. 별도로 ISO-8859-1로 해석된 한글을 UTF-8로 변경해주어야
						 * 한다.
						 */
						parameter.put(item.getFieldName(),
								new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));

					}
				}

				System.out.println("parameter: " + parameter);
				System.out.println("fileList: " + fileList);

				String name = parameter.get("name");
				String content = parameter.get("content");
				String createdPerson = ((MemberDTO) request.getSession().getAttribute("loginMember")).getId();
				String companyId = parameter.get("company");
				int price = Integer.parseInt(parameter.get("price"));

				ProductDTO newProduct = new ProductDTO();
				newProduct.setName(name);
				newProduct.setContent(content);
				newProduct.setPrice(price);
				newProduct.setCreatedPerson(createdPerson);

				CompanyDTO company = new CompanyDTO();

				company.setId(companyId);

				newProduct.setCompany(company);

				System.out.println("thumbnail product : " + newProduct);

				newProduct.setAttachments(new ArrayList<AttachmentDTO>());

				List<AttachmentDTO> list = newProduct.getAttachments();
				for (int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);

					AttachmentDTO tempFileInfo = new AttachmentDTO();
					tempFileInfo.setOriginalName(file.get("originFileName"));
					tempFileInfo.setSavedName(file.get("savedFileName"));
					tempFileInfo.setSavePath(file.get("savePath"));
					tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
					tempFileInfo.setCreatePerson(createdPerson);

					list.add(tempFileInfo);
				}

				System.out.println("thumbnail product : " + newProduct);

				// 서비스 메소드를 요청한다.
				int result = productService.insertProduct(newProduct);

				if (result > 0) {
					path = "/WEB-INF/views/common/success.jsp";
					request.setAttribute("successCode", "insertProduct");
					
					
				} else {
					path = "/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "제품 등록 실패!");
				}

			} catch (Exception e) {
				// 어떤 종류의 Exception이 발생 하더라도실패 시 파일을 삭제해야 한다.
				int cnt = 0;
				for (int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);

					File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
					boolean isDeleted = deleteFile.delete();

					if (isDeleted) {
						cnt++;
					}
				}

				if (cnt == fileList.size()) {
					System.out.println("업로드에실패한 모든 사진 삭제 완료!");
					e.printStackTrace();
				} else {
					e.printStackTrace();
				}
				path = "/WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "제품 등록 실패!");

			}
			
			
			request.getRequestDispatcher(path).forward(request, response);

		}

		/*
		 * String name = (String) request.getParameter("name"); String content =
		 * (String) request.getParameter("content");
		 * 
		 * System.out.println(name); System.out.println(content);
		 * 
		 * int price = Integer.parseInt((String) request.getParameter("price"));
		 * 
		 * System.out.println("price" + price);
		 * 
		 * 
		 * 
		 * 
		 * String img = request.getParameter("img"); // 이미지 4개로
		 * 
		 * 
		 * String companyId = request.getParameter("company");
		 * 
		 * 
		 * 
		 * 
		 * MemberDTO loginMemberDTO = (MemberDTO)
		 * request.getSession().getAttribute("loginMember"); String createdPerson =
		 * loginMemberDTO.getId();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * ProductDTO productDTO = new ProductDTO();
		 * 
		 * productDTO.setName(name); productDTO.setContent(content);
		 * productDTO.setPrice(price);
		 * 
		 * 
		 * productDTO.setCompanyId(companyId);
		 * 
		 * 
		 * 
		 * productDTO.setImg(img); productDTO.setCreatedPerson(createdPerson);
		 * 
		 * 
		 * try { // result 따라 더 나누기. 성공하면 success로 가도롥.. // path =
		 * "/WEB-INF/views/common/success.jsp" // request.setAttribute("successCode",
		 * "insertBoard");
		 * 
		 * int result= productService.insertProduct(productDTO);
		 * 
		 * path = "/product/list";
		 * 
		 * 
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); path = "/WEB-INF/views/common/errorPage.jsp";
		 * request.setAttribute("msg", "제품 입력 실패!"); }
		 * 
		 * 
		 * request.getRequestDispatcher(path).forward(request, response);
		 */

	}

}

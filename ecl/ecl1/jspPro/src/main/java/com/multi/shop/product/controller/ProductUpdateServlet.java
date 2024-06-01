package com.multi.shop.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

@WebServlet("/product/update")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductServiceImpl();
	int productId;
	

	public ProductUpdateServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		productId=Integer.parseInt(request.getParameter("productId"));

		try {
			System.out.println("Product ID 여기: " + request.getParameter("productId"));
			productId = Integer.parseInt((String) request.getParameter("productId"));
			ArrayList<ProductDTO> productList = productService.selectProduct(productId);
			request.setAttribute("productList", productList);
			request.setAttribute("productId", productId);
			System.out.println(productList + "여기입니다!!");
			System.out.println("겟으로 받아온 product Id는? : " + productId);
			System.out.println(request.getContextPath() + "으아아");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/views/product/updateform.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "";
		System.out.println("productId 널입니까???"+ productId);
		
		List<Map<String, String>> fileList = new ArrayList<>();

		try {
			ArrayList<ProductDTO> product = productService.selectProduct(productId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
							fileMap.put("thumbnailPath", "/resources/upload/thumbnail/thumbnail_" + randomFileName);

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
				String modifiedPerson = ((MemberDTO) request.getSession().getAttribute("loginMember")).getId();
				String companyId = parameter.get("company");
				int price = Integer.parseInt(parameter.get("price"));

				System.out.println(productId + "여기에 있음");

				ProductDTO newProduct = new ProductDTO();
				newProduct.setName(name);
				newProduct.setContent(content);
				newProduct.setPrice(price);
				newProduct.setModifiedPerson(modifiedPerson);
				newProduct.setId(productId);

				CompanyDTO company = new CompanyDTO();

				company.setId(companyId);

				newProduct.setCompany(company);

				System.out.println("thumbnail product : " + newProduct);

				// 가져온 리스트
				List<AttachmentDTO> list = productService.selectAttachments(productId);

				// 새로운 이미지 리스트. 추가 수정된 파일만 저장된다
				List<AttachmentDTO> newList = new ArrayList<AttachmentDTO>();

				// 가져온 이미지 리스트를 바꾸기
				// 리스트 크기 비교가 더 필요하다!!
				for (int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);

					AttachmentDTO tempFileInfo = new AttachmentDTO();
					tempFileInfo.setNo(list.get(i).getNo());
					tempFileInfo.setRefProductNo(list.get(i).getRefProductNo());
					tempFileInfo.setOriginalName(file.get("originFileName"));
					tempFileInfo.setSavedName(file.get("savedFileName"));
					tempFileInfo.setSavePath(file.get("savePath"));
					tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
					tempFileInfo.setModifyPerson(modifiedPerson);

					newList.add(tempFileInfo);
				}

				// 원래 있는 파일은 업데이트, 없는 거는 삭제.. 복잡하다 여기부터
				// 기존 리스트의 이미지 갯수가 더 작은 경우가 이상함
				// 기존에 있는 이미지의 갯수와 같은 수 만큼 변경하는 경우만 가능.. 
				
				for (int i = 0; i < list.size(); i++) {

					for (int j = 0; j < newList.size(); j++) {

						if (list.get(i).getNo() == newList.get(j).getNo()) {

							list.set(i, newList.get(j));

						}

					}

				}
				
				

				
				
				
				

				System.out.println("list는 여기있음!!!" + list);
				System.out.println("newList" + newList);

				// 프로덕트에 다 담아서 서비스로 보내기
				newProduct.setAttachments(list);

				System.out.println("thumbnail product : " + newProduct);

				// 서비스 메소드를 요청한다. 어태치먼트 업데이트 과정도 포함한다.
				int result = productService.updateProduct(newProduct);

				if (result > 0) {
					path = "/WEB-INF/views/common/success.jsp";
					request.setAttribute("successCode", "updateProduct");

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

	}

}

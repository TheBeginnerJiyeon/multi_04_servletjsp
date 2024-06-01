package com.multi.shop.product.service;

import static com.multi.shop.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InterruptedNamingException;

import org.apache.ibatis.session.SqlSession;

import com.multi.shop.product.model.dao.ProductDAO;
import com.multi.shop.product.model.dto.AttachmentDTO;
import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;

public class ProductServiceImpl implements ProductService{
	
	ProductDAO productDAO = new ProductDAO();
	

	@Override
	public ArrayList<ProductDTO> selectList() throws Exception {
		
		SqlSession sqlSession = getSqlSession();
		ArrayList list = productDAO.selectList(sqlSession);
		sqlSession.close();
		System.out.println("impl: "+ list);
		return list;
		
		
	}


	


	@Override
	public ArrayList selectProduct(int id) throws Exception {
		
		SqlSession sqlSession = getSqlSession();

		
		ArrayList productList = productDAO.selectProduct(sqlSession, id);
		
		System.out.println("productList: " + productList);
		
		sqlSession.close();
		
		return productList;
		
		
		
	}


	@Override
	public ArrayList<CompanyDTO> selectCompanyList() throws Exception {
		
		SqlSession sqlSession = getSqlSession();
		ArrayList<CompanyDTO> list = productDAO.selectCompanyList(sqlSession);
		sqlSession.close();
		
		return list;
		
		
		
	}


	@Override
	public int insertProduct(ProductDTO productDTO) throws Exception{
		
		SqlSession session = getSqlSession();
		int result = 0;
		int productResult = productDAO.insertProduct(session, productDTO);
		
		List<AttachmentDTO> fileList = productDTO.getAttachments();

		int productId = productDTO.getId();
		
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setRefProductNo(productId);
			attachmentResult += productDAO.insertAttachment(session, fileList.get(i));
			
			
			
		}
		
		/* 모든 결과가 성공이면 트랜젝션을 완료한다. */	
		if(productResult > 0 && attachmentResult == fileList.size()) {
			session.commit();
			result = 1;
		} else {
			session.rollback();
		}
		session.close();
		
		
		return result;
		
		
		
		
	}





	@Override
	public int updateProduct(ProductDTO updatedProduct) throws Exception {
		
		SqlSession session = getSqlSession();
		int result = 0;
		List<AttachmentDTO> list = updatedProduct.getAttachments();
		
		
		int productResult = productDAO.updateProduct(session, updatedProduct);		
		int id = updatedProduct.getId();		
		int productId = updatedProduct.getId();		
		int attachmentResult = 0;

		for(int i = 0; i < list.size(); i++) {

			
			AttachmentDTO attachmentDTO = list.get(i);
			
			attachmentResult += productDAO.updateAttachment(session, attachmentDTO);		
			
		}
		
			
		
		/* 모든 결과가 성공이면 트랜젝션을 완료한다. */	
		if(productResult > 0 && attachmentResult == list.size()) {
			session.commit();
			result = 1;
		} else {
			session.rollback();
			System.out.println("롤백!!");
		}
		session.close();
		
		
		return result;	
		
	}
	
	







	@Override
	public ArrayList<AttachmentDTO> selectAttachments(int productId) throws Exception {
		
		SqlSession sqlSession = getSqlSession();

		
		ArrayList attArrayList = productDAO.selectAttList(sqlSession, productId);
		
		System.out.println("attList: " + attArrayList);
		
		sqlSession.close();
		
		return attArrayList;
	}





	@Override
	public ProductDTO selectProduct2(int pid) throws Exception {
		

		SqlSession sqlSession = getSqlSession();

		
		ProductDTO product = productDAO.selectProduct2(sqlSession, pid);
		
		System.out.println("product: " + product);
		
		sqlSession.close();
		
		return product;
		
		
		
	}





	@Override
	public ArrayList<ProductDTO> selectSearchList(ProductDTO productDTO)
			throws Exception {
		
		
		SqlSession sqlSession = getSqlSession();
		ArrayList list = productDAO.selectSearchList(sqlSession, productDTO);
		sqlSession.close();
		System.out.println("impl: "+ list);
		
		return list;
	}





	@Override
	public int deleteProduct(int productId) throws Exception {
		SqlSession sqlSession = getSqlSession();
		

		int result2 = productDAO.deleteAttachment(sqlSession, productId);
		
		if(result2 > 0) {
			System.out.println("첨부파일 삭제 성공...");			
			sqlSession.commit();
		}else {
			System.out.println("첨부파일 삭제 실패....");
			sqlSession.rollback();
			throw new Exception();
		}
		
		
		

		int result1 = productDAO.deleteProduct(sqlSession, productId);
		
		int result=0;
		
		if(result1 > 0) {
			System.out.println("상품 삭제 성공...");			
			sqlSession.commit();
			
			
		}else {
			System.out.println("상품 삭제 실패....");
			sqlSession.rollback();
			throw new Exception();
		}
		
		
		if (result1>0 && result2>0) {
			result=1;
		}
		
		sqlSession.close();
		
		
	
		return result;
	}








	
	
	
	
}

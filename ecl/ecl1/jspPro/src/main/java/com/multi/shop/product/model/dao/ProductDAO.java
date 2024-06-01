package com.multi.shop.product.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.multi.shop.board.model.dto.BoardDTO;
import com.multi.shop.product.model.dto.AttachmentDTO;
import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;



public class ProductDAO { 
	
	


	public ProductDAO() {
		
	}
	
	public ArrayList selectList(SqlSession sqlSession) throws Exception{
		
		System.out.println("dao"+(ArrayList) sqlSession.selectList("productMapper.selectList"));

		return (ArrayList) sqlSession.selectList("productMapper.selectList");
	}

	public int insertProduct(SqlSession sqlSession, ProductDTO productDTO) {
		
		
		return sqlSession.insert("productMapper.insertProduct", productDTO);
	}
	
	

	// 여기 고치기
	public ArrayList  selectProduct(SqlSession sqlSession, int id) {
		
		
		
		return (ArrayList) sqlSession.selectList("productMapper.selectProduct", id);
	}

	
	
	public ArrayList<CompanyDTO> selectCompanyList(SqlSession sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList) sqlSession.selectList("productMapper.selectCompanyList");
	}

	public int insertAttachment(SqlSession sqlSession, AttachmentDTO attachmentDTO) {
		
		return sqlSession.insert("productMapper.insertAttachment", attachmentDTO);
		
	}
	
	
	
	

	public int updateProduct(SqlSession session, ProductDTO updatedProduct) {
		
		
		return session.update("productMapper.updateProduct", updatedProduct);
	}

	public int updateAttachment(SqlSession session, AttachmentDTO updatedAttachment) {
		
		return session.update("productMapper.updateAttachment", updatedAttachment);
	}
	
	
	
	

	public ArrayList selectAttList(SqlSession sqlSession, int productId) {
		
		return (ArrayList) sqlSession.selectList("productMapper.selectAttachment", productId);
	}

	public ProductDTO selectProduct2(SqlSession sqlSession, int pid) {
		
		return sqlSession.selectOne("productMapper.selectProduct", pid);
	}

	public ArrayList selectSearchList(SqlSession sqlSession, ProductDTO productDTO) {
		
		System.out.println("여기임 ㅠㅠ"+(ArrayList) sqlSession.selectList("productMapper.selectSearchList",productDTO));
		
		return (ArrayList) sqlSession.selectList("productMapper.selectSearchList",productDTO);
	}

	public int deleteProduct(SqlSession sqlSession, int productId) {
		
		return sqlSession.delete("productMapper.deleteProduct", productId);
	}

	public int deleteAttachment(SqlSession sqlSession, int productId) {
		
        return sqlSession.delete("productMapper.deleteAttachment", productId);
	}


}

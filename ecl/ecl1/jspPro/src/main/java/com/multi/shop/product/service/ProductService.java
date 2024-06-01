package com.multi.shop.product.service;

import java.util.ArrayList;
import java.util.List;

import com.multi.shop.board.model.dto.BoardDTO;
import com.multi.shop.product.model.dto.AttachmentDTO;
import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;

public interface ProductService{

	ArrayList<ProductDTO> selectList() throws Exception;

	ArrayList selectProduct(int id) throws Exception;

	ArrayList<CompanyDTO> selectCompanyList() throws Exception;

	int insertProduct(ProductDTO productDTO) throws Exception;

	int updateProduct(ProductDTO newProduct) throws Exception;

	List<AttachmentDTO> selectAttachments(int productId) throws Exception;
	
	ProductDTO selectProduct2(int pid) throws Exception ;

	ArrayList<ProductDTO> selectSearchList(ProductDTO productDTO) throws Exception;

	int deleteProduct(int productId) throws Exception;

	
	
	
	
	// ctrl shift o : import

}

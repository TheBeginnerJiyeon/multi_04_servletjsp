package com.multi.shop.board.service;

import java.util.ArrayList;

import com.multi.shop.board.model.dto.BoardDTO;

public interface BoardService {

	ArrayList<BoardDTO> selectList() throws Exception ;
    BoardDTO selectBoard(int bno)throws Exception ;
	int insertBoard(BoardDTO newBoard)throws Exception;
	int updateBoard(BoardDTO boardDTO) throws Exception;
	int deleteBoard(BoardDTO boardDTO) throws Exception;
	
	
	
	
	
	// ctrl shift o : import

}

package com.multi.shop.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.multi.shop.board.model.dto.BoardDTO;



public class BoardDAO { 


	public BoardDAO() {
		
	}
	
	public ArrayList<BoardDTO> selectList(SqlSession sqlSession) throws Exception{
		

		return (ArrayList)sqlSession.selectList("boardMapper.selectList");
	}


	public int updateCount(SqlSession sqlSession, int no) throws Exception{
		
		return sqlSession.update("boardMapper.updateCount", no);
	}

	
	public BoardDTO selectBoard(SqlSession sqlSession, int bno) throws Exception{
		
		return sqlSession.selectOne("boardMapper.selectBoard", bno);
	}

	public int insertBoard(SqlSession sqlSession, BoardDTO newBoard) {
		
		return sqlSession.insert("boardMapper.insertBoard", newBoard);
	}

	public int updateBoard(SqlSession sqlSession, BoardDTO boardDTO) {
		
		System.out.println(boardDTO.getContent());
		System.out.println(boardDTO.getNo());
		
		return sqlSession.insert("boardMapper.updateBoard", boardDTO);
		
	}

	public int deleteBoard(SqlSession sqlSession, BoardDTO boardDTO) {
		
		
		return sqlSession.delete("boardMapper.deleteBoard", boardDTO);
	}
}

package com.multi.shop.board.service;

import static com.multi.shop.common.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.multi.shop.board.model.dao.BoardDAO;
import com.multi.shop.board.model.dto.BoardDTO;

public class BoardServiceImpl implements BoardService{
	
	private BoardDAO boardDao = new BoardDAO();

	@Override
	public ArrayList<BoardDTO> selectList() throws Exception {
		// TODO Auto-generated method stub
		
		
		SqlSession sqlSession = getSqlSession();
		ArrayList<BoardDTO> list = boardDao.selectList(sqlSession);
		sqlSession.close();
		
		return list;
	}

	@Override
	public BoardDTO selectBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSession();

		int result = boardDao.updateCount(sqlSession, bno);
		
		BoardDTO b = null;
		if(result > 0) {
			sqlSession.commit();
			b = boardDao.selectBoard(sqlSession, bno);
			
		}else {
			sqlSession.rollback();
			throw new Exception();
		}
		sqlSession.close();
		
		return b;
	}

	@Override
	public int insertBoard(BoardDTO newBoard) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSession();

		int result = boardDao.insertBoard(sqlSession, newBoard);
		
		
		if(result > 0) {
			System.out.println("글 쓰기 성공...");
			sqlSession.commit();
			
			
		}else {
			System.out.println("글 쓰기 실패....");
			sqlSession.rollback();
			throw new Exception();
		}
		sqlSession.close();
		
		return result;
	}

	@Override
	public int updateBoard(BoardDTO boardDTO) throws Exception {
		
		SqlSession sqlSession = getSqlSession();

		int result = boardDao.updateBoard(sqlSession, boardDTO);
		
		
		if(result > 0) {
			System.out.println("글 쓰기 성공...");
			sqlSession.commit();
			
			
		}else {
			System.out.println("글 쓰기 실패....");
			sqlSession.rollback();
			throw new Exception();
		}
		sqlSession.close();
		
		
	
		return result;
		
		
	}

	@Override
	public int deleteBoard(BoardDTO boardDTO) throws Exception {
		SqlSession sqlSession = getSqlSession();

		int result = boardDao.deleteBoard(sqlSession, boardDTO);
		
		
		if(result > 0) {
			System.out.println("글 삭제 성공...");
			sqlSession.commit();
			
			
		}else {
			System.out.println("글 삭제 실패....");
			sqlSession.rollback();
			throw new Exception();
		}
		sqlSession.close();
		
		
	
		return result;
	}


	
	
	
}

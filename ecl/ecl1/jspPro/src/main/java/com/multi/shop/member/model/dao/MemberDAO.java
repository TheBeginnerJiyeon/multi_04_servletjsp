package com.multi.shop.member.model.dao;



import org.apache.ibatis.session.SqlSession;


import com.multi.shop.member.model.dto.MemberDTO;

public class MemberDAO {
	// memberMapper, insertMember
	

	public MemberDAO() {
			
		}

	
	public MemberDTO selectMember(SqlSession sqlSession, String id) throws Exception {

		return sqlSession.selectOne("memberMapper.selectMember", id);
	}

	public int insertMember(SqlSession sqlSession, MemberDTO memberDTO) throws Exception{

		return sqlSession.insert("memberMapper.insertMember", memberDTO);
	}


	public String selectEncryptedPwd(SqlSession sqlSession, MemberDTO memberDTO) {
		
		
		return sqlSession.selectOne("memberMapper.selectEncryptedPwd", memberDTO);
		
	}


	public MemberDTO selectloginMember(SqlSession sqlSession, MemberDTO memberDTO) {
		
		return sqlSession.selectOne("memberMapper.selectLoginMember", memberDTO);
		
	}

}

package com.multi.shop.member.service;


import static com.multi.shop.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.multi.shop.member.model.dao.MemberDAO;
import com.multi.shop.member.model.dto.MemberDTO;

public class MemberServiceImpl implements MemberService{
	
	// 공부하면서 주석 아주 세세하게 달기!!!!
	private final MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		
		
		memberDAO = new MemberDAO();
		
	}
	
	
	public MemberDTO selectMember(String id) throws Exception {
		
		SqlSession sqlSession = getSqlSession();

		
		MemberDTO memberDTO = memberDAO.selectMember(sqlSession, id);
			
		sqlSession.close();
		
		return memberDTO;
	}

	@Override
	public int insertMember(MemberDTO memberDTO) throws Exception {
		
		// 세션연결
		SqlSession sqlSession = getSqlSession();

		// 다오 메서드 호출
		int result = memberDAO.insertMember(sqlSession, memberDTO);
		
			
		// 결과에 따라 커밋 / 롤백
		
		if (result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		// 결과값 리턴
		return result;
		
	}


	@Override
	public MemberDTO loginCheck(MemberDTO memberDTO) throws Exception {
		
		SqlSession sqlSession = getSqlSession();
		
		
		

		MemberDTO loginMemberDTO=null;
		/* 로그인 요청한 원문 비밀번호화 저장되어있는 암호화된 비밀번호가 일치하는지 확인한다. 
		 * //matches(평문, 암호화) -> true, false 반환
		 * */
		
		String encPwd = memberDAO.selectEncryptedPwd(sqlSession, memberDTO);
		System.out.println("encPwd: " + encPwd);
		System.out.println("입력된 비밀번호" + memberDTO.getPw());
		
		
		// 비밀번호도 일치하는 지 확인해야 함..
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();	
		
		
		boolean result = passwordEncoder.matches(memberDTO.getPw(), encPwd);
		
		if (result) {
			loginMemberDTO = memberDAO.selectloginMember(sqlSession, memberDTO);
		}else {
			
		}
		
		
		
		
		
		sqlSession.close();
		
		return loginMemberDTO;
		
		
		
		
		
		
	}
	
	


	
	
	
}

package com.multi.shop.member.service;

import com.multi.shop.member.model.dto.MemberDTO;

public interface MemberService {


    MemberDTO selectMember(String id) throws Exception ;
	int insertMember(MemberDTO memberDTO) throws Exception;
	MemberDTO loginCheck(MemberDTO memberDTO) throws Exception;
	
	
	
	
	
	// ctrl shift o : import

}

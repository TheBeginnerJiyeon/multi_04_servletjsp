package com.multi.shop.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptRequestWrapper extends HttpServletRequestWrapper {
	
	/* 부모쪽에 기본생성자가 존재하지 않기 때문에 request를 전달해주는 생성자가 필요하다. */
	public EncryptRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		System.out.println("getParameter : "+ key);
		String value = "";
		if("pw".equals(key)) {
			// 스프링 시큐리티중 BCrypt 암호화를 제공해주는 라이브러리를 추가한 후 암호화 처리
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key)); 
			//encode 메소드는 비밀번호에 솔트를 자동으로 추가하고, 결과적으로 생성된 해시 값을 반환
			System.out.println(value);
		} else {
			value = super.getParameter(key);
		}
		
		return value;
	}
	

}

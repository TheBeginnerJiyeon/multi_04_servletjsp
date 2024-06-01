package com.multi.shop.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		
		try {
			InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml");
			
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlSession;
	}
	
	
	

}

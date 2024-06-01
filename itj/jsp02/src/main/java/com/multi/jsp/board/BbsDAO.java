package com.multi.jsp.board;


import com.multi.jsp.common.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BbsDAO { // member테이블에 crud를 하고 싶으면 MemberDAO를 사용하면 됨.!
	Connection con = null; // 클래스 바로 아래에 만들어주면 클래스 전체영역에서 사용 가능
	DBConnectionMgr dbcp; // null

	public BbsDAO() {
		try {
			dbcp = DBConnectionMgr.getInstance();
			con = dbcp.getConnection();// 임대
		} catch (Exception e) {
			System.out.println("에러발생!!");
		}
	}
	
	public BbsDTO one(int no) {
		BbsDTO bbsDTO = new BbsDTO();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String sql = "select * from board where no = ? ";
			ps = con.prepareStatement(sql); //

			ps.setInt(1, no); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			rs = ps.executeQuery(); //테이블로 mysql로 받아온다. 
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
			//System.out.println(table.next()); //table안에 데이터가 있으면 true
			if(rs.next()) { //table안에 검색결과인 row가 있는지 체크 
				int no2 = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				//JOptionPane.showMessageDialog(null, title + " " + "");
				System.out.println(no2);
				System.out.println(title);
				System.out.println(content);
				System.out.println(writer);
				bbsDTO.setNo(no2);
				bbsDTO.setTitle(title);
				bbsDTO.setContent(content);
				bbsDTO.setWriter(writer);
			}else {
				System.out.println("검색결과가 없음.");
			}
			
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}finally {
			dbcp.freeConnection(con, ps, rs);//반납 
		}
		
		return bbsDTO;
	} // one

	
	public int delete(int no) {
		
		PreparedStatement ps = null;
		int result = 0; 
		try {
			String sql = "delete from board where no = ?";
			ps = con.prepareStatement(sql); //
			ps.setInt(1, no); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			result = ps.executeUpdate();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}finally {
			dbcp.freeConnection(con, ps);//반납 
		}
		return result;
	} // delete

	public int insert(BbsDTO bbsDTO) {
		// Java-DB연결 (JDBC) 4단계
		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		int result = 0;
		PreparedStatement ps = null;
		try {
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into board ( CATEGORY_CODE, TITLE, CONTENT, WRITER)  values (?, ?, ?, ?)";
			System.out.println(bbsDTO);
			ps = con.prepareStatement(sql); //
			ps.setInt(1, bbsDTO.getCategory());
			ps.setString(2, bbsDTO.getTitle()); // 물음표 번호 1번에 title에 저장한 변수값을 넣어줘!
			ps.setString(3, bbsDTO.getContent()); // 물음표 번호 2번에 content에 저장한 변수값을 넣어줘!
			ps.setString(4, bbsDTO.getWriter()); // 물음표 번호 3번에 writer에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			// URL site = new URL(site);

			// 4. 3번에서 생성된 sql문을 Mysql로 전송
			result = ps.executeUpdate();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}finally {
			dbcp.freeConnection(con, ps);//반납 
		}
		return result;
	} // insert

	public int update(String title, String content, int no) {
		// Java-DB연결 (JDBC) 4단계
		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		int result = 0;
		PreparedStatement ps = null;
		try {
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "update board set title = ?, content = ? where no = ?";
			ps = con.prepareStatement(sql); //
			ps.setString(1, title); 
			ps.setString(2, content); 
			ps.setInt(3, no); //where no = 3 
			System.out.println("3. sql문 생성 성공!!");

			// URL site = new URL(site);

			// 4. 3번에서 생성된 sql문을 Mysql로 전송
			result = ps.executeUpdate();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}finally {
			dbcp.freeConnection(con, ps);//반납 
		}
		return result;
	} // update

} // class

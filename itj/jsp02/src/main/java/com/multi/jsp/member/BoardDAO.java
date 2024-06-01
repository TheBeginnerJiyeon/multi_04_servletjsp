package com.multi.jsp.member;


import com.multi.jsp.common.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO { // member테이블에 crud를 하고 싶으면 MemberDAO를 사용하면 됨.!
	// DAO : db access object
	// shop db member table에
	// 접근해서 처리하는 객체
	Connection con = null; //클래스 바로 아래에 만들어주면 클래스 전체영역에서 사용 가능
	//전역변수(글로벌 변수)
	DBConnectionMgr dbcp; //null
	//new를 이용해서 객체생성시 클래스이름과 동일한 메서드가 있으면 자동실행
	//다른 클래스에서 MemberDAO dao = new MemberDAO();
	//생성자에 private을 붙여놓으면 외부 자바파일에서 객체생성불가능!
	//private MemberDAO() {
	public BoardDAO() {
		// 객체생성시 자동호출되는 메서드 == 생성자 (메서드), constructor
		// jdbc1-2단계 
		try {
			dbcp = DBConnectionMgr.getInstance();
			con = dbcp.getConnection();//임대 
            System.out.println(con);

		} catch (Exception e) {
			System.out.println("에러발생!!");
		}
	}
	
	
	public ArrayList<BoardDTO> list() {
//		int result = 0;
		ArrayList<BoardDTO> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from board";
			ps = con.prepareStatement(sql); //
			System.out.println("3. sql문 생성 성공!!");

			rs = ps.executeQuery(); // 테이블로 mysql로 받아온다.
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
			while(rs.next()) { // table안에 검색결과인 row가 있는지 체크
				//1. 가방을 만들자. 
				//2. table에서 한행씩 꺼내서 가방에 넣자.
				//3. 데이터가 들어있는 가방을 list에 넣자.
				
				String no = rs.getString("no");
				String categoryCode = rs.getString("category_code");
				// id는 컬럼명
				String title = rs.getString("title");
				String content  = rs.getString("content");
				String writer = rs.getString("writer");
				
				
				BoardDTO bag = new BoardDTO();
				bag.setNo(no);
				bag.setCategoryCode(categoryCode);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
				list.add(bag);
			} 
			
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}finally {
			dbcp.freeConnection(con, ps, rs);//반납 
		}

		return list;
	} // list

	public BoardDTO one(String no) {
//		int result = 0;
		BoardDTO bag = new BoardDTO();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from board where no = ? ";
			ps = con.prepareStatement(sql); //
			ps.setString(1, no); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			rs = ps.executeQuery(); // 테이블로 mysql로 받아온다.
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
			// System.out.println(table.next()); //table안에 데이터가 있으면 true
			if (rs.next()) { // table안에 검색결과인 row가 있는지 체크
				String no2 = rs.getString("no");
				String categoryCode = rs.getString("category_code");
				// id는 컬럼명
				String title = rs.getString("title");
				String content  = rs.getString("content");
				String writer = rs.getString("writer");
				bag.setNo(no2);
				bag.setCategoryCode(categoryCode);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
			} else {
				System.out.println("검색결과가 없음.");
			}
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}finally {
			dbcp.freeConnection(con, ps, rs);//반납 
		}
		return bag;
	} // one

	public int delete(String no) {
		PreparedStatement ps = null;
		int result = 0;
		try {
			String sql = "delete from board where no = ? ";
			ps = con.prepareStatement(sql); //
			ps.setString(1, String.valueOf(no)); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			result = ps.executeUpdate();
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
			dbcp.freeConnection(con, ps);
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}finally {
			dbcp.freeConnection(con, ps);//반납 
		}
		return result;
	} // delete

	public int insert(BoardDTO boardDTO) {
		PreparedStatement ps = null;

		// Java-DB연결 (JDBC) 4단계
		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		int result = 0;
		try {
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into board(CATEGORY_CODE, TITLE, CONTENT, WRITER) values (?, ?, ?, ?)";

			ps = con.prepareStatement(sql); //
			ps.setString(1, boardDTO.getCategoryCode()); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			ps.setString(2, boardDTO.getTitle()); // 물음표 번호 2번에 pw에 저장한 변수값을 넣어줘!
			ps.setString(3, boardDTO.getContent()); // 물음표 번호 3번에 name에 저장한 변수값을 넣어줘!
			ps.setString(4, boardDTO.getWriter()); // 물음표 번호 3번에 tel에 저장한 변수값을 넣어줘!
			System.out.println("3. sql문 생성 성공!!");

			// URL site = new URL(site);

			// 4. 3번에서 생성된 sql문을 Mysql로 전송
			result = ps.executeUpdate();// int
			System.out.println("4. SQL문 mySQL로 전송 성공!!");
			
			
		} catch (Exception e) { // Exception == Error
			e.printStackTrace();// 에러정보를 추적해서 프린트해줘.!
			System.out.println("에러발생함.!!!!");
		}finally {
			dbcp.freeConnection(con, ps);//반납 
		}
		return result;
	} // insert

	public int update(String title, String content, String no) {
		PreparedStatement ps = null;
		// Java-DB연결 (JDBC) 4단계
		// 1. 연결할 부품(커넥터, driver, 드라이버) 설정
		int result = 0;
		try {
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "update board set title = ?, content=?   where no = ? ";
			ps = con.prepareStatement(sql); //
			ps.setString(1, title); // 물음표 번호 1번에 id에 저장한 변수값을 넣어줘!
			ps.setString(2, content); // 물음표 번호 2번에 pw에 저장한 변수값을 넣어줘!
			ps.setString(3, String.valueOf(no)); // 물음표 번호 2번에 pw에 저장한 변수값을 넣어줘!
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

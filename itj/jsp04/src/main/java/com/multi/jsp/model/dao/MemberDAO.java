package com.multi.jsp.model.dao;


import com.multi.jsp.model.dto.MemberDTO;

import java.sql.*;
import java.util.ArrayList;

//import 화면DB연결.MemberVO;
// jsp 데이터베이스가 안만들어져서 scott로 했음...
/*String url = "jdbc:mysql://localhost:3306/scott?";
String user = "scott";
String password = "tiger"; 여기 다 jsp로 고치기*/

public class MemberDAO { // CRUD

	public int insertMembers(ArrayList<MemberDTO> members) {

		// 1. 가방을 받아서 변수에 넣어주세요.
		PreparedStatement ps  = null;
		Connection conn = null;
		// 결과 처리
		int successCount = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공.");
			// Locale.setDefault(Locale.US); // 맥 locale에러나신 분들만!!!

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/scott?";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. mySQL 연결 성공.");
			conn.setAutoCommit(false); // 트랜잭션 시작


			String sql = "insert into member3 values (?, ?, ?, ?)";
			ps = conn.prepareStatement(sql); // PreparedStatement

			for (MemberDTO member : members) {
				ps.setString(1, member.getId());
				ps.setString(2, member.getName());
				ps.setString(3, member.getEmail());
				ps.setString(4, member.getAddress());
				ps.addBatch(); // 배치에 추가
			}

			int[] results = ps.executeBatch();

			for (int res : results) {
				if (res == ps.SUCCESS_NO_INFO || res > 0) {
					successCount++;
				} else if (res == ps.EXECUTE_FAILED) {
					throw new Exception("EXECUTE_FAILED");
				}
			}

			if(successCount == members.size()){
				System.out.println("성공한 작업 수: " + successCount);
				conn.commit();
			}

			// System.out.println(result);
		} catch (Exception e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 롤백
			}
			System.err.println("배치 작업 실패: " + e.getMessage());
		} 	finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return successCount;
	}

	public ArrayList<MemberDTO> selectMemberList() {
		// 1. 가방을 받아서 변수에 넣어주세요.

		// 가방들 넣어줄 큰 컨테이너 역할을 부품이 필요!
		// ArrayList<MemberVO> ==> MemberVO만 들어간 arraylist라는 의미
		ArrayList<MemberDTO	> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps  = null;
		ResultSet rs = null;
		// 결과 처리
		int successCount = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공.");
			// Locale.setDefault(Locale.US); // 맥 locale에러나신 분들만!!!

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. mySQL 연결 성공.");
			conn.setAutoCommit(false); // 트랜잭션 시작

			String sql = "select * from member3";
			ps = conn.prepareStatement(sql); // PreparedStatement

			rs = ps.executeQuery(); // select문 전송시
			
			
			while (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				// true이면 있다라는 의미, false이면 없다라는 의미
				// 1. 검색겨로가가 있으면,
				// System.out.println("검색결과 있음. 성공.");
				// 2. 각 컬럼에서 값들을 꺼내오자.
				// System.out.println( id2 + " "
//									+ pw + " " 
//									+ name + " " 
//									+ tel);
				// 검색결과를 검색화면 UI부분을 주어야 함.
				// 3. 가방을 만들자.
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				System.out.println(rs.getString("id"));
				// 4. list에 bag을 추가해주자.
				list.add(dto);
			}
		} catch (Exception e) {
		
		} finally {
			try {
				ps.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}

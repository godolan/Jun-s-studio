package t2_Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest2 {
	Connection conn = null;
	Statement stmt = null;
	String sql = "";
	ResultSet rs = null;
	
	@SuppressWarnings("static-access")
	public DbTest2() {
				
				
		try {
			getClass().forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/works";
			String user = "green";
			String password = "1234";
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~");
		} catch (Exception e) {
		System.out.println("데이터베이스 연동 실패~~");
		}
	}	
		
	public void dbClose() {
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	//전체 자료 검색
	
	public void dbSearch() {
		try {
		stmt = conn.createStatement();
		//stmt.executeQuery("select * from test1");
		sql = "select * from test1";
		rs = stmt.executeQuery(sql);
		System.out.println("SQL문 성공적으로 처리됨..");
		System.out.println("=======================");
		
		//검색한 자료 조회 유무??
		while(true) {	// 1건의 자료라도 있으며 수행한다.
			if(rs.next()) {
			
			
			int idx = rs.getInt("idx");
			String mid = rs.getString("mid");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			
			System.out.println("일련번호 : " + idx);
			System.out.println("아이디 : " + mid);
			System.out.println("비밀번호 : " + pwd);
			System.out.println("성명 : " + name);
			System.out.println("나이 : " + age);
			System.out.println("=======================");
			}
			else {
				System.out.println("검색한 자료가 없습니다.");
				break;
			}
		}
		
		
	} catch (SQLException e) {
		System.out.println("SQL 오류 "+ e.getMessage());
		e.printStackTrace();
	}
	}
}

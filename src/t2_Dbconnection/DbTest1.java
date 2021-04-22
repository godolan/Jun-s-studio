package t2_Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest1 {
	Connection conn = null;
	Statement stmt = null;
	String sql = "";
	ResultSet rs = null;
	
	@SuppressWarnings("static-access")
	public DbTest1() {
				
				
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
	
	//개별자료 검색
	public void dbSearch() {
		try {
		stmt = conn.createStatement();
		//stmt.executeQuery("select * from test1 where name = '홍길동'");
		sql = "select * from test1 where name = '홍길동'";
		rs = stmt.executeQuery(sql);
		System.out.println("SQL문 성공적으로 처리됨..");
		System.out.println("=======================");
		
		//검색한 자료 조회 유무??
		if(rs.next()) {	//'홍길동을 찾았다.
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
			
		}
		else {
			System.out.println("검색한 자료가 없습니다.");
		}
		
		
	} catch (SQLException e) {
		System.out.println("SQL 오류 "+ e.getMessage());
		e.printStackTrace();
	}
	}
}

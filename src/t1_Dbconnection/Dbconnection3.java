package t1_Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection3 {
	Connection conn = null;
	public Dbconnection3() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공!");
			
			//DriverManager.getConnection("jdbc:mysql://localhost:3306/works", "green", "1234");
			String url = "jdbc:mysql://localhost:3306/works";
			String user = "green";
			String password = "1234";
			
			
			//4. connection 객체를 사용할 준비(앞으로는 connection 객체를 conn이란 이름으로 사용하겠다.)
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("데이터베이스 연결 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 연결 실패~~");
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패~~");
		} 
		
	}
	//5. Database Close
	public void dbclose() {
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {} 
	}
}

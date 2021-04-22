package t1_Dbconnection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	public Dbconnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공!");
			
			DriverManager.getConnection("jdbc:mysql://localhost:3306/works", "green", "1234");
			System.out.println("데이터베이스 연결 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 연결 실패~~");
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패~~");
		}
	}

}

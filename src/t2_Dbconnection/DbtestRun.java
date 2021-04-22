package t2_Dbconnection;

public class DbtestRun {
	public static void main(String[] args) {
		
		//DB연결(드라이버 검색 성공 + DB연동성공)
		DbTest1 dbTest1 = new DbTest1();
		//DB에서의 Table 작업 (ex: test1 테이블에서 '홍길동' 검색)
		dbTest1.dbSearch();
		
		dbTest1.dbClose();
		
	}
}

package t2_Dbconnection;

public class DbtestRun2 {
	public static void main(String[] args) {
		
		//DB연결(드라이버 검색 성공 + DB연동성공)
		DbTest2 dbTest2 = new DbTest2();
		//DB에서의 Table 작업 (ex: test1 테이블에서 '홍길동' 검색)
		dbTest2.dbSearch();
		
		dbTest2.dbClose();
		
	}
}

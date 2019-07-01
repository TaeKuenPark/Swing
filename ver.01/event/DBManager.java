package event;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/* 데이터 베이스를 관리하는 매니저 */
public class DBManager {
							/* 주의점!
							 * 현재 사용하는 데이터 베이스 : mariaDB(Mysql)
							 * dbName : 데이터베이스 명을 받는다
							 * dbId	  : 데이터베이스 계정명을 받는다 
							 * dbPw   : 데이터베이스 현재 패스워드를 받는다
							 * - 한가지라도 틀리면 오류가 발생하므로 주의(또한, mariaDB의 JDBCjar파일이 없어도 오류이니 주의)*/
	private String className = "org.mariadb.jdbc.Driver";
	private String dbName = "practice";
	private String dbInfo = "jdbc:mariadb://127.0.0.1:3306/"+dbName;
	private String dbId = "root";
	private String dbPw = "root";

	DBConnection db = new DBConnection();										// 데이터 베이스를 연결하는 메소드
	
	public ArrayList<String> loadDB() {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		ArrayList<String> tmp = new ArrayList<String>();
		 String sql, tableLength;
		 int length;
		 
		 tableLength = " SELECT COUNT(*) as count FROM TB_SENTANCE ";			// 테이블의 단어갯수(튜플개수)를 불러오는 문장
		
		 try {
			 con = db.DBConnect(className, dbInfo, dbId, dbPw);					// 데이터 베이스를 연결
			 ps= con.prepareStatement(tableLength);								// 길이를 저장
			 rs= ps.executeQuery();												// sql문 실행
			 rs.next();															// 값을 변환
			 length =rs.getInt("count");										// 변환된 값을 길이 변수에 툴력
			 //System.out.println(length);
			 new Close(ps, rs);													// sql문 종료 메소드
			 																	// stmt, rs를 닫는 메소드를 불러온다.
			  for (int i = 1; i <= length; i++) {								// 한줄씩 sql문으로 1번부터 문장을 가져온다.
				 sql = "	SELECT * " +
						 " FROM TB_SENTANCE " +
						 " WHERE no = " + i;
			 
			  ps= con.prepareStatement(sql);									// sql문 입력
			  rs= ps.executeQuery();											// sqp문 실행
			  rs.next();														// 값을 변환
			  
			  tmp.add(rs.getString("sentance"));								// 반복문에 따라 가져온 문장을 하나씩 ArrayList에 넣는다
			  //System.out.println(tmp);
			  new Close(ps, rs);												// 한문장 입력이 종료되면 데이터 베이스 닫음
			  }
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		
		 return tmp;															// 모두 입력한 문장ArrayList를 출력
	}
}

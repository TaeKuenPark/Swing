package event;

import java.sql.*;

/* 데이터 베이스 닫기 이벤트*/
public class Close {

	public  Close(Connection con, PreparedStatement ps, ResultSet rs) {
														// db 전체 닫기
		try {
			con.close();
			ps.close();
			rs.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public Close(PreparedStatement ps, ResultSet rs) {
														// db의 stmt, resultset만 닫는다
		try {
			ps.close();
			rs.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Close(Connection con) {
														// 각각 닫는 기능
		try {
			
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Close(PreparedStatement ps) {
		
		try {
			ps.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Close(ResultSet rs) {
		try {
			rs.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

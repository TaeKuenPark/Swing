package event;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBConnection {

	public Connection DBConnect(String className, String dbInfo, String dbId, String dbPw) {				// 데이터 베이스 연결 메소드
		
		Connection con = null;
	
	try {
		Class.forName(className);	// org.?.jdbc.Driver
													// ?(데이터베이스명)을 jdbcDriver로 불러온다.
		
		con = DriverManager.getConnection(			// 해당 데이터베이스 현결
				dbInfo,dbId,dbPw);
		
		if(con ==null) 
			JOptionPane.showMessageDialog(null, "데이터 베이스가 연결되지 않았습니다!");	// 작동 확인
		
	} catch(Exception e) {
		e.printStackTrace();
	} 
	return con;
}
}

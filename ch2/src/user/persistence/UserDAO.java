package user.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.net.httpserver.Authenticator.Result;

import user.domain.UserDTO;

public class UserDAO {
	
	//드라이버 로드
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//커넥션 생성
	public Connection getConnection() {
		
		//database 서버주소, port 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##java";
		String password = "12345";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//login (select 구문 걸어줘야해)
	//login 이 성공하면 userid와 name을 리턴하고 싶어
	//자바는 하나만 리턴할 수 있어 두개는 못해
	//userid와 namee을 가진 DTO객체를 리턴하면돼!!
	public UserDTO isLogin(String userid, String password) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO dto = null;
		
		try {
			con = getConnection();
			String sql = "select userid, name from member where userid = ? and password = ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new UserDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
}

package pattern.service;

import java.sql.Connection;

import pattern.domain.MemberDTO;
import pattern.persistence.MemberDAO;

import static pattern.persistence.JdbcUtil.*;

public class LoginService {
	public MemberDTO loginService(String userid, String password) {
		
		//db작업 => 비즈니스 로직을 구성한다고 얘기해(모델)
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		MemberDTO loginDto = dao.login(new MemberDTO(userid, password));
		//로그인디티오에는 유저아이디와 이름을 가진 객체가 들어올거야
		
		
		return loginDto;
		//그걸 리턴
	}
}

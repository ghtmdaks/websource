package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.service.LoginService;

@AllArgsConstructor
public class LoginAction implements Action {
	
	private String path;

	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		// 사용자의 입력값 가져이기
		// 이페이지로 넘어오는 사용자의 입력값이 뭐냐?
		// login form에서 userid , password가 넘어올거야
		String userid = request.getParameter("userid");
		String password = request.getParameter("current_password");
		
		// db 작업 을 service한테 부탁할거야
		LoginService service = new LoginService();
		//내가 가지고 있는 아이디랑 패스워드를 로그인서비스로 넘겨줘야해
		MemberDTO loginDto = service.loginService(userid, password);
		
		if(loginDto != null) {

			HttpSession session = request.getSession();
			session.setAttribute("loginDto", loginDto);
		}
		
		return new ActionForward(path, true);
	}

}

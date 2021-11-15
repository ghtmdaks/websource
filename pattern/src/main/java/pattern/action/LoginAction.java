package pattern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pattern.domain.MemberDTO;
import pattern.service.LoginService;

@AllArgsConstructor
@Getter
public class LoginAction implements Action {
	
	private String path; //로그인액션에서 /index.jsp가 담겨

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// 사용자가 넘기는 값 가져오기
//		String no = request.getParameter("no");
//		System.out.println("no" + no);
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		// 서비스 작업 호출
		LoginService service = new LoginService();
		MemberDTO loginDto = service.loginService(userid,password);
		
		//결과에 따라서 ActionForward 객체 생성
		//로그인플래그에 따라
		if(loginDto == null) {
			//로그인디티오가 널이면 실패
			
			//다시 로그인 페이지으로 보여주기
			path = "/view/login.jsp"; 
			
		}else {
			//로그인 성공하면 세션에 값을 담을거야
			HttpSession session = request.getSession();
			session.setAttribute("loginDto", loginDto);
			//세션은 어느페이지를 가도 그 값을 공유할거야
		}
		
		//true는 이동방식이야 어느방식으로가도 상관없어
		// 우리는 sendRedirect방식이야 그래서 주소줄이 그대로 보여질거야

		//로그인 실패  ActionForward("/view/login.jsp", true);
		//로그인 성공  ActionForward("/index.jsp", true);
		
		//path 안에 이동할 경로가 있어
		return new ActionForward(path, true);
	}

}

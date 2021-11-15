package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LogoutAction implements Action {

	private String path;
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		// db작업 안하고 그냥 session만 해제할거야
		HttpSession session = request.getSession();
		//세션 날리는 2개
		session.removeAttribute("loginDto");
		//loginDto만 날릴거야
		
		//session.invalidate();
			
		return new ActionForward(path, true);
	}

}

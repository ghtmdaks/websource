package member.action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import member.service.DuplicationService;

@AllArgsConstructor
public class DuplicationAction implements Action {

	private String path;
	
	@Override
	public ActionForward excute(HttpServletRequest request) throws Exception {
		// 중복 검사할 아이디 가져오기
		String userid = request.getParameter("userid");
		// 서비스 작업 요청
		DuplicationService service = new DuplicationService();
		boolean dupFlag = service.dupId(userid);
				
		request.setAttribute("dupId", dupFlag);
		
		
		return new ActionForward(path, false);
	}

}

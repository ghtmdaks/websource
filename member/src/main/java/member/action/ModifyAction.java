package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.domain.UpdateDTO;
import member.service.ModifyService;

@AllArgsConstructor
public class ModifyAction implements Action {
   private String path; ///view/loginForm.jsp 담겨져 있으니까 밑에는 막았어
   @Override
   public ActionForward excute(HttpServletRequest request) throws Exception {
	   //유저아이디는 세션에 들어 있어 그래서 그걸 가지고 와보쟝
	   HttpSession session = request.getSession();
	   MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");
	   String userid = loginDto.getUserid();
	   
	   
	   //modifyForm.jsp에서 사용자 입력값 가져오기
	   String current_password = request.getParameter("current_password");
	   String new_password = request.getParameter("new_password");
	   String confirm_password = request.getParameter("confirm_password");
	   
	   UpdateDTO updatedto = new UpdateDTO(userid, current_password, new_password, confirm_password);
	   if(updatedto.passwordEqualTo(new_password)) {
		   
		   //db 작업을 서비스에 맡기쟈
		   ModifyService service = new ModifyService();
		   boolean updateFlag = service.modify(updatedto);
	   
		   	// 결과에 따라서 페이지 이동하쟈
			if(updateFlag) {
			//세션 해제
			session.invalidate();
			//path="/view/loginForm.jsp";
			}else {
			path="/view/modifyForm.jsp";
			}
			
	   }else {
		   path="/view/modifyForm.jsp";
	   }
	   
	   return new ActionForward(path, true);
   }
}
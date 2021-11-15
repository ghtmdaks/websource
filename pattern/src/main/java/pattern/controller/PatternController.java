package pattern.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.action.Action;
import pattern.action.ActionForward;

/**
 * Servlet implementation class PatternController
 */


@WebServlet("*.do")
//끝에 do로 끝나는 모든 요청은 내가 처리하겠어
//어떤 페이지로 하던간에 한곳으로 보낼게요 .do 로만 보내주면 patternController 로 보내준대
//http://localhost:8080/hello.do
//http://localhost:8080/insert.do
public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청이 걸리면 항상 첫번째는 한글처리
		request.setCharacterEncoding("utf-8");
		
		//어디서 요청이 왔는지를 확인하는 작업이 필요해
		//모든 요청은 서블릿으로 빼니까 우리는 어디서 요청이 왔는지 파악이 필요해=>주소줄을 분석하면돼
		String requestUri = request.getRequestURI(); //=>주소줄을 가져와라
		String contextPath = request.getContextPath();
		String cmd = requestUri.substring(contextPath.length());
		
		//요청에 따라서 일을 시킬거야 사용자가 인서트(회원가입)해달라고하면 인서트(회원가입)를 담당하는 클래스를 찾아주면돼
		//다른 클래스에서 다른 클래스 메소드 생성
		//요청에 따라 해당 Action 생성
		//new는 안된다고 했어 그래서 getInstance로 하기로 했지
		ActionFactory af = ActionFactory.getInstance();
		//action 메소드를 쓰고싶어서 액션팩토리를 썼어
		Action action = af.action(cmd);
		// ㄴ 로그인 액션이 ㄷ ㅏㅁ길거야
		
		ActionForward actionForward=null;
		try {
			//생성된 Action 에게 일을 시킬거야 
			//그리고 그 일이 끝난 후에 결과를 ActionForward객체로 넘겨 받을거야
			actionForward = action.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		//로그인 실패  ActionForward("/view/login.jsp", true);
		//로그인 성공  ActionForward("/index.jsp", true);
		
		
		//넘겨받은 ActionForward가 가지고 있는 값에 따라서 페이지를 이동하는 작업을 여기서 시킬거야
		//Controller 작성
		//true 냐?
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getPath());
			
		//false 냐 forword로 움직이려면 이 코드를 써야해
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(actionForward.getPath());
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

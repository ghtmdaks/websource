package pattern.controller;


import pattern.action.Action;
import pattern.action.LoginAction;

public class ActionFactory {
	private static ActionFactory af;
	
	/*
	 * 객체 생성을 하나만 하는 방식 (singleton 패턴) 
	 * public BookDTO(){} => 외부에서 객체 생성시 무한정 만들어짐 계속
	 * new 해서 만들수가 있엉 
	 * private BookDTO(){} => 외부에서 객체 생성을 못해 그러면은 이 클래스가 의미가 있냐 이거지
	 * 						  아무 의미가 없어 그래서 어떻게 하냐
	 * 						  getInstance라는 메소드를 만드는 거지
	 * 						  객체를 계속 생성하면 힙이라느 메모리에 계속 쌓여
	 * 						  그래서 하나만 열어놓고 쓰는거야
	 * 나는 뭔가 객체를 생성할건데 하나만 통해서 객체 생성할거고 무한정 생성할게 아니라 하나만 만들어서
	 * 너한테 보내줄게가 싱글톤패턴이야
	 */
	
	private ActionFactory()	{}
	public static ActionFactory getInstance() {
		if(af == null) {
			//널일 경우에만 만들고
			af = new ActionFactory();
			//널이 아닌경우 있는 거써 이게 싱글패턴이래 
		}
		return af;
	}
	
	//원래 String msg 넘겼는데
	//이제는
	Action action = null;
	
	public Action action(String cmd){
		
		//여기에 쓰는 path들은 action 작업이 성공하면 움직일 페이지 기록
		
		if (cmd.equals("/login.do")) {
			//요청이 들어오면 액션을 하나 만들어
			//생성하면서 이동하는 방식
			action = new LoginAction("/index.jsp");
		}else if(cmd.equals("/update.do")) {
			
		}else if (cmd.equals("/index.do")) {
			
		}
		
		return action;
		//로그인 액션 리턴
	}
}

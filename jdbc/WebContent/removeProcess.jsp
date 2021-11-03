<%@page import="user.persistence.MemberDAO"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//사용자의 입력값 가져오기 아이디링 비밀번호
String userid = request.getParameter("userid");
String password = request.getParameter("password");

//db작업
Connection con = JdbcUtil.getConnection();
MemberDAO dao = new MemberDAO(con);
boolean deleteFlag = dao.delete(userid, password);

//페이지 이동
if(deleteFlag){
	JdbcUtil.commit(con);
	JdbcUtil.close(con);
	response.sendRedirect("allProcess.jsp");
}else{
	JdbcUtil.rollback(con);
	JdbcUtil.close(con);
	response.sendRedirect("selectProcess.jsp");
	//이렇게 가라고 하면 selectProcess  MemberDTO 부터 시작하잖아
	//userid랑 password는 null은 아니지만 비어있어
	//리무브 프로세스에서 실패가 났어 그래서 엘스가 들어왔어 방금전에 딜리트한거 롤백하고 커넥은 닫았어
	//그리고 셀렉트 프로세스로 이동했어 근데 저렇게 가면 아무것도 없어 그냥 이동이야 그냥 저기로 가
	//그래서 셀렉트 프로세스로 가 갔어 그래서 디비작업을 또해 근데 아무것도 없으니까 널값이 떠서 셀렉트로 간거야
}

%>
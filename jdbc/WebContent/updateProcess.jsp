<%@page import="user.persistence.MemberDAO"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//http://localhost:8080/update.jsp => updateProcess.jsp => 전체조회
//update.jsp에서 넘긴 값 가져오기
MemberDTO dto = new MemberDTO();
dto.setUserid(request.getParameter("userid"));
dto.setPassword(request.getParameter("currentPassword"));
dto.setChangePasswored(request.getParameter("changePassword"));

//db 작업
Connection con = JdbcUtil.getConnection();
MemberDAO dao = new MemberDAO(con);
boolean updateFlag = dao.update(dto);

//페이지 이동
if(updateFlag){
	//true 가 뜨면 commit
	JdbcUtil.commit(con);
	response.sendRedirect("allProcess.jsp");
}else{
	JdbcUtil.rollback(con);
	//실패하면 롤백 시키고 다시 업데이트 페이지로 보여주기
	response.sendRedirect("update.jsp");
}
%>

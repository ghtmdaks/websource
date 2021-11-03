<%@page import="java.sql.Connection"%>
<%@page import="user.persistence.MemberDAO"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@page import="user.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//http://localhost:8080/select.jsp => selectProcess.jsp => getMember.jsp
//select.jsp 에서 넘긴 값 가져오기
MemberDTO dto = new MemberDTO();
dto.setUserid(request.getParameter("userid"));
dto.setPassword(request.getParameter("password"));

//db 작업
Connection con = JdbcUtil.getConnection();
MemberDAO dao = new MemberDAO(con);
MemberDTO dto1 = dao.getRow(dto);
//dto1을 getMember에서만 쓸거야 여러개에서 쓸거면 session 한곳에서만 쓸거니까 request

JdbcUtil.close(con);

//페이지 이동
if(dto1!=null){
	request.setAttribute("dto1", dto1);
	pageContext.forward("getMember.jsp");
}else{
	response.sendRedirect("select.jsp");
}

%>
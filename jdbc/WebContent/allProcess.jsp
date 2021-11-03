<%@page import="user.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="user.persistence.MemberDAO"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//전체조회 후 페이지 이동
Connection con = JdbcUtil.getConnection();
MemberDAO dao = new MemberDAO(con);

List<MemberDTO> list = dao.getRows();
JdbcUtil.close(con);

request.setAttribute("list", list);
pageContext.forward("all.jsp");
// =>forward를 했기 때문에 주소와 보여지는 페이지가 같지 않어
//		내가 가지고 있는 리퀘스트를 (너한테줄게) 그래서 all + allProcess 로 나와

%>
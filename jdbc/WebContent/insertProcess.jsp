<%@page import="user.domain.MemberDTO"%>
<%@page import="user.persistence.MemberDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//insert.jsp에서 넘긴 값 가져오기
/* 	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email"); */
	request.setCharacterEncoding("utf-8");
	
	
	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setPassword(request.getParameter("password"));
	dto.setName(request.getParameter("name"));
	dto.setGender(request.getParameter("gender"));
	dto.setEmail(request.getParameter("email"));
	
	
	//db 작업
	//Connection 생성
	Connection con = JdbcUtil.getConnection();
	//생성된 connection을 이용해 DAO 객체 생성
	MemberDAO dao = new MemberDAO(con);
	boolean insertFlag = dao.insert(dto);
	
	//db작업 결과에 따라 페이지 이동
	
	//입력성공
	if(insertFlag){
		response.sendRedirect("allProcess.jsp");
		JdbcUtil.commit(con);		
		
	//입력실패
	}else{
		JdbcUtil.rollback(con);
		response.sendRedirect("insert.jsp");
	}
%>
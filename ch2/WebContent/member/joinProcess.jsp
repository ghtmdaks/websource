<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//join.jsp에서 로그인 값 가져오기

String userid = request.getParameter("userid");
String password = request.getParameter("password");
String passwordCheck = request.getParameter("passwordCheck");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
String email = request.getParameter("email");



%>
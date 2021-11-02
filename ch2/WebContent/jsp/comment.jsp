<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- jsp 주석 사용자한테 안보여주고 싶을때--%>
<!-- html 주석 사용자가 보여져도 상관 없을 때-->
<body>
<% 	//1~10까지 출력
	for(int i=1; i<11; i++){
		//화면에 출력해줘 i를 엔터
		out.print(i+"<br>");
	}
%>
<div>
	<a href="sendRedirect.jsp">이동</a> 
	<a href="main.jsp">main</a> 
</div>
</body>
</html>
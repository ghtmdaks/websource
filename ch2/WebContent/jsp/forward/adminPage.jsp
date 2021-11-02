<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//request 객체 : 사용자의 요청을 가지고 올 수 있다.
	// 				사용자가 보낸 값도 가져온당.
	
	//sendRedirect() / forward() 사용시 현재 페이지가 보여지지 않기 때문에
	//필요없는 코드가 됨
	/* String page1 = request.getParameter("page");
	String password = request.getParameter("password");
	out.print("page1 : "+page1+"<br>");
	out.print("password : "+password+"<br>");*/
	
	
	// /jsp/forward/admin => /jsp/forward/adminPage.jsp => /jsp/forward/adminProcess.jsp
	// 여기서 시작을해서		여기를 거치고 (사용자는 안보여)		여기로 도착을 했어
	// 너꺼는 너꺼고 내꺼는 내꺼야 서로 가지고 있는 request가 다르니까
	//response.sendRedirect("adminProcess.jsp");
	

	// /jsp/forward/admin => /jsp/forward/adminPage.jsp == adminProcess.jsp
	// request가 같기 때문에 adminPage.jsp request 가  할 수 있는 일을
	// adminProcess.jsp 도 할 수 있게 되는 것
	// 내가 가지고 있는 request를 너한테 줄게 왜냐면 request가 같으니까
	pageContext.forward("adminProcess.jsp");
%>

<!-- <h2><a href="adminProcess.jsp">adminProcess</a></h2> -->
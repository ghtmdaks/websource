<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>note : <%=request.getParameter("note") %></h1>
<h1>upfile : <%=request.getParameter("upfile") %></h1>
<hr />
<%-- commons fileupload 이용한 처리 --%>
<%
	//요청이 왔는데 multipart/form-data 멀티파트콘텐트인지 리퀘스트로 이거 맞니? 확인하는 작업이야
	//트루로 뜰거야
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
	//트루라면
	if(isMultipart){
		//전송된 파일을 디스크에 저장하기 위한 객채야
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//해당 디렉토리에 저장 서블릿은 내부적으로 서블릿파일 업로드 기능을 사용하는거야
		//저장소(팩토리) 전송된 파일을 디스크에 저장하거나 다른 곳에 저장하려고 객체를 생성하고
		//서블릿파일업로드로 디스크에 저장할 거야
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//업로드 가능 사이즈를 지정하는거야
		upload.setSizeMax(2000*1024);
		
		//해당 리퀘스트를 파싱(분석)하고 있어
		List<FileItem> fileItems = upload.parseRequest(request);
	/* for(FileItem item : fileItems){
			
			if(item.isFormField()){
				//아이템이 폼필드라면 text, password, checkbox...
				fieldName = item.getFieldName();
				value = item.getString("utf-8");
				out.print("<h3>일반 데이터</h3>");
				out.print(filedName+" : "+value+"<br>");
			}else{
				//타입이 파일로 넘어오는 경우
				fieldName = item.getFieldName();
				fileName = item.getName();
				long size = item.getSize();
				out.print("<h3>파일 데이터</h3>");
				out.print(filedName+" : "+fileName+"<br>");
				out.print("파일 크기 : "+size);
				
			}
		} */
		
		
		String fieldName = null, fileName = null, value = null;		
		Iterator<FileItem> iter = fileItems.iterator();		
		
		while(iter.hasNext()){
			FileItem item = iter.next();
			
			
			
			//파일 데이터 인지 일반 데이턴지 분석하는거야
			if(item.isFormField()){
				//아이템이 폼필드라면 text, password, checkbox...
				//요소명 가지고 올때 필드네임으로 가지고 오면 돼
				fieldName = item.getFieldName();
				value = item.getString("utf-8");
				out.print("<h3>일반 데이터</h3>");
				out.print(fieldName+" : "+value+"<br>");
			}else{
				
			
				//타입이 파일로 넘어오는 경우
				//요소명
				fieldName = item.getFieldName();
				//파일명
				fileName = item.getName();
				//업로드된 파일 사이즈
				long size = item.getSize();
				
				File file = null;
				
				if(!fileName.isEmpty()){					
					//파일 저장
					String path = "d:\\upload\\";
				
					//중복되지 않는 고유한 키 값 생성
					UUID uuid = UUID.randomUUID();
				
					// d:\\upload\\고유값+업로드파일명
					file = new File(path+uuid.toString()+"_"+fileName); 
					item.write(file);
				}
				
				
				out.print("<h3>파일 데이터</h3>");
				out.print(fieldName+" : "+fileName+"<br>");
				out.print("파일 크기 : "+size);
				
				//파일 다운로드 - 다운로드 시킬 파일명 전송 다운로드 시킬 파일명을 알려줘야해
				out.print("<p>");
				out.print("<a href ='download.jsp?fileName="+file.getName()+"'>"+fileName+"</a>");
				out.print("</p>");
			}
			
		}
	}

%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="/member/joinProcess.jsp" method="post">
			<div class="form-group">
				<label for="userid">아이디</label> <input type="text"
					class="form-control" id="userid" name="userid">
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password"
					class="form-control" id="password" name="password">
			</div>
			<div class="form-group">
				<label for="passwordCheck">비밀번호 확인</label> <input type="password"
					class="form-control" id="passwordCheck" name="passwordCheck">
			</div>
			<div class="form-group">
				<label for="name">이름</label> <input type="text" class="form-control"
					id="name" name="name">
			</div>
				<label for="gender">성별 </label>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="gender"
					id="gendr" value="Male"> <label
					class="form-check-label" for="gender">남</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio"
					name="gender" id="gender" value="Female">
				<label class="form-check-label" for="gender">여</label>
			</div>
			<div class="form-group">
				<label for="email">이메일</label> <input type="text"
					class="form-control" id="email" name="email">
			</div>
			<button type="submit" class="btn btn-primary">입력</button>
			<button type="button" class="btn btn-secondary">취소</button>
		</form>
	</div>
	</div>
</body>
</html>
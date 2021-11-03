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
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">BOOK / JDBC / 모델1</h1>
			<p class="lead">도서 정보 입력/수정/삭제/조회</p>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-4">
				<div class="list-group" id="list-tab" role="tablist">
					<a class="list-group-item list-group-item-action active"
						id="list-insert-list" data-bs-toggle="list" href="#insert"
						role="tab" aria-controls="list-insert">도서정보입력</a> <a
						class="list-group-item list-group-item-action" id="listall-list"
						data-bs-toggle="list" href="#all" role="tab"
						aria-controls="list-all">도서목록보기</a> <a
						class="list-group-item list-group-item-action"
						id="list-delete-list" data-bs-toggle="list" href="#delete"
						role="tab" aria-controls="list-delete">도서정보삭제</a> <a
						class="list-group-item list-group-item-action"
						id="list-modify-list" data-bs-toggle="list" href="#modify"
						role="tab" aria-controls="list-modify">도서정보수정</a> <a
						class="list-group-item list-group-item-action"
						id="list-search-list" data-bs-toggle="list" href="#search"
						role="tab" aria-controls="list-search">도서정보검색</a>
				</div>
			</div>
			<div class="col-8">
				<div class="tab-content" id="nav-tabContent">
					<div class="tab-pane fade show active" id="insert" role="tabpanel"
						aria-labelledby="list-insert-list">insert</div>
					<div class="tab-pane fade" id="all" role="tabpanel"
						aria-labelledby="list-all-list">all</div>
					<div class="tab-pane fade" id="delete" role="tabpanel"
						aria-labelledby="list-delete-list">delete</div>
					<div class="tab-pane fade" id="modify" role="tabpanel"
						aria-labelledby="list-modify-list">modify</div>
					<div class="tab-pane fade" id="search" role="tabpanel"
						aria-labelledby="list-search-list">search</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
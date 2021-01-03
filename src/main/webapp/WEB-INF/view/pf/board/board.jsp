<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/pf/css/board.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<title>게시판</title>
</head>
<body>
	<!--  header -->
	<header>
		<div class="header-div">
			<c:if test="${sessionScope.name==null}">
				<a class="no-decoration" href="login">로그인</a>
			</c:if>	
			<c:if test="${sessionScope.name!=null}">
				${sessionScope.name}님
				<a id="LogoutBtn" class="no-decoration">로그아웃</a>	
			</c:if>
			
		 </div>
	</header>
	<!--  header -->
	
	<table class="notice-table" >
		<tr class="table-head">
			<td class="table-id">id</td>
			<td class="table-title">제목</td>
			
			<td class="table-writer">작성자</td>
			<td class="table-date">날짜</td>
			<td class="table-hit">조회수</td>
		</tr>
		<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.id}</td>
			<td class="title">
				<a  href="ss">${b.title }</a>
			</td>
			<td>${b.writer_id }</td>
			<td>${b.regdate }</td>
			<td>${b.hit }</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<a href="notice/write">
		<i id="write-icon" class="fas fa-edit"></i>
	</a>
	
	
	
	
</body>
<script src="/pf/js/logout.js" ></script>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
</html>
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
<script type="text/javascript">
	function check(){
			 if(${empty sessionScope.id}){
				alert("로그인이 필요합니다");
			 }	
			 else{
				location.href="/pf/board/write"
			}	
	}
</script>

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
	
	<div class="search-div">
		<form>
			<select name="f">
				<option value="title">제목</option>
				<option value="writer_id">작성자</option>
			</select>
			<input name="q" type="text" value="">
			<input type="submit" value="검색">
		</form>
	</div>
	
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
				<a  href="/pf/board/detail?id=${b.id}">${b.title }</a>
			</td>
			<td>${b.writer_id }</td>
			<td>${b.regdate }</td>
			<td>${b.hit }</td>
		</tr>
		</c:forEach>
	</table>
	
	<div>
		<c:if test="${p.prev < 0}"> 
			<a style="cursor: pointer;" onclick="alert('첫페이지입니다')">◀</a>
		</c:if>
		<c:if test="${p.prev >= 0 }">
			<a href="board?page=${p.prev}">◀</a>
		</c:if>
		
		<c:forEach  var="page" begin="${5*p.start-4}" end="${5*p.start }">
			<c:if test="${page < p.	end or page == p.end }">
				<a href="board?page=${page }">${page}</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${p.next < p.end}"> 
			<a href="board?page=${p.next}">▶</a>
		</c:if>
		<c:if test="${p.next >= p.end}"> 
			<a style="cursor: pointer;" onclick="alert('마지막 페이지입니다')">▶</a>
		</c:if>
		
	</div>
	<a style="cursor: pointer;" class="icon">
		<i id="write-icon" class="fas fa-edit"></i>
	</a>
	
	
	
	
</body>
<script src="/pf/js/logout.js" ></script>
<script src="/pf/js/board.js" ></script>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
</html>
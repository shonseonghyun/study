<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/pf/css/main.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<script type="text/javascript">
	function logoutbtn(){
		if(confirm("로그아웃하시겠습니까?")==true){
			location.href="logout";
		}
		else
			return;
	}
</script>
<title>메인 페이지</title>
</head>
<body>			
				<!-- header 시작 -->
	<header>
		<div class="header-div">
			<c:if test="${sessionScope.name==null}">
				<a class="no-decoration" href="login">로그인</a>
			</c:if>	
			<c:if test="${sessionScope.name!=null}">
				${sessionScope.name}님
				<a onclick="logoutbtn()" class="no-decoration">로그아웃</a>	
			</c:if>
			
		 </div>
	</header>
					<!-- header 끝 -->
   <div class="item-wrapper">
        <figure>
        	<a href="board">
	            <img id="img" src="/pf/images/1.jpg" alt="없다">
	            <figcaption>
	                <p>Category</p>
	                <h2>Board</h2>	
	            </figcaption>
        	</a>
        </figure>
        <figure>
            <img src="/pf/images/2.jpg" alt="없다">
            <figcaption>
                <p>Category</p>
                <h2>ProjectTitle22</h2>
            </figcaption>
        </figure>
        <figure>
            <img src="/pf/images/3.jpg" alt="없다">
            <figcaption>
                <p>Category</p>
                <h2>ProjectTitle</h2>
            </figcaption>
        </figure>
        <figure>
            <img src="/pf/images/4.jpg" alt="없다">
            <figcaption>
                <p>Category</p>
                <h2>ProjectTitle</h2>
            </figcaption>
        </figure>
    </div>
</body>
</html>
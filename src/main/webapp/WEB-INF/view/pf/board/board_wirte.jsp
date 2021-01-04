<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="preconnect" href="https://fonts.gstatic.com">    
 <link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
 <link rel="stylesheet" href="/pf/css/board-write.css">
<title>게시판 작성</title>
</head>
<body onload="check()">
	<!--  header -->
	<header>
		<div class="header-div">
			<c:if test="${sessionScope.name==null}">
				<a class="no-decoration" href="/pf/login">로그인</a>
			</c:if>	
			<c:if test="${sessionScope.name!=null}">
				${sessionScope.name}님
				<a id="LogoutBtn" class="no-decoration">로그아웃</a>	
			</c:if>
			
		 </div>
    </header>
    <!--  header -->

    <form method="post" action="write" enctype="multipart/form-data">
        <table border="1"> 
            <tr>
                <td class="title-td">제목</td>
                <td><input class="title-write" type="text" name="title" ></td>
            </tr>
            <tr> 
                <td colspan="2">
                    <textarea name="content"  cols="30" rows="10"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="file" name="file" >
                </td>
            </tr>

            <tr>
                <td><a href="/pf/board"><button>목록</button></a></td>
                <td><input class="writebtn" type="submit" value="작성"></td>
            </tr>
        </table>
    </form>
	

</body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/pf/js/logout.js" ></script>

</html>
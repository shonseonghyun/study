<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/pf/css/log.css">
<script type="text/javascript">
	function signup(){
		url="signup";
		window.open(url,"signup",width=500,height=300);
		}
	
	function nomember(){
		alert("아이디 또는 비밀번호가 존재하지 않습니다");
		}
</script>
<title>로그인 페이지</title>
</head>
<c:if test="${name == 2}">
	<body onload="nomember()">
</c:if>
<c:if test="${name!=null }">
	<body>
</c:if>

    <section class="login-section">
            <h1>LOGO DESIGN</h1>
            <form name="login-form" action="login" method="post">
            <div class="login-area">
                <input type="text" name="id" id="id" autocomplete="off" required>
                <label for="id">아이디</label>
            </div>
            <div class="login-area">
                <input type="password" name="pwd" id="pw" autocomplete="off" required> 
                <label for="pw">비밀번호</label>
            </div>
            <div class="bt-area">
            	<div class="autologin-div">
	                <input type="checkbox" name="autologin" value="true" checked="checked">자동로그인
            	</div>
                <input type="submit" value="로그인">
            </div>
            <div class="bt-area">
                <input name="sign-btn" onclick="signup()" type="button" value="회원가입">
            </div>
            <div class="caption">
                <a href="#">아이디 및 비밀번호 찾기</a>
            </div>
        </form>
    </section>
<!--     <script src="/pf/js/log.js"></script>
 -->
 </body>
</html>
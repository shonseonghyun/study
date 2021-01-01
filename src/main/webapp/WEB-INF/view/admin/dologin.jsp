<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<!-- <script type="text/javascript">
	function logincheck(){
		if(document.form.id.value==""){
			alert("아이디를 입력하세요");
			return;
		}
		if(document.form.pwd.value=""){
			alert("비밀번호를 입력하세요");
			return;
		}
		document.form.submit();
	}
</script> -->
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){ //페이지가 로딩되면 자동적으로 호출되는 함수
		$("#btnsubmit").click(function(){ 
			if($("#userid").val()==""){
				alert("아이디를 입력하세요");
				return;
			}
			if($("#userpwd").val()==""){
				alert("비밀번호를 입력하세요");
				return;
			}
			$("#adminform").submit();
		})
	})
</script>
</head>
<body onload="adminform.id.focus()">

<h2>관리자 로그인</h2>

<form name="adminform" id="adminform" action="/admin/logindo" method="post">
	<div>아이디: <input id="userid" name="id" type="text"> </div>
	<div>비밀번호: <input id="userpwd" name="pwd" type="password"> </div>
	<input type="button" value="로그인" id="btnsubmit">
</form>
<div>${message} </div>
</body>
</html>
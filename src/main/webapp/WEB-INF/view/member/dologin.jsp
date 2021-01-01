<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function logincheck(){
		if(document.form.id.value==""){
			document.form.id.focus();
			alert("id를 입력하세요!");
			return ;
		}
		if(document.form.pwd.value==""){
			document.form.pwd.focus();
			alert("비밀번호를 입력하세요!");
			return ;
		}
		
		document.form.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body onload="form.id.focus()">
<form name="form" action="login_check" method="post">
	<div name="id_div">id:<input name="id" type="text"></div>
	<div name="pw_div">pw:<input name="pwd" type="password"></div>
	<div><input type="button" value="로그인" onclick="logincheck()"></div>
	<div>${message}</div>
</form>
</body>
</html>
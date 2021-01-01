<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		$("#btn").click(function(){
			i=$("#id").val();
			p=$("#pwd").val();
			param={"i":i,"pw":p};

			$.ajax({
				type : "post",
				url : "a",
				data : param, // -->?i=..&pw=..
				success : function(result){
					$(".result").html(result);
				}
			})
		})
	})
</script>
</head>
<body>
<input id="id" type="text">
<input id="pwd" type="password">
<input id="btn" type="button" value="ad">
<div class="result">
</div>
</body>
</html>
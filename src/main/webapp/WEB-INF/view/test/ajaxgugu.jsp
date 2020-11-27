<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		$("#btn").click(function(){
			v=$("#v").val();
			param={"v":v};
			//비동기식 호출
			$.ajax({
				type:"post",
				url:"ajaxguguresult",
				data: param,
				success:function(result){
					$("#result").html(result);
				}
		})
	})
});
</script>
<meta charset="UTF-8">
<title>구구단 결과</title>
</head>
<body>
<h2>구구단 계산</h2>
	<span>단입력:</span>
	<input type="number" id="v">
	<input type="button" id="btn" value="확인">
<div id="result"></div>
</body>
</html>
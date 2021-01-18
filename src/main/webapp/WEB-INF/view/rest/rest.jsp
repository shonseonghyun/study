<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".btn").click(function(){
			var member={
					id: "park",
					name:"박지성",
					email: "asd@naver.com",
					age:11			
				};
			console.log("hello");
			$.ajax({
				type:"post",
				url:"/test/info",
				contentType:"application/json",	
				data:JSON.stringify(member),
				success:function(data,testStatus){}
			});
		});
	});
</script>
</head>
<body>
<input type="button" class="btn" value="회원 정보 보내기">
<br/>
<div id="output"></div>

</body>
</html>
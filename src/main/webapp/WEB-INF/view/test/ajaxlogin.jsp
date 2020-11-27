<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){ //페이지가 로딩되면 자동 실행되는 함수
		$("#btnlogin").click(function(){
			id=$("#id").val();
			pw=$("#pw").val();
			param={"id":id,"pw":pw};
			//비동기식 호출
			$.ajax({
				type: "post",
				url: "backlogin",
				data:param,
				success:function(result){
					$("#result").html(result);
					}
				
				})
			})
		

});
</script>
</head>
<body>

<span>id</span> <input type="text" id="id">
<span>pw:</span> <input type="password" id="pw">
<input type="button" id="btnlogin"  value="로그인">

<div id="result">
</div>

</body>
</html>
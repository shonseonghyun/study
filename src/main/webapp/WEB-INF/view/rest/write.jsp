<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".btn").click(function(){
			var number=$(".articleNo").val();
			var writer=$(".writer").val();
			var title=$(".title").val();
			//articleVo 프로퍼티들에 맞게 키값 생성
			//글 정보를 JSON으로 생성
			data = {
					articleNo: number,
					title:title,
					writer:writer
			}
			$.ajax({
				type:"POST",
				contentType : "application/json",
				data : JSON.stringify(data), //글 정보를 JSON형식을 전송
				url : "${contextPath}/bboard",
				success : function(data){
					alert(data);
				}
			});
		});
	});
	
</script>
</head>
<body>
	<form>
	<div>
		no:<input class="articleNo" type="number">
	</div>
	<div>
		작성자 : <input class="writer" type="text">
	</div>
	<div>
		제목 : <input class="title" type="text">
	</div>
	<div>
		<input class="btn" type="button" value="쓰기">
	</div>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		$("#updatebtn").click(function(){
			if($("#amount").val()==""){
				alert("양을입력하세요");
				return ;
			}
			if($("#product_id").val()==""){
				alert("제품번호를 입력하세요");
				return ;
			}
			document.form.action="update";
			document.form.submit();
		});
		$("#delbtn").click(function(){
			if($("#product_id").val()==""){
				alert("제품번호를 입력하세요");
				return ;
			}
			if(confirm("삭제하시겠습니까?")){
				document.form.action="delete";
				document.form.submit();
			}
		});
	})
</script>
</head>
<body onload="document.form.product_id.focus()">
<h2>구매정보</h2>
<form  name="form" method="post">
	<input name="id" value="${detail.id}" readonly="readonly">님은 
 	<input id="product_id" name="product_id" value="">번 제품을 
	<input id="amount" name="amount" value="${detail.amount}">개 구입하셨습니다.
	<input type="button" id="updatebtn" value="수정">
	<input type="button" id="delbtn" value="삭제">
	${message }
</form>
</body>
</html>
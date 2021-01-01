<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
</head>
<body>

<form method="post" enctype="multipart/form-data" action="register">
	<div> 상품명:<input name="product_name" type="text"> </div> 
	<div> 가격:<input name="price" type="number"> </div> 
	<div> 설명:<input name="description" type="text"> </div> 
	<div><input name="file" type="file" ></div>	
	<div class="select_img"><img src="" /></div>
	<input type="submit" value="등록">
</form>

</body>
</html>
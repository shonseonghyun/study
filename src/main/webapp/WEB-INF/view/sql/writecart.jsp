<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/cart">목록</a>

<form action="/cart/insert" method="post">
	<input type="text" name="id">
	<input type="number" name="product_id">
	<input type="number" name="amount">
	<input type="submit" value="제출">
</form>

</body>
</html>
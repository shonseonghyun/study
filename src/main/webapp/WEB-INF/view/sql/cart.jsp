<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart</title>
</head>
<body>
<a href="/cart/write">작성</a>
<table  border="1">
	<tr align="center">
		<td>id</td>
		<td>product_id</td>
		<td>amount</td>
	</tr>
<c:forEach var="c" items="${c }">
	<tr align="center">
		<td>
			<a href="/cart/detail?id=${c.id }">${c.id }</a>
		</td>
		<td>
			${c.product_id }
		</td>
		<td>
			${c.amount }
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>

<c:if test="${sessionScope.name!=null }">
	<div>${sessionScope.name}님 안녕하세요</div>
	<a href="register" type="button">상품 등록</a> |
	<a href="/shop/cart/list">장바구니</a> |
	<a href="/member/logout">로그아웃</a>
</c:if>

<c:if test="${sessionScope.name==null }">
	<div class="top-bar">
		<a href="/member/logindo">로그인</a> | 
		<a href="/admin/logindo">관리자 로그인</a>
	</div>
</c:if>

<table  border="1" width="500px">
	<tr align="center"> 
		<td>상품 ID</td>
		<td>이미지</td>
		<td>상품명</td>
		<td>가격</td>
	</tr>
	<c:forEach var="list" items="${list}">
		<tr align="center">
			<td>${list.product_id}</td>
			<td><a href="detail?id=${list.product_id}"><img  width="50" height="50" src="/images/${list.picture_url}"></a>
			<td>${list.product_name}
				 <br/>
				<a href="/shop/product/admin/edit?id=${list.product_id}">[편집]</a>
			 </td>
			<td>
				<fmt:formatNumber  value="${list.price}" pattern="#,###원"/>
			 </td>
		</tr>
	</c:forEach>
</table>
<%=request.getRealPath("/") %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
</head>
<body>
<c:if test="${sessionScope.name!=null }">
	<div>${sessionScope.name}님</div>
	<a href="/member/logout">로그아웃</a>
</c:if>
<c:if test="${sessionScope.name==null }">
<div class="top-bar">
	<a  href="/member/logindo">로그인</a>
</div>
</c:if>

${detail.product_id}
<img width="50px" height="50px" src="/images/${detail.picture_url}">
<fmt:formatNumber  value="${detail.price}" pattern="#,###원"/>
${detail.product_name}
${detail.description}

<form method="post" action="/shop/cart/insert">
	<input type="hidden" name="product_id" value="${detail.product_id}">
	<select name="amount">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
	</select>
	<input type="submit" value="담기"> 
</form>

<h2><a href="list"> 리스트로</a></h2>

</body>
</html>
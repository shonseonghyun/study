<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 목록</title>
<script type="text/javascript">
	function delbtn(){
		if(confirm("장바구니를 비우시겠습니까?")==true){
			location.href="delall";
		}
		else return;	
	}
</script>
</head>
<body>
<div>
	<c:if test="${sessionScope.name!=null}">
		<a href="/shop/product/list">상품 목록</a>
		<a href="/member/logout">로그아웃</a>
	</c:if>
	
</div>
<form action="modify" method="post">
	<table border="1">
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>단가</td>
			<td>상품수량</td>
			<td>금액</td>
			<td> </td>
		</tr>
		<c:forEach var="list" items="${map.list}">
			<tr>
				<td>${list.product_id}</td>
				<td>${list.product_name}</td>
				<td>${list.price}</td>
				<td>
					<input type="number" name="amount"  value="${list.amount}" >
					<input type="hidden" name="cart_id" value="${list.cart_id}" >
				</td>
				<td>${list.money}</td>
				<td><a href="del?cart_id=${list.cart_id }">[삭제]</a></td>
				</tr>
			</c:forEach>
	</table>
	<input type="button" id="btnModify" value="수정" onclick="submit()">
	<button type="button" id="btnDel" onclick="delbtn()">장바구니비우기</button>
</form>
	
	</body>
</html>
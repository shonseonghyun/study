<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 편집</title>
<script type="text/javascript">
	function edit(){
		if(confirm("수정하시겠습니까?")==true){
			document.editform.action="/shop/product/admin/edit";
			document.editform.method="post";
			editform.submit();
		}
		else{
			return;
		}
	}
</script>
</head>
<body>
<form name="editform" enctype="multipart/form-data">
	${detail.product_id}<input type="hidden" name="product_id" value="${detail.product_id}"> <br/>
	
	<input type="text" name="product_name" value="${detail.product_name}"><br/>
	<input type="number" name="price" value="${detail.price}"><br/>
	<input type="text" name="description" value="${detail.description}"> <br/>
	<img src="/images/${detail.picture_url }" width="100" height="100"> <br/>
	<input name="file" type="file" /> <br>
	<input type="button" onclick="edit()" value="수정">
</form>
</body>
</html>
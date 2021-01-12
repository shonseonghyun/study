<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<link rel="stylesheet" href="/pf/css/board-detail.css">
<link rel="preconnect" href="https://fonts.gstatic.com">    
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).on('click','#delBtn',function(e){
		if(confirm("삭제하시겠습니까?")){
			location.href="/pf/board/delete?id=${detail.id}";
		}
		})
</script>
</head>
<body>
<%-- <img width="100" height="100" alt="" src="/images/pf/${detail.files }">
 --%>
	 <header>
		<div class="header-div">
			<c:if test="${sessionScope.name==null}">
				<a class="no-decoration" href="/pf/login">로그인</a>
			</c:if>	
			<c:if test="${sessionScope.name!=null}">
				${sessionScope.name}님
				<a id="LogoutBtn" class="no-decoration">로그아웃</a>	
			</c:if>
			
		 </div>
    </header>
 
 	 <div class= "detail-container">
        <table>
          <tbody>
            <tr>
              <td class="color-area">제목</td>
              <td class="color-blue" colspan="3"><strong>${detail.title }</strong></td>
            </tr>
            <tr>
              <td class="color-area">작성일</td>
              <td colspan="3">${detail.regdate }</td>
            </tr>
            <tr>
              <td class="color-area">작성자</td>
              <td>${detail.writer_id }</td>
              <td class="color-area">조회수</td>
              <td>${detail.hit }</td>
            </tr>
         
            <tr>
              <td height=200 class="not-align" colspan="4">
              	${detail.content }
              </td>
              
            </tr>
            <tr>
              <td colspan="4">
              	<a class="btn" href="/pf/board">목록</a>
              	 <c:if test="${(sessionScope.id ==  detail.writer_id) || (sessionScope.id =='admin') }">
	              	<button id="modiftBtn" type="button">수정</button>
	              	<button id="delBtn" type="button">삭제</button>
    			 </c:if>
              	</td>
            </tr>
            
            <tr>
              <td class="color-area">이전글</td>
              <td colspan="3"><a href="#">이전글 제목</a></td>
            </tr>

            <tr>
              <td class="color-area">다음글</td>
              <td colspan="3"><a href="#">다음글 제목</a></td>
            </tr>

          </tbody>
        </table>
      </div>
 </body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/pf/js/logout.js" ></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function loginin(){
		url="/member/logindo";
		window.open(url,loginin,"width=500,height=300");
	}
</script>

<a href="/main/">Home</a>
<a href="gugu">구구단</a>
<a href="point">성적계산</a>
<a href="move">redirect</a>
<a href="mav">ModelAndView</a>
<a href="ajax">비동기식전환</a>
<a href="ajaxlogin">비동기식로그인</a>
<a href="ajaxgugu">ajax구구단</a>
<a href="/upload">upload</a>
<a href="/shop/product/list">list</a>
<div class="form">
	<a onclick="loginin()">로그인</a>
	<a href="/logoutdo">로그아웃</a>
</div>



function checkpw(){
		var id=document.loginform.id;
		var name=document.loginform.name;
		var email=document.loginform.email;
		var pwd=document.getElementById("pwd");
		var repwd=document.getElementById("repwd");

		if(name.value==""){
			alert("이름을 입력하세요");
			name.focus();
			return;
		}
		if(id.value==""){
			alert("아이디를 입력하세요");
			id.focus();
			return;
		}
		if(pwd.value==""){
			alert("비밀번호를 입력하세요");
			repwd.value="";
			pwd.focus();
			return;
		}
		if(pwd.value!=repwd.value){
			alert("비밀번호가 일치하지 않습니다");
			pwd.value="";
			repwd.value="";
			pwd.focus();
			return;
		}
		if(email.value==""){
			alert("이메일을 입력하세요");
			email.focus();
			return;
		}

		document.loginform.action="sign";
		document.loginform.submit();
		//시간 지연 필요하다..
		alert("회원 가입되었습니다");
		self.close();
}
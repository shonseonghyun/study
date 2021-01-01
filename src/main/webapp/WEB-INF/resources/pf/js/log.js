let id=document.querySelector("input#id"),
    pw=document.querySelector("input#pw"),
    btn=document.querySelector("#btn"),
    form=document.querySelector("form");

const User="user";

function warning(){
    btn.addEventListener("click",function(e){
        if(id.value==""){
            id.nextElementSibling.classList.add("warning");
            setTimeout(function(){
                id.nextElementSibling.classList.remove("warning");
            },2000);
            console.log("id warnign")
        }
        else if(pw.value==""){
            pw.nextElementSibling.classList.add("warning");
            setTimeout(function(){
                pw.nextElementSibling.classList.remove("warning");
            },2000);
            console.log("pw warning");
        }
        else{
            const IdPwarr=localStorage.getItem(User);
            const IdPw=JSON.parse(IdPwarr);
            IdPw.forEach(element => {
                 if((id.value==element.id)&&(pw.value==element.pw)){
                     form.submit();
                     return false;  /* 왜여기서 함수가 종료되지 않냐? */
                 }
                e.preventDefault();
            });
            alert("존재하지 않습니다");
        }
    });
}


function init(){
    warning();
}

init();
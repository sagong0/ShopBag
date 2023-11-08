function joinok(){
	if(f.mid.value==""){
		alert("아이디를 입력해주세요.");
	}
	else if(f.mpass.value==""){
		alert("비밀번호를 입력해주세요");
	}
	else if(!ischeckedId){
		alert("아이디 중복확인을 해주세요.");
	}
	else if(f.mpass.value.length<6){
		alert("비밀번호는 6자 이상 입력해주세요");
	}
	else if(f.mpass.value!=f.mpass2.value){
		alert("비밀번호 확인란에 비밀번호를 동일하게 입력해주세요");
	}
	else if(f.mname.value==""){
		alert("회원명을 입력해주세요");
	}
	else if(f.mcode.value != f.checkcode.value){
		alert("인증번호를 확인해주세요.");
	}
	else if(!ischeckedEmail){
		alert("이메일 인증을 진행해주세요.");
	}
	else if(f.mtel.value==""){
		alert("연락처를 입력해주세요");
	}
	else if(f.mtel.value.length<10||f.mtel.value.length>11){
		alert("정상적인 연락처를 입력해주세요");
	}
	else if(isNaN(f.mtel.value)==true){
		alert("정상적인 연락처를 입력해주세요");
	}
	else{
		f.submit();
	}
}

/*동의 체크박스 */
function email_ck(ck){
	if(ck){
		f.mcmail.value = "Y";
	}
	else{
		f.mcmail.value = "N";
	}
}
function sms_ck(ck){
	if(ck){
		f.mcsms.value = "Y";
	}
	else{
		f.mcsms.value = "N";
	}
}



/*아이디 중복 체크 PART*/
var ischeckedId = false;
function idck(e){
	e.preventDefault();
	
	var id = document.getElementById("mid");
	if(id.value==""){
		alert("아이디를 입력해주세요.");
	}
	else{
		var http = new XMLHttpRequest();
		http.onreadystatechange = function(){
			if(http.readyState == XMLHttpRequest.DONE && http.status == 200){
				var result = this.response;
				
				if(result == "use"){
					alert("사용가능한 아이디 입니다.");
					ischeckedId = true;
					id.readOnly = "true";
				}
				else if(result == "nouse"){
					alert("이미 사용중인 아이디입니다.");
				}	
			}
		}
		http.open("post","./idck.do",true);
		http.setRequestHeader("content-type","application/x-www-form-urlencoded");
		http.send("id="+id.value);
	}
}








/* 이메일 인증 버튼 PART */
var ischeckedEmail = false;
function pop_mailcheck(e){
	e.preventDefault();
	// 이메일 정규식
	var email_regex = /[a-zA-z0-9._-]+@[a-zA-Z0-9]+[.]+[a-zA-Z]/;
	var memail = f.memail.value;
	
	if(!email_regex.test(memail)){
		alert("올바른 이메일 형식을 사용해주세요.");
	}
	else{
		var http = new XMLHttpRequest();
		http.onreadystatechange = function(){
			if(http.readyState == XMLHttpRequest.DONE && http.status==200){
				
				var result = this.response;
				
				console.log(result);
				
				var data = result.split(".");
				
				if(data[0]=="success"){
					f.mcode.value = data[1];
					alert("정상적으로 인증번호가 발송되었습니다.");
					ischeckedEmail = true;
					document.getElementById("memail").readOnly = "true";
				}
				else{
					alert("인증번호 전송에 오류가 발생하였습니다.");
					ischeckedEmail = false;
				}
			}
		}
		
		http.open("post","./emailck.do",true);
		http.setRequestHeader("content-type","application/x-www-form-urlencoded");
		http.send("memail="+memail);
	}
}



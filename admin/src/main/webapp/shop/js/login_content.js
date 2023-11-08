function login(){
	if(loginForm.uid.value==""){
		alert("아이디를 입력해주세요.");
		return false;
	}
	else if(loginForm.upw.value==""){
		alert("패스워드를 입력해주세요.");
		return false;
	}
	else{
		loginForm.submit();
	}
}

window.onload = function(){
	var storage = window.localStorage.getItem("userid");
	console.log(storage);
	loginForm.uid.value = storage;
}

/*자동 로그인 체크 */
function saveid(){
	var ck = document.getElementById("saveidbox");	
	var id = loginForm.uid.value; 
	
	if(id==""){
		alert("아이디를 입력해주세요");
		ck.checked = false;
	}
	else{
		if(ck.checked){
			window.localStorage.setItem("userid",id);
		}
		else{
			window.localStorage.setItem("userid","");
		}
	}
}


var today ="";
var date = "";
function t(){
	today = Date.now();
	date = sessionStorage.setItem("time",today);
	console.log(today);
}

document.querySelector("#f").addEventListener("submit",function(s){
	s.preventDefault();
	if(f.aid.value==""){
		alert("관리자 아이디를 입력해주세요.");
	}
	else if(f.apw.value==""){
		alert("관리자 비밀번호를 입력해주세요.");
	}
	else{
		f.submit();
	}
});
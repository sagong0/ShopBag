/* 전체 동의 PART*/
function all_agree(ck){
	var w = 1;
	while(w<=2){
		document.getElementById("termsAgree"+w).checked= ck;						
		w++;			
	}
}

/* 개인 동의 */
function agree_check(){
	var all = document.getElementById("allAgree");
	var ischeck = true;
	
	var w = 1;
	do{
		if(document.getElementById("termsAgree"+w).checked == false){
			ischeck = false;
		}
		w++;
	}while(w<=2);
	
	all.checked = ischeck;
}

/* 다음단계 클릭 PART */
function gonext(){
	var isok = true;
	
	var w = 1;
	while(w<=2){
		if(document.getElementById("termsAgree"+w).checked==false){
			isok = false;
		}
		w++;
	}
	if(!isok){
		alert("회원가입 약관에 필수 사항은 모두 체크하셔야 회원가입이 진행 됩니다.");
	}
	else{
		location.href="./join.do";
	}
}



/* 약관동의 ajax */
var agree = function(f){
	var http = new XMLHttpRequest();
	http.open("GET",f,false);
	http.send();
	
	return http.response;
}

document.getElementById("agree1").innerHTML = agree("./agree1.txt");
document.getElementById("agree2").innerHTML = agree("./agree2.txt");








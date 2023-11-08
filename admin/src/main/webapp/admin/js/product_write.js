/*상품 코드 PART*/
var b ="";
var w = 0;
while(w<=5){
    var a = Math.floor(Math.random() * 10);
    b += a;
    w++;
}
ff.pcode.value = b;


/* 상품코드 중복체크 PART */
function pcode_check(){
	var pcode = document.getElementById("pcode");
	
	if(pcode.value==""){
		alert("상품코드를 확인해주세요.");
	}
	else{
		var http = new XMLHttpRequest();
		http.onreadystatechange = function(){
			if(http.readyState == XMLHttpRequest.DONE && http.status==200){
				var result = this.response;
				
				if(result=="no"){
					alert("사용가능한 상품코드입니다.");
					pcode.readOnly = true;
				}
				else if(result=="yes"){
					alert("상품코드 중복 에러");
				}
				
			}
		}
		
		http.open("post","./pcodeck.do",true);
		http.setRequestHeader("content-type","application/x-www-form-urlencoded");
		http.send("pcode="+pcode.value);
	}
	
}




/* 할인가격 PART */
function cal(){
	var p_per = Number(ff.psale.value);
	ff.psaleprice.value = Math.round(Number(ff.pprice.value) * Number(1 - (p_per/100)));
}


function p_regit(){
	if(ff.pB_cate.value==""){
		alert("대메뉴 카테고리를 선택해주세요.");
	}
	else if(ff.pS_cate.value==""){
		alert("소메뉴 카테고리를 선택해주세요.");
	}
	else if(ff.pcode.value==""){
		alert("상품코드를 입력해주세요.");
	}
	else if(ff.pname.value==""){
		alert("상품명을 입력해주세요.");
	}
	else if(ff.pdescription.value==""){
		alert("상품 부가설명을 입력해주세요.");
	}
	else if(ff.pprice.value==""){
		alert("판매가격을 입력해주세요.");
	}
	else if(ff.psale.value==""){
		alert("할인율을 입력해주세요.");
	}
	else if(ff.pstock.value==""){
		alert("상품재고를 입력해주세요.");
	}
	else if(ff.pdone.value==""){
		alert("판매 유/무를 입력해주세요.");
	}
	else if(ff.psold.value==""){
		alert("품절여부를 입력해주세요.");
	}
	else if(ff.mfile.value==""){
		alert("상품 이미지를 선택해주세요.");
	}
	else if(ff.pdetail.value==""){
		alert("상품 상세설명을 입력해주세요.");
	}
	else if(ff.pB_cate.value == ff.pS_cate.value){
		alert("대메뉴와 소메뉴는 중복되면 안됩니다.");
	}
	else if(ff.psale.value < 0 || ff.psale.value > 100){
		alert("0~100 숫자를 입력해주세요.");
	}
	else{
		ff.submit();
	}
}


function p_list(){
	location.href="./plists.do";
} 







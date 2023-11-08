<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정규식 코드 사용법</title>
</head>
<body>
<form id="f">
	문자입력 : <input type="text" name="mtext" placeholder="숫자만 입력하세요."><br>
	고객명 : <input type="text" name="mname" placeholder="고객명을 입력하세요."><br>
	패스둬드 : <input type="text" name="mpass" placeholder="패스워드를 입력하세요."><br>
	이메일 : <input type="text" name="memail" placeholder="이메일 주소를 입력하세요."><br>
	<!-- 
	인증번호 : <input type="text" name="mno" placeholder="인증번호를 입력하세요."><br>
	 -->
	<input type="button" value="정규식체크" onclick="abc()">
</form>
</body>

<script>
function abc(){
	/*
	var word = f.mtext.value;
	var ck = /[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g;
	if(ck.test(word) == false){
		console.log("숫자만 입력되었습니다");
	}
	else{
		alert("숫자만 입력해주세요.");
	}
	var word = f.mname.value;
	var ck = /[0-9]/g;
	if(ck.test(word) == true){
		alert("정상적인 형식의 이름을 입력해주세요.");
	}
	else{
		console.log("이름 입력 완료");
	}
	var word = f.mpass.value;
	var ck = /\s/g;
	if(ck.test(word)){
		alert("공백은 사용불가");
	}
	else{
		console.log("good password !");
	}
	*/
	var word = f.memail.value;
	var ck = /[a-zA-Z0-9|_-]+@+[a-zA-z0-9]+[.]+[a-zA-z0-9]/
	
	if(ck.test(word) == false){
		alert("올바른 형식의 이메일을 사용해주세요.");
	}
	else{
		console.log("good Email ~!");
	}
}
</script>

</html>
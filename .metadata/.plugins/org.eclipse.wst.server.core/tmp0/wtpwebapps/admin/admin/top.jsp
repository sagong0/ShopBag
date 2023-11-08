<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name =(String) session.getAttribute("name");
%>    

 <div class="header_div">
        <p><img src="./img/logo.png" class="logo_sm"> ADMINISTRATOR</p>
        <p><%=name %> <a href="#">[개인정보 수정]</a> <a onclick="logout();" href="./admin_logout.do">[로그아웃]</a></p>
</div>
<script>
	window.onload = function(){
		var admin = "<%=name%>";
		
		console.log(admin);
		if(admin == "" || admin=="null"){
			alert("정상적인 접근이아닙니다.");
			location.href="./index.jsp";
		}
	}
</script>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Date amday = new Date();
 SimpleDateFormat amsf = new SimpleDateFormat("yyyyMMddHHmmss");
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css?v=<%=amsf.format(amday)%>">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=<%=amsf.format(amday)%>">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=<%=amsf.format(amday)%>">
    <link rel="stylesheet" type="text/css" href="./css/subpage.css?v=<%=amsf.format(amday)%>">
    <link rel="stylesheet" type="text/css" href="./css/product.css?v=<%=amsf.format(amday)%>">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>
<body>
<!-- 최상단 -->
<header class="headercss">
   <%@ include file="./top.jsp" %>
</header>
<!-- 최상단 끝-->
<!-- 상단-->
<nav class="navcss">
 <%@ include file="./menu.jsp" %>
</nav>
<!-- 상단-->
<main class="maincss">
<section>
   <%@ include file="./main.jsp" %>
</section>
<section></section>
<section></section>
</main>
<!-- 하단 -->
<footer class="main_copyright">
   <%@ include file="./footer.jsp" %>
</footer>
<!-- 하단 -->
</body>
</html>
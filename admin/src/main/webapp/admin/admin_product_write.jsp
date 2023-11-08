<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Date apwday = new Date();
 SimpleDateFormat apwsf = new SimpleDateFormat("yyyyMMddHHmmss");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css?v=<%=apwsf.format(apwday)%>">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=<%=apwsf.format(apwday)%>">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=<%=apwsf.format(apwday)%>">
    <link rel="stylesheet" type="text/css" href="./css/subpage.css?v=<%=apwsf.format(apwday)%>">
    <link rel="stylesheet" type="text/css" href="./css/product.css?v=<%=apwsf.format(apwday)%>">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>
<body>
<header class="headercss">
   <%@ include file="./top.jsp" %>
</header>
<nav class="navcss">
 <%@ include file="./menu.jsp" %>
</nav>
<main class="maincss">
<section>
   <%@ include file="./product_write.jsp" %>
</section>
</main>
<footer class="main_copyright">
   <%@ include file="./footer.jsp" %>
</footer>
</body>
</html>
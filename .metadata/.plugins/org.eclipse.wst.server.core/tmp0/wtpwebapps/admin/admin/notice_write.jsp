<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Date nwday = new Date();
 SimpleDateFormat nwsf = new SimpleDateFormat("yyyyMMddHHmmss");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쇼핑몰 환경설정</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css?v=<%=nwsf.format(nwday)%>">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=<%=nwsf.format(nwday)%>">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=<%=nwsf.format(nwday)%>">
    <link rel="stylesheet" type="text/css" href="./css/notice.css?v=<%=nwsf.format(nwday)%>">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
    <script src="./js/jquery.js?v=<%=nwsf.format(nwday)%>"></script>
</head>
<body>
<header class="headercss">
<!-- admin_header.html -->
</header>
<nav class="navcss">
<!-- admin_menu.html -->
</nav>
<main class="maincss">
<section style="height: auto;">
<!--notice_write.html-->
</section>
</main>
<footer class="main_copyright">
<!--admin_footer.html-->
</footer>
</body>
</html>
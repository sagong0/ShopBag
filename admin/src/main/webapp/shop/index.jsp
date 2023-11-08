<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Date reday = new Date();
 SimpleDateFormat resf = new SimpleDateFormat("yyyyMMddHHmmss");
%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./css/index.css?v=<%=resf.format(reday) %>" rel="stylesheet" />
  </head>

  <body>
    <div class="navbar">
    <%@ include file="./s_top.jsp" %>
    </div>
 <main>
     <%@ include file="./s_main.jsp" %>
</main>
<footer>
   <%@ include file="./s_footer.jsp" %>  
</footer>
  </body>
</html>
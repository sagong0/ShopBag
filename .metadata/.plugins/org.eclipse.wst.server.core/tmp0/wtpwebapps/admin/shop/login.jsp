<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Date lday = new Date();
 SimpleDateFormat lsf = new SimpleDateFormat("yyyyMMddHHmmss");
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./css/index.css?v=<%=lsf.format(lday) %>" rel="stylesheet" />
    <link href="./css/subpage.css?v=<%=lsf.format(lday) %>" rel="stylesheet" />
  </head>

  <body>
   <div class="navbar">
    <%@ include file="./s_top.jsp" %>
    </div>
 <main>
   <%@ include file="./login_content.jsp" %>
</main>
<footer>
     <%@ include file="./s_footer.jsp" %>  
</footer>
  </body>
</html>
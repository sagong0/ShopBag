<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Date ag_day = new Date();
 SimpleDateFormat ag_sf = new SimpleDateFormat("yyyyMMddHHmmss");
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./css/index.css?v=<%=ag_sf.format(ag_day)%>" rel="stylesheet" />
    <link href="./css/subpage.css?v=<%=ag_sf.format(ag_day)%>" rel="stylesheet" />
    <link href="./css/agree.css?v=<%=ag_sf.format(ag_day)%>" rel="stylesheet" />
  </head>

  <body>
   <div class="navbar">
    <%@ include file="./s_top.jsp" %>
    </div>
 <main>
   <%@ include file="./agree_content.jsp" %>
</main>
<footer>
      <%@ include file="./s_footer.jsp" %>  
</footer>
  </body>
</html>
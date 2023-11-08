<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Date jday = new Date();
 SimpleDateFormat jsf = new SimpleDateFormat("yyyyMMddHHmmss");
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./css/index.css?v=<%=jsf.format(jday) %>" rel="stylesheet" />
    <link href="./css/subpage.css?v=<%=jsf.format(jday) %>" rel="stylesheet" />
    <link href="./css/agree.css?v=<%=jsf.format(jday) %>" rel="stylesheet" />
    <link href="./css/join.css?v=<%=jsf.format(jday) %>" rel="stylesheet" />
  </head>

  <body>
    <div class="navbar">
    <%@ include file="./s_top.jsp" %>
    </div>
 <main>
   <%@ include file="./join_content.jsp" %>
</main>
<footer>
      <%@ include file="./s_footer.jsp" %>  
</footer>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String usernm = (String) session.getAttribute("userName");
%>    
  <a href="./shopmain.do" id="logo">
        <img src="./../images/logo.jpg" width="149">
        </a>
        <ul id="menu">
        <%
        if(usernm == "" || usernm == null){
        %>
          <li><a href="./login.do">LOGIN</a></li>
          <li><a href="#">MEMBER SHIP</a></li>
          <li><a href="#">CART</a></li>
          <li><a href="#">CUSTOMER CENTER</a></li>
        <%
        }
        else{
        %>
        <li><%=usernm %>님 환영합니다. <a href="./logoutok.do">[로그아웃]</a></li>
       	<li><a href="#">CART</a></li>
        <li><a href="#">CUSTOMER CENTER</a></li>        	
        <%
        }
        %>
        </ul>
<%@page import="team2.p_dto"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<p_dto> p_lists = (List<p_dto>) request.getAttribute("p_lists");
%>    
<div class="hero-header"></div>   
    
    <div class="products">
      <h3>NEW PRODUCTS</h3>
      <%
      if (p_lists != null && !p_lists.isEmpty()) {
      int w =0;
      do{
      int price = Integer.parseInt(p_lists.get(w).getPprice());
      int salePrice = Integer.parseInt(p_lists.get(w).getPsaleprice());
      String[] img = p_lists.get(w).getPimg().split("images");
      %>
      <div class="product-list">
        <a href="#" class="product">
          <img src="<%=p_lists.get(w).getPimg()%>" width="225">
          <div class="product-name">
            <%=p_lists.get(w).getPname()%>
          </div>
          <div class="product-price">
          <%=p_lists.get(w).getPprice()%>원
          <%if(price!=0 && salePrice != 0) {%>
          <%= "/"+p_lists.get(w).getPsaleprice()%>원
          <%} %>
          </div>
        </a>
     <%
    	 w++;
     }while(w<p_lists.size());
     }
      else{
     %>
     <p style="text-align: center; color: red;">No Products Now ! <br> You can add Product from admin Page !</p>
     <%} %>
        <div class="clearfix"></div>
      </div>
    </div>
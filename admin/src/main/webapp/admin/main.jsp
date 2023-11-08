<%@page import="team2.memberDto"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<memberDto> lists = (List<memberDto>) request.getAttribute("lists");
%>
 <p>회원 리스트</p>
    <ol class="new_admin_title">
        <li>NO</li>
        <li>고객명</li>
        <li>아이디</li>
        <li>전화번호</li>
        <li>이메일</li>
        <li>이메일 수신</li>
        <li>SMS 수신</li>
        <li>가입일자</li>
        <li>상태</li>
        <li>정지여부</li>
    </ol>
    <%if(lists.size()==0){ %>
    <ol class="new_admin_none">
        <li>가입된 회원이 없습니다.</li>
    </ol>
    <%} 
    else{
    	int w =0;
    	do{
    %>
    <ol class="new_admin_lists">
        <li><%=lists.get(w).getMidx()%></li>
        <li><%=lists.get(w).getMname()%></li>
        <li><%=lists.get(w).getMid()%></li>
        <li><%=lists.get(w).getMtel()%></li>
        <li><%=lists.get(w).getMemail()%></li>
        <li><%=lists.get(w).getMcmail()%></li>
        <li><%=lists.get(w).getMcsms()%></li>
        <li><%=lists.get(w).getMindate().substring(0, 10)%></li>
        <li><%=lists.get(w).getMuse()%></li>
        <li>
        	<form id="ckF" method="post" action="./admin_mainok.do" onsubmit="return ck_use();">
	            <input type="submit" value="정지" name="muse" class="new_addbtn1" title="정지">
	            <input type="submit" value="해제" name="muse" class="new_addbtn2" title="해제">
	            <input type="hidden" value="<%=lists.get(w).getMidx()%>" name="idx">
            </form>
        </li>
    </ol>
    <%
    w++;
    }while(w < lists.size());
    }
    %>
<script>
	function ck_use(v){
		if(ckF.muse.value==""){
			//alert("권한이 없습니다.");
			//return false;
		}
		else{
			ckF.mmuse.value=ckF.muse.value;
			ckF.submit();
		}
	}
</script>
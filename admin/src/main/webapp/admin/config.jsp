<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core"%>    
<%
 Date re_day = new Date();
 SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
%>
<script src="./js/config.js?v=<%=sf.format(re_day)%>"></script>
 <p>홈페이지 가입환경 설정</p>
 <form id="frm">
    <div class="subpage_view">
    <ul class="info_form">
        <li>홈페이지 제목</li>
        <li>
            <input type="text" name="site_title" value="${data.getSite_title()}" class="in_form1"> 
        </li>
    </ul>    
    <ul class="info_form">
        <li>관리자 메일 주소</li>
        <li>
            <input type="text" name="site_mail" value="${data.getSite_mail()}" class="in_form2"> ※ 관리자가 보내고 받는 용도로 사용하는 메일 주소를 입력합니다.(회원가입,인증메일,회원메일발송 등에서 사용)
        </li>
    </ul> 
    <ul class="info_form">
        <li>포인트 사용 유/무</li>
        <li class="checkcss">
            <em><label><input type="radio" class="ckclass" name="site_point_use" value="Y" ${data.getSite_point_use() eq "Y" ? "checked" : ""}>포인트 사용</label></em> 
            <em><label><input type="radio" class="ckclass" name="site_point_use" value="N" ${data.getSite_point_use() eq "N" ? "checked" : ""}>포인트 미사용</label></em>
        </li>
    </ul>
    <ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
        <li>회원가입시 적립금</li>
        <li>
            <input type="text" class="in_form3" name="site_point" maxlength="6" value="${data.getSite_point()}"> 점
        </li>
        <li>회원가입시 권한레벨</li>
        <li>
            <input type="text" class="in_form3" name="member_level" maxlength="1" value="${data.getMember_level()}"> 레벨
        </li>
    </ul> 
    </div>
    <p>홈페이지 기본환경 설정</p>
    <div class="subpage_view">
    <ul class="info_form2">
        <li>회사명</li>
        <li>
            <input type="text" name="site_corp" class="in_form0" value="${data.getSite_corp()}"> 
        </li>
        <li>사업자등록번호</li>
        <li>
            <input type="text" name="site_corp_no" class="in_form0" value="${data.getSite_corp_no()}"> 
        </li>
    </ul> 
    <ul class="info_form2">
        <li>대표자명</li>
        <li>
            <input type="text" name="site_ceo" class="in_form0" value="${data.getSite_ceo()}"> 
        </li>
        <li>대표전화번호</li>
        <li>
            <input type="text" name="site_tel" class="in_form0" value="${data.getSite_tel()}"> 
        </li>
    </ul>
    <ul class="info_form2">
        <li>통신판매업 신고번호</li>
        <li>
            <input type="text" name="site_register" class="in_form0" value="${data.getSite_register()}"> 
        </li>
        <li>부가통신 사업자번호</li>
        <li>
            <input type="text" name="site_register2" class="in_form0" value="${data.getSite_register2()}"> 
        </li>
    </ul>
    <ul class="info_form2">
        <li>사업장 우편번호</li>
        <li>
            <input type="text" name="site_post" class="in_form0" maxlength="5" value="${data.getSite_post()}"> 
        </li>
        <li>사업장 주소</li>
        <li>
            <input type="text" name="site_address" class="in_form2" value="${data.getSite_address()}"> 
        </li>
    </ul>
    <ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
        <li>정보관리책임자명</li>
        <li>
            <input type="text" name="site_security" class="in_form0" value="${data.getSite_security()}"> 
        </li>
        <li>정보책임자 E-mail</li>
        <li>
            <input type="text" name="site_security_mail" class="in_form1" value="${data.getSite_security_mail()}"> 
        </li>
    </ul>
    </div>
    <p>결제 기본환경 설정</p>
    <div class="subpage_view">  
    <ul class="info_form2">
        <li>무통장 은행</li>
        <li>
            <input type="text" name="site_bank" class="in_form0" value="${data.getSite_bank()}"> 
        </li>
        <li>은행계좌번호</li>
        <li>
            <input type="text" name="site_bank_no" class="in_form1" value="${data.getSite_bank_no()}"> 
        </li>
    </ul>
    <ul class="info_form">
        <li>신용카드 결제 사용</li>
        <li class="checkcss">
            <em><label><input type="radio" name="site_card" value="Y" class="ckclass" ${data.getSite_card() eq "Y" ? "checked" : ""}> 사용</label></em> 
            <em><label><input type="radio" name="site_card" value="N" class="ckclass" ${data.getSite_card() eq "N" ? "checked" : ""}> 미사용</label></em> ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
        </li>
    </ul>
    <ul class="info_form">
        <li>휴대폰 결제 사용</li>
        <li class="checkcss">
            <em><label><input type="radio" name="site_hpp" value="Y" class="ckclass" ${data.getSite_hpp() eq "Y" ? "checked" : ""}> 사용</label></em> 
            <em><label><input type="radio" name="site_hpp" value="N" class="ckclass" ${data.getSite_hpp() eq "N" ? "checked" : ""}> 미사용</label></em> ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
        </li>
    </ul>
    <ul class="info_form">
        <li>도서상품권 결제사용</li>
        <li class="checkcss">
            <em><label><input type="radio" name="site_book" value="Y" class="ckclass" ${data.getSite_book() eq "Y" ? "checked" : ""}> 사용</label></em> 
            <em><label><input type="radio" name="site_book" value="N" class="ckclass" ${data.getSite_book() eq "N" ? "checked" : ""}> 미사용</label></em> ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
        </li>
    </ul>
    <ul class="info_form2">
        <li>결제 최소 포인트</li>
        <li>
            <input type="text" name="site_min_point" class="in_form0" maxlength="6" value="${data.getSite_min_point()}"> 점
        </li>
        <li>결제 최대 포인트</li>
        <li>
            <input type="text" name="site_max_point" class="in_form0" maxlength="6" value="${data.getSite_max_point()}"> 점
        </li>
    </ul>
    <ul class="info_form">
        <li>현금 영수증 발급사용</li>
        <li class="checkcss">
            <em><label><input type="radio" name="site_cash" value="Y" class="ckclass" ${data.getSite_cash() eq "Y" ? "checked" : ""}> 사용</label></em> 
            <em><label><input type="radio" name="site_cash" value="N" class="ckclass" ${data.getSite_cash() eq "N" ? "checked" : ""}> 미사용</label></em> ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
        </li>
    </ul>
    <ul class="info_form2">
        <li>배송업체명</li>
        <li>
            <input type="text" class="in_form0" name="site_tax_name" value="${data.getSite_tax_name()}"> 
        </li>
        <li>배송비 가격</li>
        <li>
            <input type="text" class="in_form0" name="site_tax_cash" maxlength="7" value="${data.getSite_tax_cash()}"> 원
        </li>
    </ul>
    <ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
        <li>희망배송일</li>
        <li class="checkcss">
            <em><label><input type="radio" name="site_use_day" value="Y" class="ckclass" ${data.getSite_use_day() eq "Y" ? "checked" : ""}> 사용</label></em> 
            <em><label><input type="radio" name="site_use_day" value="N" class="ckclass" ${data.getSite_use_day() eq "N" ? "checked" : ""}> 미사용</label></em> ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
        </li>
    </ul>
    </div>
    <div class="btn_div">
        <button type="button" class="sub_btn1" title="설정 저장" onclick="save_infosite(1)">설정 저장</button>
        <button type="button" class="sub_btn2" title="저장 취소" onclick="save_infosite(0)">저장 취소</button>
    </div>
    </form>
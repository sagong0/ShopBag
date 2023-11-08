<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<div class="footer">
      <a href="http://facebook.com">
        <img src="../images/facebook.png"height="20">
      </a>
      <a href="http://instagram.com">
        <img src="../images/instagram.png"height="20">
      </a>
      <a href="http://twitter.com">
        <img src="../images/twitter.png"height="20">
      </a>
    </div>
    <section class="foot_section"></section>
    <aside class="aside_footer">
        <div class="div_footer">
        <ul>
	        <li><img src="../images/foot_logo.png"></li>
	        <li>
			회사명 : ${siteInfo.site_corp}
			대표자 : ${siteInfo.site_ceo}
			주소 : ${siteInfo.site_address}<br>
			고객센터 : ${siteInfo.site_tel}
			상담시간 : 
			E-Mail : ${siteInfo.site_mail}
			사업자등록번호 : ${siteInfo.site_corp_no} <br>
			통신판매업신고번호 : ${siteInfo.site_register}
			개인정보보호책임자 : ${siteInfo.site_security} <br>
			Copyright © 도메인명 All Rights Reserved.
	        </li>
        </ul>    
        </div>
    </aside>
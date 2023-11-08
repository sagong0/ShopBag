function save_infosite(no){
	if(no==0){
		if(confirm("해당 정보를 반영하지 않겠습니까?")){
			window.location.reload();
		}
	}
	else{
		if(frm.site_title.value==""){
			alert("홈페이지 제목을 입력하세요!")
			frm.site_title.focus();
		}
		else if(frm.site_mail.value==""){
			alert("관리자 메일 주소를 입력하세요");
			frm.site_mail.focus();
		}
		else if(frm.site_point.value==""){
			frm.site_point.value = 0;
		}
		else if(frm.member_level.value==""){
			frm.site_point.value = 1;
		}
		else if(frm.site_corp.value==""){
			alert("회사명을 입력하세요!")
			frm.site_corp.focus();
		}
		else if(frm.site_corp_no.value==""){
			alert("사업자등록번호를 입력하세요!")
			frm.site_corp_no.focus();
		}
		else if(frm.site_ceo.value==""){
			alert("대표자명을 입력하세요!")
			frm.site_ceo.focus();
		}
		else if(frm.site_register.value==""){
			alert("대표 전화번호를 입력하세요!")
			frm.site_register.focus();
		}
		else if(frm.site_register2.value==""){
			alert("통신판매업 신고번호를 입력하세요!")
			frm.site_register2.focus();
		}
		else if(frm.site_post.value==""){
			alert("사업장 우편번호를 입력하세요!")
			frm.site_post.focus();
		}
		else if(frm.site_address.value==""){
			alert("사업장 주소를 입력하세요!")
			frm.site_address.focus();
		}
		else if(frm.site_security.value==""){
			alert("정보관리책임자명을 입력하세요!")
			frm.site_security.focus();
		}
		else if(frm.site_security_mail.value==""){
			alert("정보책임자 이메일을 입력하세요!")
			frm.site_security_mail.focus();
		}
		else if(frm.site_tax_cash.value == ""){
			frm.site_tax_cash.value = 0;
		}
		else if(frm.site_cash.value==""){
			alert("현금 영수증 발급 여부를 체크해주세요.");
			frm.site_cash.focus();
		}
		else{
			save_check_dtc();
		}
	}	
}



function save_check_dtc(){
	if(frm.site_min_point.value > frm.site_max_point.value){
		alert("결제 최소 포인트와 최대 포인트가 서로 맞지 않습니다.");
		frm.site_min_point.focus();
	}
	else{
		
		var emailck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z0-9]{2,10}$/i;
		if(!emailck.test(frm.site_security_mail.value)){
			alert("올바른 이메일을 입력해 주시길 바랍니다.");
			frm.site_security_mail.focus();		
		}
		else{
			if(confirm("해당 정보를 저장 하시겠습니까?")){
				frm.method = "post";
				frm.action = "./admin_configok.do";
				frm.enctype = "application/x-www-form-urlencoded";
				frm.submit();	
			}
		}
	}
}
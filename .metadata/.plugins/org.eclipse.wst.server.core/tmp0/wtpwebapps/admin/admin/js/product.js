document.querySelector("#sf").addEventListener("submit",function(a){
   	a.preventDefault();
   	if(sf.searchVal.value==""){
   		location.href="./plists.do";
   	}
   	else{
   		sf.submit();
   	}
});


/*상품 등록 PART*/
function p_register(){
	location.href="./admin_product_write.jsp"
}

/* checkbox */
function p_check(check,val){
	if(check == true)
	document.querySelector("#hid_pidx").value = val;
}



/* 상품 삭제 PART */
function p_del(){
	let id = document.querySelector("#hid_pidx").value
	console.log(id);
	
	if(confirm("해당 상품을 삭제 하시겠습니까? 삭제 후 복구는 불가능합니다.")){
		location.href="./p_delete.do?pidx="+id;		
	}
}
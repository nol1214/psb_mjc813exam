function fn_submit(){
	var fn = document.frm;
	if(fn.name.value == ""){
		alert("성명 입력되지 않았습니다.");
		fn.name.focus();
		return false;
	}
	if(fn.phoneNumber.value == ""){
		alert("연락처 입력되지 않았습니다.");
		fn.phoneNumber.focus();
		return false;
	}
	if(fn.zipNumber.value == ""){
		alert("우편번호 입력되지 않았습니다.");
		fn.zipNumber.focus();
		return false;
	}
	if(fn.email.value == ""){
		alert("이메일 입력되지 않았습니다.");
		fn.email.focus();
		return false;
	}
	fn.submit();
}
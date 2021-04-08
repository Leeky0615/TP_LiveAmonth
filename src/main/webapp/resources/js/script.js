function checkValue() {
	if (!document.SignInfo.classification.value) {
		alert("회원 구분을 선택하세요.");
		return false;
	}
	if (!document.SignInfo.userSex.value) {
		alert("성별을 선택하세요.");
		return false;
	}
	if (!document.SignInfo.businessLicense.value) {
		alert("사업자 등록번호를 입력하세요.");
		return false;
	}
	if (!document.SignInfo.userName.value) {
		alert("이름을 선택하세요.");
		return false;
	}
	if (!document.SignInfo.userNickName.value) {
		alert("닉네임을 입력하세요.");
		return false;
	}
	if (!document.SignInfo.userID.value) {
		alert("아이디를 입력하세요.");
		return false;
	}
	if (!document.SignInfo.userPassword.value) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if (!document.SignInfo.userEmail.value) {
		alert("이메일을 입력하세요.");
		return false;
	}
	if (!document.SignInfo.userAge.value) {
		alert("출생일을 입력하세요.");
		return false;
	}
	if (!document.SignInfo.agreeCheck.checked) {
		alert("동의에 체크하세요.");
		return false;
	}
};


function hideBusinessNumber() {
	$('#businessBlock').hide();
	document.SignInfo.businessLicense.value = "0";
};

function showNumber() {
	document.SignInfo.businessLicense.value = "";
	$('#businessBlock').show();
};

function maxLengthCheck(object) {
	if (object.value.length > object.maxLength) {
		object.value = object.value.slice(0, object.maxLength);
	}
};

function koreanCheck() {
	if (!(event.keyCode < 47 && event.keyCode > 58)) event.returnValue = false;
};

$(document).on("keyup", "input[engAndNumOnly]", function() { $(this).val($(this).val().replace(/[^a-zA-Z0-9]/gi, "")); })

$('#userEmail').blur(function() {
 	var email_rule = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var mail =$("#userEmail").val();
	
	if (!email_rule.test(mail)) {
		alert(mail);
		alert("이메일을 형식에 맞게 입력해주세요.");
		$("#submit").attr("disabled", "disabled");   
		return false;
	}else{
		 $("#submit").removeAttr("disabled");
	}
});


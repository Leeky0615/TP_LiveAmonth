function checkValue() {
	if (!document.SignInfo.userSex.value) {
		alert("성별을 선택하세요.");
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

$(".checkID").click(function () {
	var query = {userID: $("#userID").val()};
	$.ajax({
		url: "checkID",
		type: "post",
		data: query,
		success: function (data) {
			if (data == 1) {
				$(".result .msg").text("사용불가");
				$(".result .msg").attr("style", "color:#f00");
				$("#submit").attr("disabled", "disabled");
			} else {
				$(".result .msg").text("사용가능");
				$(".result .msg").attr("style", "color:#00f");
				$("#submit").removeAttr("disabled");
			}
		}
	});  // ajax ��
});

$("#userID").keyup(function () {
	$(".result .msg").text("중복확인을 해주세요");
	$(".result .msg").attr("style", "color:#000");

	$("#submit").attr("disabled", "disabled");

});
///////////////////////////////////////////////////////////
$(".checkNickName").click(function () {
	var query = {userNickname: $("#userNickname").val()};
	$.ajax({
		url: "checkNickName",
		type: "post",
		data: query,
		success: function (data) {
			if (data == 1) {
				$(".nickNameResult .nickNameMsg").text("사용불가");
				$(".nickNameResult .nickNameMsg").attr("style", "color:#f00");
				$("#submit").attr("disabled", "disabled");
			} else {
				$(".nickNameResult .nickNameMsg").text("사용가능");
				$(".nickNameResult .nickNameMsg").attr("style", "color:#00f");

				$("#submit").removeAttr("disabled");
			}
		}
	});  // ajax ��
});

$("#userNickname").keyup(function () {
	$(".nickNameResult .nickNameMsg").text("중복확인을 해주세요");
	$(".nickNameResult .nickNameMsg").attr("style", "color:#000");
	$("#submit").attr("disabled", "disabled");
});
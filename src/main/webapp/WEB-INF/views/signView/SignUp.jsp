<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">


	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">
	<script src="/resources/js/signUp.js"></script>
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
  <jsp:include page="/incl/Header.jsp" />
    
    <section class="ftco-section">

		<div class="container">

			<form action=ResultMentSignUp method="post" class="signup-form" name = "SignInfo" onsubmit="return checkValue()">

				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="heading-section">Sign Up</h2>
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-md-7 col-lg-6 col-xl-5">
						<div class="login-wrap p-4 p-md-5">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="fa fa-edit"></span>
							</div>
							<h3 class="text-center mb-4">Create Your Account</h3>

							<form action="#" class="signup-form">
							
								<div class="form-group mb-3">
								<label class="label" for="classification">회원구분</label><br>
								<input type="radio" id="classification" name="classification"
								value="noramal" onclick="hideBusinessNumber()">일반회원 &nbsp;
								<input type="radio" id="classification" name="classification" 
								value="business" onclick="showNumber()">사업자
							</div>         
            
							<div class="form-group mb-3" id= "businessBlock">
								<label class="label" for="businessLicense">사업자정보</label>
								<input type="text" id="businessLicense" class="form-control"
									placeholder="businessLicense" name="businessLicense">
							</div>
							
								<div class="form-group mb-3">
									<label class="label" for="userID">ID</label> 
									<input type="text" id="userID" class="form-control" placeholder="ID" name="userID" engAndNumOnly>
									<button type="button" class="checkID">중복확인</button>
									<p class="result">
									 	<span class="msg">중복확인을 해주세요.</span>
									</p>								
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="userPassword">password</label> <input
										id="password-field" type="password" id="userPassword"
										class="form-control" placeholder="Password" onpaste="return false;" oncopy="return false;"
										name="userPassword"> <span toggle="#password-field"
										class="fa fa-fw fa-eye field-icon toggle-password"></span>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="userName">이름</label> <input
										type="text" id="userName" class="form-control"
										placeholder="이름(한글만 입력가능)" name="userName" onkeypress="koreanCheck()">
								</div>
								<div class="form-group mb-3">
									<label class="label" for="userNickname">닉네임</label> 
									<input type="text" id="userNickname" class="form-control" placeholder="닉네임" name="userNickname">
										<button type="button"  class="checkNickName">중복확인</button>
									<p class="nickNameResult">
									 	<span class="nickNameMsg">중복확인을 해주세요.</span>
									</p>
								</div>

						<div class="form-group mb-3" id="userSexBlock">
							<label class="label" for="userSex">성별</label><br> <select
								name="userSex" id="userSex" class="form-control">
								<option value=0>남성</option>
								<option value=1>여성</option>
							</select>
						</div>
						<br>

						<div class="form-group mb-3">
							<label class="label" for="userAge">출생년도</label><br> <input
								type="number" class="int form-control" id="userAge"
								min="1900" max="2021" maxlength="4" placeholder="생년(4자)"
								name="userAge" oninput="maxLengthCheck(this)">
						</div>

						<div class="form-group mb-3">
							<label class="label" for="userEmail">이메일</label> <input
								type="text" id="userEmail" class="form-control result-email"
								placeholder="johndoe@gmail.com" name="userEmail">
						</div>					
								
									<div class="form-group d-md-flex">
								<div class="w-100 text-left">
									<label class="checkbox-wrap checkbox-primary">I agree
										all statements in terms of service <input type="checkbox"
										checked name="agreeCheck"> <span class="checkmark"></span>
									</label>
								</div>
							</div>
							<div class="form-group">
									<button type="submit" id="submit" disabled="disabled"
										class="form-control btn btn-primary rounded submit px-3">Sign
										Up</button>
								</div>
							
							</form>
							<p>
								I'm already a member! <a data-toggle="tab" href="#signin">Sign
									In</a>
							</p>
						</div>
					</div>
				</div>
			</form>
		</div>
	</section>

<script> 
$(".checkID").click(function(){
 
 var query = {userID : $("#userID").val()};
 
 $.ajax({
  url : "checkID",
  type : "post",
  data : query,
  success : function(data) {
  
   if(data == 1) {
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

$("#userID").keyup(function(){
	 $(".result .msg").text("중복확인을 해주세요");
	 $(".result .msg").attr("style", "color:#000");
	 
	 $("#submit").attr("disabled", "disabled");
	 
	});
///////////////////////////////////////////////////////////
$(".checkNickName").click(function(){
	 
	 var query = {userNickname : $("#userNickname").val()};
	 
	 $.ajax({
	  url : "checkNickName",
	  type : "post",
	  data : query,
	  success : function(data) {
		
	   if(data == 1) {
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

	$("#userNickname").keyup(function(){
		 $(".nickNameResult .nickNameMsg").text("중복확인을 해주세요");
		 $(".nickNameResult .nickNameMsg").attr("style", "color:#000");
		 
		 $("#submit").attr("disabled", "disabled");
		 
		});
</script>
    <jsp:include page="/incl/Footer.jsp" />
</body>
</html>
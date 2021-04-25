<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %><%--
  Created by IntelliJ IDEA.
  User: rbdus
  Date: 2021-04-17
  Time: 오전 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보수정</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="/resources/js/modify.js"></script>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
<%
    UserVO userVO = (UserVO) request.getAttribute("userVO");
%>
<section class="ftco-section">
    <div class="section-title">
        <h4>회원정보 수정</h4>
    </div>
    <div class="container">
        <form action=resultMentModifyUserInfo method="post" class="signup-form" name="SignInfo">
            <div class="row justify-content-center">
                <div class="col-md-10 col-lg-10 col-xl-10">
                    <div class="login-wrap p-4 p-md-5">
                        <div class="icon d-flex align-items-center justify-content-center">
                            <span class="fa fa-edit"></span>
                        </div>
                        <h3 class="text-center mb-4">정보 수정</h3>

                        <form action="#" class="signup-form">
                            <div class="form-group mb-3">
                                <label class="label" for="userID">ID</label>
                                <input type="text" id="userID" class="form-control" placeholder="ID" name="userID"
                                       value="${userVO.userID}" readonly>
                            </div>

                            <div class="form-group mb-3">
                                <label class="label" for="userPassword">password</label> <input
                                    id="password-field" type="password" id="userPassword"
                                    class="form-control" placeholder="Password" onpaste="return false;"
                                    oncopy="return false;"
                                    name="userPassword"> <span toggle="#password-field"
                                                               class="fa fa-fw fa-eye field-icon toggle-password"></span>
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="userName">이름</label>
                                <input
                                        type="text" id="userName" class="form-control" placeholder="이름" name="userName"
                                        value="${userVO.userName}" readonly>
                            </div>

                            <div class="form-group mb-3">
                                <label class="label" for="userNickname">닉네임</label>
                                <input type="text" id="userNickname" class="form-control"
                                       placeholder="${userVO.userNickname}"
                                       name="userNickname">
                                <button type="button" class="checkNickName">중복확인</button>
                                <p class="nickNameResult">
                                    <span class="nickNameMsg">중복확인을 해주세요.</span>
                                </p>
                            </div>

                            <div class="form-group mb-3">
                                <label class="label" for="userEmail">이메일</label>
                                <input type="text" id="userEmail" class="form-control result-email"
                                       placeholder="${userVO.userEmail}" name="userEmail">
                            </div>

                            <div class="form-group d-md-flex">
                                <div class="w-100 text-left">
                                    <label class="checkbox-wrap checkbox-primary">
                                        I agree all statements in terms of service
                                        <input type="checkbox" checked name="agreeCheck">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" id="submit"
                                        class="form-control btn btn-primary rounded submit px-3">
                                    회원정보 변경
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
<script>
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
        });
    });
    $("#userNickname").keyup(function () {
        $(".nickNameResult .nickNameMsg").text("중복확인을 해주세요");
        $(".nickNameResult .nickNameMsg").attr("style", "color:#000");

        $("#submit").attr("disabled", "disabled");
    });
</script>
</body>
</html>

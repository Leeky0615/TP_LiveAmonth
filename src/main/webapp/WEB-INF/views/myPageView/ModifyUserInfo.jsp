<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %><%--
  Created by IntelliJ IDEA.
  User: rbdus
  Date: 2021-04-16
  Time: 오후 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<%
    UserVO userVO = (UserVO) request.getAttribute("userVO");
%>
<jsp:include page="/incl/Header.jsp"/>
<section class="contact-form-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="cf-content">
                    <div class="cc-title">
                        <h4>회원 정보 수정</h4>
                        <p>개인정보 보호를 위해 비밀번호를 입력해 주세요</p>
                    </div>
                    <form action="#" class="signin-form">
                        <div class="form-group mt-3">
                            <input type="text" class="form-control" id="userID" name="userID" required>
                            <label class="form-control-placeholder" for="userID">ID</label>
                        </div>
                        <div class="form-group">
                            <input id="password-field" type="password" id="userPassword" class="form-control"
                                   name="userPassword" required>
                            <label class="form-control-placeholder" for="userPassword">Password</label>

                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                        </div>
                        <button type="submit" class="site-btn">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="/incl/Footer.jsp"/>
</body>
</html>

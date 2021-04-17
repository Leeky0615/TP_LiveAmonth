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
    <link rel="stylesheet" href="css/myPage.css" type="text/css">
</head>
<body>
<%
    UserVO userVO = (UserVO) request.getAttribute("userVO");
    boolean checkUser = (boolean)request.getAttribute("checkUser");
%>
<jsp:include page="/incl/Header.jsp"/>
<section class="contact-form-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h4>비밀번호 재확인</h4>
                    <p><span>보안을 위해서</span> 회원님의 <span>비밀번호</span>를 다시한번 입력해주세요.</p>
                    <p>개인정보 변경에서는 비밀번호 변경, 이메일 변경 등의 정보를 확인, 수정하실 수 있습니다.</p>
                </div>
                <form action="goToModifyUserInfo" class="check-pw-form">
                    <div class="tab-content">
                        <ul class="cp-table">
                            <li>
                                <label class="type-name">아이디</label>
                                <input id="id-field" type="text" id="userID"
                                       class="form-control" name="userID" value="${userVO.userID}" readonly>
                            </li>
                            <li>
                                <label class="type-name">비밀번호</label>
                                <input id="password-field" type="password" id="userPassword"
                                       class="form-control" placeholder="Password" onpaste="return false;"
                                       oncopy="return false;"
                                       name="userPassword">
                            </li>
                            <li>
                                <button type="submit" class="site-btn">확인</button>
                            </li>
                        </ul>
                        <%if(checkUser == false){%>
                        <p class="text-center" style="color:#ff0000">잘못된 비밀번호입니다. 다시 확인해 주세요</p>
                        <% }%>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>


<jsp:include page="/incl/Footer.jsp"/>
</body>
</html>

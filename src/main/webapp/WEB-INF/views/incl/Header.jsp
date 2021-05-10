<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Google Font -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800,900&display=swap"
      rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="resources/css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="resources/css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="resources/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="resources/css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="resources/css/magnific-popup.css" type="text/css">
<link rel="stylesheet" href="resources/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="resources/css/style.css" type="text/css">
<link rel="stylesheet" href="resources/css/loginstyle.css" type="text/css">
<link rel="stylesheet" href="resources/css/signUpStyle.css" type="text/css">
<link rel="stylesheet" href="resources/css/ihover.min.css" type="text/css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="resources/js/cityInfo.js"></script>
<script src="resources/js/acyncMove.js"></script>
<!-- Offcanvas Menu Wrapper Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
    <div class="canvas-close">
        <span class="icon_close"></span>
    </div>
    <div class="logo">
        <a href="/"> <img src="resources/img/logo.png" alt="/">
        </a>
    </div>
    <div id="mobile-menu-wrap"></div>
    <div class="om-widget">
        <a href="#" class="hw-btn">Login</a>
    </div>
    <div class="om-social">
        <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
            class="fa fa-twitter"></i></a> <a href="#"><i
            class="fa fa-youtube-play"></i></a> <a href="#"><i
            class="fa fa-instagram"></i></a> <a href="#"><i
            class="fa fa-pinterest-p"></i></a>
    </div>
</div>
<!-- Offcanvas Menu Wrapper End -->

<!-- Header Section Begin -->
<header class="header-section">
    <div class="hs-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="logo">
                        <a href="/"><img src="resources/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-10">
                    <c:if test="${empty userVO.userNO}">
                        <div class="ht-widget">
                            <a href="signIn" class="hw-btn">Login</a>
                        </div>
                    </c:if>
                    <c:if test="${userVO.userNO != null}">
                        <div class="ht-widget">
                            <a href="logout" class="hw-btn">Logout</a>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="canvas-open">
                <span class="icon_menu"></span>
            </div>
        </div>
    </div>

    <div class="hs-nav">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <nav class="nav-menu">
                        <ul>
                            <li class="active"><a href="city">CITY</a>
                                <ul class="dropdown">
                                    <li><a href="city">서울</a>
                                    </li>
                                    <li><a href="city">강릉</a>
                                    </li>
                                    <li><a href="city">경주</a>
                                    </li>
                                    <li><a href="city">부산</a>
                                    </li>
                                    <li><a href="city">여수</a>
                                    </li>
                                    <li><a href="city">제주</a>
                                    </li>

                                </ul>
                            </li>
                            <li class="active"><a href="schedule">Schedule</a>
                                <ul class="dropdown">
                                    <li><a href="schedule">내 스케줄 보기</a></li>
                                    <li><a href="otherScheduleList?action=list">다른 사람 스케줄 보기</a></li>
                                </ul>
                            </li>
                            <li class="active"><a href="review">Review</a>
                                <ul class="dropdown">
                                    <li><a href="review">간 곳</a></li>
                                    <li><a href="review">먹은 곳</a></li>
                                    <li><a href="review">느낀 점</a></li>
                                    <li><a href="review">자유 게시판</a></li>
                                </ul>
                            </li>
                            <li class="active"><a href="myPage">MyPage</a></li>

                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="hn-social">
                        <c:if test="${userVO.userName != null}">
                            <p>환영합니다 ${userVO.userName}님.</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Header End -->

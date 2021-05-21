<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>한달 살기</title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="cityInfoSlide"/>
<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="col-lg-5">
                    <div class="section-title">
                        <h4>지역들</h4>
                    </div>
                </div>
                <div class="pd-board">
                    <div class="tab-board">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">도시 소개</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">교통 정보</a>
                            </li>
                        </ul><!-- Tab panes -->
                        <div class="tab-content">
                            <%--도시 소개--%>
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="tab-desc">
                                    <div class="row">
                                        <c:if test="${otherScheduleList != null}">
                                            <c:forEach var="scheduleContent" end="2" items="${otherScheduleList}"
                                                       varStatus="status">
                                                <div class="blog-item">
                                                    <div class="bi-pic">
                                                        <img src="resources/img/scheduleImg.png" alt="">
                                                    </div>
                                                    <div class="bi-text">
                                                        <h5><a href="./blog-details.html">Title
                                                            : ${scheduleContent.scheduleSubject}</a></h5>
                                                        <ul>
                                                            <li>by <span>${scheduleContent.userVO.userNickname}</span>
                                                            </li>
                                                            <li><span>${scheduleContent.userVO.getUserRealAge()}세</span>
                                                            </li>
                                                            <li>
                                                                <span>${scheduleContent.userVO.getUserSexToString()}</span>
                                                            </li>
                                                            <li>
                                                                <i class="icon_like"></i><span>${scheduleContent.scheduleLikeCount}</span>
                                                            </li>
                                                        </ul>
                                                        <p>${scheduleContent.userVO.userNickname}님의 ${scheduleContent.cityVO.cityName}에서
                                                            한달살기 스케줄 입니다!!</p>
                                                        <a href="/otherSchedule?userNO=${scheduleContent.userVO.userNO}&scheduleNO=${scheduleContent.scheduleNO}"
                                                           class="read-more">스케줄 보러가기 <span class="arrow_right"></span></a>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <%--교통 정보--%>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="tab-details">
                                    <div class="right_top_section">
                                        <div>
                                            <span class="reviewCategoryName">인기게시판</span>
                                            <a href="categoryReviewPage?category=popular" class="showMore">더보기></a>
                                        </div>


                                        <ul class="reviewMenu">
                                            <c:forEach var="reviewVO" items="${popularReviewList}" end="10">
                                                <li class="reviewCategorySubject">
                                                    <a href="getReview?reviewNO=${reviewVO.reviewNO}">${reviewVO.reviewSubject}</a>
                                                    <span class="reviewReplyCount">
                        <c:if test="${reviewVO.replyCount ne 0}">
                            [${reviewVO.replyCount}]
                        </c:if>
                    </span>
                                                    <span class="reviewCategoryViewCount"> ${reviewVO.reviewViewCount} </span>
                                                </li>
                                            </c:forEach>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
            <div class="col-lg-4">
                <div class="blog-sidebar">
                    <div class="subscribe-form">
                        <div class="section-title sidebar-title-b">
                            <h6>로그인</h6>
                        </div>
                        <p>더욱 다양한 한달살기 정보를 제공받으세요.</p>
                        <div class="hs-top">
                            <c:if test="${empty userVO.userNO}">
                                <div class="ht-widget">
                                    <a href="signIn" class="hw-btn">Login</a>
                                </div>
                            </c:if>
                            <%--                                <c:if test="${userVO.userNO != null}">--%>
                            <%--                                    <div class="ht-widget">--%>
                            <%--                                        <a href="logout" class="hw-btn">Logout</a>--%>
                            <%--                                    </div>--%>
                            <%--                                </c:if>--%>
                        </div>
                    </div>
                </div>
            </div>
            <tiles:insertAttribute name="cityInfoGrid"/>
        </div>
    </div>
</section>
<tiles:insertAttribute name="footer"/>
</body>
</html>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<body>
<div class="col-lg-8">
    <div class="pd-text">
        <div class="pd-board">
            <div class="tab-board">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">SCHEDULE</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">REVIEW</a>
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
                                                <h5><a href="/otherSchedule?userNO=${scheduleContent.userVO.userNO}&scheduleNO=${scheduleContent.scheduleNO}">Title
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
                    <%--인기 게시글--%>
                    <div class="tab-pane" id="tabs-2" role="tabpanel">
                        <div class="tab-desc">
                            <div class="row">
                                <c:forEach var="reviewVO" end="3" items="${popularReviewList}"
                                           varStatus="status">
                                    <div class="blog-item">
                                        <div class="pr-pic">
                                            <img src="${reviewVO.userVO.getUserImageURL()}" alt="">
                                        </div>
                                        <div class="bi-text">
                                            <h5><a href="getReview?reviewNO=${reviewVO.reviewNO}">Title
                                                : ${reviewVO.reviewSubject}</a></h5>
                                            <ul>
                                                <li>by <span>${reviewVO.userVO.userNickname}</span>
                                                </li>
                                                <li><span>${reviewVO.reviewDate}</span>
                                                </li>
                                                <li>
                                                    <i class="icon_like"></i><span>${reviewVO.reviewLikeCount}</span>
                                                </li>
                                                <li>
                                                    <i class="fa fa-eye"></i><span>${reviewVO.reviewViewCount}</span>
                                                </li>
                                            </ul>
                                            <p>${reviewVO.userVO.userNickname}님이 작성한 게시글입니다!!</p>
                                            <a href="getReview?reviewNO=${reviewVO.reviewNO}" class="read-more">
                                                게시글 보러가기 <span class="arrow_right"></span></a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link href="resources/css/schedule.css" rel="stylesheet" type="text/css">
<link href="resources/css/reply.css" rel="stylesheet" type="text/css">
<script src="resources/js/schedule.js"></script>
<script src="resources/js/reply.js"></script>

<body style="background:#ffffff">
<input type="hidden" id="userNO" name="userNO" value="${userVO.userNO}"/>
<input type="hidden" id="selectedScheduleNO" name="selectedScheduleNO" value="${otherScheduleAndLikeCount.scheduleNO}"/>
<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="section-title">
                    <h4> ${userVO.userNickname}님의 스케줄  [<span>${otherScheduleAndLikeCount.scheduleSubject}</span>]</h4>
                </div>
                <form name="calendarFrm" id="calendarFrm" action="otherSchedule">
                    <input type="hidden" name="year" value="${todayInformation.searchYear}"/>
                    <input type="hidden" name="month" value="${todayInformation.searchMonth-1}"/>
                    <div class="calendar">
                        <!--날짜 네비게이션  -->
                        <div class="navigation mb-0 pl-5 ml-5">
                            <a class="before_after_year"
                               href="./otherSchedule?scheduleNO=${scheduleNO}&year=${todayInformation.searchYear-1}&month=${todayInformation.searchMonth-1}">
                                &lt;&lt; <!-- 이전해 -->
                            </a>
                            <a class="before_after_month"
                               href="./otherSchedule?scheduleNO=${scheduleNO}&year=${todayInformation.beforeYear}&month=${todayInformation.beforeMonth}">
                                &lt; <!-- 이전달 -->
                            </a>
                            <span class="this_month">
                                &nbsp;${todayInformation.searchYear}.
                                <c:if test="${todayInformation.searchMonth<10}">0</c:if>
                                ${todayInformation.searchMonth}
				            </span>
                            <a class="before_after_month"
                               href="/otherSchedule?scheduleNO=${scheduleNO}&year=${todayInformation.afterYear}&month=${todayInformation.afterMonth}">
                                <!-- 다음달 --> &gt;
                            </a>
                            <a class="before_after_year"
                               href="/otherSchedule?scheduleNO=${scheduleNO}&year=${todayInformation.searchYear+1}&month=${todayInformation.searchMonth-1}">
                                <!-- 다음해 --> &gt;&gt;
                            </a>
                            <span id="scheduleViewCount" style="float:right;">
                                <i class="far fa-eye viewCountSpan"></i>
                                &nbsp;${otherScheduleAndLikeCount.scheduleViewCount}
                            </span>
                            <span id="likeCount" class="likeSpan"style="float: right"> &nbsp;${otherScheduleAndLikeCount.likeCount} </span>
                            <a href="#" class="heart-icon" onclick="updateScheduleLike(); return false;" style="float: right">
                                <c:choose>
                                    <c:when test="${likeStatus == 1}">
                                        <span id="like" class="icon_heart dis-none"></span>
                                    </c:when>
                                    <c:otherwise>
                                        <span id="like" class="icon_heart_alt"></span>
                                    </c:otherwise>
                                </c:choose>
                            </a>
                        </div>
                        <table class="calendar_body">
                            <thead>
                            <tr bgcolor="#CECECE">
                                <td class="day sun">일</td>
                                <td class="day">월</td>
                                <td class="day">화</td>
                                <td class="day">수</td>
                                <td class="day">목</td>
                                <td class="day">금</td>
                                <td class="day sat">토</td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <c:forEach var="dateList" items="${dateList}" varStatus="dateStatus">
                                <c:choose>
                                <c:when test="${dateList.value=='today'}">
                                <c:if test="${dateStatus.index%7==0}">
                            <tr>
                                </c:if>
                                <td class="today">
                                    <div class="date"></div>
                                    </c:when>
                                    <c:when test="${dateStatus.index%7==6}">
                                <td class="sat_day">
                                    <div class="sat"></div>
                                    </c:when>
                                    <c:when test="${dateStatus.index%7==0}">
                            </tr>
                            <tr>
                                <td class="sun_day">
                                    <div class="sun">
                                        </c:when>
                                        <c:otherwise>
                                <td class="normal_day">
                                    <div class="date"></div>
                                    </c:otherwise>
                                    </c:choose>
                                        ${dateList.date}
                                    <div>
                                        <c:forEach var="scheduleList" items="${dateList.scheduleDataArray}"
                                                   varStatus="scheduleDataArrayStatus">
                                            <div class="hoverScheduleSubject">
                                                <a href="#" data-toggle="modal"
                                                   data-target="#showScheduleContentModal"
                                                   onclick="showScheduleContentList('${scheduleList.scheduleContentNO}','${scheduleList.scheduleContentSubject}','${scheduleList.scheduleContentDate}',
                                                           '${scheduleList.scheduleContentDesc}','${scheduleList.scheduleContentCost}')">
                                                    <span class="thick"> ${scheduleList.scheduleContentSubject} </span>
                                                </a>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </td>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
            <div class="col-lg-4">
                <div class="section-title">
                    <h4>프로필</h4>
                </div>
                <div class="as-item">
                    <div class="user-pic">
                        <c:choose>
                            <c:when test="${userVO.userImage == null}">
                                <img src="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/user/default.jpg" alt>
                            </c:when>
                            <c:otherwise>
                                <img src=${userVO.getUserImageURL()} alt>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="as-text">
                        <div class="at-title">
                            <h6>${userVO.userNickname}님</h6>
                        </div>
                        <ul>
                            <li>Email <span>${userVO.userEmail}</span></li>
                            <li>Sex <span>${userVO.getUserSexToString()}</span></li>
                            <li>Age <span>${userVO.getUserRealAge()}세</span></li>
                        </ul>
                    </div>
                </div>
                <div class="section-title mt-0">
                    <h4>스케줄 관리</h4>
                </div>
                <div class="pd-text">
                    <div class="pd-board mb-1">
                        <div class="tab-board">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="user-service">
                                    <a class="nav-link active" data-toggle="tab" href="#schedule-tabs-1" role="tab">금액
                                        확인하기</a>
                                </li>
                            </ul><!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane active" id="schedule-tabs-1" role="tabpanel">
                                    <div class="tab-desc">
                                        <div class="row">
                                            <div class="blog-item">
                                                <div class="search-form-content">
                                                    <form action="durationPay" class="filter-form"
                                                          id="durationPay">
                                                        <div class="item-box mt-2 mb-2">
                                                            <span class="item-title pt-1">시작일</span>
                                                            <input type="date" id="schedulePayStartDay"
                                                                   name="schedulePayStartDay">
                                                        </div>
                                                        <div class="item-box mb-2">
                                                            <span class="item-title mb-2 pt-1">종료일</span>
                                                            <input type="date" id="schedulePayFinishDay"
                                                                   name="schedulePayFinishDay">
                                                        </div>

                                                        <c:if test="${message != null}">
                                                            <div class="item-box mt-2 mb-2">
                                                                <span class="item-title mb-2 pt-1">비용</span>
                                                                <span class="item-title pt-1" id="message"
                                                                      style="width: auto;color: #01d28e">${message}</span>
                                                            </div>
                                                        </c:if>
                                                        <input type="hidden" id="userNO" name="userNO" value="${userVO.userNO}"/>
                                                        <input type="hidden" id="selectedScheduleNO" name="selectedScheduleNO" value="${otherScheduleAndLikeCount.scheduleNO}"/>
                                                        <div class="item-box mb-2" id="scheduleDurationPay">
                                                            <button type="submit" class="site-btn">금액확인하기</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="container bootdey">
                    <div class="col-lg-7">
                        <div class="section-title mb-0">
                            <h4>Comments</h4>
                        </div>
                    </div>
                    <div class="col-md-12 bootstrap snippets">
                        <div class="panel">
                            <jsp:include page="ScheduleReplyDesc.jsp">
                                <jsp:param value="${otherScheduleAndLikeCount.scheduleNO}" name="scheduleNO"/>
                                <jsp:param value="0" name="scheduleReplyNO"/>
                            </jsp:include>
                        </div>
                        <div class="panel">
                            <div class="panel-body">
                                <c:forEach var="scheduleVOReply" items="${scheduleVOReplyList}">
                                    <c:if test="${scheduleVOReply.scheduleReply.scheduleReplyRefNO == 0 || scheduleVOReply.NO == scheduleVOReplyList[0].NO}">
                                        <div class="media-block">
                                            <a class="media-left" href="#">
                                                <c:choose>
                                                    <c:when test="${scheduleVOReply.userVO.userImage == null}">
                                                        <img class="img-circle img-sm" alt="Profile Picture"
                                                             src="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/user/default.jpg">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img class="img-circle img-sm" alt="Profile Picture"
                                                             src="${scheduleVOReply.userVO.getUserImageURL()}">
                                                    </c:otherwise>
                                                </c:choose>
                                            </a>
                                            <div class="media-body">
                                                <c:choose>
                                                    <c:when test="${scheduleVOReply.scheduleReply.scheduleReplyRefNO == 0}">
                                                        <jsp:include page="ScheduleReply.jsp">
                                                            <jsp:param value="${otherScheduleAndLikeCount.scheduleNO}"
                                                                       name="scheduleNO"/>
                                                            <jsp:param value="${scheduleVOReply.userVO.userNickname}"
                                                                       name="userNickname"/>
                                                            <jsp:param
                                                                    value="${scheduleVOReply.scheduleReply.scheduleReplyNO}"
                                                                    name="scheduleReplyNO"/>
                                                            <jsp:param
                                                                    value="${scheduleVOReply.scheduleReply.scheduleReplyDate}"
                                                                    name="scheduleReplyDate"/>
                                                            <jsp:param
                                                                    value="${scheduleVOReply.scheduleReply.scheduleReplyDesc}"
                                                                    name="scheduleReplyDesc"/>
                                                            <jsp:param value="${scheduleVOReply.scheduleReply.userNO}"
                                                                       name="userNO"/>
                                                        </jsp:include>
                                                    </c:when>
                                                    <c:when test="${scheduleVOReply.NO == scheduleVOReplyList[0].NO}">
                                                        <c:set var="beforePageScheduleReplyNO"
                                                               value="${scheduleVOReply.scheduleReply.scheduleReplyRefNO}"></c:set>
                                                        <div class="media-body">
                                                            <p>
                                                                <br>
                                                                &nbsp;&nbsp;이전 페이지의 대댓글입니다.
                                                            </p>
                                                        </div>
                                                        <hr>
                                                    </c:when>
                                                </c:choose>

                                                <c:forEach var="scheduleVOReplyRef" items="${scheduleVOReplyList}">
                                                    <c:if test="${scheduleVOReply.scheduleReply.scheduleReplyNO == scheduleVOReplyRef.scheduleReply.scheduleReplyRefNO || beforePageScheduleReplyNO == scheduleVOReplyRef.scheduleReply.scheduleReplyRefNO}">
                                                        <div>
                                                            <div class="media-block">
                                                                <a class="media-left" href="#">
                                                                    <c:choose>
                                                                        <c:when test="${scheduleVOReplyRef.userVO.userImage == null}">
                                                                            <img class="img-circle img-sm"
                                                                                 alt="Profile Picture"
                                                                                 src="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/user/default.jpg">
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <img class="img-circle img-sm"
                                                                                 alt="Profile Picture"
                                                                                 src="${scheduleVOReplyRef.userVO.getUserImageURL()}">
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </a>
                                                                <div class="media-body">
                                                                    <jsp:include page="ScheduleReply.jsp">
                                                                        <jsp:param
                                                                                value="${otherScheduleAndLikeCount.scheduleNO}"
                                                                                name="scheduleNO"/>
                                                                        <jsp:param
                                                                                value="${scheduleVOReplyRef.userVO.userNickname}"
                                                                                name="userNickname"/>
                                                                        <jsp:param
                                                                                value="${scheduleVOReplyRef.scheduleReply.scheduleReplyNO}"
                                                                                name="scheduleReplyNO"/>
                                                                        <jsp:param
                                                                                value="${scheduleVOReplyRef.scheduleReply.scheduleReplyDate}"
                                                                                name="scheduleReplyDate"/>
                                                                        <jsp:param
                                                                                value="${scheduleVOReplyRef.scheduleReply.scheduleReplyDesc}"
                                                                                name="scheduleReplyDesc"/>
                                                                        <jsp:param
                                                                                value="${scheduleVOReplyRef.scheduleReply.userNO}"
                                                                                name="userNO"/>
                                                                        <jsp:param
                                                                                value="${scheduleVOReplyRef.scheduleReply.scheduleReplyRefNO}"
                                                                                name="checkScheduleReplyRefNO"/>
                                                                    </jsp:include>
                                                                    <hr>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                </c:forEach>
                                                <c:set var="beforePageScheduleReplyNO" value="-1"></c:set>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>

                                <jsp:include page="Paging.jsp">
                                    <jsp:param value="${otherScheduleAndLikeCount.scheduleNO}" name="scheduleNO"/>
                                    <jsp:param value="${paging.page}" name="page"/>
                                    <jsp:param value="${paging.beginPage}" name="beginPage"/>
                                    <jsp:param value="${paging.endPage}" name="endPage"/>
                                    <jsp:param value="${paging.prev}" name="prev"/>
                                    <jsp:param value="${paging.next}" name="next"/>
                                </jsp:include>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="ScheduleModal.jsp"/>

</body>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.liveamonth.liveamonth.entity.dto.CalendarDTO" %>
<%@ page import="com.liveamonth.liveamonth.entity.vo.ScheduleVO" %>
<%@page import="java.util.*" %>

<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
<link href="resources/css/schedule.css" rel="stylesheet" type="text/css">
<link href="resources/css/reply.css" rel="stylesheet" type="text/css">
<script src="resources/js/schedule.js"></script>
<script src="resources/js/reply.js"></script>


<body style="background:#ffffff">
<input type="hidden" id="userNO" name="userNO" value="${userVO.userNO}"/>
<input type="hidden" id="selectedScheduleNO" name="selectedScheduleNO" value="${otherScheduleAndLikeCount.scheduleNO}"/>

<form name="calendarFrm" id="calendarFrm" action="otherSchedule">
    <input type="hidden" name="year" value="${todayInformation.searchYear}"/>
    <input type="hidden" name="month" value="${todayInformation.searchMonth-1}"/>
    <script>
        var message = "${message}";
        if (message != "") {
            alert(message);
        }
    </script>
    <div class="calendar">
        <!--날짜 네비게이션  -->
        <div class="navigation">
            <a class="before_after_year"
               href="./otherSchedule?scheduleNO=${scheduleNO}&year=${todayInformation.searchYear-1}&month=${todayInformation.searchMonth-1}">
                &lt;&lt; <!-- 이전해 -->
            </a>
            <a class="before_after_month"
               href="./otherSchedule?scheduleNO=${scheduleNO}&year=${todayInformation.beforeYear}&month=${todayInformation.beforeMonth}">
                &lt; <!-- 이전달 -->
            </a>
            <span class="this_month"> &nbsp;${todayInformation.searchYear}. <c:if
                    test="${todayInformation.searchMonth<10}">0</c:if>${todayInformation.searchMonth}
               </span>
            <a class="before_after_month"
               href="/otherSchedule?scheduleNO=${scheduleNO}&year=${todayInformation.afterYear}&month=${todayInformation.afterMonth}">
                <!-- 다음달 --> &gt;
            </a>
            <a class="before_after_year"
               href="/otherSchedule?scheduleNO=${scheduleNO}&year=${todayInformation.searchYear+1}&month=${todayInformation.searchMonth-1}">
                <!-- 다음해 --> &gt;&gt;
            </a>
            <span> <div></div></span>
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
                <c:forEach var="dateList" items="${dateList}"
                           varStatus="dateStatus">
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
    </div>
    <div>
        <c:forEach var="scheduleList"
                   items="${dateList.scheduleDataArray}"
                   varStatus="scheduleDataArrayStatus">
            <div class="hoverScheduleSubject">
                <a href="#" data-toggle="modal"
                   data-target="#showScheduleContentModal"
                   onclick="showScheduleContentList('${scheduleList.scheduleContentNO}','${scheduleList.scheduleContentSubject}','${scheduleList.scheduleContentDate}',
                           '${scheduleList.scheduleContentDesc}','${scheduleList.scheduleContentCost}')">
                                    <span class="thick">
                                            ${scheduleList.scheduleContentSubject} </span>
                </a>
            </div>
        </c:forEach>
    </div>
    </c:forEach>
    </tbody>
    </table>
</form>

<div class="modal fade" id="showScheduleContentModal" role="dialog"
     aria-labelledby="showScheduleLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="showScheduleLabel">스케줄</h5>
                <button type="button" class="close" data-dismiss="modal" onclick="resetAddScheduleContentButton()"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div class="info"></div>
                <form name="deleteScheduleContent" action="deleteScheduleContent">
                    <input type="hidden" name="year" value="${todayInformation.searchYear}"/>
                    <div class="contents">
                        <p class="scheduleContentSubject">
                            <span class="scheduleContentSubjectMessage"></span>
                        </p>
                        <p class="scheduleContentDesc">
                            <span class="scheduleContentDescMessage"></span>
                        </p>
                        <p class="scheduleContentCost">
                            <span class="scheduleContentCostMessage"></span>
                        </p>

                        <div>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="container bootdey likeDiv">
    <span class="likeSpan"> 좋아요&nbsp;&nbsp; </span>
    <a href="#" class="heart-icon" onclick="updateScheduleLike(); return false; ">
        <c:choose>
            <c:when test="${likeStatus == 1}">
                <span id="like" class="icon_heart dis-none"></span>
            </c:when>
            <c:otherwise>
                <span id="like" class="icon_heart_alt"></span>
            </c:otherwise>
        </c:choose>
    </a>
    <span id="likeCount" class="likeSpan"
          style="margin-right: 20px;"> &nbsp;${otherScheduleAndLikeCount.likeCount} </span>
    <span class="likeSpan"> 조회수&nbsp;&nbsp; </span>
    <span id="scheduleViewCount" class="likeSpan"><i
            class="far fa-eye viewCountSpan"></i>  &nbsp;${otherScheduleAndLikeCount.scheduleViewCount} </span>
</div>

<div class="container bootdey">
    <div class="col-lg-7">
        <div class="section-title">
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
                                <img class="img-circle img-sm" alt="Profile Picture"
                                                                src="${scheduleVOReply.userVO.getUserImageURL()}"></a>
                            <div class="media-body">
                                <c:choose>
                                    <c:when test="${scheduleVOReply.scheduleReply.scheduleReplyRefNO == 0}">
                                        <jsp:include page="ScheduleReply.jsp">
                                            <jsp:param value="${otherScheduleAndLikeCount.scheduleNO}"
                                                       name="scheduleNO"/>
                                            <jsp:param value="${scheduleVOReply.userVO.userNickname}" name="userNickname"/>
                                            <jsp:param value="${scheduleVOReply.scheduleReply.scheduleReplyNO}"
                                                       name="scheduleReplyNO"/>
                                            <jsp:param value="${scheduleVOReply.scheduleReply.scheduleReplyDate}"
                                                       name="scheduleReplyDate"/>
                                            <jsp:param value="${scheduleVOReply.scheduleReply.scheduleReplyDesc}"
                                                       name="scheduleReplyDesc"/>
                                            <jsp:param value="${scheduleVOReply.scheduleReply.userNO}" name="userNO"/>
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
                                                    <img class="img-circle img-sm" alt="Profile Picture"
                                                         src="${scheduleVOReplyRef.userVO.getUserImageURL()}"></a>
                                                <div class="media-body">
                                                    <jsp:include page="ScheduleReply.jsp">
                                                        <jsp:param value="${otherScheduleAndLikeCount.scheduleNO}"
                                                                   name="scheduleNO"/>
                                                        <jsp:param value="${scheduleVOReplyRef.userVO.userNickname}"
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
                                                        <jsp:param value="${scheduleVOReplyRef.scheduleReply.userNO}"
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
                                <c:set var="beforePageScheduleReplyNO" value="null"></c:set>
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
</body>
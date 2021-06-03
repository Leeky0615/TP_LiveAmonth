<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<link href="resources/css/schedule.css" rel="stylesheet" type="text/css">--%>
<%--<link href="resources/css/smallSchedule.css" rel="stylesheet" type="text/css">--%>
<script src="resources/js/evo-calendar.js"></script>
<link href="resources/css/evo-calendar.royal-navy.css" rel="stylesheet" type="text/css">
<div class="royal-navy">
    <div class="calendar-inner">
        <table class="calendar-body">
            <tbody>
            <tr>
                <th colspan="7">June</th>
            </tr>
            <tr class="calendar-header">
                <td class="calendar-header-day --weekend">Sun</td>
                <td class="calendar-header-day">Mon</td>
                <td class="calendar-header-day">Tue</td>
                <td class="calendar-header-day">Wed</td>
                <td class="calendar-header-day">Thu</td>
                <td class="calendar-header-day">Fri</td>
                <td class="calendar-header-day --weekend">Sat</td>
            </tr>
            <c:forEach var="dateList" items="${dateList}" varStatus="dateStatus">
            <c:choose>
            <c:when test="${dateList.value=='today'}">
            <c:if test="${dateStatus.index%7==0}">
            <tr>
                </c:if>
                <td class="today">
                    <div class="day"></div>
                    </c:when>
                    <c:when test="${dateStatus.index%7==6}">
                <td class="sat_day ">
                    <div class="day"></div>
                    </c:when>
                    <c:when test="${dateStatus.index%7==0}">
            </tr>
            <tr>
                <td class="calendar-day --weekend">
                    <div class="day">
                        </c:when>
                        <c:otherwise>
                <td class="normal_day">
                    <div class="day"></div>
                    </c:otherwise>
                    </c:choose>
                        ${dateList.date}
                    <div>
                        <c:forEach var="scheduleList"
                                   items="${dateList.scheduleDataArray}"
                                   varStatus="scheduleDataArrayStatus">
                            <div class="hoverScheduleSubject">
                                <span class="day"> ${scheduleList.scheduleContentSubject} </span>
                            </div>
                        </c:forEach>
                    </div>
                    </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="calendar-events">
    <div class="event-header"><p>June 2, 2021</p></div>
    <div class="event-list">
        <div class="event-container" role="button" data-event-index="in8bha4">
            <div class="event-icon">
                <div class="event-bullet-holiday"></div>
            </div>
            <div class="event-info"><p class="event-title">Holiday #2</p>
                <p class="event-desc">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p></div>
        </div>
        <div class="event-container" role="button" data-event-index="in8bha4">
            <div class="event-icon">
                <div class="event-bullet-event"></div>
            </div>
            <div class="event-info"><p class="event-title">Event #2</p></div>
        </div>
    </div>
</div>
<span id="eventListToggler" role="button" aria-pressed="" title="Close event list"><button class="icon-button"><span
        class="chevron-arrow-right"></span></button></span>
<%--    <form name="calendarFrm" id="calendarFrm" action="otherSchedule">--%>
<%--        <div class="calendar">--%>
<%--            <!--날짜 네비게이션  -->--%>
<%--            <div class="navigation">--%>
<%--                <span class="this_month"> &nbsp;${todayInformation.searchYear}. <c:if--%>
<%--                        test="${todayInformation.searchMonth<10}">0</c:if>${todayInformation.searchMonth}--%>
<%--               </span>--%>
<%--                <span> <div></div></span>--%>
<%--            </div>--%>

<%--            <table class="calendar_body">--%>
<%--                <thead>--%>
<%--                <tr bgcolor="#CECECE" style="font-size: 5px">--%>
<%--                    <td class="day sun">일</td>--%>
<%--                    <td class="day">월</td>--%>
<%--                    <td class="day">화</td>--%>
<%--                    <td class="day">수</td>--%>
<%--                    <td class="day">목</td>--%>
<%--                    <td class="day">금</td>--%>
<%--                    <td class="day sat">토</td>--%>
<%--                </tr>--%>
<%--                </thead>--%>
<%--                <tbody>--%>
<%--                    <c:forEach var="dateList" items="${dateList}"--%>
<%--                               varStatus="dateStatus">--%>
<%--                    <c:choose>--%>
<%--                    <c:when test="${dateList.value=='today'}">--%>
<%--                    <c:if test="${dateStatus.index%7==0}">--%>
<%--                <tr>--%>
<%--                    </c:if>--%>
<%--                    <td class="today">--%>
<%--                        <div class="date"></div>--%>
<%--                        </c:when>--%>
<%--                        <c:when test="${dateStatus.index%7==6}">--%>
<%--                    <td class="sat_day">--%>
<%--                        <div class="sat"></div>--%>
<%--                        </c:when>--%>
<%--                        <c:when test="${dateStatus.index%7==0}">--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td class="sun_day">--%>
<%--                        <div class="sun">--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                    <td class="normal_day">--%>
<%--                        <div class="date"></div>--%>
<%--                        </c:otherwise>--%>
<%--                        </c:choose>--%>
<%--                            ${dateList.date}--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <c:forEach var="scheduleList"--%>
<%--                       items="${dateList.scheduleDataArray}"--%>
<%--                       varStatus="scheduleDataArrayStatus">--%>
<%--                <div class="hoverScheduleSubject">--%>
<%--                     <span class="day"> ${scheduleList.scheduleContentSubject} </span>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--        </table>--%>
<%--    </form>--%>

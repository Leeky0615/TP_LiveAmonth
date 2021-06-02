<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link href="resources/css/smallSchedule.css" rel="stylesheet" type="text/css">
<%--<link href="resources/css/schedule.css" rel="stylesheet" type="text/css">--%>
<body style="background:#ffffff">
<div>
    <form name="calendarFrm" id="calendarFrm" action="otherSchedule">
        <div class="calendar">
            <!--날짜 네비게이션  -->
            <div class="navigation">
                <span class="this_month"> &nbsp;${todayInformation.searchYear}. <c:if
                        test="${todayInformation.searchMonth<10}">0</c:if>${todayInformation.searchMonth}
               </span>
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
                     <span class="day"> ${scheduleList.scheduleContentSubject} </span>
                </div>
            </c:forEach>
        </div>
        </c:forEach>
        </tbody>
        </table>
    </form>
</div>

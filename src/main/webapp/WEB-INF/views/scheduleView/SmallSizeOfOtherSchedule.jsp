<%@ page import="com.liveamonth.liveamonth.constants.LogicConstants" %>
<%@ page import="com.liveamonth.liveamonth.constants.EntityConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--<link href="resources/css/schedule.css" rel="stylesheet" type="text/css">--%>
<link href="resources/css/smallSchedule.css" rel="stylesheet" type="text/css">
<%--<script src="resources/js/evo-calendar.js"></script>--%>
<%--<link href="resources/css/evo-calendar.royal-navy.css" rel="stylesheet" type="text/css">--%>
<div class="royal-navy p-3">
    <table class="calendar_body p-2">
        <tbody>
        <tr>
            <th colspan="7">${monthList[todayInformation.searchMonth-1]}</th>
        </tr>
        <tr class="calendar-header">
            <td class="calendar-header-day">Sun</td>
            <td class="calendar-header-day">Mon</td>
            <td class="calendar-header-day">Tue</td>
            <td class="calendar-header-day">Wed</td>
            <td class="calendar-header-day">Thu</td>
            <td class="calendar-header-day">Fri</td>
            <td class="calendar-header-day">Sat</td>
        </tr>
        <c:forEach var="dateList" items="${dateList}" varStatus="dateStatus">
        <c:choose>
        <c:when test="${dateList.value=='today'}">
        <c:if test="${dateStatus.index%7==0}">
        <tr>
            </c:if>
            <td id="${listIndex}_${dateList.date}" class="today">
                </c:when>
                <c:when test="${dateStatus.index%7==0}">
        </tr>
        <tr>
            <td id="${listIndex}_${dateList.date}" class="sun_day">
                </c:when>
                <c:when test="${dateStatus.index%7==6}">
            <td id="${listIndex}_${dateList.date}" class="sat_day">
                </c:when>
                <c:otherwise>
            <td id="${listIndex}_${dateList.date}" class="normal_day">
                </c:otherwise>
                </c:choose>
                <span class="contents pl-1">${dateList.date}</span>
                <div class="scheduleContentsModal" id="${listIndex}_${dateList.date}_modal">
                    <div class="form-group mb-0">
                        <label class="scheduleContentLabel m-0 pl-3">Contents Title</label>
                        <c:forEach var="scheduleList" items="${dateList.scheduleDataArray}" varStatus="status">
                            <c:if test="${scheduleList.scheduleContentNO != null}">
                                <label id="scheduleContentSubject" class="contents-label mt-1" readonly>#${status.index+1}. ${scheduleList.scheduleContentSubject}</label>
                                <c:set value="true" var="scheduleStatus"/>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <c:if test="${scheduleStatus == true}">
                <script>
                    $('.contents').parent('td#${listIndex}_${dateList.date}').css('background-color', '#00C89E');
                    $('.contents').parent('td#${listIndex}_${dateList.date}').css('font-weight', 'bold');
                    $('.contents').parent('td#${listIndex}_${dateList.date}').css('color', '#e1edea');
                    $('.contents').parent('td#${listIndex}_${dateList.date}').attr("name", 'Contents');
                    $('td#${listIndex}_${dateList.date}').hover(function (e) {
                        $('td#${listIndex}_${dateList.date}').css('color', '#00C89E');
                        $('td#${listIndex}_${dateList.date}').css('background-color', '#e1edea');
                        $("#${listIndex}_${dateList.date}_modal").css('left', e.offsetX+20);
                        $("#${listIndex}_${dateList.date}_modal").css('top', e.offsetY+5);
                        $("#${listIndex}_${dateList.date}_modal").css('display', 'block');
                    }, function (e) {
                        $('td#${listIndex}_${dateList.date}').css('color', '#e1edea');
                        $('td#${listIndex}_${dateList.date}').css('background-color', '#00C89E');
                        $("#${listIndex}_${dateList.date}_modal").css('display', 'none');
                    });
                </script>
                    <c:set value="false" var="scheduleStatus"/>
                </c:if>
                </c:forEach>
        </tbody>
    </table>
</div>


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

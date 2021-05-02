<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.liveamonth.liveamonth.entity.vo.ScheduleVO" %>
<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.List" %>
<%@page import="com.liveamonth.liveamonth.constants.EntityConstants.*" %>
<body>
<form action="/otherScheduleList" class="filter-form">
    <h4>필터 검색</h4>
    <table>
        <thead>
        <tr>
            <th><label>성별</label></th>
            <th><label>나이</label></th>
            <th><label>장소</label></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><select name="userSex" id="userSex" class="sm-width">
                <option value="null">기본</option>
                <option value="0">남성</option>
                <option value="1">여성</option>
            </select>
            </td>
            <td><select name="userAge" id="userAge" class="sm-width">
                <option value="null">기본</option>
                <option value="20">20대</option>
                <option value="30">30대</option>
                <option value="40">40대</option>
                <option value="50">50대</option>
                <option value="60">60대</option>
            </select></td>
            <td><select name="schedulePlace" id="schedulePlace" class="sm-width">
                <option value="null">기본</option>
                <c:forEach var="schedulePlace" items="${schedulePlaceList}" varStatus="status">
                    <option value="${status.index}">${schedulePlace.nameKR}</option>
                </c:forEach>
            </select></td>
            <!-- 	<td><input type="submit" name="filter" value="조회"></td> -->
        </tr>
        </tbody>
    </table>

    <h4>정렬</h4>
    <table>
        <thead>
        <tr>
            <th><label>정렬 조건</label></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <input type="radio" name="orderBy" value="orderByLiked" checked="checked" class="sm-width">좋아요 순
                <input type="radio" name="orderBy" value="orderByView" class="sm-width">조회 순
                <input type="radio" name="orderBy" value="orderByNew" class="sm-width">최신 순
            </td>
            <td><input type="submit" name="order" value="적용"></td>
        </tr>
        </tbody>
    </table>
    <input type="hidden" name="action" value="filter">
</form>

<div class="pc-table">
    <table>
        <thead>
        <tr>
            <th class="type">스케줄(이미지, 제목)</th>
            <th class="type">장소</th>
            <th class="type">닉네임</th>
            <th class="type">성별</th>
            <th class="type">나이</th>
            <th class="type">조회 수</th>
            <th class="type">좋아요 수</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${otherScheduleList != null}">
            <c:forEach var="scheduleContent" items="${otherScheduleList}" varStatus="status">
                <c:forEach var="cityName" items="${schedulePlaceList}">
                    <c:if test="${scheduleContent.schedulePlace eq cityName}">
                        <c:set var="place" value="${cityName.nameKR}"/>
                    </c:if>
                </c:forEach>
                <c:choose>
                    <c:when test="${scheduleContent.userVO.userSex eq 'false'}">
                        <c:set var="sex" value="남자"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="sex" value="여자"/>
                    </c:otherwise>
                </c:choose>
                <tr>
                    <td>
                        <div class="title">스케줄 제목</div>
                        <a
                                href="/otherSchedule?userNO=${scheduleContent.userVO.userNO}&scheduleNO=${scheduleContent.scheduleNO}">
                            <img src="resources/img/scheduleImg.png" alt="">
                        </a>
                    </td>
                    <td>${place}</td>
                    <td>${scheduleContent.userVO.userNickname}</td>
                    <td>${sex}</td>
                    <td>${scheduleContent.userVO.userAge}세</td>
                    <td>${scheduleContent.scheduleViewCount}</td>
                    <td>${scheduleContent.scheduleLikeCount}</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
</body>
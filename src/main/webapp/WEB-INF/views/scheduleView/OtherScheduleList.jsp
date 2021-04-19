<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="utf-8">

<head>
</head>

<body>
<jsp:include page="/incl/Header.jsp" />

<!--  <div class="container">
   <div class="row">
      <div class="col-lg-12 p-0">  -->

<!-- <div>
   <form action="/filteringScheduleList" class="filter-form">
      <h4>필터 검색</h4>
      <label>성별</label> <br> <select name="sex" id="sex"
         class="sm-width">
         <option value="0">기본</option>
         <option value="1">남성</option>
         <option value="2">여성</option>
      </select> <label>나이</label> <br> <select name="age" id="age"
         class="sm-width">
         <option value="0">기본</option>
         <option value="20">20대</option>
         <option value="30">30대</option>
         <option value="40">40대</option>
         <option value="50">50대</option>
         <option value="60">60대</option>
      </select> <label>장소</label> <br> <select name="place" id="place"
         class="sm-width">
         <option value="NULL">기본</option>
         <option value="SEOUL">서울</option>
         <option value="JEJU">제주</option>
      </select> <input type="submit" value="조회">
   </form>
</div> -->

<form action="/filteringScheduleList" class="filter-form">
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
         <td><select name="sex" id="sex" class="sm-width">
            <option value="0">기본</option>
            <option value="1">남성</option>
            <option value="2">여성</option>
         </select></td>
         <td><select name="age" id="age" class="sm-width">
            <option value="0">기본</option>
            <option value="20">20대</option>
            <option value="30">30대</option>
            <option value="40">40대</option>
            <option value="50">50대</option>
            <option value="60">60대</option>
         </select></td>
         <td><select name="place" id="place" class="sm-width">
            <option value="NULL">기본</option>
            <c:forEach var="place" items="${placeList}">
               <option value="${place}">${place.label}</option>
            </c:forEach>
         </select></td>
         <td><input type="submit" value="조회"></td>
      </tr>
      </tbody>
   </table>
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
         <th class="type">좋아요 수</th>
      </tr>
      </thead>
      <tbody>

      <c:set var="now" value="<%=new java.util.Date()%>" />
      <c:set var="sysYear">
         <fmt:formatDate value="${now}" pattern="yyyy" />
      </c:set>

      <c:set var="size" value="${fn:length(userVOList)}" />
      <c:forEach var="i" begin="0" end="${size-1}">
         <c:choose>
            <c:when test="${userVOList[i].isUserSex() eq 'false'}">
               <c:set var="sex" value="남자" />
            </c:when>

            <c:otherwise>
               <c:set var="sex" value="여자" />
            </c:otherwise>
         </c:choose>

         <tr>
            <td>
               <div class="title">스케줄 제목</div> <a
                    href="/otherSchedule?useNO=${userVOList[i].getUserNO()}&scheduleNO=${scheduleVOList[i].getScheduleNO()}">
               <img src="resources/img/scheduleImg.png" alt="">
            </a>
            </td>
            <td><c:out value="${scheduleVOList[i].getPlace()}" /></td>
            <td><c:out value="${userVOList[i].getUserNickname()}" /></td>
            <td><c:out value="${sex}" /></td>
            <td><c:out value="${sysYear-userVOList[i].getUserAge()}세" /></td>
            <td><c:out
                    value="${scheduleVOList[i].getScheduleLikeCount()}" /></td>
         </tr>
      </c:forEach>
      </tbody>
   </table>
</div>
<jsp:include page="/incl/Footer.jsp" />
</body>
</html>
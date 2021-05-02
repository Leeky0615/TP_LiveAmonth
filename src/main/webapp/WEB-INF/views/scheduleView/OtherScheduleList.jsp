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

<!--  <div class="container">
   <div class="row">
      <div class="col-lg-12 p-0">  -->

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
         <td><select name="sex" id="sex" class="sm-width">
            <option value="0">기본</option>
            <option value="1">남성</option>
            <option value="2">여성</option>
         </select>
         </td>       
         <td><select name="age" id="age" class="sm-width">
            <option value="0">기본</option>
            <option value="20">20대</option>
            <option value="30">30대</option>
            <option value="40">40대</option>
            <option value="50">50대</option>
            <option value="60">60대</option>
         </select></td>
         <td><select name="place" id="place" class="sm-width">
            <option value= "null">기본</option>
            <c:forEach var="place" items="${placeList}">
               <option value="${place}">${place.label}</option>
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
        	 <input type="radio" name="orderBy" value="orderByLiked" checked = "checked" class="sm-width">좋아요 순
        	 <input type="radio" name="orderBy" value="orderByNew" class="sm-width">최신 순
		 </td>
         <td><input type="submit" name="order" value="적용"></td>
      </tr>
      </tbody>
   </table>
   <input type="hidden" name = "action" value = "filter">
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
		
	  <c:if test="${userVOList.size()>0}">
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
                    href="/otherSchedule?userNO=${userVOList[i].getUserNO()}&scheduleNO=${scheduleVOList[i].getScheduleNO()}">
               <img src="resources/img/scheduleImg.png" alt="">
            </a>
            </td>

            <td><c:set var="place" value="${scheduleVOList[i].getPlace()}"/>
               <c:choose>
                  <c:when test="${place eq 'SEOUL'}">
                     <c:out value= '서울'/>
                  </c:when>
                  <c:when test="${place eq 'JEJU'}">
                     <c:out value= '제주'/>
                  </c:when>
                  <c:when test="${place eq 'BUSAN'}">
                     <c:out value= '부산'/>
                  </c:when>
                  <c:when test="${place eq 'GANGNEUNG'}">
                     <c:out value= '강릉'/>
                  </c:when>
                  <c:when test="${place eq 'YEOSU'}">
                     <c:out value= '여수'/>
                  </c:when>
                  <c:when test="${place eq 'GYEONGJU'}">
                     <c:out value= '경주'/>
                  </c:when>
                  <c:otherwise>
                     <c:out value= '??'/>
                  </c:otherwise>
               </c:choose>
            </td>
            <td><c:out value="${userVOList[i].getUserNickname()}" /></td>
            <td><c:out value="${sex}" /></td>
            <td><c:out value="${sysYear-userVOList[i].getUserAge()}세" /></td>
            <td><c:out
                    value="${scheduleVOList[i].getScheduleLikeCount()}" /></td>
         </tr>
      </c:forEach>
      </c:if>
      <c:if test="${userVOList.size()==0}">
         <c:out value= '조건에 해당하는 결과가 없습니다'/>
      </c:if>
      </tbody>
   </table>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Insert title here</title>
   <style type="text/css">
      #paging{
         text-align:center;
      }
      #paging{
         font-size: 22pt;
      }
   </style>
</head>
<body>
<div id="paging" class="col-lg-12">
   <div class="property-pagination">
      <c:url var="action" value="otherSchedule?scheduleNO=${scheduleNO}"/>
      <c:if test="${param.prev}">
         <a href="${action}&page=${param.beginPage-1}"><-</a>
      </c:if>
      <c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1" var="index">
         <c:choose>
            <c:when test="${param.page==index}">
               <a id = "selectPage">${index}</a>
            </c:when>
            <c:otherwise>
               <a href="${action}&page=${index}">${index}</a>
            </c:otherwise>
         </c:choose>
      </c:forEach>
      <c:if test="${param.next}">
         <a href="${action}&page=${param.endPage+1}">-></a>
      </c:if>
   </div>
</div>
</body>
</html>
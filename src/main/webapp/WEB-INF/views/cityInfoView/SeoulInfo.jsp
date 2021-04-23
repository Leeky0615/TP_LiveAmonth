<%@ page import="com.liveamonth.liveamonth.entity.vo.CityInfoVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    CityInfoVO seoulInfo = (CityInfoVO) request.getAttribute("seoulInfo");
    ArrayList<CityInfoVO> seoulFoodList = (ArrayList<CityInfoVO>) request.getAttribute("seoulFoodList");
    ArrayList<CityInfoVO> seoulViewList = (ArrayList<CityInfoVO>) request.getAttribute("seoulViewList");
%>
<jsp:include page="/incl/Header.jsp"/>
<%--탭누를때마다 정보가 3개--%>
<p>info : <c:out value="${seoulInfo.getCityDesc()}" /></p>
<p>
    food : <c:out value="${seoulFoodList[0].getCityDesc()}" />
    <img src="/resources/img/food/+<c:out value='${seoulFoodList[0].getCityDesc()}' />" alt>
</p>
<p>
    view : <c:out value="${seoulViewList[0].getCityDesc()}" />
</p>

<jsp:include page="/incl/Footer.jsp"/>
</body>
</html>

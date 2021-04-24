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
    CityInfoVO yeosuInfo = (CityInfoVO) request.getAttribute("yeosuInfo");
    ArrayList<CityInfoVO> yeosuFoodList = (ArrayList<CityInfoVO>) request.getAttribute("yeosuFoodList");
    ArrayList<CityInfoVO> yeosuViewList = (ArrayList<CityInfoVO>) request.getAttribute("yeosuViewList");
%>
<jsp:include page="/incl/Header.jsp"/>

<p> 정보 : <c:out value="${yeosuInfo.getCityDesc()}" /></p>
<p>
    먹을거리 : <c:out value="${yeosuFoodList[0].getCityDesc()}" />
    <img src="/resources/img/food/+<c:out value='${yeosuFoodList[0].getCityDesc()}' />" alt>
</p>
<p>
    볼거리 : <c:out value="${yeosuViewList[0].getCityDesc()}" />
</p>

<jsp:include page="/incl/Footer.jsp"/>
</body>
</html>

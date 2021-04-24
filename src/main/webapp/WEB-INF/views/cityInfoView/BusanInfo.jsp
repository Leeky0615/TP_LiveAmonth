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
    CityInfoVO busanInfo = (CityInfoVO) request.getAttribute("busanInfo");
    ArrayList<CityInfoVO> busanFoodList = (ArrayList<CityInfoVO>) request.getAttribute("busanFoodList");
    ArrayList<CityInfoVO> busanViewList = (ArrayList<CityInfoVO>) request.getAttribute("busanViewList");
%>
<jsp:include page="/incl/Header.jsp"/>

<p>info : <c:out value="${busanInfo.getCityDesc()}" /></p>
<p>
    food : <c:out value="${busanFoodList[0].getCityDesc()}" />
    <img src="/resources/img/food/+<c:out value='${busanFoodList[0].getCityDesc()}' />" alt>
</p>
<p>
    view : <c:out value="${busanViewList[0].getCityDesc()}" />
</p>

<jsp:include page="/incl/Footer.jsp"/>
</body>
</html>
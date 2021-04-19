<%@ page import="com.liveamonth.liveamonth.entity.vo.CityInfoVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <title>한달 살기</title>
</head>

<body>
<%
    ArrayList<CityInfoVO> cityInfoVOS = (ArrayList<CityInfoVO>) request.getAttribute("cityInfoList");

%>
 	<jsp:include page="/incl/Header.jsp" />

    <jsp:include page="/incl/Footer.jsp" />
</body>

</html>
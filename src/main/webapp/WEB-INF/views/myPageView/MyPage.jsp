<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    UserVO userVO = (UserVO) request.getAttribute("userVO");
%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <title>한달 살기</title>
</head>

<body>
 	<jsp:include page="/incl/Header.jsp" />
    <a href="modifyUserInfo">회원 정보 수정</a>
    <jsp:include page="/incl/Footer.jsp" />
</body>

</html>
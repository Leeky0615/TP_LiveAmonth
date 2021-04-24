<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
</head>
<body>
<section class="profile-section spad">
    <div class="container">
        <div class="section-title sidebar-title-b">
            <h4>프로필</h4>
        </div>
        <div class="profile-agent-content">
            <div class="row">
                <div class="col-lg-4">
                    <div class="profile-agent-info">
                        <div class="pi-pic">
                            <img src="/resources/img/agents/profile-agent.jpg" alt>
                        </div>
                        <div class="pi-text">
                            <h5><c:out value="${userVO.getUserName()}"/></h5>
                            <span><c:out value="${userVO.getUserNickname()}"/></span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="profile-agent-widget">
                        <ul>
                            <c:set var="now" value="<%=new java.util.Date()%>"/>
                            <c:set var="sysYear">
                                <fmt:formatDate value="${now}" pattern="yyyy"/>
                            </c:set>
                            <c:choose>
                                <c:when test="${userVO.isUserSex() eq 'false'}">
                                    <c:set var="sex" value="남자"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="sex" value="여자"/>
                                </c:otherwise>
                            </c:choose>
                            <li>나이 <span><c:out value="${sysYear-userVO.getUserAge()}세"/></span></li>
                            <li>성별 <span><c:out value="${sex}"/></span></li>
                            <li>Email <span><c:out value="${userVO.getUserEmail()}"/></span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>

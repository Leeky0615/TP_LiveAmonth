<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>한달 살기</title>
</head>
<%
    UserVO userVO = (UserVO) request.getAttribute("userVO");
//    boolean checkUser = (boolean) request.getAttribute("checkUser");
    String pagefile = request.getParameter("page");
    if (pagefile == null) {
        pagefile = "ReCheckUserPW.jsp";
    }
%>
<body>
<jsp:include page="/incl/Header.jsp"/>
<jsp:include page="/WEB-INF/views/myPageView/MyPageProfile.jsp"/>
<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <jsp:include page="/views/myPageView/MyPageSideBar.jsp"/>
            <div class="col-lg-10">
                <jsp:include page='<%="/WEB-INF/views/myPageView/"+pagefile%>'/>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/incl/Footer.jsp"/>
</body>

</html>
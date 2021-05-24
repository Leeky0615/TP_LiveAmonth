<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %><!DOCTYPE html>
<html>
<head>
    <title>한달 살기</title>
</head>
<body>

<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="reviewHeader"/>
<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <tiles:insertAttribute name="reviewSideBar"/>
            <div class="col-lg-10">
                <tiles:insertAttribute name="reviewBody"/>
            </div>
        </div>
    </div>
</section>
<tiles:insertAttribute name="footer"/>
</body>
</html>
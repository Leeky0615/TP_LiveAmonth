<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.liveamonth.liveamonth.entity.vo.CityInfoVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<section class="property-section latest-property-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-5">
                <div class="section-title">
                    <h4>지역들</h4>
                </div>
            </div>
        </div>
        <div class="row property-filter">
            <c:forEach var="name" items="${cityNameList}" varStatus="status">
                <div class="col-lg-4 col-md-6 mix">
                    <div class="ih-item square effect13 left_to_right property-item">
                        <a href="selectCityInfo?page=${name}">
                            <c:set var="i" value="${status.count-1}"/>
                            <c:set var="imageurl" value="${cityIntroList[i].getCityInfoImageURL()}"/>
                            <div class="pi-pic set-bg" data-setbg="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/intro/${imageurl}">
                                <div class="label">
                                    <c:out value="${cityIntroList[i].getCityInfoName()}"/>
                                </div>
                            </div>
                            <div class="info">
                                <h3><c:out value="${cityIntroList[i].getCityInfoName()}"/></h3>
                                <p>
                                    <c:out value="${cityIntroList[i].getCityInfoName()}"/>
                                    입니다.
                                </p>
                            </div>
                        </a>
                    </div>
                </div>
                <p><c:out value="${boardVO.title}"/></p>
            </c:forEach>
        </div>
    </div>
</section>

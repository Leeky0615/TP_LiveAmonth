<%@ page import="com.liveamonth.liveamonth.entity.vo.CityInfoVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*" %>
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

<body>
<%
    ArrayList<String> cityNameList = (ArrayList<String>) request.getAttribute(CITY_NAME_LIST.getText());
    ArrayList<CityInfoVO> cityIntroList = (ArrayList<CityInfoVO>) request.getAttribute(CITY_INTRO_LIST.getText());
%>
<jsp:include page="/incl/Header.jsp"/>
<jsp:include page="/WEB-INF/views/cityInfoView/CityInfoGrid.jsp"/>
<c:if test="${cityName != null}">
    <section class="property-section latest-property-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="section-title">
                        <h4>도시소개</h4>
                    </div>
                </div>
                <div class="row property-filter">
                    <p><c:out value="${Intro.getCityInfoDesc()}"/></p>
                    <div class="col-lg-4 col-md-6 mix">
                        <div class="ih-item square effect13 left_to_right property-item">
                            <div class="pi-pic set-bg"
                                 data-setbg="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/view/<c:out value='${View[0].getCityInfoImageURL()}'/>">
                                <div class="label">
                                    <c:out value="${View[0].getCityInfoDesc()}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mix all seoul">
                        <div class="ih-item square effect13 left_to_right property-item">
                            <div class="pi-pic set-bg"
                                 data-setbg="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/food/<c:out value='${Food[0].getCityInfoImageURL()}'/>">
                                <div class="label">
                                    <c:out value="${Food[0].getCityInfoDesc()}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</c:if>
<jsp:include page="/incl/Footer.jsp"/>
</body>

</html>
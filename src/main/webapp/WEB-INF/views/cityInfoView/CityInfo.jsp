<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<body>
<section class="property-section latest-property-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-5">
                <div class="section-title">
                    <h4>INTRO</h4>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="property-controls">
                    <ul class="cityMenu">
                        <li><a href="selectCityInfo?page=all">전체</a></li>
                        <c:forEach var="cityIntro" items="${cityIntroList}">
                            <li>
                                <a href="selectCityInfo?page=${cityIntro.cityVO.cityName}">${cityIntro.cityVO.cityName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row property-filter">
            <c:forEach var="cityIntro" items="${cityIntroList}">
                <c:if test="${cityIntro.cityVO.cityName == selectedCityName}">
                    <div class="col-lg-4 col-md-6 mix">
                        <div class="property-item">
                            <div class="pi-pic set-bg" data-setbg="${cityIntro.getCityInfoImageURL()}">
                                <div class="label">${cityIntro.cityVO.cityName}</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-7 col-md-6">
                            ${cityIntro.cityInfoDesc}
                    </div>
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h4>VIEW</h4>
                        </div>
                    </div>
                    <c:forEach var="cityFood" items="${cityFoodList}">
                        <div class="col-lg-3 col-md-4 mix">
                            <div class="property-item">
                                <div class="pi-pic set-bg" data-setbg="${cityFood.getCityInfoImageURL()}">
                                    <div class="label">${cityFood.cityInfoDesc}</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h4>FOOD</h4>
                        </div>
                    </div>
                    <c:forEach var="cityView" items="${cityViewList}">
                        <div class="col-lg-3 col-md-4 mix">
                            <div class="property-item">
                                <div class="pi-pic set-bg" data-setbg="${cityView.getCityInfoImageURL()}">
                                    <div class="label">${cityView.cityInfoDesc}</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${selectedCityName == 'all'}">
                    <div class="col-lg-4 col-md-6 mix">
                        <div class="ih-item square effect13 left_to_right property-item">
                            <a href="selectCityInfo?page=${cityIntro.cityVO.cityName}">
                                <div class="pi-pic set-bg" data-setbg="${cityIntro.getCityInfoImageURL()}">
                                    <div class="label">${cityIntro.cityVO.cityName}</div>
                                </div>
                                <div class="info">
                                    <h3>${cityIntro.cityVO.cityName}</h3>
                                    <p>${cityIntro.cityVO.cityName}입니다.</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</section>
</body>

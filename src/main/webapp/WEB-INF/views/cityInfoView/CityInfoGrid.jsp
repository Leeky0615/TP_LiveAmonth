<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
            <c:forEach var="cityIntro" items="${cityIntroList}">
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
            </c:forEach>
        </div>
    </div>
</section>

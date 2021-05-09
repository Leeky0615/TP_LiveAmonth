<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="property-section latest-property-section spad">
    <div class="container" id="body">
        <div class="row">
            <div class="col-lg-5">
                <div class="section-title">
                    <h4>INTRO</h4>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="property-controls">
                    <ul class="cityMenu">
                        <li><a href="#" onclick=acyncMovePage("cityInfo?cityName=all");>전체</a></li>
                        <c:forEach var="cityIntro" items="${cityIntroList}">
                            <li>
                                <a href="#"
                                   onclick=acyncMovePage("cityInfo?cityName=${cityIntro.cityVO.cityName}");>${cityIntro.cityVO.cityName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row property-filter">
            <c:forEach var="cityIntro" items="${cityIntroList}">
                <c:if test="${cityName == 'all'}">
                    <div class="col-lg-4 col-md-6 mix">
                        <div class="ih-item square effect13 left_to_right property-item">
                            <a href="#" onclick=acyncMovePage("cityInfo?cityName=${cityIntro.cityVO.cityName}");>
                                <div class="pi-pic">
                                    <img src="${cityIntro.getCityInfoImageURL()}">
                                    <div class="label">${cityIntro.cityVO.cityName}</div>
                                </div>
                                <div class="info">
                                    <h3>${cityIntro.cityVO.cityName}</h3>
                                        <%--                                    날씨 교통 정보 등 들어가야할 부분--%>
                                    <p>${cityIntro.cityVO.cityName}입니다.</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:if>
                <c:if test="${cityName == cityIntro.cityVO.cityName}">
                    <%--도시 사진--%>
                    <div class="col-lg-4 col-md-6 mix">
                        <div class="property-item">
                            <div class="pi-pic">
                                <img src="${cityIntro.getCityInfoImageURL()}">
                                <div class="label">${cityIntro.cityVO.cityName}</div>
                            </div>
                        </div>
                    </div>
                    <%--도시 소개--%>
                    <div class="col-lg-7 col-md-6">
                            ${cityIntro.cityInfoDesc}
                    </div>
                    <div class="agent-section spad">
                        <div class="container">
                            <div class="as-slider owl-carousel">
                                <div class="row">
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6">
                                        <div class="as-item">
                                            <div class="as-pic">
                                                <div class="rating-point">
                                                    4.5
                                                </div>
                                            </div>
                                            <div class="as-text">
                                                <div class="at-title">
                                                    <h6>Ashton Kutcher</h6>
                                                    <div class="rating-star">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star-half-o"></i>
                                                    </div>
                                                </div>
                                                <ul>
                                                    <li>Property <span>215</span></li>
                                                    <li>Email <span>Kucher@gmail.com</span></li>
                                                    <li>Phone <span>123-455-688</span></li>
                                                </ul>
                                                <a href="#" class="primary-btn">View profile</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>
<%-- 도시 FOOD 정보 --%>



<%--    <section class="agent-section spad">--%>
<%--        <div class="container">--%>
<%--                &lt;%&ndash;제목&ndash;%&gt;--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-6">--%>
<%--                    <div class="section-title">--%>
<%--                        <h4>FOOD</h4>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--                &lt;%&ndash;슬라이드 시작&ndash;%&gt;--%>
<%--            <div class="as-slider owl-carousel">--%>
<%--                    &lt;%&ndash;슬라이드 1번째 줄&ndash;%&gt;--%>
<%--                <div class="row">--%>
<%--                    <c:forEach var="cityFood" begin="0" end="5" items="${cityFoodList}">--%>
<%--                        <div class="col-lg-4 col-md-6">--%>
<%--                            <div class="as-item">--%>
<%--                                <div class="as-pic">--%>
<%--                                    <img src="${cityFood.getCityInfoImageURL()}">--%>
<%--                                    <div class="label">${cityFood.cityInfoDesc}</div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </c:forEach>--%>
<%--                </div>--%>
<%--                    &lt;%&ndash;슬라이드 2번째 줄&ndash;%&gt;--%>
<%--                <div class="row">--%>
<%--                    <c:set var="size" value="${fn:length(cityFoodList)}"/>--%>
<%--                    <c:forEach var="cityFood" begin="6" end="${size-1}" items="${cityFoodList}">--%>
<%--                        <div class="col-lg-4 col-md-6">--%>
<%--                            <div class="as-item">--%>
<%--                                <div class="as-pic">--%>
<%--                                    <img src="${cityFood.getCityInfoImageURL()}">--%>
<%--                                    <div class="label">${cityFood.cityInfoDesc}</div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </c:forEach>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </section>--%>

<%--            <c:forEach var="cityFood" items="${cityFoodList}">--%>
<%--                <div class="col-lg-3 col-md-4 mix">--%>
<%--                    <div class="property-item">--%>
<%--                        <div class="pi-pic">--%>
<%--                            <img src="${cityFood.getCityInfoImageURL()}">--%>
<%--                            <div class="label">${cityFood.cityInfoDesc}</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>

<%--            &lt;%&ndash; 도시 VIEW 정보&ndash;%&gt;--%>
<%--            <div class="col-lg-12">--%>
<%--                <div class="section-title">--%>
<%--                    <h4>VIEW</h4>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <c:forEach var="cityView" items="${cityViewList}">--%>
<%--                <div class="col-lg-3 col-md-4 mix">--%>
<%--                    <div class="property-item">--%>
<%--                        <div class="pi-pic">--%>
<%--                            <img src="${cityView.getCityInfoImageURL()}">--%>
<%--                            <div class="label">${cityView.cityInfoDesc}</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>


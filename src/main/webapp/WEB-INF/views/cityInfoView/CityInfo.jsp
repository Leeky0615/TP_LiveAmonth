<%@ page import="com.liveamonth.liveamonth.entity.vo.CityInfoVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<body>
<%
    ArrayList<String> cityNameList = (ArrayList<String>) request.getAttribute(CITY_NAME_LIST.getText());
%>
<%--<c:if test="${cityName != null}">--%>
<script>
    document.getElementById("allCity").click(function () {
        document.getElementById("cityText").style.display = 'none';
    });
</script>
<section class="property-section latest-property-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-5">
                <div class="section-title">
                    <h4>Latest PROPERTY</h4>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="property-controls">
                    <ul>
                        <li data-filter="all" class="allCity">All</li>
                        <c:forEach var="name" items="${Intro}">
                            <li data-filter=".${name.cityVO.cityName}">${name.cityVO.cityName}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row property-filter">
            <c:forEach var="name" items="${Intro}">
                <div class="col-lg-4 col-md-6 mix all ${name.cityVO.cityName}">
                    <div class="property-item">
                        <div class="pi-pic set-bg" data-setbg="${name.getCityInfoImageURL()}"
                             data-filter=".${name.cityVO.cityName}">
                            <div class="label">${name.cityVO.cityName}</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 mix all ${name.cityVO.cityName}" id="cityText" style="display: none">
                    <p>${name.cityInfoDesc}</p>
                </div>
            </c:forEach>

            <%--            <div class="col-lg-4 col-md-6 mix all hotel">--%>
            <%--                <div class="property-item">--%>
            <%--                    <div class="pi-pic set-bg" data-setbg="img/property/property-2.jpg">--%>
            <%--                        <div class="label c-red">For rent</div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--            <div class="col-lg-4 col-md-6 mix all apart">--%>
            <%--                <div class="property-item">--%>
            <%--                    <div class="pi-pic set-bg" data-setbg="img/property/property-2.jpg">--%>
            <%--                        <div class="label c-red">For rent</div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--            <div class="col-lg-4 col-md-6 mix all restaruent">--%>
            <%--                <div class="property-item">--%>
            <%--                    <div class="pi-pic set-bg" data-setbg="img/property/property-4.jpg">--%>
            <%--                        <div class="label c-red">For rent</div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--            <div class="col-lg-4 col-md-6 mix all office">--%>
            <%--                <div class="property-item">--%>
            <%--                    <div class="pi-pic set-bg" data-setbg="img/property/property-5.jpg">--%>
            <%--                        <div class="label c-magenta">For rent</div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--            <div class="col-lg-4 col-md-6 mix house apart office">--%>
            <%--                <div class="property-item">--%>
            <%--                    <div class="pi-pic set-bg" data-setbg="img/property/property-6.jpg">--%>
            <%--                        <div class="label">For rent</div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
        </div>
    </div>
</section>
<%--    <section class="property-section latest-property-section spad">--%>
<%--        <div class="container">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-5">--%>
<%--                    <div class="section-title">--%>
<%--                        <h4>도시소개</h4>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-7">--%>
<%--                    <div class="property-controls">--%>
<%--                        <ul>--%>
<%--                            <li data-filter="all">all</li>--%>
<%--                                &lt;%&ndash;                            <a href="cityInfo">전체</a>&ndash;%&gt;--%>
<%--                            <c:forEach var="name" items="${Intro}">--%>
<%--                                <li data-filter=".${name.cityVO.cityName}">${name.cityVO.cityName}</li>--%>
<%--                                &lt;%&ndash;                                <a href="selectCityInfo?page=${name}">${name}</a>&ndash;%&gt;--%>
<%--                            </c:forEach>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="row property-filter">--%>
<%--                    <c:forEach var="name" items="${Intro}">--%>
<%--                    <div class="col-lg-4 col-md-6 mix ${name.cityVO.cityName}">--%>
<%--                        <div class="property-item">--%>
<%--                            <div class="pi-pic set-bg" data-setbg="${name.getCityInfoImageURL()}">--%>
<%--                                <div class="label">${name.cityVO.cityName}</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                            &lt;%&ndash;                        <p><c:out value="${Intro[status.index].getCityInfoDesc()}"/></p>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                        <div class="ih-item square effect13 left_to_right property-item">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                            <div class="pi-pic set-bg"&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                                 data-setbg="<c:out value='${View[0].getCityInfoImageURL()}'/>">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                                <div class="label">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                                    <c:out value="${View[0].getCityInfoDesc()}"/>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                            </div>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--                    </div>--%>
<%--                        &lt;%&ndash;                    <div class="col-lg-4 col-md-6 mix all seoul">&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                        <div class="ih-item square effect13 left_to_right property-item">&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                            <div class="pi-pic set-bg"&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                                 data-setbg="<c:out value='${Food[0].getCityInfoImageURL()}'/>">&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                                <div class="label">&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                                    <c:out value="${Food[0].getCityInfoDesc()}"/>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                            </div>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        </div>--%>
<%--    </section>--%>
<%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
</body>

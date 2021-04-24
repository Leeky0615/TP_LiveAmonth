<%@ page import="com.liveamonth.liveamonth.entity.vo.CityInfoVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>

    <title>한달 살기</title>
</head>

<body>
<%
    ArrayList<CityInfoVO> cityInfoList = (ArrayList<CityInfoVO>) request.getAttribute("cityInfoList");
    String pagefile = request.getParameter("page");
    if (pagefile == null) {
        pagefile = "SeoulInfo.jsp";
    }
%>
<jsp:include page="/incl/Header.jsp"/>
<section class="property-section latest-property-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-5">
                <div class="section-title">
                    <h4>지역들</h4>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="property-controls">
                    <ul>
                        <li data-filter="all">All</li>
                        <li data-filter=".seoul">서울</li>
                        <li data-filter=".jeju">제주</li>
                        <li data-filter=".yeosu">여수</li>
                        <li data-filter=".busan">부산</li>
                        <li data-filter=".gangneung">강릉</li>
                        <li data-filter=".gyeongju">경주</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row property-filter">

            <div class="col-lg-4 col-md-6 mix all seoul">
                <div class="ih-item square effect13 left_to_right property-item">
                    <a href="seoulInfo">
                        <div class="pi-pic set-bg" data-setbg="resources/img/info/INFO_SE.png">
                            <div class="label">서울</div>
                        </div>
                        <div class="info">
                            <h3>Seoul</h3>
                            <p>서울입니다.</p>
                        </div>
                    </a>
                </div>
            </div>

            <div class="col-lg-4 col-md-6 mix all jeju">
                <div class="ih-item square effect13 left_to_right property-item">
                    <a href="jejuInfo">
                        <div class="pi-pic set-bg" data-setbg="resources/img/info/INFO_JJ.png">
                            <div class="label">제주</div>
                        </div>
                        <div class="info">
                            <h3>Jeju</h3>
                            <p>제주입니다.</p>
                        </div>
                    </a>
                </div>
            </div>

            <div class="col-lg-4 col-md-6 mix all yeosu">
                <div class="ih-item square effect13 left_to_right property-item">
                    <a href="yeosuInfo">
                        <div class="pi-pic set-bg" data-setbg="resources/img/info/INFO_YS.png">
                            <div class="label">여수</div>
                        </div>
                        <div class="info">
                            <h3>YeoSU</h3>
                            <p>여수입니다.</p>
                        </div>
                    </a>
                </div>
            </div>

            <div class="col-lg-4 col-md-6 mix all busan">
                <div class="ih-item square effect13 left_to_right property-item">
                    <a href="busanInfo">
                        <div class="pi-pic set-bg" data-setbg="resources/img/info/INFO_BS.png">
                            <div class="label">부산</div>
                        </div>
                        <div class="info">
                            <h3>Busan</h3>
                            <p>부산입니다.</p>
                        </div>
                    </a>
                </div>
            </div>

            <div class="col-lg-4 col-md-6 mix all gyungju">
                <div class="ih-item square effect13 left_to_right property-item">
                    <a href="gyungjuInfo">
                        <div class="pi-pic set-bg" data-setbg="resources/img/info/INFO_KJ.png">
                            <div class="label">경주</div>
                        </div>
                        <div class="info">
                            <h3>Gyungju</h3>
                            <p>경주입니다.</p>
                        </div>
                    </a>
                </div>
            </div>

            <div class="col-lg-4 col-md-6 mix all gangneung">
                <div class="ih-item square effect13 left_to_right property-item">
                    <a href="gangneungInfo">
                        <div class="pi-pic set-bg" data-setbg="resources/img/info/INFO_KN.png">
                            <div class="label">강릉</div>
                        </div>
                        <div class="info">
                            <h3>Gangneung</h3>
                            <p>강릉입니다.</p>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/incl/Footer.jsp"/>
<jsp:include page="/incl/Footer.jsp"/>
</body>

</html>
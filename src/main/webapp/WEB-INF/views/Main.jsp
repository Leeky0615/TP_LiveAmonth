<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    
    <title>한달 살기</title>
</head>

<body>
 	<jsp:include page="/incl/Header.jsp" />
 	

	<!-- Hero Section Begin -->
    <section class="hero-section">
        <div class="container">
            <div class="hs-slider owl-carousel">
                <div class="hs-item set-bg" data-setbg="resources/img/hero/hero-1.jpg">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="hc-inner-text">
                                <div class="hc-text">
                                    <h4>Seoul</h4>
                                    <p><span class="icon_pin_alt"></span> Korea, Seoul</p>
                                </div>
                                <div class="hc-widget">
                                    <ul>
                                        <li><i class="fa fa-bed"></i> 05</li>
                                        <li><i class="fa fa-automobile"></i> 01</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="hs-item set-bg" data-setbg="resources/img/hero/hero-2.jpg">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="hc-inner-text">
                                <div class="hc-text">
                                    <h4>Jeju</h4>
                                    <p><span class="icon_pin_alt"></span> Korea, Jeju</p>
                                </div>
                                <div class="hc-widget">
                                    <ul>
                                        <li><i class="fa fa-bed"></i> 05</li>
                                        <li><i class="fa fa-automobile"></i> 01</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="hs-item set-bg" data-setbg="resources/img/hero/hero-3.jpg">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="hc-inner-text">
                                <div class="hc-text">
                                    <h4>Gangneung</h4>
                                    <p><span class="icon_pin_alt"></span> Korea, Gangneung</p>
                                </div>
                                <div class="hc-widget">
                                    <ul>
                                        <li><i class="fa fa-object-group"></i> 2, 283</li>
                                        <li><i class="fa fa-bathtub"></i> 03</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Property Section Begin -->
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
                            <li data-filter=".gyeonggi">경기도</li>
                            <li data-filter=".gangwon">강원도</li>
                            <li data-filter=".chungcheong">충청도</li>
                            <li data-filter=".jeolla">전라도</li>
                            <li data-filter=".gyeongsang">경상도</li>
                            <li data-filter=".jeju">제주도</li>
                        </ul>
                    </div>
                </div>
            </div>
            
            <div class="row property-filter">
            
               <div class="col-lg-4 col-md-6 mix all seoul">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-1.jpg">
	                           <div class="label">서울</div>
	                       </div>
					       <div class="info">
					         <h3>Seoul</h3>
					         <p>서울입니다.</p>
					       </div>
				       </a>
			       </div>
                </div>
                
              	<div class="col-lg-4 col-md-6 mix all gyeonggi">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-2.jpg">
	                           <div class="label">양평</div>
	                       </div>
					       <div class="info">
					         <h3>Yangpyeong</h3>
					         <p>양평입니다.</p>
					       </div>
				       </a>
			       </div>
                </div>
                
                <div class="col-lg-4 col-md-6 mix all gangwon">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-3.jpg">
	                           <div class="label">강릉</div>
	                       </div>
					       <div class="info">
					         <h3>Gangneung</h3>
					         <p>강릉입니다.</p>
					       </div>
				       </a>
			       </div>
                </div>
                
                 <div class="col-lg-4 col-md-6 mix all chungcheong">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-4.jpg">
	                           <div class="label">보령</div>
	                       </div>
					       <div class="info">
					         <h3>Boryeong</h3>
					         <p>보령입니다.</p>
					       </div>
				       </a>
			       </div>
                </div>
                
                <div class="col-lg-4 col-md-6 mix all jeju">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-5.jpg">
	                           <div class="label">제주</div>
	                       </div>
					       <div class="info">
					         <h3>Jeju</h3>
					         <p>제주도 입니다.</p>
					       </div>
				       </a>
			       </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="/incl/Footer.jsp" />

</body>

</html>
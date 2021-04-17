<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Sign Up Done</title>
</head>
<body>
<jsp:include page="/incl/Header.jsp" />

<!-- Contact Form Section Begin -->
<section class="contact-form-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="cf-content">
                    <div class="cc-title">
                        <h4>회원가입이 완료되었습니다.</h4>
                        <p>환영합니다...</p>
                    </div>
                    <form action="/signIn" method = post class="cc-form">
                        <button type="submit" class="site-btn">로그인하러가기</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Contact Form Section End -->

<jsp:include page="/incl/Footer.jsp" />
</body>
</html>
<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
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
                            <h4>ȸ������ ������ �Ϸ�Ǿ����ϴ�.</h4>
                        </div>
                        <form action="/myPage" class="cc-form">
                            <button type="submit" class="site-btn">������������ ���ư���</button>
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
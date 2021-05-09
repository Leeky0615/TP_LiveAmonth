<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<body>
<section class="profile-section spad">
    <div class="container">
        <div class="section-title sidebar-title-b">
            <h4>프로필</h4>
        </div>
        <div class="profile-agent-content">
            <div class="row">
                <div class="col-lg-4">
                    <div class="profile-agent-info">
                        <div class="pi-pic">
                            <img src=${userVO.getUserImageURL()} alt>
                        </div>
                        <div class="pi-text">
                            <h5>${userVO.userName}</h5>
                            <span>${userVO.userNickname}</span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="profile-agent-widget">
                        <ul>

                            <li>나이 <span>${userVO.getUserRealAge()}세</span></li>
                            <li>성별 <span>${userVO.getUserSex()}</span></li>
                            <li>Email <span>${userVO.userEmail}</span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>

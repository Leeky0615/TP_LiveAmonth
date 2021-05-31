<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<body>
<div class="col-lg-4">
    <div class="blog-sidebar">
        <div class="subscribe-form">
            <c:if test="${empty userVO.userNO}">
                <div class="section-title sidebar-title-b">
                    <h6>로그인</h6>
                </div>
                <p>더욱 다양한 한달살기 정보를 제공받으세요.</p>
                <div class="hs-top">
                    <div class="ht-widget">
                        <a href="signIn" class="hw-btn">signIn</a>
                    </div>
                </div>
            </c:if>
            <c:if test="${userVO.userNO != null}">
                <div class="as-item">
                    <div class="user-pic">
                        <c:choose>
                            <c:when test="${userVO.userImage == null}">
                                <img src="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/user/default.jpg"
                                     alt>
                            </c:when>
                            <c:otherwise>
                                <img src=${userVO.getUserImageURL()} alt>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="as-text">
                        <div class="at-title">
                            <h6>${userVO.userNickname}님</h6>
                        </div>
                        <ul>
                            <li>Email <span>${userVO.userEmail}</span></li>
                            <li>Sex <span>${userVO.getUserSexToString()}</span></li>
                            <li>Age <span>${userVO.getUserRealAge()}세</span></li>
                        </ul>
                        <a href="myPage" class="site-btn">MyPage</a>
                        <a href="logout" class="site-btn">Logout</a>
                    </div>
                </div>
                <div class="pd-text">
                    <div class="pd-board">
                        <div class="tab-board">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="user-service">
                                    <a class="nav-link" data-toggle="tab" href="#profile-tabs-1" role="tab">Notice</a>
                                </li>
                                <li class="user-service">
                                    <a class="nav-link" data-toggle="tab" href="#profile-tabs-2" role="tab">My
                                        Schedule</a>
                                </li>
                                <li class="user-service">
                                    <a class="nav-link" data-toggle="tab" href="#profile-tabs-3" role="tab">My
                                        Review</a>
                                </li>
                            </ul><!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane" id="profile-tabs-1" role="tabpanel">
                                    <div class="tab-desc">
                                        <div class="row">
                                            알림창입니다!!
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="profile-tabs-2" role="tabpanel">
                                    <div class="tab-desc">
                                        <div class="row">
                                            <c:choose>
                                                <c:when test="${scheduleList.size() == 0}">
                                                    <div class="row justify-content-center">
                                                        <div class="col-md-6 text-center mb-5">
                                                            <h2 class="heading-section">작성하신 글이 없습니다.</h2>
                                                        </div>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="table table-hover">
                                                        <input type="hidden" name="manageScheduleCategory"
                                                               id="manageScheduleCategory"
                                                               value="${manageScheduleCategory}">
                                                        <table>
                                                            <thead>
                                                            <tr>
                                                                <th></th>
                                                                <th></th>
                                                                <th>제목</th>
                                                                <th>좋아요</th>
                                                                <th>조회</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            <c:forEach var="scheduleList" end="5" items="${scheduleList}">
                                                                <tr>
                                                                    <td style="width:10%">${scheduleList.scheduleNO}</td>
                                                                    <td><input type="checkbox" name="myScheduleCheckbox"
                                                                               value="${scheduleList.scheduleNO}"></td>
                                                                    <td style="width:35%"><a
                                                                            href="otherSchedule?scheduleNO=${scheduleList.scheduleNO}">${scheduleList.scheduleSubject}</a>
                                                                        <span class="scheduleReplyCount">
                                                                    <c:if test="${scheduleList.replyCount ne null}">
                                                                        [${scheduleList.replyCount}]
                                                                    </c:if>
                                                                     </span>
                                                                    </td>
                                                                    <td style="width:15%">${scheduleList.scheduleLikeCount}</td>
                                                                    <td style="width:15%">${scheduleList.scheduleViewCount}</td>
                                                                </tr>
                                                            </c:forEach>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="profile-tabs-3" role="tabpanel">
                                    <div class="tab-desc">
                                        <div class="row">
                                            내 게시글 입니다!!
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
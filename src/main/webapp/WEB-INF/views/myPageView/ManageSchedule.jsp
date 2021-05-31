<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<body>
<link rel="stylesheet" href="resources/css/myPage.css" type="text/css">
<script type="text/javascript" src="resources/js/myPage.js"></script>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-5">
            <div class="section-title"></div>
        </div>
        <div class="col-lg-7">
            <div class="property-controls">
                <ul class="scheduleMenu">
                    <li><a href="manageSchedule?manageScheduleCategory=writeSchedule">작성글</a></li>
                    <li>
                        <a href="manageSchedule?manageScheduleCategory=writeScheduleReply">댓글단글</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<form id="deleteMyScheduleForm" action="manageSchedule">
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

                <input type="hidden" name="manageScheduleCategory" id="manageScheduleCategory"
                       value="${manageScheduleCategory}">
                <table>
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th>제목</th>
                        <th>좋아요</th>
                        <th>조회</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="scheduleList" items="${scheduleList}">
                        <tr>
                            <td style="width:10%">${scheduleList.scheduleNO}</td>
                            <c:choose>
                                <c:when test="${manageScheduleCategory eq 'writeScheduleReply'}">
                                    <td><input type="checkbox" name="myScheduleCheckbox"
                                               value="${scheduleList.scheduleReplyNO}"></td>
                                </c:when>
                                <c:otherwise>
                                    <td><input type="checkbox" name="myScheduleCheckbox"
                                               value="${scheduleList.scheduleNO}"></td>
                                </c:otherwise>
                            </c:choose>
                            <td><img src="resources/img/scheduleImg.png" alt=""></td>
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

            <jsp:include page="Paging.jsp">
                <jsp:param value="${manageScheduleCategory}" name="manageScheduleCategory"/>
                <jsp:param value="${paging.page}" name="page"/>
                <jsp:param value="${paging.beginPage}" name="beginPage"/>
                <jsp:param value="${paging.endPage}" name="endPage"/>
                <jsp:param value="${paging.prev}" name="prev"/>
                <jsp:param value="${paging.next}" name="next"/>
            </jsp:include>
        </c:otherwise>
    </c:choose>
    <button type="button" class="btn btn-sm btn-primary pull-right" onclick="deleteMySchedule();">글삭제</button>
</form>
<c:choose>
<c:when test="${scheduleList.size() == 0}">
</c:when>
<c:otherwise>
<input type='checkbox' name='myScheduleCheckbox' value='scheduleSelectAll' onclick='scheduleSelectAll(this)'/> 전체선택
</c:otherwise>
</c:choose>
</body>
</html>
</body>
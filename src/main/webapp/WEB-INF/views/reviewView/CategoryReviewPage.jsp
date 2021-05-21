<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="resources/css/review.css" type="text/css">
<script type="text/javascript" src="resources/js/review.js"></script>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-5">
            <div class="section-title"></div>
        </div>
        <div class="col-lg-7">
            <div class="property-controls">
                <ul class="reviewMenu">
                    <li><a href="review">메인화면</a></li>
                    <li>
                        <a href="#">간곳</a>
                    </li>
                    <li>
                        <a href="#">먹은곳</a>
                    </li>
                    <li>
                        <a href="#">느낀점</a>
                    </li>
                    <li>
                        <a href="#">자유게시판</a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>
<div class="table table-hover">
    <table>
        <thead>
        <tr>
            <th style="width:10%"></th>
            <th style="width:50%">제목</th>
            <th style="width:10%">작성자</th>
            <th style="width:15%">작성일</th>
            <th style="width:15%">조회</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reviewList" items="${reviewList}">
            <tr>
                <td style="width:10%">${reviewList.reviewNO}</td>
                <td style="width:50%"><a
                        href="getReview?reviewNO=${reviewList.reviewNO}">${reviewList.reviewSubject}</a>
                    <span class="reviewReplyCount">
                        <c:if test="${reviewList.replyCount ne 0}">
                            [${reviewList.replyCount}]
                        </c:if>
                    </span>
                </td>
                <td style="width:10%">${reviewList.userNickName}</td>
                <td style="width:20%">${reviewList.reviewDate}</td>
                <td style="width:10%">${reviewList.reviewViewCount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="Paging.jsp">
    <jsp:param value="${category}" name="category"/>
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>


<button type="button" class="btn btn-sm btn-primary pull-right" onclick="addReviewReply(${userVO.userNO});">
    글작성
</button>
</body>
</html>

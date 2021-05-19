<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="resources/css/review.css" type="text/css">

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
            <th ></th>
            <th >제목</th>
            <th>작성자</th>
            <th><a href="categoryReviewPage?category=${category}&selectedPage=${selectPage}&orderBy=dateOrderBy&dateDescAsc=${dateDescAsc}">작성일</a></th>
            <th><a href="categoryReviewPage?category=${category}&selectedPage=${selectPage}&orderBy=likeOrderBy&likeDescAsc=${likeDescAsc}">좋아요</a></th>
            <th><a href="categoryReviewPage?category=${category}&selectedPage=${selectPage}&orderBy=viewOrderBy&viewDescAsc=${viewDescAsc}">조회</a></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reviewList" items="${reviewList}">
            <tr>
                <td style="width:10%">${reviewList.reviewNO}</td>
                <td style="width:35%"><a
                        href="getReview?reviewNO=${reviewList.reviewNO}">${reviewList.reviewSubject}</a>
                    <span class="reviewReplyCount">
                        <c:if test="${reviewList.replyCount ne null}">
                            [${reviewList.replyCount}]
                        </c:if>
                    </span>
                </td>
                <td style="width:10%">${reviewList.userNickName}</td>
                <td style="width:15%">${reviewList.reviewDate}</td>
                <td style="width:15%">${reviewList.reviewLikeCount}</td>
                <td style="width:15%">${reviewList.reviewViewCount}</td>
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
    <jsp:param value="${orderBy}" name="orderBy"/>
    <jsp:param value="${dateDescAsc}" name="dateDescAsc"/>
    <jsp:param value="${likeDescAsc}" name="likeDescAsc"/>
    <jsp:param value="${viewDescAsc}" name="viewDescAsc"/>
</jsp:include>


<button type="button" class="btn btn-sm btn-primary pull-right" onclick="addScheduleReply(${param.scheduleReplyNO});">
    글작성
</button>
</body>
<script>
    function addScheduleReply(scheduleReplyNO) {
        var userNO = "${userVO.userNO}";
        if (userNO == "" || userNO == null) {
            alert("로그인 후 이용해주세요.");
            return false;
        }
        location.replace("/reviewWrite")
    }
</script>
</html>

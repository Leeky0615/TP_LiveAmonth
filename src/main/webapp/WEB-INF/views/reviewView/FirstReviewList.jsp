<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <title>한달 살기</title>
</head>

<body>
<section class="property-section latest-property-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-5">
                <div class="section-title">
                    <h4>INTRO</h4>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="property-controls">
                    <ul class="reviewMenu">
                        <li><a href="#">전체</a></li>
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

    <!-- Property Comparison Section Begin -->
    <div class="property-comparison-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 p-0">
                    <div class="pc-table">
                        <table>
                            <thead>
                            <tr>
                                <th class="type">제목</th>
                                <th class="type">타입</th>
                                <th class="type">작성자</th>
                                <th class="type">날짜</th>
                                <th class="type">조회수</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="reviewVO" items="${AllReviewList}">
                                    <tr>
                                        <td class="p-type"> <a href="getReview?reviewNO=${reviewVO.reviewNO}">${reviewVO.reviewSubject}</a></td>
                                        <td>${reviewVO.reviewCategory.nameKR}</td>
                                        <td>${reviewVO.userNO}</td>
                                        <td>${reviewVO.reviewDate}</td>
                                        <td>${reviewVO.reviewViewCount}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <br>
                    <button type="button" class="btn btn-sm btn-primary pull-right" onclick="addScheduleReply(${param.scheduleReplyNO});"> 글작성 </button>
                    <script>
                        function addScheduleReply(scheduleReplyNO) {
                            var userNO = "${userVO.userNO}";
                            if(userNO == "" || userNO == null){
                                alert("로그인 후 이용해주세요.");
                                return false;
                            }
                            location.replace("/reviewWrite")
                        }
                    </script>
                </div>
            </div>
        </div>
    </div>


</section>
</body>

</html>
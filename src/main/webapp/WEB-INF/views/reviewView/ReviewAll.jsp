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


    <div class="pc-table">
        <table>
            <thead>
            <tr>
                <th>카테고리</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
                <th>조회수</th>
            </tr>
            </thead>
            <tbody>
<%--            <c:forEach var="oneToOneAskVOList" items="${oneToOneAskVOList}">--%>
<%--                <tr>--%>
<%--                    <td>${oneToOneAskVOList.oneToOneAskNO}</td>--%>
<%--                    <td>${oneToOneAskVOList.oneToOneAskCategory}</td>--%>
<%--                    <td>--%>
<%--                        <a href="showOneToOneAsk?oneToOneAskNO=${oneToOneAskVOList.oneToOneAskNO}">${oneToOneAskVOList.oneToOneAskSubject}</a>--%>
<%--                    </td>--%>
<%--                    <td>${oneToOneAskVOList.oneToOneAskDate}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
            </tbody>
        </table>
    </div>
</section>
</body>

</html>
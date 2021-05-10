<%--
  Created by IntelliJ IDEA.
  User: hjww1
  Date: 2021-05-09
  Time: 오전 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="blog-item-list">
                    <div class="blog-item large-blog">
                        <div class="bi-text">
                            <h4><a href="#" return false;>${reviewVO.reviewSubject}</a></h4>
                            <ul style="float: right;">
                                <li>by <span>${reviewVO.userNO}</span></li>
                                <li>${reviewVO.reviewDate}</li>
                                <li>조회수 ${reviewVO.reviewViewCount}</li>
                            </ul>
                            <br>
                            <br>
                            <p>${reviewVO.reviewDesc}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>

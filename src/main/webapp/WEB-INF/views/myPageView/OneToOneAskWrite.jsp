<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>문의 글 작성하기</title>
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link
            href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/style.css">
    <script src="/resources/js/signUp.js"></script>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
<jsp:include page="/incl/Header.jsp"/>

<section class="ftco-section">

    <div class="container">

        <form action=resultMentOneToOneAsk method="post" class="signup-form" name="SignInfo">

            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <h2 class="heading-section">1:1문의 글 작성하기</h2>
                </div>
            </div>

            <div class="row justify-content-center">
					<div class="col-md-7 col-lg-6 col-xl-5">
						<div class="login-wrap p-4 p-md-5">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="fa fa-edit"></span>
							</div>
							<h3 class="text-center mb-4">문의하기</h3>

							

								<div class="form-group mb-3" id="oneToOneAskCategoryBlock">
									<label class="label" for="oneToOneAskCategory">목록</label><br> 
									<select name="oneToOneAskCategory" id="oneToOneAskCategory" class="form-control">
									<c:forEach var="oneToOneAskCategory" items="${oneToOneAskCategory}">
										<option value="${oneToOneAskCategory}">${oneToOneAskCategory.label}</option>
									</c:forEach>
									
									</select>
								</div>


								<div class="form-group mb-3">
									<label class="label" for="oneToOneAskSubject">제목</label> <input type="text"
										id="oneToOneAskSubject" class="form-control" placeholder="제목"
										name="oneToOneAskSubject">
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="oneToOneAskDesc">내용</label> <input type="text"
										id="oneToOneAskDesc" class="form-control" placeholder="내용"
										name="oneToOneAskDesc">
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="oneToOneAskUserEmail">이메일</label> <input type="text"
										id="oneToOneAskUserEmail" class="form-control result-email" placeholder="email"
										name="oneToOneAskUserEmail">
								</div>
								
								<br>

								<div class="form-group">
									<button type="submit" id="submit"
										class="form-control btn btn-primary rounded submit px-3">제출하기</button>
								</div>

						
						</div>
					</div>
				</div>
        </form>
    </div>
</section>
<jsp:include page="/incl/Footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>답변글 작성하기</title>
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

        <form action="resultMentOneToOneAskReply" class="signup-form">
			<input type="hidden" id="oneToOneAskUserEmail" name="oneToOneAskUserEmail" value="${oneToOneAskVO.oneToOneAskUserEmail}">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <h2 class="heading-section">1:1문의 글 답변하기</h2>
                </div>
            </div>

            <div class="row justify-content-center">
					<div class="col-md-7 col-lg-6 col-xl-5">
						<div class="login-wrap p-4 p-md-5">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="fa fa-edit"></span>
							</div>
							<h3 class="text-center mb-4">문의글 답변하기</h3>
							
							<div class="form-group mb-3">
									<label class="label" for="oneToOneAskNO">번호</label> <input type="text"
										id="oneToOneAskNO" class="form-control" value="${oneToOneAskVO.oneToOneAskNO}"
										name="oneToOneAskNO" readonly>
								</div>
							
							<div class="form-group mb-3">
									<label class="label" for="oneToOneAskCategory">카테고리</label> <input type="text"
										id="oneToOneAskCategory" class="form-control" value="${oneToOneAskVO.oneToOneAskCategory}"
										name="oneToOneAskCategory" readonly>
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="oneToOneAskSubject">제목</label> <input type="text"
										id="oneToOneAskSubject" class="form-control" value="${oneToOneAskVO.oneToOneAskSubject}"
										name="oneToOneAskSubject" readonly>
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="oneToOneAskDesc">내용</label> <input type="text"
										id="oneToOneAskDesc" class="form-control" value="${oneToOneAskVO.oneToOneAskDesc}"
										name="oneToOneAskDesc" readonly>
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="oneToOneAskDate">작성날짜</label> <input type="text"
										id="oneToOneAskDate" class="form-control" value="${oneToOneAskVO.oneToOneAskDate}"
										name="oneToOneAskDate" readonly>
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="oneToOneAskReply">답변작성하기</label> <input type="text"
										id="oneToOneAskReply" class="form-control" placeholder="답변작성"
										name="oneToOneAskReply">
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
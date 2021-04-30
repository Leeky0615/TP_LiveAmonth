<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>작성한 문의글</title>
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
<section class="ftco-section">

    <div class="container">

        
			<div class="section-title">
				<h4>문의내용</h4>
			</div>

            <div class="row justify-content-center">
					<div class="col-md-12 col-lg-10 col-xl-10">
					<div class="login-wrap p-4 p-md-5">
						<div class="icon d-flex align-items-center justify-content-center">
							<span class="fa fa-edit"></span>
						</div>
						<h3 class="text-center mb-4"></h3>

						<div class="form-group mb-3">
							<label class="label" for="oneToOneAskNO">번호</label> <input
								type="text" id="oneToOneAskNO" class="form-control"
								value="${oneToOneAskVO.oneToOneAskNO}" name="oneToOneAskNO"
								readonly>
						</div>

						<div class="form-group mb-3">
							<label class="label" for="oneToOneAskCategory">카테고리</label> <input
								type="text" id="oneToOneAskCategory" class="form-control"
								value="${oneToOneAskVO.oneToOneAskCategory}"
								name="oneToOneAskCategory" readonly>
						</div>

						<div class="form-group mb-3">
							<label class="label" for="oneToOneAskSubject">제목</label> <input
								type="text" id="oneToOneAskSubject" class="form-control"
								value="${oneToOneAskVO.oneToOneAskSubject}"
								name="oneToOneAskSubject" readonly>
						</div>

						<div class="form-group mb-3">
							<label class="label" for="oneToOneAskDesc">내용</label> <input
								type="text" id="oneToOneAskDesc" class="form-control"
								value="${oneToOneAskVO.oneToOneAskDesc}" name="oneToOneAskDesc"
								readonly>
						</div>

						<div class="form-group mb-3">
							<label class="label" for="oneToOneAskDate">작성날짜</label> <input
								type="text" id="oneToOneAskDate" class="form-control"
								value="${oneToOneAskVO.oneToOneAskDate}" name="oneToOneAskDate"
								readonly>
						</div>

						<div class="form-group mb-3">
							<label class="label" for="oneToOneAskReply">답변</label> <input
								type="text" id="oneToOneAskReply" class="form-control"
								value="${oneToOneAskVO.oneToOneAskReply}"
								name="oneToOneAskReply" readonly>
						</div>



						<br>

						<div class="form-group">
							<form action="myPage" class="signup-form">
								<button type="submit" id="submit"
									class="form-control btn btn-primary rounded submit px-3">확인</button>
							</form>
						</div>

						<div>       
					  
							<form action="deleteOneToOneAsk" class="signup-form">
							<input type="hidden" id="oneToOneAskNO" name="oneToOneAskNO" value="${oneToOneAskVO.oneToOneAskNO}">
								<button type="submit" id="submit"
									class="form-control btn btn-primary rounded submit px-3">삭제하기</button>
							</form>
						</div>


					</div>
				</div>
				</div>
        
    </div>
</section>
</body>
</html>
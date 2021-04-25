<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>user Drop</title>
</head>
<body>
<% boolean firstIn = (boolean) request.getAttribute("firstIn"); %>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">회원 탈퇴</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-5">

                <div class="d-flex">
                    <div class="w-100">
                        <h3 class="mb-4">실명 확인</h3>
                    </div>
                </div>

                <form action="checkDropUserPassword" method="post" class="signin-form">
                    <div class="form-group mt-3">

                        <input type="text" class="form-control" id="userID" name="userID" value="${userID}" readonly
                               required>

                    </div>
                    <div class="form-group">
                        <input id="password-field" type="password" id="userPassword" class="form-control"
                               name="userPassword" required>
                        <label class="form-control-placeholder" for="userPassword">Password</label>

                        <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="form-control btn btn-primary rounded submit px-3">확인</button>
                        <%if (firstIn == false) {%>
                        <p class="text-center" style="color:#ff0000">잘못된 비밀번호입니다.</p>
                        <% }%>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(function () {
        $("#loginBtn").click(function () {
            location.href = 'signIn';
        })
    })
</script>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">아이디 찾기 검색결과</h2>
            </div>
        </div>

        <form action="/resultMentFindID" method="post">
            <div class="row justify-content-center">
                <div class="col-md-7 col-lg-5">
                    <div class="d-flex">
                        <div class="w-100">
                            <h3 class="mb-4">${ userID }</h3>

                        </div>
                    </div>
                    <div class="form-group">
                        <button type="button" onclick="history.go(-2);"
                                class="form-control btn btn-primary rounded submit px-3">Login
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>

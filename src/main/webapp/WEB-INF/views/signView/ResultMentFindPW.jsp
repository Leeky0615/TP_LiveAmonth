<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <h2 class="heading-section">비밀번호 찾기 검색결과</h2>
            </div>
        </div>

        <form action="/resultMentFindPW" method="post">
            <div class="row justify-content-center">
                <div class="col-md-7 col-lg-5">

                    <div class="d-flex">
                        <div class="w-100">
                            <h3 class="mb-4">${ userPassword }</h3>
                        </div>
                    </div>
                    <div class="form-group mt-3">
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
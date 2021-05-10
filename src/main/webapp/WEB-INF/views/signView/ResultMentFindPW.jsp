<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
<%  boolean firstIn = (boolean)request.getAttribute("firstIn"); %>
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
                <h2 class="heading-section">임시비밀번호 발급결과</h2>
            </div>
        </div>

        <form action="/resultMentFindPW" method="post">
            <div class="row justify-content-center">
                <div class="col-md-7 col-lg-5">

                    <div class="d-flex">

                    </div>
                    <div class="form-group mt-3">
                    </div>
                    <div class="form-group">
                        <button type="button" onclick="history.go(-2);"
                                class="form-control btn btn-primary rounded submit px-3">Login
                        </button>
                    </div>
                                                            		            <%if(firstIn == false){%>
		             <p class="text-center" style="color:#ff0000">가입하지 않은 아이디이거나, 잘못된 이메일입니다.</p>
		            <% }%>
                </div>
            </div>
        </form>
    </div>
</section>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>
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
                <h2 class="heading-section">아이디 찾기 검색결과</h2>
            </div>
        </div>

        <form action="/resultMentFindID" method="post">
            <div class="row justify-content-center">
                <div class="col-md-7 col-lg-5">
                    <div class="d-flex">
                        <div class="w-100">
                            <h3 class="mb-4">${ userID }
                            </h3>

                        </div>
                    </div>
                    <div class="form-group">
                        <button type="button" onclick="history.go(-2);"
                                class="form-control btn btn-primary rounded submit px-3">Login
                        </button>
                    </div>
                                        		            <%if(firstIn == false){%>
		             <p class="text-center" style="color:#ff0000">가입하지 않은 아이디이거나, 잘못된 이름입니다.</p>
		            <% }%>
                </div>
            </div>
        </form>
    </div>
</section>

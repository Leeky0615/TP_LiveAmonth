<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<body>
<section class="contact-form-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="cf-content">
                    <div class="cc-title">
                        <h4>회원탈퇴확인</h4>
                        <p>확인을 누를 시 회원탈퇴가 진행됩니다.</p>
                    </div>
                    <div>
                        <form action="resultMent?page=dropUser" class="cc-form" id="checkUserForm">
                            <button type="submit" class="site-btn">확인</button>
                            <button type="button" class="site-btn"
                                    onclick=acyncMovePage("reCheckPassword?page=dropUser");>취소
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
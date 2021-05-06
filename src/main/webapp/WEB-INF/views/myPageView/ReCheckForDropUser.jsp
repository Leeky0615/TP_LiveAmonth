<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<script src="resources/js/MyPage.js"></script>
<div class="check-pw">
    <div class="section-title">
        <h4>회원 탈퇴 : 비밀번호 재확인</h4>
        <p><span>보안을 위해서</span> 회원님의 <span>비밀번호</span>를 다시한번 입력해주세요.</p>
        <p>회원 해지시, 회원님의 정보는 삭제되며 복구 불가능합니다.</p>
    </div>
    <form id="checkUserForm" action="checkDropUserPassword">
        <div class="tab-content">
            <ul class="cp-table">
                <li>
                    <label class="type-name">아이디</label>
                    <input id="id-field" type="text"
                           class="form-control" name="userID" value="${userVO.userID}" readonly>
                </li>
                <li>
                    <label class="type-name">비밀번호</label>
                    <input id="password-field" type="password"
                           class="form-control" placeholder="Password" onpaste="return false;"
                           oncopy="return false;" name="userPassword">
                </li>
            </ul>
        </div>
        <c:if test="${!checkUser}">
            <p class="text-center" style="color:#ff0000">잘못된 비밀번호입니다. 다시 확인해 주세요</p>
        </c:if>
        <button class="site-btn" type="submit">확인</button>
    </form>
</div>
</body>
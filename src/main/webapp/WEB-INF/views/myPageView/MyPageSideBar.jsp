<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="col-lg-2">
    <div class="blog-sidebar">
        <div class="feature-post">
            <div class="section-title sidebar-title-b">
                <h6>계정</h6>
            </div>
            <div class="recent-post">
                <div class="rp-item">
                    <div class="rp-text">
                        <a href="#"  onclick=acyncMovePage("reCheckForModifyUserInfo");>회원정보 수정</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="feature-post">
            <div class="section-title sidebar-title-b">
                <h6>커뮤니티</h6>
            </div>
            <div class="recent-post">
                <div class="rp-item">
                    <div class="rp-text">
                        <a href="#">게시판 관리</a>
                    </div>
                </div>
                <div class="rp-item">
                    <div class="rp-text">
                        <a href="#">스케줄 관리</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="feature-post">
            <div class="section-title sidebar-title-b">
                <h6>이용안내</h6>
            </div>

            <div class="recent-post">
                <div class="rp-item">
                    <div class="rp-text">
                        <div class="rp-item">
                            <div class="rp-text">
                                <a href="oneToOneAsk">1:1 문의하기</a>
                            </div>
                        </div>
                        <div class="rp-item">
                            <div class="rp-text">
                                <a href="oneToOneAskReply">1:1문의답변(직원용)</a>
                            </div>
                        </div>
                        <div class="rp-item">
                            <div class="rp-text">
                                <a href="#">공지사항</a>
                            </div>
                        </div>

                        <div class="rp-item">
                            <div class="rp-text">
                                <a href="#">개인정보 처리방침</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="feature-post">
            <div class="section-title sidebar-title-b">
                <h6>기타</h6>
            </div>
            <div class="recent-post">
                <div class="rp-item">
                    <div class="rp-text">
                        <a href="#" onclick=acyncMovePage("reCheckForDropUser");>회원 탈퇴</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

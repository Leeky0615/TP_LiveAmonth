<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="col-lg-2">
    <div class="blog-sidebar">
        <div class="feature-post">
            <div class="section-title sidebar-title-b">
                <h6>전체 게시판</h6>
            </div>
            <div class="recent-post">
                <div class="rp-item">
                    <div class="rp-text">
                        <a href="categoryReviewPage?category=all">전체글보기</a>
                    </div>
                    <div class="rp-text">
                        <a href="categoryReviewPage?category=popular">인기글보기</a>
                    </div>
                    <div class="rp-text">
                        <a href="categoryReviewPage?category=free">자유게시판</a>
                    </div>
                </div>
            </div>
        </div>


        <div class="feature-post">
            <div class="section-title sidebar-title-b">
                <h6>숙박시설</h6>
            </div>
            <div class="recent-post">
                <div class="rp-item">
                    <div class="rp-text">
                       <c:forEach var="reviewCategory" items="${reviewCategoryList}">
                           <c:choose>
                               <c:when test="${fn:contains(reviewCategory,'HOUSE')}">
                                   <a href="categoryReviewPage?category=${reviewCategory}"><option value="${reviewCategory}">${reviewCategory.nameKR}</option></a>
                               </c:when>
                           </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <div class="feature-post">
            <div class="section-title sidebar-title-b">
                <h6>가볼만한곳</h6>
            </div>
            <div class="recent-post">
                <div class="rp-item">
                    <div class="rp-text">
                        <c:forEach var="reviewCategory" items="${reviewCategoryList}">
                            <c:choose>
                                <c:when test="${fn:contains(reviewCategory,'GO')}">
                                    <a href="categoryReviewPage?category=${reviewCategory}"><option value="${reviewCategory}">${reviewCategory.nameKR}</option></a>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <div class="feature-post">
            <div class="section-title sidebar-title-b">
                <h6>먹을만한곳</h6>
            </div>
            <div class="recent-post">
                <div class="rp-item">
                    <div class="rp-text">
                        <c:forEach var="reviewCategory" items="${reviewCategoryList}">
                            <c:choose>
                                <c:when test="${fn:contains(reviewCategory,'FOOD')}">
                                    <a href="categoryReviewPage?category=${reviewCategory}"><option value="${reviewCategory}">${reviewCategory.nameKR}</option></a>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <div class="feature-post">
            <div class="section-title sidebar-title-b">
                <h6>솔직후기</h6>
            </div>
            <div class="recent-post">
                <div class="rp-item">
                    <div class="rp-text">
                        <c:forEach var="reviewCategory" items="${reviewCategoryList}">
                            <c:choose>
                                <c:when test="${fn:contains(reviewCategory,'REVIEW')}">
                                    <a href="?category='${reviewCategory}'"><option value="${reviewCategory}">${reviewCategory.nameKR}</option></a>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>




    </div>
</div>
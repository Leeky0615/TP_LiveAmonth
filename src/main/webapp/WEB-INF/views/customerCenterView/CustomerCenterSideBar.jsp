<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="col-lg-2">
  <div class="blog-sidebar">
    <div class="feature-post">
      <div class="section-title sidebar-title-b">
        <h6>고객센터</h6>
      </div>
      <div class="recent-post">
        <div class="rp-item">
          <div class="rp-text">
            <a href="#"  onclick=acyncMovePage("oneToOneAsk");>1:1 문의</a>
            <a  href="#" onclick=acyncMovePage("faq");>공지사항</a>
            <a  href="#" onclick=acyncMovePage("faq");>FAQ</a>
            <a  href="#" onclick=acyncMovePage("personalTerms");>개인정보 처리방침</a>
          </div>
        </div>
      </div>
    </div>

  </div>
</div>
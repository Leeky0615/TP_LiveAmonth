<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="profile"/>
<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <tiles:insertAttribute name="sideBar"/>
            <div class="col-lg-10" id="body">
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
    </div>
</section>
<tiles:insertAttribute name="footer"/>
</body>
</html>
<script>
    function acyncMovePage(url){
        // ajax option
        var ajaxOption = {
            url : url,
            async : true,
            type : "POST",
            dataType : "html",
            cache : false
        };
        $.ajax(ajaxOption).done(function(data){
            // Contents 영역 삭제
            $('#body').children().remove();
            // Contents 영역 교체
            $('#body').html(data);
        });
    }
</script>
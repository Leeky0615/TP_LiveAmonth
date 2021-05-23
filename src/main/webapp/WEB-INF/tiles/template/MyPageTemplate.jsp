<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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

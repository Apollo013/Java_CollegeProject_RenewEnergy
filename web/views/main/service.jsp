
<%@include file="../../jspf/header.jspf"%>
<%@include file="../../jspf/service_sidebar.jspf"%>	

<c:choose>
    <c:when test="${service == null}">
        <c:redirect url="../messages/error.jsp">
            <c:set var="errorMessage" value="Sorry, No Service data is available for the key - ${param.key}. Please check that the correct url has been entered." scope="session"/>                
        </c:redirect>        
    </c:when>
</c:choose>

<div id="content_wrapper" class="floatright radius shadow content_container content_container_w750" >

    <div id="content_title" class="content_title">Services</div>

    <div id="content_banner_wrapper">
        <img id="content_banner" src="${service.getBannerImageFullPath()}" alt="banner"/>
    </div>  

    <div id="content_overview">

        <div id="overview_header" class="content_sub_title" >Overview</div>

        <div id="overview_content">
            <img class="radius floatright" style="margin-left: 20px;" alt="${service.name}" src="${service.getOverviewImageFullPath()}"/>
            ${service.overview}
        </div>         

        <img src="${initParam.productImagesPath}product_footer.jpg" alt="footer" style="height: 40px; margin-top: auto; margin-bottom: auto; display: inline-block;"/>                  
    </div>  
    
</div>
        
<%@include file="../../jspf/footer.jspf" %>

<script type="text/javascript" >
    
    // Change the page title
    document.title = 'Services';

</script>


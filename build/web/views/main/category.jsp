<%-- 
    Document   : product
    Created on : 28-Oct-2013, 12:39:12
    Author     : Paul Millar <D00152098>
--%>

<%@include file="../../jspf/header.jspf"%>
<%@include file="../../jspf/products_sidebar.jspf"%>

<c:choose>
    <c:when test="${category == null}">
        <c:redirect url="../messages/error.jsp">
            <c:set var="errorMessage" value="Sorry, No Category data is available for the key - ${param.key}. Please check that the correct url has been entered." scope="session"/>                
        </c:redirect>        
    </c:when>
</c:choose>

<div id="content_wrapper" class="floatright radius shadow content_container content_container_w750">


    <div id="content_title" class="content_title">${category.name}</div>  

    <div id="content_banner_wrapper">
        <img id="content_banner" src="${category.getBannerImageFullPath()}" alt="banner"/>
    </div> 

    <div id="content_overview">

        <div id="overview_header" class="content_sub_title">Overview</div>

        <div id="overview_content">
            <img class="radius floatright" style="margin-left: 20px;" alt="${category.name}" src="${category.getOverviewImageFullPath()}"/>

            <p>${category.overview}</p>

        </div>
    </div>  

    <div id="content_overview">
        <div id="product_sub_header" class="content_sub_title">Products</div>  
        <c:forEach var="product" items="${category.products}" >
            <div class="bordered radius">
                <img class="radius floatleft margin" alt="${product.name}" src="${product.getListItemImageFullPath()}"></img>
                <div class="product_content">

                    <a href="${initParam.productPage}&key=${product.id}">${product.name}</a>
                    <p>
                      ${product.introduction}
                    </p>
                    <!--
                    <a href="${initParam.productPage}&key=${product.id}" class="view_details_button floatright" style="margin-left: 10px;">
                      <span>Add To Cart</span>
                    </a>
                    -->
                    <a href="${initParam.productPage}&key=${product.id}" class="view_details_button floatright">
                      <span>View Details</span>
                    </a>

                </div>
            </div>
        </c:forEach>                 
    </div>

    <div>
        <div id="how_it_works_sub_header" class="content_sub_title">How It Works ...</div>                    
    </div>
    <div>
        <div><img id="howitworks_image" src="${category.getHowItWorksImageFullPath()}" alt="How It Works" class="howitworks_image"/></div>
    </div>                

    <img src="${initParam.productImagesPath}product_footer.jpg" alt="footer" style="height: 40px; margin-top: auto; margin-bottom: auto; display: inline-block;"/>
    
</div>

<%@include file="../../jspf/footer.jspf" %>

<script type="text/javascript">
    // Change the page title
    document.title = 'Products';    
</script> 
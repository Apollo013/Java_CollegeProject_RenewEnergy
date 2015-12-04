<%-- 
    Document   : productdetail
    Created on : 28-Oct-2013, 12:39:34
    Author     : Paul Millar <D00152098>
--%>

<%@include file="../../jspf/header.jspf"%>
<%@include file="../../jspf/products_sidebar.jspf"%>	

<div id="content_wrapper" class="floatright radius shadow content_container content_container_w750" style="height: 861px">


    <div id="content_title" class="content_title">${product.getName()}</div>  

    <div id="content_banner_wrapper">
        <img id="content_banner" src="${product.getBannerImageFullPath()}" alt="banner" />
    </div>              

    <div id="content_overview">

        <div id="overview_header" class="content_sub_title">Overview</div>

        <div id="overview_content" style="height: 190px">
            <img class="radius floatright" style="margin-left: 20px;" alt="${product.name}" src="${product.getOverviewImageFullPath()}"/>
            <p>${product.overview}</p>
        </div>    

    </div>

    <div id="content_overview">
        <div id="product_sub_header" class="content_sub_title">Savings Graph</div>                 
        <div class="bordered radius">

            <div id="graph" class="radius floatleft" style="display:none; margin-right: 30px;"></div>
            <div class="product_content" style="width: 350px;">
                <p class="margin">
                    <span>${product.introduction}</span>
                    <br/><br/>                            
                    <strong>Price: <fmt:formatNumber value="${product.price}"/></strong>
                </p>

            </div>
            <!--
            <a href="${initParam.productPage}&key=${product.id}" class="view_details_button floatright margin">
              <span>Add To Cart</span>
            </a>
            -->
        </div>

    </div>
    <br/><br/><br/><br/>          
    <img src="${initParam.productImagesPath}product_footer.jpg" alt="footer" style="height: 40px; margin-top: auto; margin-bottom: auto; display: inline-block;"/>                           
                                  
</div>
  
                
<%@include file="../../jspf/footer.jspf" %>

<script src="${initParam.jsPath}graph.js" type="text/javascript"></script>

<script type="text/javascript" >
    
    // Change the page title
    document.title = 'Products';
    
    // Run Graph Animation
    loadProductGraphValues('${product.savingsValues}');
    
</script>

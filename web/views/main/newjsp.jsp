    
<%@include file="../../jspf/header.jspf"%>
<%@include file="../../jspf/products_sidebar.jspf"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<div id="content_wrapper" class="floatright radius shadow content_container content_container_w750">

    <div id="content_title" class="content_title">Product Categories</div>

    <div id="content_banner_wrapper">
        <img id="content_banner" src="${initParam.productImagesPath}products_bannerimage.jpg" alt="products banner"/>
    </div>

    <div id="content_overview">
        <div id="overview_header" class="content_sub_title">Overview</div>
        <div id="overview_content">
            <img id="overview_image" src="${initParam.productImagesPath}products-page-renewable-energy.jpg" class="floatright radius" alt="overview image"/>
            <p><strong>Renew Energy Group plc</strong> is a building products business focused on establishing leading market positions by providing energy conserving and renewable construction systems with a global reach.</p>
            <p>Renew has manufacturing and distribution operations throughout Ireland and is recognized throughout the construction industry for its commitment to innovation, design, quality and technical expertise.</p>
            <p>Across a wide range of sectors within the industry, Renew's integrated approach to the energy efficiency of buildings has made it first choice in delivering the specialist needs of architects, specifiers, developers and building owners.</p>
            <p style="margin-bottom:-10px;"><strong>Renew's Solar and Turbine business has an overall goal to provide solutions towards a zero carbon lifestyle.</strong></p>
        </div>
    </div>
                        
    <div>
        <div id="product_sub_header" class="content_sub_title">Products</div>                    
    </div>
     
    <c:choose>
        <c:when test="${searchAllList != null}">
            <div>
                <c:forEach var="category" items="${searchAllList}" >
                    <div class="bordered radius">
                        <img class="radius floatleft margin" alt="${category.name}" src="${category.getListItemImageFullPath()}"></img>
                        <div class="product_content">

                            <a href="${initParam.categoryPage}&key=${category.id}">${category.name}</a>
                            <p>
                                ${category.introduction}
                            </p>
                            <a href="${initParam.categoryPage}&key=${category.id}" class="view_details_button floatright">
                                <span>View Details</span>
                            </a>
                        </div>
                    </div>
                </c:forEach> 
            </div>                    
        </c:when>
    </c:choose>
   
    <img src="${initParam.productImagesPath}product_footer.jpg" alt="footer" style="height: 40px; margin-top: auto; margin-bottom: auto; display: inline-block;"/>  
        
</div>

<%@include file="../../jspf/footer.jspf" %>

<script type="text/javascript">

    // Change the page title
    document.title = 'Products';
    
</script> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>
<%@include file="//jspf/admin/toolbar_listview.jspf"%> 

<div class ="admin_content">
    <div class="header_row blue_gradient">
        <span class="tiny_width">ID</span>           
        <span class="long_width">Name</span>
        <span class="medium_width">Category</span>     
        <span class="short_width">Price</span>   
        <span class="short_width">On Hand</span>           
    </div>
    <c:choose>
        <c:when test="${searchAllList != null}">
            <div>
                <c:forEach var="product" items="${searchAllList}" >
                    <div class="row blue_gradient">
                        <a href="product?cmd=${initParam.editCommand}&key=${product.getId()}">
                            <span class="tiny_width">${product.getId()}</span>                              
                            <span class="long_width">${product.getName()}</span>
                            <span class="medium_width">${product.getCategoryName()}</span>
                            <span class="short_width"><fmt:formatNumber value="${product.getPrice()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span>
                            <span class="short_width">${product.getOnHand()}</span>
                        </a>
                        <div class="list_button_wrapper">
                            <a href="product?cmd=${initParam.editCommand}&key=${product.getId()}" class="button orange_button list_button">
                                Edit
                            </a>    
                            <a href="product?cmd=${initParam.confirmdeleteCommand}&key=${product.getId()}" class="button orange_button list_button">
                                Delete
                            </a>                             
                        </div>                              
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div>There are no products !!!</div>
        </c:otherwise>        
    </c:choose>
</div>
<%@include file="//jspf/admin/admin_footer.jspf"%>    
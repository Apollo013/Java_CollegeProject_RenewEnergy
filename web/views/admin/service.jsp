<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>
<%@include file="//jspf/admin/toolbar_listview.jspf"%>   

<div class ="admin_content">
    <div class="header_row blue_gradient">
        <span class="tiny_width">ID</span>          
        <span class="long_width">Name</span>   
        <span class="short_width">Price</span>          
    </div>
    <c:choose>
        <c:when test="${searchAllList != null}">
            <div>
                <c:forEach var="service" items="${searchAllList}" >
                    <div class="row blue_gradient">
                        <a href="service?cmd=${initParam.editCommand}&key=${service.getId()}">
                            <span class="tiny_width">${service.getId()}</span>                              
                            <span class="long_width">${service.getName()}</span>
                            <span class="short_width"><fmt:formatNumber value="${service.getPrice()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span>
                        </a>
                        <div class="list_button_wrapper">
                            <a href="service?cmd=${initParam.editCommand}&key=${service.getId()}" class="button orange_button list_button">
                                Edit
                            </a>    
                            <a href="service?cmd=${initParam.confirmdeleteCommand}&key=${service.getId()}" class="button orange_button list_button">
                                Delete
                            </a>                             
                        </div>                              
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div>There are no services !!!</div>
        </c:otherwise>        
    </c:choose>
</div>

<%@include file="//jspf/admin/admin_footer.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>
<%@include file="//jspf/admin/toolbar_listview.jspf"%>   

<div class ="admin_content">
    <div class="header_row blue_gradient">
        <span class="tiny_width">No.</span>        
        <span class="long_width">Customer Name</span>
        <span class="short_width">Order Date</span>  
        <span class="short_width">Price</span>   
        <span class="short_width">Status</span>         
    </div>
    <c:choose>
        <c:when test="${searchAllList != null}">
            <div>
                <c:forEach var="order" items="${searchAllList}" >
                    <div class="row blue_gradient">
                        <a href="order?cmd=${initParam.editCommand}&key=${order.getOrderNo()}">
                            <span class="tiny_width">${order.getOrderNo()}</span>                            
                            <span class="long_width">${order.getUser().getFullName()}</span>                            
                            <span class="short_width">${order.getOrderDateFormatted()}</span>
                            <span class="short_width"><fmt:formatNumber value="${order.getTotalPrice()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span>
                            <span class="short_width">${order.getOrderStatus()}</span>                         
                        </a>
                        <div class="list_button_wrapper">
                            <a href="order?cmd=${initParam.editCommand}&key=${order.getOrderNo()}" class="button orange_button list_button">
                                Edit
                            </a>    
                            <a href="order?cmd=${initParam.confirmdeleteCommand}&key=${order.getOrderNo()}" class="button orange_button list_button">
                                Delete
                            </a>                             
                        </div>                              
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div>There are no orders !!!</div>
        </c:otherwise>        
    </c:choose>
</div>


<%@include file="//jspf/admin/admin_footer.jspf"%>
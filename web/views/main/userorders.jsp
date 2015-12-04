<%-- 
    Document   : userorders
    Created on : 16-Dec-2013, 03:41:52
    Author     : Paul Millar <D00152098>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">             
        <title>${pagetitle}</title>          		        
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>      
        <script src="${initParam.jsPath}validation.js" type="text/javascript"></script>
        
        <link href="${initParam.generalImagesPath}favicon.ico" rel="shortcut icon" type="image/x-icon" >
        <link href="${initParam.cssPath}forms.css" type="text/css" rel="stylesheet"/>         
    </head>
    <body>        
        <div class="user_wrapper form_background" style="width:80%;">
            <h1 style="color: #FFFFAA !important;">Your Orders</h1>             
            <div class ="admin_content" style="background: none;">
                <div class="header_row blue_gradient">
                    <span class="tiny_width">No.</span>        
                    <span class="long_width">Customer Name</span>
                    <span class="medium_width">Order Date</span>  
                    <span class="medium_width">Total Cost</span>   
                    <span class="medium_width">Status</span>         
                </div>
                <c:choose>
                    <c:when test="${userorders != null}">
                        <div>
                            <c:forEach var="order" items="${userorders}" >
                                <div class="row blue_gradient" style="margin-top: 20px !important;">
                                    <div class="row blue_gradient">

                                            <span class="tiny_width" style="color: #FFFFAA !important;">${order.getOrderNo()}</span>                            
                                            <span class="long_width" style="color: #FFFFAA !important;">${order.getUser().getFullName()}</span>                            
                                            <span class="medium_width" style="color: #FFFFAA !important;">${order.getOrderDateFormatted()}</span>
                                            <span class="medium_width" style="color: #FFFFAA !important;"><fmt:formatNumber value="${order.getTotalPrice()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span>
                                            <span class="medium_width" style="color: #FFFFAA !important;">${order.getOrderStatus()}</span>                                                  
                                    </div>

                                    <c:choose>
                                        <c:when test="${order.getOrderItems().size() != 0}">
                                            <div class="header_row">
                                                <span class="long_width">Product Name</span>          
                                                <span class="long_width">Price</span>    
                                                <span class="medium_width">Quantity</span>           
                                                <span class="long_width">Line Total</span>                     
                                            </div> 
                                            <c:forEach var="orderItem" items="${order.getOrderItems()}" >
                                                <form id="input_form" name="input_form" action="order" method="post">

                                                    <div class="row blue_gradient" >
                                                        <a href="order?cmd=${initParam.editCommand}&key=${orderItem.getId()}">                             
                                                            <span class="long_width">${orderItem.getProductName()}</span>
                                                            <span class="long_width"><fmt:formatNumber value="${orderItem.getPrice()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span>                                        
                                                            <span class="medium_width">${orderItem.getQuantity()}</span>
                                                            <span class="long_width"><fmt:formatNumber value="${orderItem.getLineTotal()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span>                                                                           
                                                        </a>   

                                                    </div>  

                                                </form>
                                            </c:forEach>                      
                                        </c:when>                
                                    </c:choose>
                                </div>
                            </c:forEach>               
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div>There are no orders !!!</div>
                    </c:otherwise>        
                </c:choose>
            </div>
            <div class="button_wrapper center">
                <input type="button" onclick="document.location.href='index.jsp';" value="Go To Home" class="button blue_button standard_button floatright" tabindex="13"/>                      
            </div>              
        </div>   
    </body>
</html>
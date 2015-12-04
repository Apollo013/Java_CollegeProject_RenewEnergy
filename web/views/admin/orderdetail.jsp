<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>

<%-- when no user is selected - force the user to select one --%>
<c:set var="userid" value="${order.getUser().getId()}"/>
<c:choose>
    <c:when test="${userid < 1}">
        <c:redirect url="selectuser.jsp"/>        
    </c:when>
</c:choose>

<div class="admin_toolbar blue_gradient">
    
    <div class="admin_detail_button_wrapper">   
        <c:choose>
            <c:when test="${command == initParam.editCommand || command == initParam.createCommand}">
                <input type="submit" value="Save" class="button orange_button toolbar_button" tabindex="15" onclick="submitForm()"/>  
            </c:when>
            <c:otherwise>
                <input type="submit" value="Delete" class="button orange_button toolbar_button" tabindex="16" onclick="submitForm()"/>                   
            </c:otherwise>
        </c:choose>        
        <a href="javascript:history.back()" class="button orange_button toolbar_button" tabindex="17" >Back</a>                    
    </div>
                
<%-- depending on the current command, set the next command and appropriate header title --%>
<%-- this will never be insert, because an order is inserted after they select a user/customer --%>
    <c:choose>
        <c:when test="${command != initParam.editCommand}">
            <h3 class="floatright admin_page_header">Delete Order</h3>    
            <c:set var="command" value="${initParam.deleteCommand}"/>          
        </c:when>         
        <c:otherwise>
            <h3 class="floatright admin_page_header">Edit Order</h3> 
            <c:set var="command" value="${initParam.updateCommand}"/>             
        </c:otherwise>
    </c:choose>    
          
</div> 

<div class ="admin_content">
    <div>
        <form id="input_form" name="input_form" action="order" method="post">
            <div class="row blue_gradient">
                <div style="width: 47%; float:left; margin: 10px;">
                    <span class="form_green_title">Order No.</span>
                    <input id="orderno" name="orderno" type="text" readonly="true" class="input blue_gradient required" style="margin-left: 10px; width: 100px;" value="${order.getOrderNo()}" />                                 
                    <span class="form_green_title">Customer Name</span>
                    <input id="fullname" name="fullname" type="text" readonly="true" class="input blue_gradient required" style="margin-left: 10px; width: 80%;" value="${order.getUser().getFullName()}" /> 
                    <span class="form_green_title">Address</span>
                    <textarea id="fulladdress" name="fulladdress" rows="7" cols="95" readonly="true" class="textbox blue_gradient required" style="margin: 10px; width: 80%;">${order.getUser().getFullAddress()}</textarea>                 
                </div>
                <div style="width: 47%; float:left;  margin: 10px;">
                    <span class="form_green_title">Order Date</span>                
                    <input id="orderdate" name="orderdate" type="text" readonly="true" class="input blue_gradient required" style="margin-left: 10px; width: 200px;" value="${order.getOrderDate()}" />                                
                    <span class="form_green_title">Status</span>
                    <select class="input blue_gradient required" name="status" id="status" style="margin-left: 10px; width: 220px;">
                        <option value="1" ${order.getStatus() == 1 ? 'selected' : '' }>On Order</option>
                        <option value="2" ${order.getStatus() == 2 ? 'selected' : '' }>Work In Progress</option>
                        <option value="3" ${order.getStatus() == 3 ? 'selected' : '' }>Ready</option>
                        <option value="4" ${order.getStatus() == 4 ? 'selected' : '' }>Shipped</option>
                        <option value="5" ${order.getStatus() == 5 ? 'selected' : '' }>Canceled</option>
                        <option value="6" ${order.getStatus() == 6 ? 'selected' : '' }>Processed</option>                        
                    </select>   
                    <span class="form_green_title">Ship Date</span>                
                    <input id="shipdate" name="shipdate" type="text" readonly="true" class="input blue_gradient" style="margin-left: 10px; width: 200px;" value="${order.getShipDate()}" />                    
                    <span class="form_green_title">Order Total</span>                
                    <input id="totalprice" name="totalprice" type="text" readonly="true" min="0.01" step="0.01" class="input blue_gradient required" style="margin-left: 10px; width: 200px;" value="${order.getTotalPrice()}" />                     
                </div>
            </div>    
            <div class="row blue_gradient">
                <span class="form_green_title">Line Items</span>
                <c:choose>
                    <c:when test="${order.getStatus() < 3}">
                        <a href="selectproduct.jsp" class="button orange_button list_button floatright">
                            Add New Line
                        </a> 
                    </c:when>
                </c:choose>
            </div>
            <div class="row blue_gradient">
                <div class="header_row">
                    <span class="long_width">Product Name</span>          
                    <span class="medium_width">Price</span>    
                    <span class="medium_width">Quantity</span>           
                    <span class="medium_width">Line Total</span>                     
                </div>                

                <c:choose>
                    <c:when test="${order.getOrderItems().size() != 0}">
                        <c:forEach var="orderItem" items="${order.getOrderItems()}" >

                            <div class="row blue_gradient">
                                <a href="orderitem?cmd=${initParam.editCommand}&key=${orderItem.getId()}">                             
                                    <span class="long_width">${orderItem.getProductName()}</span>
                                    <span class="medium_width"><fmt:formatNumber value="${orderItem.getPrice()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span> 
                                    <span class="medium_width">${orderItem.getQuantity()}</span>
                                    <span class="medium_width"><fmt:formatNumber value="${orderItem.getLineTotal()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span> 
                                </a>   
                                <c:choose>
                                    <c:when test="${order.getStatus() < 3}">
                                        <div class="list_button_wrapper">  
                                            <a href="orderitem?cmd=${initParam.editCommand}&key=${orderItem.getId()}" class="button orange_button list_button">
                                                Edit
                                            </a>    
                                            <a href="orderitem?cmd=${initParam.confirmdeleteCommand}&key=${orderItem.getId()}" class="button orange_button list_button">
                                                Delete
                                            </a>                             
                                        </div>   
                                    </c:when>                                          
                                </c:choose>                                                             
                            </div>  
                        </c:forEach>                      
                    </c:when>                
                </c:choose>
            </div> 
            <div class="row blue_gradient">
                <span class="form_green_title floatright" style="margin-right: 10px;">Total: <fmt:formatNumber value="${order.getTotalPrice()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span>
            </div>                
            <input type="hidden" name="key"             value="${order.getOrderNo()}" />
            <input type="hidden" name="lastupdated"     value="${order.getLastUpdated()}" />            
            <input type="hidden" name="cmd"             value="${command}" />               
        </form>
    </div>    
</div>

<%@include file="//jspf/admin/admin_footer.jspf"%>

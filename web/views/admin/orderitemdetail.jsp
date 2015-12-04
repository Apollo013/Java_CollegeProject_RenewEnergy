<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>

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
        <a href="javascript:history.back()" class="button orange_button toolbar_button" tabindex="17" >Cancel</a>                    
    </div>
                
<%-- depending on the current command, set the next command and appropriate header title
this will never be insert, because order items are inserted from the select product page --%>
    <c:choose>
        <c:when test="${command != initParam.editCommand}">
            <h3 class="floatright admin_page_header">Delete Order Item</h3>    
            <c:set var="formaction" value="deleteorderitem"/>
        </c:when>         
        <c:otherwise>
            <h3 class="floatright admin_page_header">Edit Order Item</h3> 
            <c:set var="formaction" value="changeorderitem"/>            
        </c:otherwise>
    </c:choose>  
          
</div> 

<div class ="admin_content ">

    <div class="blue_gradient radius" style="margin: 20px;">
        <form id="input_form" name="input_form" action="orderitem" method="post">

            <div id="errorDisplay" class="error_display blue_gradient"></div>
                   
            <div class="admin_field_wrapper">

                <table>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Product Name</span>
                        </td>
                        <td class="table_data">
                            <input id="productname" name="productname" type="text" size="40" class="input blue_gradient required" tabindex="1" readonly="true" required placeholder="Product Name *" value="${orderitem.getProductName()}"/> 
                        </td>
                    </tr>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Price</span>
                        </td>
                        <td class="table_data">
                            <input id="price" name="price" type="number" min="0.00" step="0.01" readonly="true" class="input blue_gradient positive" tabindex="2" required placeholder="Price *" value="${orderitem.getPrice()}"/> 
                        </td>
                    </tr>   
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Quantity</span>
                        </td>
                        <td class="table_data">
                            <input id="quantity" name="quantity" type="number" min="1" step="1" class="input blue_gradient required positive" tabindex="3" required placeholder="Quantity *" value="${orderitem.getQuantity()}"/> 
                        </td>
                    </tr>                      
                </table>
                        
            </div>
                        
            <input type="hidden" name="key"         value="${orderitem.getProductId()}" />
            <input type="hidden" name="orderno"     value="${orderitem.getOrderNo()}"/>
            <input type="hidden" name="cmd"         value="${initParam.processOrderCommand}" />                         
            <input type="hidden" name="action"      value="${formaction}" /> 
            
        </form>
    </div>
</div>
                            
<%@include file="//jspf/admin/admin_footer.jspf"%>

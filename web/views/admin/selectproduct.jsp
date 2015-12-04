<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>

<div class="admin_toolbar">
    <h3 class="admin_page_header ">New Order <span class="tiny_width">${order.getOrderNo()}</span></h3>   
    <h3 class="admin_page_header floatright">Select a product</h3> 
</div>

<div class ="admin_content">
    <div class="header_row blue_gradient">
        <span class="tiny_width">ID</span>           
        <span class="long_width">Product Name</span>   
        <span class="short_width">Price</span>   
        <span class="short_width">Quantity</span>           
    </div>
    <c:choose>
        <c:when test="${orderProductsList != null}">
            <div>
                <c:forEach var="product" items="${orderProductsList}" >
                    <form id="input_form" name="input_form" action="orderitem" method="post">
                        <div class="row blue_gradient">
                              
                            <span class="tiny_width">${product.getId()}</span>                              
                            <span class="long_width">${product.getName()}</span>
                            <span class="short_width"><fmt:formatNumber value="${product.getPrice()}" type="currency" minFractionDigits="2" maxIntegerDigits="10" /> </span>                            
                            <input id="quantity" name="quantity" type="number" min="1" step="1" value="1" required class="input blue_gradient currency short_width positive" style="display:inline-block;"/>
                            
                            <c:choose>
                                <c:when test="${product.getOnHand() < 1}">
                                    <div class="list_button_wrapper">
                                        <span style="color:red; margin-right: 40px; line-height: 45px; font-weight: bolder">Out Of Stock</span>                            
                                    </div>                                      
                                </c:when>
                                <c:otherwise>
                                    <div class="list_button_wrapper">
                                        <input type="submit" value="Select" class="button orange_button toolbar_button"/>                             
                                    </div>                                       
                                </c:otherwise>
                            </c:choose>
                        </div>       
                        <input type="hidden" name="key"             value="${product.getId()}" />
                        <input type="hidden" name="productname"     value="${product.getName()}" />
                        <input type="hidden" name="price"           value="${product.getPrice()}"/>
                        <input type="hidden" name="orderno"         value="${order.getOrderNo()}"/>
                        <input type="hidden" name="cmd"             value="${initParam.processOrderCommand}" />  
                        <input type="hidden" name="action"          value="addorderitem" />                      
                    </form>

                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div>There are no products !!!</div>
        </c:otherwise>        
    </c:choose>
</div>
<%@include file="//jspf/admin/admin_footer.jspf"%>    
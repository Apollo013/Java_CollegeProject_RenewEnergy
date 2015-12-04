<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>

<div class="admin_toolbar">
    <h3 class="admin_page_header ">New Order</h3>   
    <h3 class="admin_page_header floatright">Select a Customer</h3> 
</div>

<div class ="admin_content">
    <div class="header_row blue_gradient">
        <span class="tiny_width">ID</span>          
        <span class="long_width">Customer Name</span>    
        <span class="medium_width">Email</span>           
    </div>
    <c:choose>
        <c:when test="${orderUsersList != null}">
            <div>
                <c:forEach var="user" items="${orderUsersList}" >
                    <form id="input_form" name="input_form" action="order" method="post">

                        <div class="row blue_gradient">
                            <span class="tiny_width">${user.getId()}</span>                              
                            <span class="long_width">${user.getFullName()}</span>
                            <span class="medium_width">${user.getEmail()}</span>                         

                            <div class="list_button_wrapper">
                                <input type="submit" value="Select" class="button orange_button toolbar_button"/>                             
                            </div>                              

                            <input type="hidden" name="key"     value="${user.getId()}" />
                            <input type="hidden" name="cmd"     value="${initParam.insertCommand}" />  
                            <%--<input type="hidden" name="action"  value="addcustomer" />  --%>
                        </div>
                            
                    </form>   
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div>There are no users !!!</div>            
        </c:otherwise>
    </c:choose>
</div>

<%@include file="//jspf/admin/admin_footer.jspf"%>

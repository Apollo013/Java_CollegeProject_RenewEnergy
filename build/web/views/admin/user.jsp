<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>
<%@include file="//jspf/admin/toolbar_listview.jspf"%>   

<div class ="admin_content">
    <div class="header_row blue_gradient">
        <span class="tiny_width">ID</span>          
        <span class="medium_width">First Name</span>   
        <span class="medium_width">Last Name</span>    
        <span class="medium_width">Email</span>           
    </div>
    <c:choose>
        <c:when test="${searchAllList != null}">
            <div>
                <c:forEach var="user" items="${searchAllList}" >
                    <div class="row blue_gradient">
                        <a href="user?cmd=${initParam.editCommand}&key=${user.getId()}">
                            <span class="tiny_width">${user.getId()}</span>                              
                            <span class="medium_width">${user.getFirstName()}</span>
                            <span class="medium_width">${user.getLastName()}</span>
                            <span class="medium_width">${user.getEmail()}</span>                            
                        </a>
                        <div class="list_button_wrapper">
                            <a href="user?cmd=${initParam.editCommand}&key=${user.getId()}" class="button orange_button list_button">
                                Edit
                            </a>    
                            <a href="user?cmd=${initParam.confirmdeleteCommand}&key=${user.getId()}" class="button orange_button list_button">
                                Delete
                            </a>                             
                        </div>                              
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div>There are no users !!!</div>
        </c:otherwise>
    </c:choose>
</div>


<%@include file="//jspf/admin/admin_footer.jspf"%>
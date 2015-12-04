<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>
<%@include file="//jspf/admin/toolbar_listview.jspf"%>   

    <div class ="admin_content">
        <div class="header_row blue_gradient">
            <span class="tiny_width">ID</span>        
            <span class="long_width">Name</span>
            <span class="long_width">Last Updated</span>        
        </div>
        <c:choose>
            <c:when test="${searchAllList != null}">
                <div>
                    <c:forEach var="category" items="${searchAllList}" >
                        <div class="row blue_gradient">
                            <a href="category?cmd=${initParam.editCommand}&key=${category.getId()}">
                                <span class="tiny_width">${category.getId()}</span>                            
                                <span class="long_width">${category.getName()}</span>                            
                                <span class="long_width">${category.getLastUpdatedFormatted()}</span>
                            </a>
                            <div class="list_button_wrapper">
                                <a href="category?cmd=${initParam.editCommand}&key=${category.getId()}" class="button orange_button list_button">
                                    Edit
                                </a>    
                                <a href="category?cmd=${initParam.confirmdeleteCommand}&key=${category.getId()}" class="button orange_button list_button">
                                    Delete
                                </a>                             
                            </div>                              
                        </div>
                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <div>There are no categories !!!</div>
            </c:otherwise>        
        </c:choose>
    </div>

<%@include file="//jspf/admin/admin_footer.jspf"%>
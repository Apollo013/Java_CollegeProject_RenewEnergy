<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>
<%@include file="//jspf/admin/toolbar_detailview.jspf"%>  

<div class ="admin_content">

    <div class="blue_gradient radius" style="margin: 20px;">
        <form id="input_form" name="input_form" action="user" method="post">

            <div id="errorDisplay" class="error_display blue_gradient"></div>
                   
            <div class="admin_field_wrapper">

                <table>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">First Name</span>
                        </td>
                        <td class="table_data">
                            <input id="firstname" name="firstname" type="text" size="30" class="input blue_gradient required" tabindex="1" autofocus required placeholder="Enter User's First Name *" value="${user.getFirstName()}"/> 
                        </td>
                    </tr>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Last Name</span>
                        </td>
                        <td class="table_data">
                            <input id="lastname" name="lastname" type="text" size="30" class="input blue_gradient required" tabindex="2" required placeholder="Enter User's Last Name *" value="${user.getLastName()}"/> 
                        </td>
                    </tr>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Type</span> 
                        </td>
                        <td class="table_data">
                            <select class="input blue_gradient required" name="usertype" id="usertype">
                                <option value="1" ${user.getUserType() != 2 ? 'selected' : '' }>Administrator</option>
                                <option value="2" ${user.getUserType() == 2 ? 'selected' : '' }>Customer</option>
                            </select>                             
                        </td>
                    </tr>                      
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Email</span>
                        </td>
                        <td class="table_data">
                            <input id="email" name="email" type="email" size="100" class="input blue_gradient email" tabindex="3" required placeholder="Enter User's Email Address *" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" value="${user.getEmail()}"/> 
                        </td>
                    </tr>     
                    <c:choose>
                        <c:when test="${command == initParam.insertCommand}">
                            <%-- only allow administrator to insert a new password, not change it --%>
                            <tr>
                                <td class="table_label">
                                    <span class="form_green_title">Password</span>
                                </td>
                                <td class="table_data">
                                    <input id="password" name="password" type="password" size="10" class="input blue_gradient password" tabindex="3" required placeholder="Enter User's Password *" pattern="^([a-zA-Z0-9_-]){6,10}$" value="${user.getPassword()}"/> 
                                </td>
                            </tr> 
                        </c:when> 
                        <c:otherwise>
                                    <input id="password" name="password" type="hidden" value="${user.getPassword()}"/>                             
                        </c:otherwise>
                    </c:choose>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Address</span> 
                        </td>
                        <td class="table_data">
                            <input id="address1" name="address1" type="text" size="40" class="input blue_gradient required" tabindex="6" required placeholder="Enter The First Line Of User's Address *" value="${user.getAddress1()}"/>                      
                        </td>
                    </tr> 
                    <tr>
                        <td class="table_label">

                        </td>
                        <td class="table_data">
                            <input id="address2" name="address2" type="text" size="40" class="input blue_gradient" tabindex="7" placeholder="Enter The Second Line Of User's Address" value="${user.getAddress2()}"/> 
                        </td>
                    </tr>  
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Town/City</span> 
                        </td>
                        <td class="table_data">
                            <input id="city" name="city" type="text" size="30" class="input blue_gradient required" tabindex="8" required placeholder="Enter User's Town or City *" value="${user.getCity()}"/> 
                        </td>
                    </tr> 
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">County</span> 
                        </td>
                        <td class="table_data">
                            <input id="county" name="county" type="text" size="30" class="input blue_gradient required" tabindex="9" required placeholder="Enter User's County *" value="${user.getCounty()}"/>    
                        </td>
                    </tr> 
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Country</span> 
                        </td>
                        <td class="table_data">
                            <input id="country" name="country" type="text" size="30" class="input blue_gradient required" tabindex="10" required placeholder="Enter User's Country *" value="${user.getCountry()}"/>  
                        </td>
                    </tr> 
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Post Code</span> 
                        </td>
                        <td class="table_data">
                            <input id="postcode" name="postcode" type="text" size="10" class="input blue_gradient" tabindex="11" placeholder="Enter User's Post Code" value="${user.getPostCode()}"/>   
                        </td>
                    </tr>   
                </table>                    
            </div>   
                        
            <input type="hidden" name="key"         value="${user.getId()}" />
            <input type="hidden" name="lastupdated" value="${user.getLastUpdated()}" />                            
            <input type="hidden" name="cmd"         value="${command}" />
            
        </form>
    </div>                 
</div>
            
<%@include file="//jspf/admin/admin_footer.jspf"%>

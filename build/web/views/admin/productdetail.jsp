<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>
<%@include file="//jspf/admin/toolbar_detailview.jspf"%>   

<div class ="admin_content">

    <div class="blue_gradient radius" style="margin: 20px;">
        <form id="input_form" name="input_form" action="product" method="post">

            <div id="errorDisplay" class="error_display blue_gradient"></div>
                   
            <div class="admin_field_wrapper">

                <table>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Name</span>
                        </td>
                        <td class="table_data">
                            <input id="name" name="name" type="text" size="40" class="input blue_gradient required" tabindex="1" autofocus required placeholder="Enter Product Name *" value="${product.getName()}"/> 
                        </td>
                    </tr>
                    <c:choose>
                        <c:when test="${categoryNamesList != null && action != 'delete'}">
                            <tr>
                                <td class="table_label">
                                    <span class="form_green_title">Category</span>
                                </td>
                                <td class="table_data">
                                    <select name="cat_id" class="input blue_gradient required" tabindex="2" >
                                        <c:forEach items="${categoryNamesList}" var="category">
                                            <option value="${category.getId()}" ${category.getId() == searchKeyItem.getCategoryID() ? 'selected' : ''}>${category.getName()}</option>
                                        </c:forEach>
                                    </select>                                 
                                    <input type="hidden" name="category_name"   value="${product.getCategoryName()}" />                                      
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <input type="hidden" name="category_name"   value="${product.getCategoryName()}" />                             
                            <input id="cat_id" type="hidden" value="${product.getCategoryID()}" tabindex="2" />
                        </c:otherwise>
                    </c:choose>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Introduction</span>
                        </td>
                        <td class="table_data">
                            <textarea id="introduction" name="introduction" rows="5" cols="100" class="textbox blue_gradient required" tabindex="3" required placeholder="Enter Product Introduction *" >${product.getIntroduction()}</textarea> 
                        </td>
                    </tr>                    
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Overview</span>
                        </td>
                        <td class="table_data">
                            <textarea id="overview" name="overview" rows="16" cols="100" class="textbox blue_gradient required" tabindex="4" required placeholder="Enter Product Overview *" >${product.getOverview()}</textarea> 
                        </td>
                    </tr>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Savings Text</span>
                        </td>
                        <td class="table_data">
                            <textarea id="savingstext" name="savings_Text" rows="2" cols="100" class="textbox blue_gradient required" tabindex="5" required placeholder="Enter Text For Product Savings *" >${product.getSavingsText()}</textarea> 
                        </td>
                    </tr> 
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Savings Values</span>
                        </td>
                        <td class="table_data">
                            <input id="savingsvalues" name="savings_values" type="number" size="3" class="input blue_gradient required" tabindex="6" required placeholder="Enter Product Savings Values *" value="${product.getSavingsValues()}"/> 
                        </td>
                    </tr>                    
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Price</span>
                        </td>
                        <td class="table_data">
                            <input id="price" name="price" type="number" min="0.01" step="0.01" class="input blue_gradient currency positive" tabindex="7" required placeholder="Enter Product Price *" value="${product.getPrice()}"/> 
                        </td>
                    </tr>   
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">On Hand</span>
                        </td>
                        <td class="table_data">
                            <input id="onhand" name="onhand" type="number" min="0.00" step="1" class="input blue_gradient required positive" tabindex="8" required placeholder="Enter On Hand Quantity *" value="${product.getOnHand()}"/> 
                        </td>
                    </tr>    
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Overview Image</span>
                        </td>
                        <td class="table_data">
                            <div class="fileUpload">
                                <input id="overviewImage" name="overviewImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${product.getOverviewImage()}"/>
                                <input id="overviewImageuploadBtn" type="file" class="upload" />
                            </div>
                        </td>
                    </tr>  
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Banner Image</span>
                        </td>
                        <td class="table_data">
                            <div class="fileUpload">
                                <input id="bannerImage" name="bannerImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${product.getBannerImage()}"/>
                                <input id="bannerImageuploadBtn" type="file" class="upload"/>
                            </div>
                        </td>
                    </tr>     
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">List Item Image</span>
                        </td>
                        <td class="table_data">
                            <div class="fileUpload">
                                <input id="listitemImage" name="listitemImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${product.getListitemImage()}"/>
                                <input id="listitemImageuploadBtn" type="file" class="upload"/>
                            </div>
                        </td>
                    </tr>                     
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Brochure File</span>
                        </td>
                        <td class="table_data">
                            <div class="fileUpload">
                                <input id="brochureFile" name="brochureFile" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${product.getBrochureFile()}"/>
                                <input id="brochureFileuploadBtn" type="file" class="upload"/>
                            </div>
                        </td>
                    </tr>  
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">FAQs File</span>
                        </td>
                        <td class="table_data">
                            <div class="fileUpload">
                                <input id="faqsFile" name="faqsFile" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${product.getFaqsFile()}"/>
                                <input id="faqsFileuploadBtn" type="file" class="upload" />
                            </div>
                        </td>
                    </tr>                     
                </table>                    
            </div>   
                        
            <input type="hidden" name="key"             value="${product.getId()}" />
            <input type="hidden" name="lastupdated"     value="${product.getLastUpdated()}" />            
            <input type="hidden" name="cmd"             value="${command}" />
            
        </form>
    </div>                 
</div>

<%@include file="//jspf/admin/admin_footer.jspf"%>

<script type="text/javascript">

        document.getElementById("overviewImageuploadBtn").onchange = function () {
            document.getElementById("overviewImage").value = this.value;        
        };

        document.getElementById("bannerImageuploadBtn").onchange = function () {
            document.getElementById("bannerImage").value = this.value;
        };

        document.getElementById("listitemImageuploadBtn").onchange = function () {
            document.getElementById("listitemImage").value = this.value;
        };    

        document.getElementById("brochureFileuploadBtn").onchange = function () {
            document.getElementById("brochureFile").value = this.value;
        }; 

        document.getElementById("faqsFileuploadBtn").onchange = function () {
            document.getElementById("faqsFile").value = this.value;
        }; 
        
</script>
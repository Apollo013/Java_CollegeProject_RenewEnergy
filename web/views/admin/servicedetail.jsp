<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>
<%@include file="//jspf/admin/toolbar_detailview.jspf"%>   

<div class ="admin_content">

    <div class="blue_gradient radius" style="margin: 20px;">
        <form id="input_form" name="input_form" action="service" method="post">

            <div id="errorDisplay" class="error_display blue_gradient"></div>
                   
            <div class="admin_field_wrapper">

                <table>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Name</span>
                        </td>
                        <td class="table_data">
                            <input id="name" name="name" type="text" size="40" class="input blue_gradient required" tabindex="1" autofocus required placeholder="Enter Service Name *" value="${service.getName()}"/> 
                        </td>
                    </tr>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Overview</span>
                        </td>
                        <td class="table_data">
                            <textarea id="overview" name="overview" rows="25" cols="100" class="textbox blue_gradient required" tabindex="2" required placeholder="Enter Service Overview *" >${service.getOverview()}</textarea> 
                        </td>
                    </tr>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Price</span>
                        </td>
                        <td class="table_data">
                            <input id="price" name="price" type="number" min="0.01" step="0.01" class="input blue_gradient currency" tabindex="3" required placeholder="Enter Service Price *" value="${service.getPrice()}"/> 
                        </td>
                    </tr>  
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">On Hand</span>
                        </td>
                        <td class="table_data">
                            <input id="onhand" name="onhand" type="number" min="0.00" step="1" class="input blue_gradient required positive" tabindex="8" required placeholder="Enter On Hand Quantity *" value="${service.getOnHand()}"/> 
                        </td>
                    </tr>    
                    <tr>                    
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Overview Image</span>
                        </td>
                        <td class="table_data">
                            <div class="fileUpload">
                                <input id="overviewImage" name="overviewImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${service.getOverviewImage()}"/>
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
                                <input id="bannerImage" name="bannerImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${service.getBannerImage()}"/>
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
                                <input id="listitemImage" name="listitemImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${service.getListitemImage()}"/>
                                <input id="listitemImageuploadBtn" type="file" class="upload"/>
                            </div>
                        </td>
                    </tr>                     
                </table>                    
            </div>   
                        
            <input type="hidden" name="key"         value="${service.getId()}" />
            <input type="hidden" name="lastupdated" value="${service.getLastUpdated()}" />                                
            <input type="hidden" name="cmd"         value="${command}" />
            
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

</script>

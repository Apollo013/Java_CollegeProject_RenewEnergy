<%@include file="//jspf/admin/admin_header.jspf"%>
<%@include file="//jspf/admin/admin_sidebar.jspf"%>
<%@include file="//jspf/admin/toolbar_detailview.jspf"%>   

<div class ="admin_content">

    <div class="blue_gradient radius" style="margin: 20px;">
        <form id="input_form" name="input_form" action="category" method="post">

            <div id="errorDisplay" class="error_display blue_gradient"></div>
                   
            <div class="admin_field_wrapper">

                <table>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Name</span>
                        </td>
                        <td class="table_data">
                            <input id="name" name="name" type="text" size="40" class="input blue_gradient required" tabindex="1" autofocus required placeholder="Enter Category Name *" value="${category.getName()}"/> 
                        </td>
                    </tr>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Introduction</span>
                        </td>
                        <td class="table_data">
                            <textarea id="introduction" name="introduction" rows="5" cols="100" class="textbox blue_gradient required" tabindex="2" required placeholder="Enter Category Introduction *" >${category.getIntroduction()}</textarea> 
                        </td>
                    </tr>                    
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Overview</span>
                        </td>
                        <td class="table_data">
                            <textarea id="overview" name="overview" rows="16" cols="100" class="textbox blue_gradient required" tabindex="3" required placeholder="Enter Category Overview *" >${category.getOverview()}</textarea> 
                        </td>
                    </tr>
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Video Url</span>
                        </td>
                        <td class="table_data">
                            <input id="videoUrl" name="videoUrl" type="url" size="100" class="input blue_gradient required" tabindex="4" required placeholder="Enter Category You Tube Url *" value="${category.getVideoUrl()}"/> 
                        </td>
                    </tr>   
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Overview Image</span>
                        </td>
                        <td class="table_data">
                            <div class="fileUpload">
                                <input id="overviewImage" name="overviewImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${category.getOverviewImage()}"/>
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
                                <input id="bannerImage" name="bannerImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${category.getBannerImage()}"/>
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
                                <input id="listitemImage" name="listitemImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${category.getListitemImage()}"/>
                                <input id="listitemImageuploadBtn" type="file" class="upload"/>
                            </div>
                        </td>
                    </tr>       
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">How To Image</span>
                        </td>
                        <td class="table_data">
                            <div class="fileUpload">
                                <input id="howImage" name="howImage" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${category.getHowImage()}"/>
                                <input id="howImageuploadBtn" type="file" class="upload"/>
                            </div>
                        </td>
                    </tr>   
                    <tr>
                        <td class="table_label">
                            <span class="form_green_title">Brochure File</span>
                        </td>
                        <td class="table_data">
                            <div class="fileUpload">
                                <input id="brochureFile" name="brochureFile" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${category.getBrochureFile()}"/>
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
                                <input id="faqsFile" name="faqsFile" placeholder="Click Here To Choose File*" readonly required class="input blue_gradient required" value="${category.getFaqsFile()}"/>
                                <input id="faqsFileuploadBtn" type="file" class="upload" />
                            </div>
                        </td>
                    </tr>                      
                </table>                    
            </div>   
                        
            <input type="hidden" name="key"             value="${category.getId()}" />
            <input type="hidden" name="lastupdated"     value="${category.getLastUpdated()}" />            
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

        document.getElementById("howImageuploadBtn").onchange = function () {
            document.getElementById("howImage").value = this.value;
        }; 

        document.getElementById("brochureFileuploadBtn").onchange = function () {
            document.getElementById("brochureFile").value = this.value;
        }; 

        document.getElementById("faqsFileuploadBtn").onchange = function () {
            document.getElementById("faqsFile").value = this.value;
        }; 
        
</script>
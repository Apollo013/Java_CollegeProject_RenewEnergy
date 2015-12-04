<%-- 
    Document   : newIndex
    Created on : 30-Jan-2014, 18:44:57
    Author     : Paul Millar <D00152098>
--%>

 <%@include file="../../jspf/header_1.jspf"%>   

    <div id="billboard" class="radius shadow">				
        <ul id="slider_Content">
            <li>
                <a  href="http://www.youtube.com/embed/30ttqGYxoFk"
                    class="lytebox" data-lyte-options="width:700 height:500" style="width:300px;"
                    id="category_video_link">
                    <img src="${initParam.generalImagesPath}billboard_media_04.png" alt="Central Heating" id="index_video_link_img"/>
                </a>
                <div>
                    <span class="slidertopspan">Welcome To Renew Energy</span>
                    <span class="sliderbottomspan">Watch this brief introduction video</span>
                </div>
            </li>
            <li>
                <a href="${initParam.categoriesPage}"><img src="${initParam.generalImagesPath}billboard_media_02.jpg" alt="Products"/></a>
                <div>
                    <span class="slidertopspan">Solar Plates, Slates & Wind Turbines</span>
                    <span class="sliderbottomspan">Residential, commercial, agricultural and maritime solutions</span>
                </div>
            </li>
            <li>
                <a href="${initParam.informationPage}"><img src="${initParam.generalImagesPath}billboard_media_03.jpg" alt="Child and Globe"/></a>
                <div>
                    <span class="slidertopspan">Plan For The Future</span>
                    <span class="sliderbottomspan">Want to know where to start ?  We have all the information you need ...</span>
                </div>
            </li>
        </ul>				
    </div>
 
 <%@include file="../../jspf/footer_1.jspf"%>   
 
 <script type="text/javascript">       
    document.title = 'The Home Of Renewable Energy';   
</script>  
 
        
        <script src="${initParam.jsPath}jsDate.js" type="text/javascript"></script>
        <script src="${initParam.jsPath}animation.js" type="text/javascript"></script>
        <script src="${initParam.lyteboxPath}lytebox.js" type="text/javascript"></script>
        <link href="${initParam.lyteboxPath}lytebox.css" type="text/css" rel="stylesheet"/>   
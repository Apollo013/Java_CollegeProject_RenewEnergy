<%-- 
    Document   : index
    Created on : 10-Oct-2013, 11:54:44
    Author     : d00152098
--%>

 <%@include file="../../jspf/header.jspf"%>     
				
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
                
    <div id="products_container" class="floatleft radius shadow content_container content_container_w370 content_container_h360 beige_background" >
        <div class="content_container_header">
            <span id="product_span">Products</span>
        </div>
        <div>
            <div style="width:200px; float:left;">
                <a href="${initParam.categoryPage}&key=2">
                    <img src="${initParam.generalImagesPath}products_solar_slates.jpg" alt="Solar Slates" class="margin_top_left radius"/>
                    <div class="floatright">
                        <span class="more_details ">Solar Slates</span>	
                        <img class="floatright" src="${initParam.generalImagesPath}more_button.png" alt="more"/>	
                    </div>						
                </a>
                <a href="${initParam.categoryPage}&key=1">
                    <img src="${initParam.generalImagesPath}products_solar_panels.jpg" alt="Solar Panels" class="margin_top_left radius"/>
                    <div class="floatright">
                        <span class="more_details ">Solar Panels</span>	
                        <img class="floatright" src="${initParam.generalImagesPath}more_button.png" alt="more"/>	
                    </div>						
                </a>														
            </div>							
            <div style="width:160px;">
                <a href="${initParam.categoryPage}&key=3">
                    <img src="${initParam.generalImagesPath}products_turbine.jpg" alt="Wind Turbine" class="margin_top_left radius"/>
                    <div class="floatright">
                        <span class="more_details ">Wind Turbines</span>	
                        <img class="floatright" src="${initParam.generalImagesPath}more_button.png" alt="more"/>	
                    </div>						
                </a>														
            </div>
        </div>
    </div>

    <div id="events_container" class="floatleft radius shadow content_container content_container_w370 content_container_h360 beige_background">
        <div class="content_container_header">
            <span id="events_span">Events</span>
        </div>
        <div class="margin">
            <table style="width:100%">
                <tr>
                    <td rowspan="2" >
                        <a href="http://www.seai.ie/News_Events/Energy_Show/" target="_blank">
                            <img src="${initParam.generalImagesPath}seai_energyshow.png" alt="Energy Show 2013"/>
                        </a>
                    </td>
                    <td>
                        <img src="${initParam.generalImagesPath}stylish_sun.png" alt="Style Sun" style="margin-left:30px;"/>
                    </td>
                </tr>
                <tr>
                    <td>								
                        <div class="floatright">
                            <a href="http://www.seai.ie/News_Events/Energy_Show/" target="_blank" >
                                <span  class="more_details">More Details</span>								
                            </a>
                            <a href="http://www.seai.ie/News_Events/Energy_Show/" target="_blank" class="floatright">
                                <img src="${initParam.generalImagesPath}more_button.png" alt="more"/>
                            </a>
                        </div>
                    </td>
                </tr>
            </table>
            <div id="countdownDisplay" class="center">
                <span class="slate_text" style="line-height:30px;">Date: </strong>Wednesday March 12 - Thursday April 13, 2014 - RDS</span>
                <span class="slate_text" style="line-height:30px;">Only </span><span id="countdown_monthsdata" class="slate_text"></span> <span id="countdown_monthslabel" class="slate_text"></span><span class="slate_text"> to go </span><strong><span class="orange">&nbsp;JOIN US !!!</span></strong>
            </div>						
            
            <div class="divider"></div>
            <table style="width:100%; top: 10px;">
                <tr>
                    <td><a href="${initParam.eventPage}"><img src="${initParam.generalImagesPath}calendar.jpg" alt="calendar" class="radius floatleft margin_right"/></a>
                    <span  class="slate_text" style="display:block; line-height: 20px;">Find the latest environmental events for your area and nationwide ...</span>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <div id="news_container" class="floatleft content_container radius shadow content_container_w200 content_container_h360 beige_background">
        <div class="content_container_header">
            <span id="news_span">News</span>
        </div>
        <!--http://www.nidirect.gov.uk/index/information-and-services/environment-and-greener-living/energy-wise/energy-efficiency/energy-efficiency-tips.htm-->
        <ul id="news_list">
            <li>
                <a href="http://consciouslifenews.com/world-takes-streets-protest-monsanto-gmo/1166666/" target="_blank">
                    <table class="news_item_table">
                        <tr>
                            <td class="news_item_image" rowspan="2">
                                <img src="${initParam.generalImagesPath}news.png" alt="news item"/>
                            </td>
                            <td class="news_item_info">
                                <span class="slate_text">Street Protests Against<br/> Monsanto & GMO</span>
                            </td>                           
                        </tr>
                        <tr>
                            <td class="news_item_date">
                                <span>Sun, 12 Oct 2013</span>
                            </td>                             
                        </tr>
                    </table>
                </a>                
            </li>
            <li>
                <a href="http://www.nidirect.gov.uk/index/information-and-services/environment-and-greener-living/energy-wise/energy-efficiency/energy-efficiency-tips.htm" target="_blank">
                    <table id="news_item_table" class="news_item_table">
                        <tr>
                            <td class="news_item_image" rowspan="2">
                                <img src="${initParam.generalImagesPath}news.png" alt="news item"/>
                            </td>
                            <td class="news_item_info">
                                <span class="slate_text">Being energy wise can save you money</span>
                            </td>                           
                        </tr>
                        <tr>
                            <td class="news_item_date">
                                <span>Sun, 12 Oct 2013</span>
                            </td>                             
                        </tr>
                    </table>
                </a>                
            </li>
            <li>
                <a href="http://www.nidirect.gov.uk/index/information-and-services/environment-and-greener-living/energy-wise/energy-saving-grants/renewable-heat-grants/renewable-heat-incentive.htm" target="_blank">
                    <table id="news_item_table" class="news_item_table">
                        <tr>
                            <td class="news_item_image" rowspan="2">
                                <img src="${initParam.generalImagesPath}news.png" alt="news item"/>
                            </td>
                            <td class="news_item_info">
                                <span class="slate_text">New Heat Incentive Scheme (NI)</span>
                            </td>                           
                        </tr>
                        <tr>
                            <td class="news_item_date">
                                <span>Thu, 29 Aug 2013</span>
                            </td>                             
                        </tr>
                    </table>
                </a>                
            </li>
            <li>
                <a href="http://www.nidirect.gov.uk/index/information-and-services/environment-and-greener-living/the-wider-environment/being-green-in-the-community-and-at-work.htm" target="_blank">
                    <table id="news_item_table" class="news_item_table">
                        <tr>
                            <td class="news_item_image" rowspan="2">
                                <img src="${initParam.generalImagesPath}news.png" alt="news item"/>
                            </td>
                            <td class="news_item_info">
                                <span class="slate_text">Being Green In Your Community</span>
                            </td>                           
                        </tr>
                        <tr>
                            <td class="news_item_date">
                                <span>Wed, 11 Sept 2013</span>
                            </td>                             
                        </tr>
                    </table>                        
                </a>                
            </li>
            <li>
                <a href="http://www.seai.ie/Publications/Statistics_Publications/Fuel_Cost_Comparison/" target="_blank">
                    <table id="news_item_table" class="news_item_table">
                        <tr>
                            <td class="news_item_image" rowspan="2">
                                <img src="${initParam.generalImagesPath}news.png" alt="news item"/>
                            </td>
                            <td class="news_item_info">
                                <span class="slate_text">Fuel Cost Comparisons</span>
                            </td>                           
                        </tr>
                        <tr>
                            <td class="news_item_date">
                                <span>Thu, 10 Oct 2013</span>
                            </td>                             
                        </tr>
                    </table>   
                </a>
            </li>
            <li>
                <a href="http://www.seai.ie/Power_of_One/Heat_Your_Home_For_Less/" target="_blank">
                    <table id="news_item_table" class="news_item_table">
                        <tr>
                            <td class="news_item_image" rowspan="2">
                                <img src="${initParam.generalImagesPath}news.png" alt="news item"/>
                            </td>
                            <td class="news_item_info">
                                <span class="slate_text">Heat your home for less</span>
                            </td>                           
                        </tr>
                        <tr>
                            <td class="news_item_date">
                                <span>Fri, 14 Sep 2012</span>
                            </td>                             
                        </tr>
                    </table>                          
                </a>                
            </li>
            <li>
                <a href="http://www.nidirect.gov.uk/news-aug13-grant-available-to-replace-old-boilers" target="_blank">
                    <table id="news_item_table" class="news_item_table">
                        <tr>
                            <td class="news_item_image" rowspan="2">
                                <img src="${initParam.generalImagesPath}news.png" alt="news item"/>
                            </td>
                            <td class="news_item_info">
                                <span class="slate_text">Boiler replacement scheme launched (NI)</span>
                            </td>                           
                        </tr>
                        <tr>
                            <td class="news_item_date">
                                <span>Mon, 3 Sep 2012</span>
                            </td>                             
                        </tr>
                    </table>                      
                </a>
            </li>
            <li>
                <a href="http://www.seai.ie/Power_of_One/Energy_Saving/Electricity_Saving_Tips/" target="_blank">
                    <table id="news_item_table" class="news_item_table">
                        <tr>
                            <td class="news_item_image" rowspan="2">
                                <img src="${initParam.generalImagesPath}news.png" alt="news item"/>
                            </td>
                            <td class="news_item_info">
                                <span class="slate_text">Electricity Savings Tips</span>
                            </td>                           
                        </tr>
                        <tr>
                            <td class="news_item_date">
                                <span>Mon, 5 Nov 2012</span>
                            </td>                             
                        </tr>
                    </table>                          
                </a>                
            </li>
        </ul>
    </div>			                                        

<%@include file="../../jspf/footer.jspf" %>

<script type="text/javascript">       
    document.title = 'The Home Of Renewable Energy';   
</script>  

<script src="${initParam.jsPath}jsDate.js" type="text/javascript"></script>
<script src="${initParam.jsPath}animation.js" type="text/javascript"></script>
<script src="${initParam.lyteboxPath}lytebox.js" type="text/javascript"></script>
<link href="${initParam.lyteboxPath}lytebox.css" type="text/css" rel="stylesheet"/>  
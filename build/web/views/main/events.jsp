<%-- 
    Document   : events
    Created on : 30-Oct-2013, 16:42:48
    Author     : Paul Millar <D00152098>
--%>

             
<%@include file="../../jspf/header.jspf"%>

    <div id="banner_wrapper" class="floatleft radius shadow content_container ">
        <img class="banner_header" src="${initParam.generalImagesPath}banner_events.jpg" alt="image"/>
    </div>	

    <div class="radius shadow content_container">
        <div id="calendar_wrapper"></div>
    </div>		

<%@include file="../../jspf/footer.jspf" %>

<script type="text/javascript" >
    // Change the page title
    document.title = 'Events';
</script>  

<script src="${initParam.jsPath}eventcalendar.js" type="text/javascript"></script>
<link href="${initParam.cssPath}eventcalendar.css" type="text/css" rel="stylesheet"/>  

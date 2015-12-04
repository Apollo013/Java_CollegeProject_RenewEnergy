<%-- 
    Document   : error
    Created on : 26-Oct-2013, 22:18:08
    Author     : Paul Millar <D00152098>
--%>

    <%-- Use this page for any errors caught by the developer --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <meta name="Author" content="Paul Millar" />

        <title>Error</title>
        		        
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>            
        
        <link href="${initParam.generalImagesPath}favicon.ico" rel="shortcut icon" type="image/x-icon" >
        <link href="${initParam.cssPath}forms.css" type="text/css" rel="stylesheet"/>   
               
    </head>
        
    <body>
        
        <div class="form_background" style="text-align: center;">

            <c:choose>
                <c:when test="${errorTitle != null}">
                    <h1 class="error_header"> <strong><c:out value="${errorTitle}"/></strong> </h1>      
                </c:when>
                <c:otherwise>
                    <h1 class="error_header"> <strong>ERROR !!!</strong> </h1>            
                </c:otherwise>
            </c:choose>        

            <div class="exception_wrapper radius shadow center">
                <h2 style="margin: 20px;">${errorMessage}</h2>
            </div>

            <div style="margin-top: 20px;"> 
                <a href="../main/index.jsp" class="button blue_button standard_button" tabindex="1" >Go To Home</a>  
                <c:choose>
                    <c:when test="${username != null}">
                        <a href="../main/login.jsp" class="button blue_button standard_button" tabindex="2" >login</a>                           
                    </c:when>
                </c:choose>  
                <a href="javascript:history.back()" class="button blue_button standard_button" tabindex="3" >Back</a>                          
            </div>  
            
            <div class="clearfloat"></div>
        </div>  
            
    </body>
</html>

<%-- 
    Document   : confirmation
    Created on : 01-Dec-2013, 14:10:24
    Author     : Paul Millar <D00152098>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<html>
    <head>
        <meta name="Author" content="Paul Millar" />

        <title>Confirmation</title>
        		        
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>            
        
        <link href="${initParam.generalImagesPath}favicon.ico" rel="shortcut icon" type="image/x-icon" >
        <link href="${initParam.cssPath}forms.css" type="text/css" rel="stylesheet"/>   
               
    </head>
        
    <body>
        
        <div class="form_background" style="text-align: center;">
            
            <c:choose>
                <c:when test="${confirmationTitle != null}">
                    <h1> <strong><c:out value="${confirmationTitle}"/></strong> </h1>      
                </c:when>
                <c:otherwise>
                    <h1> <strong>Confirmation !!!</strong> </h1>            
                </c:otherwise>
            </c:choose>        

            <div class="exception_wrapper radius shadow center">
                <h2 style="margin: 20px;">${confirmationMessage}</h2>
            </div>                    

            <div style="margin-top: 20px;"> 
                <a href="../main/index.jsp" class="button blue_button standard_button" tabindex="1" >Go To Home</a>  
                <c:choose>
                    <c:when test="${username != null}">
                        <a href="../main/login.jsp" class="button blue_button standard_button" tabindex="2" >login</a>                           
                    </c:when>
                </c:choose>                          
            </div> 
            
        </div>

        <div class="clearfloat"></div>     

    </body>
</html>
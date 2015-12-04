<%-- 
    Document   : exceptions
    Created on : 01-Nov-2013, 18:10:03
    Author     : Paul Millar <D00152098>
--%>
    

<%@ page isErrorPage="true" %> 
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<html>
    <head>
        <meta name="Author" content="Paul Millar" />

        <title>Exception</title>
        		        
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>            
        
        <link href="${initParam.generalImagesPath}favicon.ico" rel="shortcut icon" type="image/x-icon" >
        <link href="${initParam.cssPath}forms.css" type="text/css" rel="stylesheet"/>   
               
    </head>
        
    <body>
        
        <div class="form_background" style="text-align: center;">
            
            <h1 class="error_header"> <strong>EXCEPTION</strong> </h1> 
            
            <div class="exception_wrapper radius shadow center">
                <p><% exception.printStackTrace(new java.io.PrintWriter(out)); %></p>
            </div>

            <div style="margin-top: 20px;"> 
                <a href="../main/index.jsp" class="button blue_button standard_button" tabindex="1" >Go To Home</a>                         
            </div>  
                    
        </div>        


        <div class="clearfloat"></div>
    
    </body>  
</html>

    

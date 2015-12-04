<%-- 
    Document   : login
    Created on : 28-Oct-2013, 12:40:02
    Author     : Paul Millar <D00152098>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<c:choose>
    <c:when test="${loggedSessionId != null}">
        <c:redirect url="${initParam.errorPath}">
            <c:set var="errorTitle" value="Login Error" scope="session"/>                 
            <c:set var="errorMessage" value="Sorry, but you are already logged in" scope="session"/>                
        </c:redirect>        
    </c:when>
</c:choose>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        		        
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>      
        <script src="${initParam.jsPath}validation.js" type="text/javascript"></script>
        
        <link href="${initParam.generalImagesPath}favicon.ico" rel="shortcut icon" type="image/x-icon" >
        <link href="${initParam.cssPath}forms.css" type="text/css" rel="stylesheet"/>         
    </head>
    <body>        
        <div class="user_wrapper form_background" >

            <form id="input_form" name="input_form" action="user" method="post" class="user_form">
                

                    
                <div class="field_wrapper center">
                    <h1>Login</h1>                          
                    <div id="errorDisplay" class="error_display blue_gradient center" style="width: 95%; margin-left: 0;"></div> 
                    <span>Email</span>
                    <input id="email" name="email" type="email" size="100" class="input blue_gradient email" tabindex="1" autofocus required placeholder="Enter Your Email Address" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" />
                    <script>
                        if (!("autofocus" in document.createElement("input"))) {
                          document.getElementById("email").focus();
                        }
                    </script>
                    <span>Password</span>        
                    <input id="password" name="password" type="password" size="10" class="input blue_gradient password" tabindex="2" required placeholder="Enter Your Password" pattern="^([a-zA-Z0-9_-]){6,10}$"/>    
                                     
                    <div class="button_wrapper">
                        <input type="submit" onclick="submitForm()" value="Submit" class="button blue_button standard_button floatright" tabindex="3" />  
                        <input type="button" onclick="document.location.href='user.jsp';" value="Register" class="button blue_button standard_button floatright" tabindex="4"/> 
                        <input type="button" onclick="document.location.href='index.jsp';" value="Go To Home" class="button blue_button standard_button floatright" tabindex="5"/>                      
                    </div>  
                </div> 
                <input type="hidden" name="cmd" value="login" />
            </form>             
            
        </div>   
    </body>
</html>

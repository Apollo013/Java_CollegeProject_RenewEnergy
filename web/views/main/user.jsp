<%-- 
    Document   : login
    Created on : 28-Oct-2013, 12:40:02
    Author     : Paul Millar <D00152098>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<c:choose>
    <c:when test="${loggedSessionId == null}">
        <c:set var="pagetitle" value="Register" />  
        <c:set var="formtitle" value="Register A New Account" />
        <c:set var="command"   value="register" />
    </c:when>
    <c:otherwise>
        <c:set var="pagetitle" value="Manage" />  
        <c:set var="formtitle" value="Manage Your Account" />  
        <c:set var="command"   value="update" />        
    </c:otherwise>
</c:choose>  
                
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">             
        <title>${pagetitle}</title>          		        
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>      
        <script src="${initParam.jsPath}validation.js" type="text/javascript"></script>
        
        <link href="${initParam.generalImagesPath}favicon.ico" rel="shortcut icon" type="image/x-icon" >
        <link href="${initParam.cssPath}forms.css" type="text/css" rel="stylesheet"/>         
    </head>
    <body>        
        <div class="user_wrapper form_background" >

            <form id="input_form" name="input_form" action="user" method="post" class="user_form">

                <div class="field_wrapper center">
                    
                    <h1>${formtitle}</h1> 
                    
                    <div id="errorDisplay" class="error_display blue_gradient center" style="width: 95%; margin-left: 0;"></div>
                    
                    <span>First Name</span>
                    <input id="firstname" name="firstname" type="text" size="30" class="input blue_gradient required" tabindex="1" autofocus required placeholder="Enter Your First Name *" value="${user.getFirstName()}"/> 
                    <script>
                        if (!("autofocus" in document.createElement("input"))) {
                          document.getElementById("firstname").focus();
                        }
                    </script>        
                    
                    <span>Last Name</span>
                    <input id="lastname" name="lastname" type="text" size="30" class="input blue_gradient required" tabindex="2" required placeholder="Enter Your Last Name *" value="${user.getLastName()}"/> 

                    <span>Email</span>
                    <input id="email" name="email" type="email" size="100" class="input blue_gradient email" tabindex="3" required placeholder="Enter Your Email Address *" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" value="${user.getEmail()}"/> 

                    <span>Password</span>        
                    <input id="password" name="password" type="password" size="10" class="input blue_gradient password" tabindex="4"  placeholder="Enter Your Password *" pattern="^([a-zA-Z0-9_-]){6,10}$" value="${user.getPassword()}"/>    
                    <input id="confirmpassword" name="confirmpassword" type="password" size="10" class="input blue_gradient password" tabindex="5"  placeholder="Confirm Your Password *" pattern="^([a-zA-Z0-9_-]){6,10}$" value="${user.getPassword()}"/>    
                       
                    <span>Address</span>        
                    <input id="address1" name="address1" type="text" size="40" class="input blue_gradient required" tabindex="6"  placeholder="Enter The First Line Of Your Address *" value="${user.getAddress1()}"/>                      
                    <input id="address2" name="address2" type="text" size="40" class="input blue_gradient" tabindex="7" placeholder="Enter The Second Line Of Your Address" value="${user.getAddress2()}"/> 
 
                    <span>Town/City</span>  
                    <input id="city" name="city" type="text" size="30" class="input blue_gradient required" tabindex="8"  placeholder="Enter Your Town or City *" value="${user.getCity()}"/> 

                    <span>County</span>        
                    <input id="county" name="county" type="text" size="30" class="input blue_gradient required" tabindex="9"  placeholder="Enter Your County *" value="${user.getCounty()}"/>    

                    <span>Country</span>        
                    <input id="country" name="country" type="text" size="30" class="input blue_gradient required" tabindex="10"  placeholder="Enter Your Country *" value="${user.getCountry()}"/>  

                    <span>Post Code</span>        
                    <input id="postcode" name="postcode" type="text" size="10" class="input blue_gradient" tabindex="11" placeholder="Enter Your Post Code" value="${user.getPostCode()}"/>   
                               
                    <div class="button_wrapper">
                        <input type="submit" value="Submit" class="button blue_button standard_button floatright" tabindex="12" />  
                        <input type="button" onclick="document.location.href='index.jsp';" value="Go To Home" class="button blue_button standard_button floatright" tabindex="13"/>                      
                    </div>  
                </div> 
                <input type="hidden" name="key" value="${user.getId()}" />   
                <input type="hidden" name="lastupdated" value="${user.getLastUpdated()}" />                   
                <input type="hidden" name="usertype" value="${user.getUserType()}" />                    
                <input type="hidden" name="cmd" value="${command}" />
            </form>             
            
        </div>   
    </body>
</html>

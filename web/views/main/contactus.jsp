<%@include file="../../jspf/header.jspf"%>
        
<div id="banner_wrapper" class="floatleft radius shadow content_container ">
    <img class="banner_header bordered radius margin_right" style="border-color: #000;" src="${initParam.generalImagesPath}banner_contactus.jpg" alt="Contact Us Image"/>
</div>

<div class="user_wrapper form_background" style="width: 97%;">

    <form id="input_form" name="input_form" action="user" method="post" class="user_form">

        <div class="field_wrapper center">                    

            <div id="errorDisplay" class="error_display blue_gradient"></div> 

            <div class="field_wrapper" class="center">
                <span>Name</span>
                <input id="name" name="name" type="text" size="40" class="input blue_gradient required" tabindex="1" autofocus required placeholder="Enter Your Full Name *"/>          
                <script>
                    if (!("autofocus" in document.createElement("input"))) {
                      document.getElementById("name").focus();
                    }
                </script>

                <span>Email</span>
                <input id="email" name="email" type="email" size="100" class="input blue_gradient required" tabindex="2" required placeholder="Enter Your Email Address *" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$"/>    

                <span>Phone</span>
                <input id="phone" name="phone" type="text" size="20" class="input blue_gradient required" tabindex="3" required placeholder="Enter Your Phone Number *"/>

                <span>Comment</span>
                <textarea name="comment" id="comment" class="textbox blue_gradient required" cols="75" rows="10" tabindex="4" required placeholder="Enter Your Query Here *"></textarea>

                <div class="button_wrapper">
                    <input type="submit" onclick="submitForm()" value="Submit" class="button blue_button standard_button floatright" tabindex="5" />
                </div> 
            </div>  

        </div> 
        <input type="hidden" name="cmd" value="email" />
    </form> 

</div>
  
<%@include file="../../jspf/footer.jspf" %>

<script type="text/javascript">
    document.title = 'Contact Us';
</script>

<link href="${initParam.cssPath}forms.css" type="text/css" rel="stylesheet"/>
<script src="${initParam.jsPath}validation.js" type="text/javascript"></script>
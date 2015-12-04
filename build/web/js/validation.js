function submitForm(){
    if(validateInput()){
        document.getElementById("input_form").submit();
    }        
}
    
function validateInput(){
    
    //NOTE: HTML5 is not supported in all browsers so it is not safe to just
    //      rely on it's 'required' or 'password' attributes when validating.
    //      Therefore, we will assign each input field an appropriate dummy css class,
    //      i.e. '.required', '.password', '.email' & '.currency', and then iterate 
    //      through each class and validate as required.

    var errors = 0;

    // Reset all errors
    $("input").css( "border-color", "#15243b" ).css("border-top-color","#0d1827");      
    $("#errorDisplay").html("").css("display","hidden");
    
    // Validate 'Required' Fields (as denoted by the '.required' css class)
    var inputs = $("input").filter(".required");    
    $(inputs).each(function(){
        if($(this).val() === ""){
            errors++;
            $(this).css("border-color", "red" );
            displayError("The '" + $(this).attr("name") + "' field is required");    
        }
    });

    // Validate 'Required' textareas (as denoted by the '.required' css class)
    var inputs = $("textarea").filter(".required");    
    $(inputs).each(function(){
        if($(this).val() === ""){
            errors++;
            $(this).css("border-color", "red" );
            displayError("The '" + $(this).attr("name") + "' field is required");    
        }
    });

    // Validate 'Password' Fields (as denoted by the '.password' css class)
    var inputs = $("input").filter(".password");    
    $(inputs).each(function(){
        if(!(new RegExp(/^([a-zA-Z0-9_-]){6,10}$/)).test($(this).val())){
            errors++;
            $(this).css("border-color", "red" );
            displayError("The '" + $(this).attr("name") + "' field is not correct");    
        }
    });    
    
    // Compare password & password confirm field values
    var psw1 = $("#password").val();
    var psw2 = $("#confirmpassword").val();
    if (psw1 != null && psw2 != null){
        if(psw1 != psw2){
            $("#password").css("border-color", "red" );
            $("#confirmpassword").css("border-color", "red" );                
            displayError("Password fields do not match"); 
            errors++;
        }            
    }    
    
    // Validate 'Email' Fields (as denoted by the '.email' css class)
    var inputs = $("input").filter(".email");    
    $(inputs).each(function(){
        if(!(new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)).test($(this).val())){
            errors++;
            $(this).css("border-color", "red" );
            displayError("The '" + $(this).attr("name") + "' field is not formatted correctly");    
        }
    });    
    
    // Validate 'Currency' Fields (as denoted by the '.currency' css class)
    var inputs = $("input").filter(".currency");    
    $(inputs).each(function(){
        if(!(new RegExp(/^\d+(?:\.\d{0,2})?$/)).test($(this).val())){ 
            errors++;
            $(this).css("border-color", "red" );
            displayError("The '" + $(this).attr("name") + "' field is not formatted correctly for currency");    
        }
    });             
    
    // Check if product savings values has 12 numbers
    var valQuantity = 0;
    var savingsvals = $("#savings_values").val();
    if(savingsvals != null){
        var vals = savingsvals.split(',');
        $(vals).each(function(idx,val){
            valQuantity++; // increment for every value            
            if(!(new RegExp(/^([0-9]|[0-9]\d|100)$/)).test(val)){            
                errors++;
                valQuantity--; // decrement for every value that is not a valid number       
            }               
        });
        // Now check that we have 12 valid numbers
        if (valQuantity != 12){
            errors++;
            $("#savings_values").css("border-color", "red" );
            displayError("The '" + $("#savings_values").attr("name") + "' field has only " + valQuantity + " valid numbers (There must be 12 with values between 0 and 100)"); 
        }
    }

    
    return errors === 0;
}

function displayError(errorString){
    var err = $("#errorDisplay").html();    
    $("#errorDisplay").html(err + errorString +'<br/>');        
    $("#errorDisplay").css("display","block");      
}

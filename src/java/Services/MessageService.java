package Services;

import javax.servlet.http.HttpSession;

// NOTE: Quite often, the same error messages are called from multiple locations, therefore I wanted a central location in which
//       to create them rather than repeat them throughout the project. Also, if we internationalise this project later, 
//       we only have to make changes in one place.

/**
 *
 * @author Paul Millar <D00152098>
 */
public class MessageService {
        
    public static String createAuthorisationError(String errorLocation, HttpSession session){        
        return createErrorMessage("Authorisation Error", errorLocation, "Sorry, but you are not authorised to access this information.", session);
    }

    public static String createLoggedInError(String errorLocation, HttpSession session){        
        return createErrorMessage("User Error", errorLocation, "Sorry, but you are already logged in.", session);
    }
    
    public static String createDataAccessError(String errorLocation, String errorMessage, HttpSession session){        
        return createErrorMessage("Data Access Error", errorLocation, errorMessage, session);
    }
    
    public static String createNumberFormatError(String errorLocation, String errorMessage, String key, HttpSession session){        
        return createErrorMessage("Number Format Error", errorLocation, key + " is not a number !<br/>" + errorMessage, session);
    }
        
    public static String createNullPointerMessage(String errorLocation, String errorMessage, HttpSession session){
        String message =  "Is your url correct ?<br/>"
                        + "If you have typed in a url, please make sure that it has been entered correctly.<br/>"
                        + "It is recommended that you only use the links provided.<br/>" + errorMessage;
        
        session.setAttribute("errorTitle", "Null Pointer Exception (" + errorLocation + ")");
        session.setAttribute("errorMessage", message);           
        return session.getServletContext().getInitParameter("errorPath");         
    }
        
    public static String createErrorMessage(String errorType, String errorLocation, String errorMessage, HttpSession session){
        session.setAttribute("errorTitle", errorType + "(" + errorLocation + ")");
        session.setAttribute("errorMessage", errorMessage);           
        return session.getServletContext().getInitParameter("errorPath");         
    }

    public static String createConfirmationMessage(String title, String message, HttpSession session){
        session.setAttribute("confirmationTitle", title);
        session.setAttribute("confirmationMessage", message);
        return session.getServletContext().getInitParameter("confirmationPath");        
    }  
    
    public static String createRegistrationConfirmMessage(HttpSession session){        
        return createConfirmationMessage("Registration Confirmed", "Thank you for registering with us.<br/>You will now be able to receive discounts, regular newsletters, and view your order details.", session);
    }    

    public static String createRegistrationConfirmEmailBody(String name){
        return  "Thank you for registering with us " + name +
                "\n\nYou will now be able to receive discounts, regular newsletters, and view your order details.";
    }
    
    public static String createContactConfirmMessage(HttpSession session){        
        return createConfirmationMessage("Contact Confirmed", "Thank you for contacting us.<br/>A member of our staff will contact you shortly about your query.", session);
    }     
    
    public static String createEmailError(String errorLocation, String errorMessage, HttpSession session){        
        return createErrorMessage("Email Error", errorLocation, "An error has occured emailing.<br/>" + errorMessage, session);
    } 
    
    public static String createAdminSelfDeleteError(String errorLocation, HttpSession session){
        return createErrorMessage("Admin Error",errorLocation,"You cannot remove your own details.", session);
    }
    
    public static String createValidationError(String errorLocation, String errorMessage, HttpSession session){
        return createErrorMessage("Validation Error",errorLocation,errorMessage, session);
        
    }    
}

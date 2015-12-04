package Commands.Login;

import Commands.Abstract.AbstractCommand;
import Exceptions.DaoException;
import Models.Concrete.User;
import Services.EmailService;
import Services.MessageService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class RegisterCommand extends AbstractCommand{

    public RegisterCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {

        try {
            
            User user = (User)super.createBusinessModelFromRequest();
            if (user.isValid()){
                // Create a new User Object from the request parameters                
                super.getDao().insert(user);     
                forwardPath = MessageService.createRegistrationConfirmMessage(session);

                // Now notify the user by email that they have successfully registered.            
                EmailService email = new EmailService();            
                email.emailUser(user, "Registration");                
            } else {
                forwardPath = MessageService.createValidationError(RegisterCommand.class.getName(), user.toErrorString(), session);
                Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, user.toErrorString());   
            }
        } 

        catch (DaoException ex) { 
            forwardPath = MessageService.createDataAccessError(RegisterCommand.class.getName(), ex.getMessage(),session);             
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        }        
          
        return forwardPath;
    }
    
}

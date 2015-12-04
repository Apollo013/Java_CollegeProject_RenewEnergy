package Commands.GenericCrud;

import Commands.Abstract.AbstractCommand;
import Exceptions.DaoException;
import Services.MessageService;
import Services.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// THIS COMMAND GETS AN OBJECT FROM THE DB AND DISPLAYS IT SO THAT THE ADMIN CAN THEN CONFIRM DELETE

/**
 *
 * @author Paul Millar <D00152098>
 */
public class PreDeleteCommand extends AbstractCommand{

    public PreDeleteCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {
        forwardPath = request.getServletPath() + "detail.jsp";  
                
        // Make sure the user is authorised. 
        UserService uService = new UserService();
        if(!uService.hasAdministrationAuthorisation(session)){
            return MessageService.createAuthorisationError(PreDeleteCommand.class.getName(),session);
        }

        int key=0;        
        try {
            key = Integer.parseInt(request.getParameter("key"));
            request.setAttribute(super.getEntityType(), super.getDao().getByKey(key));                    
        }
        catch(NumberFormatException nfe){
            forwardPath = MessageService.createNumberFormatError(PreDeleteCommand.class.getName(), nfe.getMessage(), String.valueOf(key), session);
            Logger.getLogger(PreDeleteCommand.class.getName()).log(Level.SEVERE, null, nfe);               
        }             
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(PreDeleteCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(PreDeleteCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return forwardPath;
    }
    
}

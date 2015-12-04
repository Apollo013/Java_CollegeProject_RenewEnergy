package Commands.GenericCrud;

import Commands.Abstract.AbstractCommand;
import Exceptions.DaoException;
import Services.MessageService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class UpdateCommand extends AbstractCommand{

    public UpdateCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {

        if(request.getServletPath().contains("/admin/")){ 
            // After u[date, send user back to viewing all records
            forwardPath = request.getRequestURL()+"?cmd=searchall";          
        } else {
            // Send user back to index page when finished updating
            forwardPath = "index.jsp";
        }

        // Attempt an update
        try {            
            super.getDao().update(super.createBusinessModelFromRequest());
        }         
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(UpdateCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(UpdateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }         

        return forwardPath;
    }    
}

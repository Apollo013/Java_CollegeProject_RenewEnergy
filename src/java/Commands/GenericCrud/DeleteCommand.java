package Commands.GenericCrud;

import Commands.Abstract.AbstractCommand;
import Commands.Login.LogoutCommand;
import Exceptions.DaoException;
import Services.MessageService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// THIS REMOVES AN ENTITY/MODEL FROM THE DB.

/**
 *
 * @author Paul Millar <D00152098>
 */
public class DeleteCommand extends AbstractCommand{

    public DeleteCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {

        int key=0;
        
        try {
            key = Integer.parseInt(request.getParameter("key"));
            
            if(request.getServletPath().contains("/admin/")){ 
                // After an admin delete, go back to viewing all records
                forwardPath = request.getRequestURL()+"?cmd=searchall";          
            } else {
                // Go back to the home page after a user deletes their own details.
                forwardPath = "index.jsp";
            }
            
            // Attempt delete
            super.getDao().delete(key);

            // If user removes their details, then also log them out
            if(request.getServletPath().contains("/main/user")){ 
                LogoutCommand lc = new LogoutCommand(request,response);
                lc.execute();
            }
        }  
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(DeleteCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(DeleteCommand.class.getName()).log(Level.SEVERE, null, ex);
        }          

        return forwardPath;
    }    
}

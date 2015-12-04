package Commands.GenericCrud;

import Commands.Abstract.AbstractCommand;
import Exceptions.DaoException;
import Models.Abstract.ErrorBase;
import Services.MessageService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// THIS COMMAND IS CALLED WHEN THE USER CLICKS THE 'SUBMIT' BUTTON ON AN 'INSERT' FORM.

/**
 *
 * @author Paul Millar <D00152098>
 */
public class InsertCommand extends AbstractCommand{

    public InsertCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }
               
    @Override
    public String execute() {
           
        int key = 0;
        
        if(request.getServletPath().contains("/admin/")){ 
            // Only applies when inserting from the admin area.
            if(request.getServletPath().contains("order")){
                // After inserting an order, we go directly to adding a line item
                forwardPath = "selectproduct.jsp";            
            } else {
                // Otherwise, we simply go back to viewing all records
                forwardPath = request.getRequestURL()+"?cmd=searchall";          
            }
        }

        try {
            // (1) Create a new Model object from request parameters.
            // (2) Insert the model into the db.
            // (3) Get the newly created primary key.
            ErrorBase eb = (ErrorBase)super.createBusinessModelFromRequest();
            if (eb.isValid()){
                // Get the newly inserted model object and placed in a session variable.
                // This variable will have the same name as the model class name.
                
                key = super.getDao().insert(super.createBusinessModelFromRequest()); 
                session.setAttribute(super.getEntityType(),super.getDao().getByKey(key));                
            } else {
                forwardPath = MessageService.createValidationError(InsertCommand.class.getName(), eb.toErrorString(), session);
                Logger.getLogger(InsertCommand.class.getName()).log(Level.SEVERE, null, eb.toErrorString());                
            }
                

        }
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(InsertCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(InsertCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            forwardPath = MessageService.createDataAccessError(InsertCommand.class.getName(), ex.getMessage(),session);            
            Logger.getLogger(InsertCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            forwardPath = MessageService.createDataAccessError(InsertCommand.class.getName(), ex.getMessage(),session);            
            Logger.getLogger(InsertCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            forwardPath = MessageService.createDataAccessError(InsertCommand.class.getName(), ex.getMessage(),session);            
            Logger.getLogger(InsertCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return forwardPath;
    }
}

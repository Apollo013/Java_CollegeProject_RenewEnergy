package Commands.GenericCrud;

import Commands.Abstract.AbstractCommand;
import Exceptions.DaoException;
import Services.DataAccessService;
import Services.MessageService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// THIS COMMAND IS CALLED WHEN CLICKS THE 'NEW' BUTTON.
// THE PURPOSE FOR THIS IS TO ...
// (1) VERIFY THAT THE USER IS AUTHORISED TO PERFORM AN INSERT (HANDLED PREVIOUSLY IN MAIN SERVLET).
// (2) CREATE THE APPROPRIATE MODEL/DTO OBJECT AND PLACE IN THE SESSION
// (3) LOAD ANY ADDITIONAL TABLES THAT MAYBE REQUIRED FOR DROP DOWN LISTS / SIDEBARS.

/**
 *
 * @author Paul Millar <D00152098>
 */
public class PreNewCommand extends AbstractCommand{

    public PreNewCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute(){
        
        // Always forward to a 'detail' form.
        forwardPath = request.getServletPath() + "detail.jsp";        

        // Create a new object and place it in a session variable.
        session.setAttribute(super.getEntityType(), super.createNewBusinessModel());   

        // Load any necessary tables for drop down lists / sidebars
        try {
            if(super.getEntityType().equalsIgnoreCase("product")){
                DataAccessService dataService = new DataAccessService();
                session.setAttribute("categoryNamesList", dataService.loadCategoryNames());
            } else if(super.getEntityType().equalsIgnoreCase("order")){
                DataAccessService dataService = new DataAccessService();
                session.setAttribute("orderProductsList", dataService.loadOrderProducts());     
                session.setAttribute("orderUsersList", dataService.loadOrderUsers());
            }         
        }            
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(PreNewCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(PreNewCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return forwardPath;        
    }    
}

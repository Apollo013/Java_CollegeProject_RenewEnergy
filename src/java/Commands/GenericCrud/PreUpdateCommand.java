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
public class PreUpdateCommand extends AbstractCommand{

    public PreUpdateCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {
        // Forward to detail form
        forwardPath = request.getServletPath() + "detail.jsp";  

        int key=0;        
        try {
            key = Integer.parseInt(request.getParameter("key"));
            session.setAttribute(super.getEntityType(), super.getDao().getByKey(key));       
            
            // Load any necessary tables for drop down lists / sidebars
            if(super.getEntityType().equalsIgnoreCase("product")){
                // Load category names for products category dropdown list
                DataAccessService dataService = new DataAccessService();
                session.setAttribute("categoryNamesList", dataService.loadCategoryNames());
            } else if(super.getEntityType().equalsIgnoreCase("order")){
                // Creating a new order, so load a list of products and users
                DataAccessService dataService = new DataAccessService();
                session.setAttribute("orderProductsList", dataService.loadOrderProducts());     
            }         
        }
        catch(NumberFormatException nfe){
            forwardPath = MessageService.createNumberFormatError(PreUpdateCommand.class.getName(), nfe.getMessage(), String.valueOf(key), session);
            Logger.getLogger(PreUpdateCommand.class.getName()).log(Level.SEVERE, null, nfe);            
        }             
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(PreUpdateCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(PreUpdateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return forwardPath;
    }
    
}

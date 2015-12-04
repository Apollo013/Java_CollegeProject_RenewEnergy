package Commands.GenericCrud;

import Commands.Abstract.AbstractCommand;
import Exceptions.DaoException;
import Services.DataAccessService;
import Services.MessageService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class SearchKeyCommand extends AbstractCommand{

    public SearchKeyCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {                            

        int key=0;        
        try {
            key = Integer.parseInt(request.getParameter("key"));
            session.setAttribute(super.getEntityType(), super.getDao().getByKey(key));

            DataAccessService dataService = new DataAccessService();
            if(forwardPath.contains("category") || forwardPath.contains("product")){
                // When viewing categories or products, load info used in the products sidebar & dropdown lists(admin).                                
                session.setAttribute("categorySidebarList", dataService.loadCategoryNames());
            } else if (forwardPath.contains("/main/service")){
                // When viewing services, load info used in the services sidebar.                
                session.setAttribute("serviceSidebarList", dataService.loadServiceNames());
            }                
        }
        catch(NumberFormatException nfe){
            forwardPath = MessageService.createNumberFormatError(SearchKeyCommand.class.getName(), nfe.getMessage(), String.valueOf(key), session);
            Logger.getLogger(SearchKeyCommand.class.getName()).log(Level.SEVERE, null, nfe);            
        }             
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(SearchKeyCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(SearchKeyCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return forwardPath;
    }        
}

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
public class SearchAllCommand extends AbstractCommand{

    public SearchAllCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }
         
    @Override
    public String execute() {
      
        try {
            request.setAttribute("searchAllList", super.getDao().getAll());

            DataAccessService dataService = new DataAccessService();
            if(forwardPath.contains("category") || forwardPath.contains("product")){
                // When viewing categories or products, load info used in the products sidebar & dropdown lists.                                
                session.setAttribute("categorySidebarList", dataService.loadCategoryNames());
            } else if (forwardPath.contains("/main/service")){
                // When viewing services, load info used in the services sidebar.                
                session.setAttribute("serviceSidebarList", dataService.loadServiceNames());
            }                
        } catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(SearchAllCommand.class.getName(), ex.getMessage(), session);
            Logger.getLogger(SearchAllCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        // All categories are displayed on the 'categories.jsp' page(not category.jsp).
        return forwardPath.equalsIgnoreCase("/views/main/category.jsp") ? "/views/main/categories.jsp" : forwardPath;
    }
 
}

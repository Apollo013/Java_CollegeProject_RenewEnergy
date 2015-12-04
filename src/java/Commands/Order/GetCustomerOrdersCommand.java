package Commands.Order;

import Commands.Abstract.AbstractCommand;
import DataAccess.Abstract.IOrderDao;
import DataAccess.Concrete.OrderDao;
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
public class GetCustomerOrdersCommand extends AbstractCommand{

    public GetCustomerOrdersCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {
        
        forwardPath = "userorders.jsp";
        
        IOrderDao ioDao = new OrderDao();

        int key=0;        
        try {
            key = Integer.parseInt(request.getParameter("key"));
            session.setAttribute("userorders", ioDao.getUserOrders(key));              
        }
        catch(NumberFormatException nfe){
            forwardPath = MessageService.createNumberFormatError(GetCustomerOrdersCommand.class.getName(), nfe.getMessage(), String.valueOf(key), session);
            Logger.getLogger(GetCustomerOrdersCommand.class.getName()).log(Level.SEVERE, null, nfe);            
        }             
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(GetCustomerOrdersCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(GetCustomerOrdersCommand.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return forwardPath;
    }
    
}

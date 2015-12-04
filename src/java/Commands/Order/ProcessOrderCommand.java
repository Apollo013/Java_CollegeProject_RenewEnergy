package Commands.Order;

import Commands.Abstract.AbstractCommand;
import Exceptions.DaoException;
import Models.Concrete.Order;
import Models.Concrete.OrderItem;
import Services.DataAccessService;
import Services.MessageService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

// THE SOLE PURPOSE OF THIS IS TO HANDLE THE INSERTION, UPDATING AND DELETION OF
// ORDER ITEMS FOR A SPECIFIC ORDER.

/**
 *
 * @author Paul Millar <D00152098>
 */
public class ProcessOrderCommand extends AbstractCommand{

    private Order order = null;
    
    public ProcessOrderCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public String execute() {

        // Create a new order if one does not already exist
        order = (Order)session.getAttribute("order");
        if(order == null){
            order = new Order();
        }

        // Default forward page is always the order detail page
        forwardPath = "orderdetail.jsp?cmd=edit";           
        
        // Grab the current acion
        String action = request.getParameter("action");
        
        if(action.equalsIgnoreCase("addorderitem")){
            addOrderItem();       
        } 
        else if(action.equalsIgnoreCase("changeorderitem")){
            changeOrderItem(null);
        }
         else if(action.equalsIgnoreCase("deleteorderitem")){
            deleteOrderItem();
        }
        
        // put the edited order back into a session variable
        session.setAttribute("order", order);
        return forwardPath;
    }

    private void addOrderItem(){      

        // NOTE: IT IS POSSIBLE TO ADD A PRODUCT THAT ALREADY EXISTS IN THE ORDER
        // IN THAT SCENARIO, WE SIMPLY CHANGE QUANTITY & PRICE FIELDS.
        
        //JOptionPane.showMessageDialog(null, "addOrderItem", "alert", JOptionPane.ERROR_MESSAGE);
        // Create a new order item object from the request parameters
        OrderItem oi = (OrderItem)super.createBusinessModelFromRequest();    
        //JOptionPane.showMessageDialog(null, String.valueOf(oi.getOrderNo()), "alert", JOptionPane.ERROR_MESSAGE);
        // Check if it exists (search for a matching product)
        OrderItem existingOI = order.getExistingOrderItemProduct(oi.getProductId());
        
        if(existingOI == null){
            // It does not already exist, so add it
            try {            
                DataAccessService das = new DataAccessService();
                das.insertOrderItem(oi, order);
            }      
            catch (DaoException ex) {
                forwardPath = MessageService.createDataAccessError(ProcessOrderCommand.class.getName(), ex.getMessage(),session);
                Logger.getLogger(ProcessOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
            }             
        }
        else {
            // it does, so update the quantity & price
            oi.setId(existingOI.getId());
            oi.setQuantity(existingOI.getQuantity() + oi.getQuantity()); 
            changeOrderItem(oi);           
        }
          
    }           
    
    private void changeOrderItem(OrderItem orderitem){
        
        // NOTE: THIS IS CALLED WHEN WE ALREADY KNOW THAT WE HAVE AN EXISTING ORDER ITEM

        OrderItem oi            = null;
        OrderItem existingOI    = null;
                
        if(orderitem == null){
            // Create a new order item object from the request parameters
            oi = (OrderItem)super.createBusinessModelFromRequest(); 
            // Get the existing order item
            existingOI = order.getExistingOrderItemProduct(oi.getProductId());    
            oi.setId(existingOI.getId());            
        } else {
            oi = orderitem;
        }

        try{
            // Change the order in memory
            order.changeOrderItem(oi);
            // Change the order in the db
            DataAccessService das = new DataAccessService();
            das.changeOrderItem(oi, order);        
        }
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(ProcessOrderCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(ProcessOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
        }           

    }
    
    private void deleteOrderItem(){
        // Create a new order item object from the request parameters
        OrderItem oi = (OrderItem)super.createBusinessModelFromRequest(); 
        
        // Get the existing order item
        OrderItem existingOI = order.getExistingOrderItemProduct(oi.getProductId());
        
        try{
            // Change the order in memory
            order.removeOrderItem(existingOI.getId());
            // Change the order in the db
            DataAccessService das = new DataAccessService();
            das.deleteOrderItem(existingOI.getId());        
        }
        catch (DaoException ex) {
            forwardPath = MessageService.createDataAccessError(ProcessOrderCommand.class.getName(), ex.getMessage(),session);
            Logger.getLogger(ProcessOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
}

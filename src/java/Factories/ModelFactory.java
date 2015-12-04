package Factories;

import Models.Concrete.Category;
import Models.Concrete.Order;
import Models.Concrete.OrderItem;
import Models.Concrete.Product;
import Models.Concrete.Service;
import Models.Concrete.User;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

// HERE WE CREATE NEW MODEL OBJECTS, EITHER FROM THE PARAMETERS PASSED TO THE REQUEST VIA A FORM
// WHEN INSERTING OR UPDATING, OR AN EMPTY MODEL WHEN THE USER ENTERS A BLANK FORM FOR THE FIRST TIME.

/**
 *
 * @author Paul Millar <D00152098>
 */
public class ModelFactory {
    
    private static ModelFactory mf = null;
    
    private ModelFactory(){}
    
    public synchronized static ModelFactory getInstance(){
        if (mf == null){
            mf = new ModelFactory();
        }
        return mf;
    }
    
    public synchronized Object createModelObject(HttpServletRequest request, String modelType){
                           
        // The request object is required in order to create the appropriate business model
        // with the data supplied by the user via a <form>
        if (modelType.equalsIgnoreCase("category")){ 
            return createCategoryModel(request);
        }        
        else if (modelType.equalsIgnoreCase("service")){ 
            return createServiceModel(request);
        } 
        else if (modelType.equalsIgnoreCase("product")){ 
            return createProductModel(request);
        } 
        else if(modelType.equalsIgnoreCase("user")){             
            return createUserModel(request);
        }
        else if(modelType.equalsIgnoreCase("order")) {         
            return createOrderModel(request);
        }   
        else if(modelType.equalsIgnoreCase("orderitem")) {         
            return createOrderItemModel(request);
        }         
        return null;
    }
        
    public synchronized Object createNewModelObject(HttpServletRequest request, String modelType){
                           
        // The request object is required in order to create the appropriate business model
        // with the data supplied by the user via a <form>
        if (modelType.equalsIgnoreCase("category")){ 
            return new Category();
        }        
        else if (modelType.equalsIgnoreCase("service")){ 
            return new Service();
        } 
        else if (modelType.equalsIgnoreCase("product")){ 
            return new Product();
        } 
        else if(modelType.equalsIgnoreCase("user")){             
            return new User();
        }
        else if(modelType.equalsIgnoreCase("order")) {         
            return new Order();
        }   
        else if(modelType.equalsIgnoreCase("orderitem")) {         
            return new OrderItem();
        }         
        return null;
    }
        
    private User createUserModel(HttpServletRequest request){

        return new User(parseInt(request,"key"),
                        request.getParameter("firstname"),
                        request.getParameter("lastname"),
                        request.getParameter("address1"),
                        request.getParameter("address2"),
                        request.getParameter("city"),
                        request.getParameter("county"),
                        request.getParameter("country"),
                        request.getParameter("postcode"),
                        request.getParameter("email"),
                        request.getParameter("password"),
                        parseByte(request,"usertype"),
                        parseLastUpdated(request));      
    }
    
    private Service createServiceModel(HttpServletRequest request){

        return new Service( parseInt(request,"key"),
                            request.getParameter("name"),
                            request.getParameter("overview"),
                            request.getParameter("overviewImage"),  
                            request.getParameter("bannerImage"),
                            request.getParameter("listitemImage"),                 
                            parseDouble(request,"price"),
                            parseInt(request,"onhand"),
                            parseLastUpdated(request));
    }
    
    private Product createProductModel(HttpServletRequest request){
        
        return new Product( parseInt(request,"key"),
                            parseInt(request,"cat_id"),
                            request.getParameter("name"),
                            request.getParameter("introduction"),
                            request.getParameter("overview"),
                            request.getParameter("overviewImage"),  
                            request.getParameter("bannerImage"),
                            request.getParameter("listitemImage"),                 
                            request.getParameter("brochureFile"),
                            request.getParameter("faqsFile"),                 
                            request.getParameter("savings_Text"),
                            request.getParameter("savings_values"),                        
                            parseDouble(request,"price"),
                            parseInt(request,"onhand"),
                            parseLastUpdated(request));
    }
    
    private Category createCategoryModel(HttpServletRequest request){
        
       return new Category(parseInt(request,"key"),
                            request.getParameter("name"),
                            request.getParameter("introduction"),
                            request.getParameter("overview"),
                            request.getParameter("overviewImage"),  
                            request.getParameter("bannerImage"),
                            request.getParameter("listitemImage"),
                            request.getParameter("howImage"),
                            request.getParameter("brochureFile"),
                            request.getParameter("faqsFile"),
                            request.getParameter("videoUrl"),                   
                            parseLastUpdated(request));
    }

    private Object createOrderItemModel(HttpServletRequest request) {
        //JOptionPane.showMessageDialog(null, request.getParameter("orderno"), "alert", JOptionPane.ERROR_MESSAGE);
        return new OrderItem(   parseInt(request,"orderno"),
                                parseInt(request,"quantity"),
                                parseDouble(request,"price"),
                                new Product(parseInt(request,"key"),request.getParameter("productname")
        ));
    }
    
    private Order createOrderModel(HttpServletRequest request){ 

        Order order = (Order)request.getSession().getAttribute("order");
        
        // Is this a request for an insert ?
        if(order == null || order.getOrderNo() == 0){
            return new Order(parseInt(request,"key"));
        } else {
            // or an update ?
            Byte status = parseByte(request,"status");
            if(status != 0 && status != order.getStatus()){
                order.setStatus(status);
            }
            return order;
        }

    }
    
    private int parseInt(HttpServletRequest request, String paramName){           
        int num = 0;
        String NUM = request.getParameter(paramName);
        if(!NUM.isEmpty()){
            num = Integer.parseInt(NUM);
        }        
        return num;
    }    

    private double parseDouble(HttpServletRequest request, String paramName){
        return Double.parseDouble(request.getParameter(paramName));
    }
  
    private byte parseByte(HttpServletRequest request, String paramName){
        byte num = 0;
        String NUM = request.getParameter(paramName);
        if(!NUM.isEmpty()){
            num = Byte.parseByte(NUM);
        }      
        return num;
    }
    
    private Timestamp parseLastUpdated(HttpServletRequest request){  
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        java.sql.Timestamp ts = null;
        String sDate = (String)request.getParameter("lastupdated");
        if(sDate.equals("0") || sDate.isEmpty()){
            ts = new Timestamp(utilDate.getTime());
        } else {
            ts = Timestamp.valueOf(sDate);
        }
        return ts;
    }

}

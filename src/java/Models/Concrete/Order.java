package Models.Concrete;

import Models.Abstract.ErrorBase;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class Order extends ErrorBase implements Serializable{
        
    // <editor-fold defaultstate="collapsed" desc="Properties">  
        
    private int                 orderNo;
    @RequiredValidator
    private byte                status;
    private Date                orderDate;
    private Date                shipDate;
    private Timestamp           lastUpdated;
    @RequiredValidator
    private User                user;

    
    private HashMap<Integer,OrderItem> lineItems;
    
    private static HashMap<Integer,String> statusOptions;    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Order(){

        this.user = new User();
        
        java.util.Date today = new java.util.Date();
        this.orderDate = new java.sql.Date(today.getTime()); 
        
        this.status=1; // On Order
        
        lineItems = new HashMap<Integer,OrderItem>();
    }
    
    public Order(int userid){
        user = new User(userid);
        java.util.Date today = new java.util.Date();
        this.orderDate = new java.sql.Date(today.getTime()); 
        
        this.status=1; // On Order        
        
        lineItems = new HashMap<Integer,OrderItem>();
    }

    public Order(int orderNo, byte status, Date orderDate, Date shipDate, Timestamp lastUpdated, User user, HashMap<Integer,OrderItem> orderItems) {
        this.orderNo = orderNo;
        this.setStatus(status);
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.lastUpdated = lastUpdated;
        this.user = user;
       
        lineItems = orderItems;        
    }
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public int getOrderNo() {
        return orderNo;
    }

    private void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
        if(this.status == 4){ // shipped
            java.util.Date today = new java.util.Date();
            this.setShipDate(new java.sql.Date(today.getTime()));             
        }
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        
        if(user != null && this.user == null){
            this.user = user;
        }
    }

    public HashMap<Integer,OrderItem> getLineItems() {
        return lineItems;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Custom">   
            

    public static HashMap<Integer,String> getOrderStatusOptions(){
        if(statusOptions == null){
            statusOptions = new HashMap<Integer,String>();
            statusOptions.put(1, "On Order");
            statusOptions.put(2, "Work In Progress");
            statusOptions.put(3, "Ready");
            statusOptions.put(4, "Shipped");
            statusOptions.put(5, "Canceled");
            statusOptions.put(6, "Processed");              
        }
        return statusOptions;
    }
        
    public String getOrderStatus(){
        
        // RETURN THE STRING VALUE OF THE CURRENT STATUS
        return getOrderStatusOptions().get((int)status);
    }
    
    
        
    public String getLastUpdatedFormatted(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(lastUpdated) ;        
    }
        
    public String getOrderDateFormatted(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(orderDate) ;        
    }   
    
    

    public Collection<OrderItem> getOrderItems() {
        return lineItems.values();
    }
    
    public Double getTotalPrice() {
        double total = 0;
        
        Iterator iter = this.lineItems.keySet().iterator();
        
        while(iter.hasNext()){
            Integer key = (Integer)iter.next();
            OrderItem oi = (OrderItem)this.lineItems.get(key);
            total += oi.getLineTotal();
        }

        return total;
    }
    
    
    public boolean addOrderItem(OrderItem orderitem){
        
        if(orderitem == null){
            return false;
        }
        
        // IF THIS ITEM ALREADY EXISTS THEN WE WILL JUST INCREASE THE QUANTITY        
        if(this.lineItems.containsKey(orderitem.getProductId())){
            return changeOrderItem(orderitem);
        } else {
            lineItems.put(orderitem.getProductId(), orderitem);
        }
        
        return true;

    }


    public boolean changeOrderItem(OrderItem orderitem){
        
        if(orderitem == null){
            return false;
        }
        
        OrderItem oi = lineItems.get(orderitem.getProductId());
        if(oi != null){
            oi.setQuantity(orderitem.getQuantity());
            oi.setPrice(orderitem.getPrice());        
            return true;
        } else {
            return false;
        }
    }    
    

    public boolean changeOrderQuantity(OrderItem orderitem){
        
        if(orderitem == null){
            return false;
        }
        
        OrderItem oi = lineItems.get(orderitem.getProductId());
        if(oi!= null){
            oi.setQuantity(oi.getQuantity() + orderitem.getQuantity());
            oi.setPrice(orderitem.getPrice());
            return true;
        } else {
            return false;
        }
    }
    
    public void removeOrderItem(int key){
        
        if(key > 0 && this.lineItems.containsKey(key)){
            OrderItem orderitem = (OrderItem)this.lineItems.get(key);
            this.lineItems.remove(key);
        }

    }
    
    public void removeOrderItem(OrderItem oi){
        
        if(oi != null && this.lineItems.containsKey(oi.getProductId())){
            this.lineItems.remove(oi);
        }
    }
    
    public OrderItem getExistingOrderItemProduct(int key){
        
        return lineItems.get(key);
        
    }
    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Overrides">  
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.orderNo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order order = (Order) obj;
        if (this.orderNo != order.orderNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderNo=" + orderNo + ", status=" + status + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", lastUpdated=" + lastUpdated + ", user=" + user + '}';
    }
     
    // </editor-fold>  

}


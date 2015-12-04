package Models.Concrete;

import Models.Abstract.ErrorBase;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class OrderItem extends ErrorBase implements Serializable, Comparable<OrderItem> {
    
    // <editor-fold defaultstate="collapsed" desc="Properties">  
    
    private int     id;
    
    @RangeValidator(minValue = 1, maxValue = 9999999)
    private int     quantity;
    
    @RangeValidator(minValue = 0.01, maxValue = 9999999)
    private double  price;
    
    private Product product;
    private int orderNo;
    
    //private Order   order;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    
    public OrderItem(){
        this.product = new Product();
    }
            
    public OrderItem(int id, int orderNo, int quantity, double price,int productId, String productName, double productPrice, int onHandQty) {
        this.id = id;
        this.orderNo = orderNo;
        this.quantity = quantity;
        this.price = price;
        this.product = new Product(productId, productName, productPrice, onHandQty);
    }

    public OrderItem(int orderNo, int quantity, double price, Product product) {
        //JOptionPane.showMessageDialog(null, String.valueOf(orderNo), "alert", JOptionPane.ERROR_MESSAGE);
        this.orderNo = orderNo;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }
    
    public OrderItem(int id, int orderNo, int quantity, double price, Product product) {
        this.id = id;
        this.orderNo = orderNo;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNo() {
        return this.orderNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Custom">
     
    public double getLineTotal(){
        return this.quantity * this.price;
    }      
    
    public int getProductId(){
        return this.product.getId();
    }
    
    public String getProductName(){
        return this.product.getName();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Overrides">  
        
    @Override
    public int compareTo(OrderItem oi) {

        if(this.id > oi.id){
            return 1;              
        }
        else if (this.id < oi.id){
            return -1;
        }
        
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.orderNo;
        hash = 29 * hash + this.product.getId();
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
        
        // Order Items are determined by their order number and product id
        final OrderItem other = (OrderItem) obj;
        if (this.orderNo != other.getOrderNo()) {
            return false;
        }
        
        if (this.product.getId() != other.product.getId()) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        
        String rv = "orderNo=" + this.orderNo + ", id=" + id + ", quantity=" + quantity + ", price=" + price;
        
        if (this.product != null){
            rv = rv + ", product=" + this.product.getName();
        }    
        
        return rv;
    }
    
    // </editor-fold> 

}

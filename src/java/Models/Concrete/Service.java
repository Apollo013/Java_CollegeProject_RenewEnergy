package Models.Concrete;

import Models.Abstract.ProductBase;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class Service extends ProductBase implements Serializable{
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    
    public Service(){
        this.onHand = 0;
        this.price = 1;
    }
    
    public Service(int id, String name, String listitemImage) {
        this.id = id;
        this.name = name;
        this.listitemImage = listitemImage;        
    }
   
    public Service(int id, String name, String overview, String overviewImage, String bannerImage, String listitemImage, double price, int onHand, Timestamp lastUpdated) {
        this.id             = id;
        this.categoryID     = 1;        
        this.name           = name;
        this.overview       = overview;
        this.overviewImage  = overviewImage;
        this.bannerImage    = bannerImage;
        this.listitemImage  = listitemImage;
        this.price          = price;
        this.onHand         = onHand;        
        this.lastUpdated    = lastUpdated;
    }

    // </editor-fold>

}

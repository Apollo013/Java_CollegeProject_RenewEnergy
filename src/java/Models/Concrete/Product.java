package Models.Concrete;

import Models.Abstract.ProductBase;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class Product extends ProductBase implements Serializable{
   
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    
    public Product(){
        this.onHand = 0;
        this.price = 1;
    }
    
    /**
     * Constructor used by 'ProductDao.getBasicDetailsByCategoryKey()'.
     * @param id
     * @param name
     */
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor used by 'ProductDao.getPriceDetailsForOrders()'.
     * @param id
     * @param name
     * @param price
     * @param onHand
     */
    public Product(int id, String name, double price, int onHand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.onHand = onHand;
    }

    /**
     * Constructor used by 'ProductDao.getAll()'.
     * @param id
     * @param name
     * @param price
     * @param onHand
     * @param lastUpdated
     * @param category
     */
    public Product(int id, String name, double price, int onHand, Timestamp lastUpdated, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.onHand = onHand;
        this.lastUpdated = lastUpdated;   
        this.categoryName = category;
    }    

    /**
     * Constructor used by 'ProductDao.getBriefDetailsByCategoryKey()'.
     * @param id
     * @param categoryID
     * @param name
     * @param introduction
     * @param listitemImage
     * @param price
     * @param onHand
     */
    public Product(int id, int categoryID, String name, String introduction, String listitemImage, double price, int onHand) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.introduction = introduction;
        this.listitemImage = listitemImage;
        this.price = price;
        this.onHand = onHand;
    }  

    /**
     * Constructor used by 'ProductDao.getByKey()'.
     * @param id
     * @param categoryID
     * @param name
     * @param introduction
     * @param overview
     * @param overviewImage
     * @param bannerImage
     * @param listitemImage
     * @param brochureFile
     * @param faqsFile
     * @param savingsText
     * @param savingsValues
     * @param price
     * @param onHand
     * @param lastUpdated
     */
    public Product(int id, int categoryID, String name, String introduction, String overview, String overviewImage, String bannerImage, String listitemImage, String brochureFile, String faqsFile, String savingsText, String savingsValues, double price, int onHand, Timestamp lastUpdated) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.introduction = introduction;
        this.overview = overview;
        this.overviewImage = overviewImage;
        this.bannerImage = bannerImage;
        this.listitemImage = listitemImage;
        this.brochureFile = brochureFile;
        this.faqsFile = faqsFile;
        this.savingsText = savingsText;
        this.savingsValues = savingsValues;
        this.price = price;
        this.onHand = onHand;
        this.lastUpdated = lastUpdated;
    }
    
    // </editor-fold>
       
}


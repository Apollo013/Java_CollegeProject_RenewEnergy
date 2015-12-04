package Models.Concrete;

import Models.Abstract.ProductBase;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;        

/**
 *
 * @author Paul Millar <D00152098>
 */
public class Category extends ProductBase implements Serializable{
        
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    
    public Category(){}
    
    /**
     * Constructor used by 'CategoryDao.getBasicDetails()'.
     * @param id
     * @param name
     * @param products
     */
    public Category(int id, String name, List<Product> products) {
       
        this.id         = id;
        this.name       = name;
        this.products   = products;        
    }

    /**
     * Constructor used by 'CategoryDao.searchAll()'.
     * @param id
     * @param name
     * @param introduction
     * @param listitemImage
     * @param lastUpdated
     * @param status
     */
    public Category(int id, String name, String introduction, String listitemImage, Timestamp lastUpdated) {
      
        this.id             = id;
        this.name           = name;
        this.introduction   = introduction;
        this.listitemImage  = listitemImage;
        this.lastUpdated    = lastUpdated;
    }

    /**
     * Constructor used by 'ModelFactory.createCategoryModel()'.
     * @param id
     * @param name
     * @param introduction
     * @param overview
     * @param overviewImage
     * @param bannerImage
     * @param listitemImage
     * @param howImage
     * @param brochureFile
     * @param faqsFile
     * @param videoUrl
     * @param lastUpdated
     * @param status
     */
    public Category(int id, String name, String introduction, String overview, String overviewImage, String bannerImage, String listitemImage, String howImage, String brochureFile, String faqsFile, String videoUrl, Timestamp lastUpdated) {
  
        this.id             = id;
        this.name           = name;
        this.introduction   = introduction;
        this.overview       = overview;
        this.overviewImage  = overviewImage;
        this.bannerImage    = bannerImage;
        this.listitemImage  = listitemImage;
        this.howImage       = howImage;
        this.brochureFile   = brochureFile;
        this.faqsFile       = faqsFile;
        this.videoUrl       = videoUrl;
        this.lastUpdated    = lastUpdated;
    }

    /**
     * Constructor used by 'CategoryDao.searchByKey()'.
     * @param id
     * @param name
     * @param introduction
     * @param overview
     * @param overviewImage
     * @param bannerImage
     * @param listitemImage
     * @param howImage
     * @param brochureFile
     * @param faqsFile
     * @param videoUrl
     * @param lastUpdated
     * @param status
     * @param products
     */
    public Category(int id, String name, String introduction, String overview, String overviewImage, String bannerImage, String listitemImage, String howImage, String brochureFile, String faqsFile, String videoUrl, Timestamp lastUpdated, List<Product> products) {
        this.id             = id;
        this.name           = name;
        this.introduction   = introduction;
        this.overview       = overview;
        this.overviewImage  = overviewImage;
        this.bannerImage    = bannerImage;
        this.listitemImage  = listitemImage;
        this.howImage       = howImage;
        this.brochureFile   = brochureFile;
        this.faqsFile       = faqsFile;
        this.videoUrl       = videoUrl;
        this.lastUpdated    = lastUpdated;
        this.products       = products;        
    }
  
    // </editor-fold>
             
}

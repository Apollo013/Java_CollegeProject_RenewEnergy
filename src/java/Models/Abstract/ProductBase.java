package Models.Abstract;

import Models.Concrete.Product;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Paul Millar <D00152098>
 */
public abstract class ProductBase  extends ErrorBase {
    
    
    // <editor-fold defaultstate="collapsed" desc="Properties">  
    
    protected   int             id;
    protected   int             categoryID;
    
    @RequiredValidator
    protected   String          name;
    
    @RequiredValidator    
    protected   String          introduction;
    
    @RequiredValidator    
    protected   String          overview;
    
    @RequiredValidator    
    protected   String          overviewImage;
    
    @RequiredValidator    
    protected   String          bannerImage;
    
    @RequiredValidator    
    protected   String          listitemImage;
    
    @RequiredValidator    
    protected   String          howImage;    
    
    @RequiredValidator    
    protected   String          brochureFile;    
    
    @RequiredValidator
    protected   String          faqsFile;   
    
    @RequiredValidator
    protected   String          videoUrl;   
    
    protected   String          savingsText;
    protected   String          savingsValues;
    
    @RangeValidator(maxValue = 9999999.99, minValue = 0.0)
    protected   double          price;
    
    @RangeValidator(maxValue = 9999999, minValue = 0)
    protected   int             onHand;  
    
    protected   Timestamp       lastUpdated;
    protected   String          categoryName;
    protected   List<Product>   products;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constants">
    
    public static final String productImagesPath    = "../../images/products/";
    public static final String serviceImagesPath    = "../../images/services/";   
    public static final String pdfMediaPath         = "../../media/"; 
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverviewImage() {
        return overviewImage;
    }

    public void setOverviewImage(String overviewImage) {
        this.overviewImage = overviewImage;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getListitemImage() {
        return listitemImage;
    }

    public void setListitemImage(String listitemImage) {
        this.listitemImage = listitemImage;
    }

    public String getHowImage() {
        return howImage;
    }

    public void setHowImage(String howImage) {
        this.howImage = howImage;
    }

    public String getBrochureFile() {
        return brochureFile;
    }

    public void setBrochureFile(String brochureFile) {
        this.brochureFile = brochureFile;
    }

    public String getFaqsFile() {
        return faqsFile;
    }

    public void setFaqsFile(String faqsFile) {
        this.faqsFile = faqsFile;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getSavingsText() {
        return savingsText;
    }

    public void setSavingsText(String savingsText) {
        this.savingsText = savingsText;
    }

    public String getSavingsValues() {
        return savingsValues;
    }

    public void setSavingsValues(String savingsValues) {
        this.savingsValues = savingsValues;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOnHand() {
        return onHand;
    }

    public void setOnHand(int onHand) {
        this.onHand = onHand;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Custom Getters">
    
    public String getOverviewImageFullPath() {
        return this.productImagesPath + this.overviewImage;
    }
    
    public String getBannerImageFullPath() {
        return this.productImagesPath + this.bannerImage;
    }
    
    public String getListItemImageFullPath(){
        return this.productImagesPath + this.listitemImage;
    }
            
    public String getHowItWorksImageFullPath(){
        return this.productImagesPath + this.howImage;
    }   
    
    public String getBrochurePdfFullPath(){
        return this.pdfMediaPath + this.brochureFile;
    }  
    
    public String getFaqsPdfFullPath(){
        return this.pdfMediaPath + this.faqsFile;
    } 
    
    public String getLastUpdatedFormatted(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(lastUpdated) ;        
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Overrides">
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final ProductBase other = (ProductBase) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductBase{" + "id=" + id + ", categoryID=" + categoryID + ", name=" + name + ", introduction=" + introduction + ", overview=" + overview + ", overviewImage=" + overviewImage + ", bannerImage=" + bannerImage + ", listitemImage=" + listitemImage + ", howImage=" + howImage + ", brochureFile=" + brochureFile + ", faqsFile=" + faqsFile + ", videoUrl=" + videoUrl + ", savingsText=" + savingsText + ", savingsValues=" + savingsValues + ", price=" + price + ", onHand=" + onHand + ", lastUpdated=" + lastUpdated + ", categoryName=" + categoryName + '}';
    }
        
    // </editor-fold>


}

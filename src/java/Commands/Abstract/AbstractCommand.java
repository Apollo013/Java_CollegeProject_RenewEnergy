package Commands.Abstract;

import DataAccess.Abstract.IGenericDao;
import Factories.DaoFactory;
import Factories.ModelFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Paul Millar <D00152098>
 */
public abstract class AbstractCommand {
    
    protected   HttpServletRequest      request;
    protected   HttpServletResponse     response;
    protected   HttpSession             session;
    protected   String                  forwardPath;
    
    public AbstractCommand(HttpServletRequest request, HttpServletResponse response){
        this.request        = request;
        this.response       = response;
        this.session        = request.getSession();
        this.forwardPath    = request.getServletPath() + ".jsp";
    }
        
    public abstract String execute();
    
    protected IGenericDao getDao(){
        // We want to grab the last portion of the 'SERVLET PATH'.
        // i.e. user, service, product, category, order,  etc ...
        // So we can then determine the appropriate Dao Object to create.    
        return DaoFactory.getInstance().createDataAccessObject(getEntityType());
        // It is possible for this to return null
    }
    
    protected Object createBusinessModelFromRequest(){
        // We want to grab the last portion of the 'SERVLET PATH'.
        // i.e. user, service, product, category, order,  etc ...
        // So we can then determine the appropriate Model Object to create.           
        return ModelFactory.getInstance().createModelObject(request,getEntityType());
        // It is possible for this to return null        
    }    
    
    protected Object createNewBusinessModel(){
        // We want to grab the last portion of the 'SERVLET PATH'.
        // i.e. user, service, product, category, order,  etc ...
        // So we can then determine the appropriate Model Object to create.           
        return ModelFactory.getInstance().createNewModelObject(request,getEntityType());
        // It is possible for this to return null        
    }  
    
    protected String getEntityType(){
        // Grabs the last portion of the 'SERVLET PATH'.
        // i.e. user, service, product, category, order,  etc ...        
        String url = this.request.getServletPath();
        return url.substring(url.lastIndexOf('/')+1, url.length()).toLowerCase();   
    }
            
}

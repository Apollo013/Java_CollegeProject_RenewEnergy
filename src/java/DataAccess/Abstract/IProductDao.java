package DataAccess.Abstract;

import Exceptions.DaoException;
import Models.Concrete.Product;
import java.util.List;

/**
 *
 * @author Paul Millar <D00152098>
 */
public interface IProductDao extends IGenericDao<Product>{
    public List<Product> getBriefDetailsByCategoryKey(int catID) throws DaoException; 
    public List<Product> getBasicDetailsByCategoryKey(int catID) throws DaoException; 
    public List<Product> getPriceDetailsForOrders() throws DaoException;

}

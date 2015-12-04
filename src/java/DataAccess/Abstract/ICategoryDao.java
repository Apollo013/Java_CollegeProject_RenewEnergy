package DataAccess.Abstract;

import Exceptions.DaoException;
import Models.Concrete.Category;
import java.util.List;

/**
 *
 * @author Paul Millar <D00152098>
 */
public interface ICategoryDao extends IGenericDao<Category>{
    public List<Category> getBasicDetails() throws DaoException ;
}

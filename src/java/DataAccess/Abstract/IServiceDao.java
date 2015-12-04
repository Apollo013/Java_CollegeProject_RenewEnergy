package DataAccess.Abstract;

import Exceptions.DaoException;
import Models.Concrete.Service;
import java.util.List;

/**
 *
 * @author Paul Millar <D00152098>
 */
public interface IServiceDao extends IGenericDao<Service>{
    public List<Service> getBriefDetails() throws DaoException;
}

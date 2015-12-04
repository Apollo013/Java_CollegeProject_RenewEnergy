package DataAccess.Abstract;

import Exceptions.DaoException;
import Models.Concrete.Order;
import java.util.List;

/**
 *
 * @author Paul Millar <D00152098>
 */
public interface IOrderDao extends IGenericDao<Order>{
    public List<Order> getUserOrders(int userId) throws DaoException;
}

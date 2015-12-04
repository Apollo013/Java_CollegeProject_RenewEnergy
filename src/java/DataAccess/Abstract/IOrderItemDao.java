package DataAccess.Abstract;

import Exceptions.DaoException;
import Models.Concrete.OrderItem;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Paul Millar <D00152098>
 */
public interface IOrderItemDao extends IGenericDao<OrderItem>{
    public List<OrderItem> getByOrderNo(int orderno) throws DaoException;   
    public HashMap<Integer,OrderItem> getOrderItems(int orderno) throws DaoException;
}

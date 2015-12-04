package DataAccess.Abstract;

import Exceptions.DaoException;
import Models.Concrete.User;

/**
 *
 * @author Paul Millar <D00152098>
 */
public interface IUserDao extends IGenericDao<User>{
    public User login(String email, String password) throws DaoException;
}

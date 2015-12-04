
package DataAccess.Abstract;

import Exceptions.DaoException;
import java.util.List;

/**
 * Generic Data Access Interface
 * @author Paul Millar <D00152098>
 * @param <T>
 */
public interface IGenericDao<T> {
    
    public int      insert(T obj)           throws DaoException;
    public boolean  update(T obj)           throws DaoException;
    public boolean  delete(int key)         throws DaoException;
    public List<T>  getAll()                throws DaoException;
    public T        getByKey(int key)       throws DaoException;
    
}

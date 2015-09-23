/**
 * 
 */
package dao;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.*;

/**
 * @author Mariana
 *
 */
public abstract class ExamHelperDao<T extends Serializable, ID> implements IExamHelperDao<T, ID> {

	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public ExamHelperDao(){
		type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T findByID(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(ID id) {
		// TODO Auto-generated method stub
		
	}

}

package dao;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author asawe_000
 *
 * @param <T>
 * @param <ID>
 */
public abstract class ExamHelperCollectionDao <T extends Serializable, ID> implements IExamHelperDao<T , ID>{

	protected ArrayList<T> database;
	//private Class<T> type;
	
	public ExamHelperCollectionDao() {
		this.database = new ArrayList<T>();
		//type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public ExamHelperCollectionDao(ArrayList<T> database) {
		super();
		this.database = database;
	}

	/**
	 * Save an entity
	 * 
	 * @param entity
	 *            the entity to save
	 */
	public void save(T entity) {
		database.add(entity);
	}

	/**
	 * Updates an entity
	 * 
	 * @param entity
	 *            the entity to update
	 */
	public abstract void update(T entity);

	/**
	 * Saves or updates an entity
	 * 
	 * @param entity
	 *            the entity to update or save
	 */
	public abstract void saveOrUpdate(T entity);



	/**
	 * Find an entity by its primary key
	 * 
	 * @param id
	 *            the entity's primary key
	 * @return the entity
	 */
	public abstract  T findByID(ID id) ;

	/**
	 * Find an entity by its name
	 * 
	 * @param name
	 *            the entity's name
	 * @return the entity
	 */
	public abstract T findByName(String name) ;

	/**
	 * Get all entities
	 * 
	 * @return a list of all entities
	 */
	public ArrayList<T> getAll() {

		return database;
	}



	/**
	 * Deletes an entity
	 * 
	 * @param entity
	 *            the entity to delete
	 */
	public void delete(T entity) {
		for(T t : database){
			if(t.equals(entity))
				database.remove(entity);
		}
	}

	/**
	 * Deletes an entity
	 * 
	 * @param id
	 *            the primar key of the entity to deletee
	 */
	public abstract void delete(ID id) ;
	



	/**
	 * Count all entities
	 * 
	 * @return how many entities there are
	 */
	public int count() {
		return database.size();
	}
	
	public abstract void populateDatabase();
}

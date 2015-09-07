/**
 * 
 */
package dao;


import java.io.Serializable;
import java.util.List;

/**
 * Generic repository providing basic CRUD operations
 * 
 * @author Asa
 *
 * @param <T>
 *            the entity type
 * @param <ID>
 *            the primary key type
 */
public interface IExamHelperCollectionDao<T, ID extends Serializable> {


	/**
	 * Find an entity by its primary key
	 * 
	 * @param id
	 *            the entity's primary key
	 * @return the entity
	 */
	T findByID(ID id);

	/**
	 * Find an entity by its name
	 * 
	 * @param name
	 *            the entity's name
	 * @return the entity
	 */
	T findByName(String name);

	/**
	 * Get all entities
	 * 
	 * @return a list of all entities
	 */
	List<T> getAll();


	int count();

	/**
	 * Save an entity
	 * 
	 * @param entity
	 *            the entity to save
	 */
	void save(T entity);

	/**
	 * Updates an entity
	 * 
	 * @param entity
	 *            the entity to update
	 */
	void update(T entity);

	/**
	 * Saves or updates an entity
	 * 
	 * @param entity
	 *            the entity to update or save
	 */
	void saveOrUpdate(T entity);



	/**
	 * Deletes an entity
	 * 
	 * @param entity
	 *            the entity to delete
	 */
	void delete(T entity);

	/**
	 * Deletes an entity
	 * 
	 * @param id
	 *            the primar key of the entity to deletee
	 */
	void delete(ID id);
}

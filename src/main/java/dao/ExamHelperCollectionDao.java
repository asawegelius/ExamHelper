package dao;

import java.io.Serializable;
import java.util.ArrayList;

import model.Answer;
import model.Chapter;
import model.Choice;
import model.Question;

/**
 * 
 * @author asawe_000
 *
 * @param <T>
 * @param <ID>
 */
public abstract class ExamHelperCollectionDao <T, ID extends Serializable> implements IExamHelperCollectionDao<T, ID>{

	protected ArrayList<T> database;

	public ExamHelperCollectionDao() {
		this.database = new ArrayList<T>();
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
	public T findByID(ID id) {
		
		return null;
	}

	/**
	 * Find an entity by its name
	 * 
	 * @param name
	 *            the entity's name
	 * @return the entity
	 */
	public T findByName(String name) {
		return null;
	}

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
	public void delete(ID id) {
		for(T t : database){
			if(t instanceof Chapter){
				//if (((Chapter) t).getId() == (long)id);
				database.remove(t);
			}
			else if (t instanceof Question){
				//if (((Question) t).getId() == (long)id);
				database.remove(t);
			}
			else if (t instanceof Choice){
				//if (((Choice) t).getId() == (long)id);
				database.remove(t);
			}
			else if (t instanceof Answer){
				//if (((Answer) t).getId() == (long)id);
				database.remove(t);
			}
		}
	}



	/**
	 * Count all entities
	 * 
	 * @return how many entities there are
	 */
	public int count() {
		return database.size();
	}
}

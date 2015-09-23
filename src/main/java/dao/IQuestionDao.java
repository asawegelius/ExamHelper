/**
 * 
 */
package dao;

import java.io.Serializable;

import model.Chapter;

/**
 * @author Asa
 *
 */
public interface IQuestionDao<T extends Serializable, ID> extends IExamHelperDao<T, ID> {
	/**
	 * 
	 * @param i - the Chapter value the parameter chapter shall equal in Questions picked for the pair
	 * @return a pair of Questions belonging to the chapter
	 */
	public T[] getRandomPair(long i);
}

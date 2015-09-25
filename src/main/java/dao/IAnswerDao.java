/**
 * 
 */
package dao;

import java.io.Serializable;

import model.Answer;

/**
 * @author asawe_000
 *
 */
public interface IAnswerDao<T extends Serializable, ID> extends
IExamHelperDao<T, ID>  {
	Answer answerForQuestion(ID questionID);
}

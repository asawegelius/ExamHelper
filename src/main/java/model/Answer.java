package model;

import java.io.Serializable;

public class Answer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long answerId;
	private long questionId;
	private long choiceId;
	private String description;
	
	public Answer(){
		answerId = -1;
	}	


	/**
	 * @param answerId
	 * @param questionId
	 * @param choiceId
	 * @param description
	 */
	public Answer(long answerId, long questionId, long choiceId, String description) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.choiceId = choiceId;
		this.description = description;
	}


	/**
	 * @return the answerId
	 */
	public long getAnswerId() {
		return answerId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	/**
	 * @return the questionId
	 */
	public long getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId
	 *            the questionId to set
	 */
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the answerId
	 */
	public long getChoiceId() {
		return choiceId;
	}

	/**
	 * @param answerId
	 *            the answerId to set
	 */
	public void setChoiceId(long choiceId) {
		this.choiceId = choiceId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}

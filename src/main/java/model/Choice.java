package model;

import java.io.Serializable;

public class Choice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long choiceId;
	private long questionId;
	private String description;
	
	public Choice(){
		choiceId = -1;
	}	
	/**
	 * @param choiceId
	 * @param questionId
	 * @param description
	 */
	public Choice(long choiceId, long questionId, String description) {
		super();
		this.choiceId = choiceId;
		this.questionId = questionId;
		this.description = description;
	}
	/**
	 * @return the choiceId
	 */
	public long getChoiceId() {
		return choiceId;
	}
	/**
	 * @param choiceId the choiceId to set
	 */
	public void setChoiceId(long choiceId) {
		this.choiceId = choiceId;
	}
	/**
	 * @return the questionId
	 */
	public long getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}

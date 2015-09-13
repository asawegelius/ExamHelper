package model;

public class Answer {
	private long questionId;
	private long choiceId;
	private String description;

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

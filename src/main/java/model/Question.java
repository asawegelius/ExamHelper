package model;

public class Question {
	private long questionId;
	private Chapter chapter;
	private String name;
	private String description;
	
	public Question(){
		questionId = -1;
	}
			
	public Question(long questionId, Chapter chapter, String name,String description) {
		super();
		this.questionId = questionId;
		this.chapter = chapter;
		this.name = name;
		this.description = description;
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
	 * @return the chapter
	 */
	public Chapter getChapter() {
		return chapter;
	}
	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

package controller;

import model.Question;
import dao.IExamHelperDao;
import dao.IQuestionDao;

public class QuestionController {

	private IQuestionDao<Question, Long> database;
    
    public QuestionController(IQuestionDao<Question, Long> database) {
        super();
        this.setDatabase(database);
    }
	public QuestionController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the database
	 */
	public IExamHelperDao<Question, Long> getDatabase() {
		return database;
	}
	/**
	 * @param database the database to set
	 */
	public void setDatabase(IQuestionDao<Question, Long> database) {
		this.database = database;
	}
	
	public Question[] getQuestionsForChapter(long chapter){		
		return database.getRandomPair(chapter);
	}

}

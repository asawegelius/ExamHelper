package dao;

import model.Chapter;
import model.Question;

public class QuestionCollection extends ExamHelperCollectionDao<Question, Long> {

	@Override
	public void update(Question entity) {
		for(Question q : database){
			if(q.getQuestionId() == entity.getQuestionId()){
				q.setChapter(entity.getChapter());
				q.setDescription(entity.getDescription());
				q.setName(entity.getName());
			}
		}
		
	}

	@Override
	public void saveOrUpdate(Question entity) {
		if(entity.getQuestionId() < 0)
			update(entity);
		else save(entity);		
	}

	@Override
	public void delete(Long id) {
		for(Question q : database){
			if(q.getQuestionId() == id){
				database.remove(q);
			}
		}
	}
	
	public void populateDatabase(){
		save(new Question(1, Chapter.LIFE_CYCLES,"Q1", "What is life cylces?" ));
		save(new Question(2, Chapter.STATIC_TESTING, "Q2", "What is static testing?"));
		save(new Question(3, Chapter.TEST_DESIGN_TECHNIQUES, "Q3", "What is test design techniques?"));
		save(new Question(4, Chapter.TEST_MANAGEMENT, "Q4", "What is test management?"));
		save(new Question(5, Chapter.THE_EXAMINATION, "Q5", "What is the examination?"));
		save(new Question(6, Chapter.THE_FUNDAMENTALS_OF_TESTING, "Q6", "What is the fundamentals of testing?"));
		save(new Question(7, Chapter.TOOL_SUPPORT_FOR_TESTING, "Q7", "What is tool suport for testing?"));
	}

	@Override
	public Question findByID(Long id) {
		for(Question q : database){
			if(q.getQuestionId() == id){
				return q;
			}
		}
		return null;
	}

	@Override
	public Question findByName(String name) {
		for(Question q : database){
			if(q.getName() == name){
				return q;
			}
		}
		return null;	
	}

}

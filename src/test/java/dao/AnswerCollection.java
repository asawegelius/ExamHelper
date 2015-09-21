package dao;

import model.Answer;

public class AnswerCollection extends ExamHelperCollectionDao<Answer, Long>{
	@Override
	public void update(Answer entity){
		for(Answer a : database){
			if(a.getAnswerId() == entity.getAnswerId()){
				a.setQuestionId(entity.getQuestionId());
				a.setChoiceId(entity.getChoiceId());
				a.setDescription(entity.getDescription());
			}
		}
	}	
	@Override
	public void saveOrUpdate(Answer entity){
		if(entity.getAnswerId() < 0)
			update(entity);
		else save(entity);
	}
	public void populateDatabase(){
		
	}
	@Override
	public Answer findByID(Long id) {
		for(Answer a : database){
			if(a.getAnswerId() == id){
				return a;
			}
		}
		return null;
	}
	@Override
	public Answer findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		for(Answer a : database){
			if(a.getAnswerId() == id){
				database.remove(a);
			}
		}
	}
	
}

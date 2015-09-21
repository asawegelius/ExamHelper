package dao;

import model.Choice;


public class ChoiceCollection extends ExamHelperCollectionDao<Choice, Long>{
	@Override
	public void update(Choice entity){
		for(Choice ch : database){
			if(ch.getChoiceId() == entity.getChoiceId()){
				ch.setQuestionId(entity.getQuestionId());
				ch.setDescription(entity.getDescription());
			}
		}
	}	
	@Override
	public void saveOrUpdate(Choice entity){
		if(entity.getChoiceId() < 0)
			update(entity);
		else save(entity);
	}
	public void populateDatabase(){
		
	}
	@Override
	public Choice findByID(Long id) {
		for(Choice ch : database){
			if(ch.getChoiceId() == id){
				return ch;
			}
		}
		return null;
	}
	@Override
	public Choice findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		for(Choice ch : database){
			if(ch.getChoiceId() == id){
				database.remove(ch);
			}
		}
	}
}

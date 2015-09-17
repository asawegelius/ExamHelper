package dao;

import model.Chapter;
import model.Question;

public class ChapterCollection extends ExamHelperCollectionDao<Chapter, Long>{

	@Override
	public void update(Chapter entity) {
		
		
	}
	@Override
	public void saveOrUpdate(Chapter entity) {
		if(entity.getChapterNo() < 0)
			update(entity);
		else save(entity);
		
	}

	@Override
	public void delete(Long id) {
		for(Chapter c : database){
			if(c.getChapterNo() == id){
				database.remove(c);
			}
		}
		
	}
	@Override
	public void populateDatabase(){
	}

	@Override
	public Chapter findByID(Long id) {
		for(Chapter c : database){
			if(c.getChapterNo() == id){
				return c;
			}
		}
		return null;
	}

	@Override
	public Chapter findByName(String name) {
		return null;
			
	}

}

package dao;

import model.Chapter;
import model.Question;

public class QuestionCollection extends ExamHelperCollectionDao<Question, Long> implements IQuestionDao<Question, Long> {
	
	public QuestionCollection(){
		populateDatabase();
	}

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
		save(new Question(8, Chapter.THE_FUNDAMENTALS_OF_TESTING, "E5. K2", "Which pair of definitions is correct?"));
		save(new Question(10, Chapter.THE_FUNDAMENTALS_OF_TESTING, "E7. K1", "When is testing complete?"));
		save(new Question(14, Chapter.LIFE_CYCLES,"SA1 (K2)", "Which of the following is true about the V-model?" ));
		save(new Question(19, Chapter.LIFE_CYCLES,"E3. K2", "Which of the following is a non-functional requirement?" ));
		save(new Question(25, Chapter.STATIC_TESTING, "SA3 (K1)", "What do static analysis tools analyse?"));
		save(new Question(29, Chapter.STATIC_TESTING, "E4. K1", "Which of the following are static techniques?"));
		save(new Question(32, Chapter.TEST_DESIGN_TECHNIQUES, "SA1 (K1)", "Which of the following defines the expected result of a test?"));
		save(new Question(36, Chapter.TEST_DESIGN_TECHNIQUES, "E2 (K1)", "Which of the following is a structure-based (white-box) technique?"));
		save(new Question(44, Chapter.TEST_MANAGEMENT, "SA3 (K1)", "What can a risk-based approach to testing provide?"));
		save(new Question(50, Chapter.TEST_MANAGEMENT, "E6", "Which of the following statements about risks is most accurate?"));
		save(new Question(56, Chapter.TOOL_SUPPORT_FOR_TESTING, "E3 (K1)", "Which of the following defects is most likely to be found by a test harness?"));
		save(new Question(59, Chapter.TOOL_SUPPORT_FOR_TESTING, "E6 (K1)", "A test management tool is most likely to integrate with which of the following tools?"));
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


	
	public Question[] getRandomPair(long i) {
		System.out.println("number of entries: " + database.size());
		Question[] pairs = new Question[2];
		int picked = 0;
		for(Question q : database){
			System.out.println(q.getChapter().name());

			System.out.println(q.getChapter().getChapterNo());
			System.out.println(Chapter.values()[(int)i]);
			if(q.getChapter().getChapterNo() == i){

				System.out.println("added question");
				pairs[picked] = q;
				picked ++;
			}
			if(!(picked < 2)){
				return pairs;
			}
		}
		return null;
	}


}

package dao;

import model.Answer;

public class AnswerCollection extends ExamHelperCollectionDao<Answer, Long>implements IAnswerDao<Answer, Long> {

	public AnswerCollection() {
		populateDatabase();
	}

	@Override
	public void update(Answer entity) {
		for (Answer a : database) {
			if (a.getAnswerId() == entity.getAnswerId()) {
				a.setQuestionId(entity.getQuestionId());
				a.setChoiceId(entity.getChoiceId());
				a.setDescription(entity.getDescription());
			}
		}
	}

	@Override
	public void saveOrUpdate(Answer entity) {
		if (entity.getAnswerId() < 0)
			update(entity);
		else
			save(entity);
	}

	public void populateDatabase() {
		save(new Answer(8, 8, 32,
				"Regression testing is testing that nothing has regressed. Retesting (or confirmation testing) confirms the fix is correct by running the same test after the fix has been made. No other option has both of these as true."));
		save(new Answer(10, 10, 38,
				"Sometimes time/money does signify the end of testing, but it is really complete when everything that was set out in advance has been achieved."));
		save(new Answer(14, 14, 56, null));
		save(new Answer(19, 19, 76,
				"The other options are functional requirements. Note that security is regarded as a functional requirement in this syllabus."));
		save(new Answer(25, 25, 100, null));
		save(new Answer(29, 29, 113, "Options (b), (c) and (d) are all dynamic test techniques."));
		save(new Answer(32, 32, 125, null));
		save(new Answer(36, 36, 143,
				"All other options are specification-based (black-box) techniques, and the main distracter is answer (a) because decision table testing could be confused with decision testing."));
		save(new Answer(44, 44, 173, null));
		save(new Answer(50, 50, 199,
				"In general, project risk and product risk can be hard to differentiate. Anything that impacts on the quality of the delivered system is likely to lead to delays or increased costs as the problem is tackled. Anything causing delays to the project is likely to threaten the delivered system’s quality. The risk-based approach is an approach to managing product risk through testing, so it impacts most directly on product risk."));
		save(new Answer(56, 56, 224,
				"Defects in middleware (option (b)) are generally more likely to be found by a test harness or a dynamic analysis tool than by any other type of tool (see Figure 6.5 in te book)."));
		save(new Answer(59, 59, 237,
				"Requirements management tools (option (d)) often have interfaces with test management tools. In some cases they will be sold as a package or in other cases a test management tool may have its own requirements module. The use of such interfaces or integrated packages aids traceability from requirements through to test scripts and defects."));
	}

	@Override
	public Answer findByID(Long id) {
		for (Answer a : database) {
			if (a.getAnswerId() == id) {
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
		for (Answer a : database) {
			if (a.getAnswerId() == id) {
				database.remove(a);
			}
		}
	}

	public Answer answerForQuestion(Long questionID) {
		for(Answer a : database){
			if(a.getQuestionId() == questionID){
				return a;
			}
		}
		return null;
	}

}

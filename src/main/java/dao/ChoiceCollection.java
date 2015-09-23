package dao;

import java.util.ArrayList;

import model.Choice;


public class ChoiceCollection extends ExamHelperCollectionDao<Choice, Long> implements IChoiceDao<Choice, Long>{
	
	public ChoiceCollection(){
		populateDatabase();
	}
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
		save(new Choice(29, 8, "a. Regression testing is checking that the reported defect has been fixed; retesting is testing that there are no additional problems in previously tested software."));
		save(new Choice(30, 8, "b. Regression testing is checking there are no additional problems in previously tested software; retesting enables developers to isolate the problem."));
		save(new Choice(31, 8, "c. Regression testing involves running all tests that have been run before; retesting runs new tests."));
		save(new Choice(32, 8, "d. Regression testing is checking that there are no additional problems in previously tested software, retesting is demonstrating that the reported defect has been fixed."));
		save(new Choice(37, 10, "a. When time and budget are exhausted."));
		save(new Choice(38, 10, "b. When there is enough information for sponsors to make an informed decision about release."));
		save(new Choice(39, 10, "c. When there are no remaining high priority defects outstanding."));
		save(new Choice(40, 10, "d. When every data combination has been exercised successfully."));
		save(new Choice(53, 14, "a. It has the same steps as the waterfall model for software development."));
		save(new Choice(54, 14, "b. It is referred to as a cyclical model for software development."));
		save(new Choice(55, 14, "c. It enables the production of a working version of the system as early as possible."));
		save(new Choice(56, 14, "d. It enables test planning to start as early as possible."));
		save(new Choice(73, 19, "a. The system will enable users to buy books."));
		save(new Choice(74, 19, "b. The system will allow users to return books."));
		save(new Choice(75, 19, "c. The system will ensure security of the customer details."));
		save(new Choice(76, 19, "d. The system will allow up to 100 users to log in at the same time."));
		save(new Choice(97, 25, "a. Design"));
		save(new Choice(98, 25, "b. Test cases"));
		save(new Choice(99, 25, "c. Requirements"));
		save(new Choice(100, 25, "d. Program code"));
		save(new Choice(113, 29, "a. Walkthrough"));
		save(new Choice(114, 29, "b. State transition testing"));
		save(new Choice(115, 29, "c. Decision table testing"));
		save(new Choice(116, 29, "d. Statement testing"));
		save(new Choice(125, 32, "a. Test case"));
		save(new Choice(126, 32, "b. Test procedure"));
		save(new Choice(127, 32, "c. Test execution schedule"));
		save(new Choice(128, 32, "d. Test condition"));
		save(new Choice(141, 36, "a. Decision table testing"));
		save(new Choice(142, 36, "b. State transition testing"));
		save(new Choice(143, 36, "c. Statement testing"));
		save(new Choice(144, 36, "d. Boundary value analysis"));
		save(new Choice(173, 44, "a. The types of test techniques to be employed."));
		save(new Choice(174, 44, "b. The total tests needed to provide 100 per cent coverage."));
		save(new Choice(175, 44, "c. An estimation of the total cost of testing."));
		save(new Choice(176, 44, "d. Only that test execution is effective at reducing risk."));
		save(new Choice(197, 50, "a. Project risks rarely affect product risk."));
		save(new Choice(198, 50, "b. Product risks rarely affect project risk."));
		save(new Choice(199, 50, "c. A risk-based approach is more likely to be used to mitigate product rather than project risks."));
		save(new Choice(200, 50, "d. A risk-based approac"));
		save(new Choice(221, 56, "a.    Variance from programming standards."));
		save(new Choice(222, 56, "b.   A defect in middleware."));
		save(new Choice(223, 56, "c.    Memory leaks."));
		save(new Choice(224, 56, "d.   Regression defects."));
		save(new Choice(234, 59, "a. Performance testing tool"));
		save(new Choice(235, 59, "b. Test data preparation tool"));
		save(new Choice(236, 59, "c. Static analysis tool"));
		save(new Choice(237, 59, "d. Requirements management tool"));
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
	
	public ArrayList<Choice> getChoicesForQuestion(Long id) {
		ArrayList<Choice> choices = new ArrayList<Choice>();
		for(Choice c : database){
			if( c.getQuestionId() == id){
				choices.add(c);
			}
		}
		return choices;
	}
}

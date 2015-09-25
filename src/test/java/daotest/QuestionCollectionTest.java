package daotest;

import dao.QuestionCollection;
import junit.framework.TestCase;
import model.Chapter;
import model.Question;

public class QuestionCollectionTest extends TestCase {
  
	public void test() {
		findID();
	    findName();
	}


	public void findID() {
		QuestionCollection q = new QuestionCollection();
		long a = 12;
		Question b = new Question(a, Chapter.THE_FUNDAMENTALS_OF_TESTING, "E5. K2", "Which pair of definitions is correct?");	
		Question c = q.findByID(a);
		
		assertEquals(b.getQuestionId(),c.getQuestionId());
	}
	
	public void findName() {
		QuestionCollection q = new QuestionCollection();
		String a = "E3. K2";
		Question b=new Question(19, Chapter.LIFE_CYCLES,a, "Which of the following is a non-functional requirement?");
		Question c = q.findByName(a);
		
		assertEquals(b.getName(),c.getName());
	}
	
}

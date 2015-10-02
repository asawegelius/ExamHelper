package daotest;

import dao.QuestionCollection;
import junit.framework.TestCase;
import model.Question;
import model.Chapter;
/**
 * @author gulc0112
 *
 */

public class QuestionCollectionTest extends TestCase {
  
	public void test() {
		findID();
	    findName();
	    update();
	    getRandomPair();
	}
    public void update(){
    	QuestionCollection q = new QuestionCollection();
    	Question a = new Question(19, Chapter.LIFE_CYCLES,"E3. K2", "Which of the following is a non-functional requirement?");
		q.update(a);
		Question b = new Question();
		b=q.findByName("E3. K2");
		assertEquals(b.getName(),a.getName());
		assertEquals(b.getChapter(),a.getChapter());
		assertEquals(b.getDescription(),a.getDescription());
    }

	public void findID() {
		QuestionCollection q = new QuestionCollection();
		long a = 8;
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
	public void getRandomPair(){
		QuestionCollection q = new QuestionCollection();
		Question[] arr = new Question[3];
		long i = 3;
		Question a = new Question(25, Chapter.STATIC_TESTING, "SA3 (K1)", "What do static analysis tools analyse?");
		Question b = new Question(29, Chapter.STATIC_TESTING, "E4. K1", "Which of the following are static techniques?");
		Question c = new Question(32, Chapter.TEST_DESIGN_TECHNIQUES, "SA1 (K1)", "Which of the following defines the expected result of a test?");
		arr[0]=a;arr[1]=b;arr[2]=c;
		Question[] arr1 = new Question[2];
		arr1=q.getRandomPair(i);
		
		assertEquals(arr[0].getName(),arr1[0].getName());
		assertEquals(arr[1].getName(),arr1[1].getName());
		
	}
	
}

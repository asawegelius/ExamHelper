package daotest;

import dao.AnswerCollection;
import junit.framework.TestCase;
import model.Answer;
/**
 * @author gulc0112
 *
 */

public class AnswerCollectionTest extends TestCase {
	public void test() {
		update();
		findID();
	    answerForQuestion();
	}
	public void update(){
		AnswerCollection a = new AnswerCollection();
		Answer b = new Answer(36, 36, 143,"All other options are specification-based (black-box) techniques, and the main distracter is answer (a) because decision table testing could be confused with decision testing.");
		a.update(b);
		Answer c = new Answer();
		long n=36;
		c=a.findByID(n);
		assertEquals(c.getQuestionId(),b.getQuestionId());
		assertEquals(c.getChoiceId(),b.getChoiceId());
		assertEquals(c.getDescription(),b.getDescription());
		
	}

	public void findID() {
		AnswerCollection a = new AnswerCollection();
		long b = 10;
		Answer c = new Answer(b,10,38,"Sometimes time/money does signify the end of testing, but it is really complete when everything that was set out in advance has been achieved.");	
		Answer d = a.findByID(b);
		
		assertEquals(c.getAnswerId(),d.getAnswerId());
	}
	
	public void answerForQuestion(){
	    AnswerCollection a = new AnswerCollection();		
		long q = 56;
		Answer b=new Answer(56, q, 224,"Defects in middle ware (option (b)) are generally more likely to be found by a test harness or a dynamic analysis tool than by any other type of tool (see Figure 6.5 in the book).");
        Answer c=a.answerForQuestion(q);
		assertEquals(b.getQuestionId(),c.getQuestionId());		
	}
}

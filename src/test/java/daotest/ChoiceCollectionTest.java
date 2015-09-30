package daotest;

import java.util.ArrayList;
import dao.ChoiceCollection;
import junit.framework.TestCase;
import model.Choice;
/**
 * @author gulc0112
 *
 */

public class ChoiceCollectionTest extends TestCase {
	public void test() {
		update();
		findID();
		getChoicesForQuestion();
	}
	public void update(){
		ChoiceCollection c = new ChoiceCollection();		
		Choice a = new Choice(38, 10, "b. When there is enough information for sponsors to make an informed decision about release.");
		c.update(a);
		Choice b = new Choice();
		long n=38;
		b=c.findByID(n);
		assertEquals(b.getQuestionId(),a.getQuestionId());
		assertEquals(b.getDescription(),a.getDescription());
		
	}
	public void findID() {
		ChoiceCollection c = new ChoiceCollection();
		long b = 55;
		Choice a = new Choice(b, 14, "c. It enables the production of a working version of the system as early as possible.");	
		Choice d = c.findByID(b);
		
		assertEquals(d.getChoiceId(),a.getChoiceId());
	}
	public void getChoicesForQuestion(){
		ChoiceCollection c = new ChoiceCollection();
		long q = 19;
		long q1= 25;

		ArrayList<Choice> arr = new ArrayList<Choice>(); 
		arr=c.getChoicesForQuestion(q);
		int n=1;
		for(Choice ch : arr){
			if( ch.getQuestionId() == q1){
				n=0;
			}
		}
		assertEquals(1,n);		
	}

}

package daotest;

import dao.QuestionDao;
import junit.framework.Assert;
import junit.framework.TestCase;
import model.Question;

public class QuestionDaoTest extends TestCase {
	QuestionDao questDao;
	public void testfindByID(){
		/* 
	        # pk_qid, name, description, fk_chaid_answer
			'30', 'E5. K1', 'Which one of the following roles is typically used in a review?', '3'

	        *
	        */
		long a = 30;
		Question quest = questDao.findByID(a);
		Assert.assertEquals("E5. K1", quest.getName());
		Assert.assertEquals("Which one of the following roles is typically used in a review?", quest.getDescription());
		Assert.assertEquals("3", quest.getChapter());
		return;
		
	}
	
/*	public void testfindByName(){

		String a = "E5. K1";
		Question quest = questDao.findByName(a);
		Assert.assertEquals("30", quest.getQuestionId());
		Assert.assertEquals("Which one of the following roles is typically used in a review?", quest.getDescription());
		Assert.assertEquals("3", quest.getChapter());
		return;
		
	}*/
}

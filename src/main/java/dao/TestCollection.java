package dao;

import java.util.ArrayList;

import model.Answer;
import model.Choice;
import model.Question;

public class TestCollection {

	public TestCollection() {
	}

	public static void main(String[] args) {
		QuestionDao questionDAO = new QuestionDao();
		ChoiceDao choiceDAO = new ChoiceDao();
		AnswerDao answerDAO = new AnswerDao();
		Question[] pair = questionDAO.getRandomPair(0);
		System.out.println(pair[0].getDescription());
		System.out.println();
		System.out.println(questionDAO.count());

		System.out.println(choiceDAO.getAll().size());
		
		ArrayList<Choice> choices = choiceDAO.getChoicesForQuestion(pair[0].getQuestionId());
		for(Choice c : choices){
			System.out.println("description: " + c.getDescription());
			System.out.println("id: " + c.getChoiceId());
		}
		
		System.out.println(answerDAO.getAll().size());
		Answer answer = answerDAO.answerForQuestion(pair[0].getQuestionId());
		System.out.println("correct choice id for answer: " + answer.getChoiceId());
			
	}

}

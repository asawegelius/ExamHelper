package dao;

import java.util.ArrayList;

import model.Choice;
import model.Question;

public class TestCollection {

	public TestCollection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		QuestionCollection controller = new QuestionCollection();
		Question[] pair = controller.getRandomPair(0);
		ChoiceCollection choiceController = new ChoiceCollection();
		ArrayList<Choice> choices = choiceController.getChoicesForQuestion((long) 8);
		for(int i = 0; i < choices.size(); i++){
			System.out.println(choices.get(i).getDescription());
		}
	}

}

package dao;

import model.Question;

public class TestCollection {

	public TestCollection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		QuestionCollection controller = new QuestionCollection();
		Question[] pair = controller.getRandomPair(0);
	}

}

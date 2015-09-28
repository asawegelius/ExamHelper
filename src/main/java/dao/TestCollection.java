package dao;

import model.Question;

public class TestCollection {

	public TestCollection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		QuestionDao controller = new QuestionDao();
		Question[] pair = controller.getRandomPair(0);
		System.out.println(pair[0].getDescription());
		System.out.println(pair[1].getDescription());
	}

}

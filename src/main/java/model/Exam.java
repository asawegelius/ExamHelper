package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Exam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Question> questions;
	ArrayList<ArrayList<Choice>> choices;
	ArrayList<Answer> answers;

	public Exam() {
		this.questions = new ArrayList<Question>();
		this.choices = new ArrayList<ArrayList<Choice>>();
		this.answers = new ArrayList<Answer>();
	}
	

	/**
	 * @param questions
	 * @param choices
	 * @param answers
	 */
	public Exam(ArrayList<Question> questions,
			ArrayList<ArrayList<Choice>> choices, ArrayList<Answer> answers) {
		super();
		this.questions = questions;
		this.choices = choices;
		this.answers = answers;
	}

	/**
	 * @return the questions
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	/**
	 * @return the choices
	 */
	public ArrayList<ArrayList<Choice>> getChoices() {
		return choices;
	}

	/**
	 * @param choices the choices to set
	 */
	public void setChoices(ArrayList<ArrayList<Choice>> choices) {
		this.choices = choices;
	}

	/**
	 * @return the answers
	 */
	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}

}

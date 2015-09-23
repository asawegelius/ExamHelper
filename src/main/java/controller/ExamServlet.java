package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChoiceCollection;
import dao.IChoiceDao;
import dao.IQuestionDao;
import dao.QuestionCollection;
import model.Exam;
import model.Question;
import model.Choice;

/**
 * Servlet implementation class ExamServlet
 */
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IQuestionDao<Question, Long> questionsDatabase;
	private IChoiceDao<Choice, Long> choicesDatabase;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExamServlet() {
		super();
		this.questionsDatabase = new QuestionCollection();
		this.choicesDatabase = new ChoiceCollection();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Question> questions = new ArrayList<Question>();
			ArrayList<ArrayList<Choice>> choices = new ArrayList<ArrayList<Choice>>();
			Exam exam = new Exam();
			for (int i = 1; i < 7; i++) {
				Question[] pair = questionsDatabase.getRandomPair(i);
				questions.add(pair[0]);
				questions.add(pair[1]);
				choices.add(choicesDatabase.getChoicesForQuestion(pair[0].getQuestionId()));
				choices.add(choicesDatabase.getChoicesForQuestion(pair[1].getQuestionId()));
			}
			exam.setQuestions(questions);
			exam.setChoices(choices);
			request.setAttribute("exam", exam);
			RequestDispatcher dispatcher = request.getRequestDispatcher("exam.jsp");
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			System.out.println("exception in ExamServlet");
			ex.printStackTrace();
		}
	}

}

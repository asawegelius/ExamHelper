package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnswerCollection;
import dao.AnswerDao;
import dao.ChoiceCollection;
import dao.ChoiceDao;
import dao.IAnswerDao;
import dao.IChoiceDao;
import dao.IQuestionDao;
import dao.QuestionCollection;
import dao.QuestionDao;
import model.Exam;
import model.Question;
import model.Choice;
import model.Answer;

/**
 * Servlet implementation class ExamServlet
 */
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IQuestionDao<Question, Long> questionsDatabase;
	private IChoiceDao<Choice, Long> choicesDatabase;
	private IAnswerDao<Answer, Long> answersDatabase;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExamServlet() {
		super();
		//this.questionsDatabase = new QuestionCollection();
		//this.choicesDatabase = new ChoiceCollection();
		//this.answersDatabase = new AnswerCollection();

		this.questionsDatabase = new QuestionDao();
		this.choicesDatabase = new ChoiceDao();
		this.answersDatabase = new AnswerDao();
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
			ArrayList<Answer> answers = new ArrayList<Answer>();
			Exam exam = new Exam();
			for (int i = 1; i < 7; i++) {
				Question[] pair = questionsDatabase.getRandomPair(i);
				questions.add(pair[0]);
				questions.add(pair[1]);
				choices.add(choicesDatabase.getChoicesForQuestion(pair[0].getQuestionId()));
				choices.add(choicesDatabase.getChoicesForQuestion(pair[1].getQuestionId()));
				answers.add(answersDatabase.answerForQuestion(pair[0].getQuestionId()));
				answers.add(answersDatabase.answerForQuestion(pair[1].getQuestionId()));
			}
			exam.setQuestions(questions);
			exam.setChoices(choices);
			exam.setAnswers(answers);
			HttpSession session = request.getSession();
			session.setAttribute("exam", exam);
			RequestDispatcher dispatcher = request.getRequestDispatcher("exam.jsp");
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			System.out.println("exception in ExamServlet");
			ex.printStackTrace();
		}
	}

}

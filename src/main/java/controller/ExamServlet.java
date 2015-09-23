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
import model.Chapter;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	        	Exam exam = new Exam();
	        	ArrayList<Question> questions = new ArrayList<Question>();
	        	ArrayList<ArrayList<Choice>> choices = new ArrayList<ArrayList<Choice>>();;
	        	for(int i = 0; i < 6; i++){
	        		Question[] pair = questionsDatabase.getRandomPair(Chapter.values()[i]);
	        		questions.add(pair[0]);
	        		questions.add(pair[1]);
	        		choices.add(choicesDatabase.getChoicesForQuestion(pair[0].getQuestionId()));
	        		choices.add(choicesDatabase.getChoicesForQuestion(pair[1].getQuestionId()));
	        	}
	    		request.setAttribute("randExam", exam);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/exam.jsp");
	            dispatcher.forward(request, response);
	          } catch (Exception ex) {
	        	  System.out.println("exception in questioncontroller:");
	            ex.printStackTrace();
	          }
	}

}

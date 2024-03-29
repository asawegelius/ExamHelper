package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IExamHelperDao;
import dao.QuestionCollection;
import model.Chapter;
import model.Question;

/**
 * Servlet implementation class QuestionController
 */
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IExamHelperDao<Question, Long> database;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
        database = new QuestionCollection();
    }
    
    public QuestionServlet(IExamHelperDao<Question, Long> database) {
        super();
        this.setDatabase(database);
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
        	Question question = new Question();
        	question.setQuestionId(1);
        	question.setChapter(Chapter.LIFE_CYCLES);
        	question.setName("Q1");
        	question.setDescription("What is life cycles?");
    		request.setAttribute("randQuestion", question);
            RequestDispatcher dispatcher = request.getRequestDispatcher("exam.jsp");
            dispatcher.forward(request, response);
          } catch (Exception ex) {
        	  System.out.println("exception in QuestionServlet");
            ex.printStackTrace();
          }
	}

	public IExamHelperDao<Question, Long> getDatabase() {
		return database;
	}

	public void setDatabase(IExamHelperDao<Question, Long> database) {
		this.database = database;
	}

}

package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IExamHelperDao;
import dao.QuestionCollection;
import model.Question;

/**
 * Servlet implementation class QuestionController
 */
public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IExamHelperDao<Question, Long> database;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionController() {
        super();
        database = new QuestionCollection();
    }
    
    public QuestionController(IExamHelperDao<Question, Long> database) {
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
		Random randomGenerator = new Random();
		//long index = randomGenerator.nextInt(database.count());
		Question question = database.findByID((long)1);
		request.setAttribute("randQuestion", question);
		String address = "/WEB-INF/exam.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	public IExamHelperDao<Question, Long> getDatabase() {
		return database;
	}

	public void setDatabase(IExamHelperDao<Question, Long> database) {
		this.database = database;
	}

}

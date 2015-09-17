package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;
import dao.IExamHelperDao;

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
        // TODO Auto-generated constructor stub
    }
    
    public QuestionController(IExamHelperDao<Question, Long> database) {
        super();
        this.setDatabase(database);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public IExamHelperDao<Question, Long> getDatabase() {
		return database;
	}

	public void setDatabase(IExamHelperDao<Question, Long> database) {
		this.database = database;
	}

}

package survey;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.Category;
import businessObject.Question;
import businessObject.Questionanswer;
import businessObject.Questionnaire;
import database.Db;

/**
 * Servlet implementation class ViewSurveyServlet
 */
@WebServlet("/ViewSurveyServlet")
public class ViewSurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Db database = new Db();
		HttpSession session = request.getSession();
		try {
			database.createConnection();
			int questionnaireid = Integer.parseInt(request.getParameter("questionnaireid"));
			Questionnaire questionnaire = database.getQuestionnaireById(questionnaireid);
			request.setAttribute("questionnaire", questionnaire);
			List<Questionanswer> questionAnswerList = questionnaire.getQuestionanswers();
			List<Question> questionList = database.getSurveyQuestions();	
			List<Category> categoryList = database.getSurveyCategories();
			

			request.setAttribute("questionList", questionList);	
			request.setAttribute("categoryList", categoryList);	
			request.setAttribute("questionAnswerList", questionAnswerList);	
			request.setAttribute("accountid", questionnaire.getClient().getAccount().getAccountid());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("./viewSurvey.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

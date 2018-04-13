package survey;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.Questionanswer;
import businessObject.Questionnaire;
import database.Db;

/**
 * Servlet implementation class SaveSurveyServlet
 */
@WebServlet("/SaveSurveyServlet")
public class SaveSurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveSurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Db database = new Db();
		HttpSession session = request.getSession();
		try {
			ArrayList<Questionanswer> qa  = (ArrayList<Questionanswer>)session.getAttribute("questionAnswerList");
			Questionnaire questionnaire = (Questionnaire)session.getAttribute("questionnaire");
			int score = 0;
			for (Questionanswer q : qa) {
				int weight = Integer.parseInt(q.getAnswer().getWeight().getWeight());
				score = score + weight;
			}
			questionnaire.setScore(score);
			
			database.createConnection();
			questionnaire = database.persistQuestionnaire(questionnaire);
			for (Questionanswer q : qa) {
				q.setQuestionnaire(questionnaire);
			}
			database.persistQuestionAnswers(qa);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/DisplaySurvey").forward(request, response);
	}

}

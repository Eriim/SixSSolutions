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
			int category1 = 0;
			int category2 = 0;
			int category3 = 0;
			int category4 = 0;
			int category5 = 0;
			for (Questionanswer q : qa) {
				int weight = Integer.parseInt(q.getAnswer().getWeight().getWeight());
				score = score + weight;
				switch(q.getQuestion().getCategory().getCategoryid()) {
				case 1:
					category1 = category1 + weight;
					break;
				case 2:
					category2 = category2 + weight;
					break;
				case 3:
					category3 = category3 + weight;
					break;
				case 4:
					category4 = category4 + weight;
					break;
				case 5:
					category5 = category5 + weight;
					break;				
					
				}
			
			}
			questionnaire.setScore(score);
			questionnaire.setCategory1(category1);
			questionnaire.setCategory2(category2);
			questionnaire.setCategory3(category3);
			questionnaire.setCategory4(category4);
			questionnaire.setCategory5(category5);
			
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

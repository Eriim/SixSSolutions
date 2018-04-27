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
			double score = 0;
			
			double category1 = 0;
			double total1 = 21;
			
			double category2 = 0;
			double total2 = 24;
			
			double category3 = 0;
			double total3 = 18;
			
			double category4 = 0;
			double total4 = 18;
			
			double category5 = 0;
			double total5 = 21;
			
			for (Questionanswer q : qa) {
				double weight = Double.parseDouble(q.getAnswer().getWeight().getWeight());
				score = score + weight;
				switch(q.getQuestion().getCategory().getCategoryid()) {
				case 1:
					category1 = category1 + weight;		
					System.out.println(category1);
					break;
				case 2:
					category2 = category2 + weight;
					System.out.println(category2);
					break;
				case 3:
					category3 = category3 + weight;	
					System.out.println(category3);
					break;
				case 4:
					category4 = category4 + weight;	
					System.out.println(category4);
					break;
				case 5:
					category5 = category5 + weight;	
					System.out.println(category5);
					break;				
					
				}
			
			}
			category1 = (category1 / total1)*100;
			category2 = (category2 / total2)*100;
			category3 = (category3 / total3)*100;
			category4 = (category4 / total4)*100;
			category5 = (category5 / total5)*100;
			score = score / (total1 + total2+ total3+ total4+ total5);			
			questionnaire.setScore((int)score);
			questionnaire.setCategory1((int)category1);
			questionnaire.setCategory2((int)category2);
			questionnaire.setCategory3((int)category3);
			questionnaire.setCategory4((int)category4);
			questionnaire.setCategory5((int)category5);
			
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

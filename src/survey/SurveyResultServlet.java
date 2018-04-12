package survey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessObject.Answer;
import businessObject.Category;
import businessObject.Question;
import businessObject.Questionanswer;
import businessObject.Questionnaire;
import database.Db;

/**
 * Servlet implementation class SubmitSurveyServlet
 */
@WebServlet("/SubmitSurveyServlet")
public class SurveyResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyResultServlet() {
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
		
		try {
			database.createConnection();
			
			List<Category> categoryList = database.getSurveyCategories();		
			
			List<Question> questionList = database.getSurveyQuestions();
			
			List<Answer> answerList = new ArrayList<Answer>();
			
			Questionnaire questionnaire = new Questionnaire();
			
			
			
			ArrayList<Questionanswer> qa = new ArrayList<Questionanswer>();
			
			
			System.out.println(questionList.size());
			
			for (int i = 0; i < questionList.size(); i++) {
				System.out.println(i);
				String index = Integer.toString(i + 1);
				Answer tempAnswer = database.getAnswerByText(request.getParameter(index));							
				
				Questionanswer tempQuestionAnswer = new Questionanswer();
				tempQuestionAnswer.setQuestion(questionList.get(i));
				tempQuestionAnswer.setAnswer(tempAnswer);
				qa.add(tempQuestionAnswer);		
				
			}
			
			
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("questionAnswerList", qa);
			
			database.persistQuestionAnswers(qa);
			
			for (Questionanswer quest : qa) {
				
				System.out.println(quest.getAnswer().getAnswertext());
				
			}
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher("/answers.jsp").forward(request, response);
	}

}

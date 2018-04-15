package survey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.Answer;
import businessObject.Category;
import businessObject.Client;
import businessObject.Question;
import businessObject.Questionanswer;
import businessObject.Questionnaire;
import database.Db;

/**
 * Servlet implementation class SubmitSurveyServlet
 */
@WebServlet("/SubmitSurveyServlet")
public class SubmitSurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitSurveyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Db database = new Db();
		HttpSession session = request.getSession();
		try {
			String username = (String) session.getAttribute("username");
			database.createConnection();

			List<Category> categoryList = database.getSurveyCategories();

			List<Question> questionList = database.getSurveyQuestions();

			List<Answer> answerList = new ArrayList<Answer>();

			Questionnaire questionnaire = new Questionnaire();
			Client client = database.getClientByUsername(username);
			questionnaire.setClient(client);
			questionnaire.setDatecompleted(new Date());
			questionnaire.setIscompleted(true);

			ArrayList<Questionanswer> qa = new ArrayList<Questionanswer>();

			System.out.println(questionList.size());
			
			Boolean errors = false;
			try {
				for (int i = 0; i < questionList.size(); i++) {
					System.out.println(i);
					String index = Integer.toString(i + 1);

					Answer tempAnswer = database.getAnswerByText(request.getParameter(index));

					Questionanswer tempQuestionAnswer = new Questionanswer();
					tempQuestionAnswer.setQuestion(questionList.get(i));
					tempQuestionAnswer.setAnswer(tempAnswer);
					qa.add(tempQuestionAnswer);

				}
			} catch (Exception e) {
				errors = true;
			}

			request.setAttribute("categoryList", categoryList);
			request.setAttribute("questionList", questionList);
			session.setAttribute("questionAnswerList", qa);
			session.setAttribute("questionnaire", questionnaire);

			for (Questionanswer quest : qa) {

				System.out.println(quest.getAnswer().getAnswertext());

			}
			if(errors)
			{
				request.setAttribute("errors", "Please answer every survey question");
				request.getRequestDispatcher("SurveyServlet").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("/answers.jsp").forward(request, response);
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

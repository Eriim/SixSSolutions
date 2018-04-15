package survey;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.Account;
import businessObject.Client;
import businessObject.Questionnaire;
import database.Db;

/**
 * Servlet implementation class LoadClientSurveyServlet
 */
@WebServlet("/LoadClientSurveyServlet")
public class LoadClientSurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadClientSurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Db database = new Db();
		HttpSession session = request.getSession();
		session.removeAttribute("questionAnswerList");
		session.removeAttribute("questionnaire");
		try {
			
			database.createConnection();
			Account account = database.getAccountByID(Integer.parseInt(request.getParameter("accountid")));
			Client client = database.getClientByUsername(account.getUsername());
					
			List<Questionnaire> questionnaires = database.getQuestionnaireByClient(client);
			request.setAttribute("questionnaireList", questionnaires);
			request.setAttribute("clientTitle", client.getCompanyname());
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/results.jsp").forward(request, response);
	}

}

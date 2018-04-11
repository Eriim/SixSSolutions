package account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessObject.Account;
import businessObject.Consultant;
import database.Db;

/**
 * Servlet implementation class CreateConsultantServlet
 */
@WebServlet("/CreateConsultantServlet")
public class CreateConsultantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateConsultantServlet() {
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
		HttpSession session = request.getSession();
		Db database = new Db();
		int accountID = (int)(session.getAttribute("accountID"));
		String workPhone = request.getParameter("workPhone");
		Boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
		
		Boolean error = false;
		String errorMsg = "";
		
		try {
			
			if(workPhone.length() < 10 || !workPhone.matches("^[0-9]+$"))
			{
				error = true;
				errorMsg = "Please enter a valid work phone <br/>";
				request.setAttribute("error", errorMsg);
				request.getRequestDispatcher("createConsultantAccount.jsp").forward(request, response);
			}
			else
			{
				database.createConnection();
				Account account = database.getAccountByID(accountID);
				
				System.out.println("Account retrieved for creation of consultant");
				
				Consultant consultant = new Consultant();
				consultant.setAccount(account);
				consultant.setWorkphone(workPhone);
				consultant.setIsadmin(isAdmin);
				database.persistConsultant(consultant);
				System.out.println(2);
				request.setAttribute("message", "Consultant: " + account.getFirstnamecontact() + ", " + account.getLastnamecontact() + " created.");
				request.getRequestDispatcher("./index.jsp").forward(request, response);
				
			}
			
				
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

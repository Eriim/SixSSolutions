package account;

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
import businessObject.Consultant;
import database.Db;

/**
 * Servlet implementation class EditConsultantServlet
 */
@WebServlet("/EditConsultantServlet")
public class EditConsultantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditConsultantServlet() {
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
		
		HttpSession session = request.getSession();
		Db database = new Db();
		String accountID = request.getParameter("accountid");
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
				Account account = database.getAccountByID(Integer.parseInt(accountID));
				
				
				
				
				Consultant consultant = account.getConsultants().get(0);
				consultant.setAccount(account);
				consultant.setWorkphone(workPhone);
				consultant.setIsadmin(isAdmin);
				database.UpdateConsultant(consultant);
				request.setAttribute("message", "Consultant: " + account.getFirstnamecontact() + ", " + account.getLastnamecontact() + " updated.");
				
				List<Client> clients = database.getAllCLients();
				List<Consultant> consultants = database.getAllConsultants();
				List<Consultant> admins = database.getAllAdmins();
				
				
				request.setAttribute("clients", clients);
				request.setAttribute("consultants", consultants);	
				request.setAttribute("admins", admins);	
				request.getRequestDispatcher("./accounts.jsp").forward(request, response);
				
			}
			
				
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

package account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessObject.Client;
import businessObject.Consultant;
import database.Db;

/**
 * Servlet implementation class ClientsSurvey
 */
@WebServlet("/AccountsServlet")
public class AccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Db database = new Db();
		try {
			database.createConnection();
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		List<Client> clients = database.getAllCLients();
		List<Consultant> consultants = database.getAllConsultants();
		List<Consultant> admins = database.getAllAdmins();
		
		
		request.setAttribute("clients", clients);
		request.setAttribute("consultants", consultants);	
		request.setAttribute("admins", admins);	
		request.getRequestDispatcher("/accounts.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

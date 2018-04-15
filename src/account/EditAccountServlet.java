package account;

import java.io.IOException;
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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditAccountServlet")
public class EditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String accountID = request.getParameter("accountID");
			System.out.println("ACCOUNT ID:" + accountID);
			Db database = new Db();
			try {
				database.createConnection();
			}catch(Exception e)
			{
				e.printStackTrace();
			}	
			
			Account account = database.getAccountByID(Integer.parseInt(accountID));
			
		
			
			request.setAttribute("username", account.getUsername());
			request.setAttribute("email", account.getEmail());
			request.setAttribute("phonenumber", account.getPhonenumber());
			request.setAttribute("firstname", account.getFirstnamecontact());
			request.setAttribute("lastname", account.getLastnamecontact());
			request.setAttribute("accountid", account.getAccountid());
			
			request.getRequestDispatcher("./editAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accountID = request.getParameter("accountID");
		request.setAttribute("accountid", accountID);
		System.out.println("ACCOUNT ID:" + accountID);
		Db database = new Db();
		try {
			database.createConnection();
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		Boolean error = false;
		String errorMsg = "";
		
		Account account = database.getAccountByID(Integer.parseInt(accountID));
		
		String usernameEntered = request.getParameter("username");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		
		HttpSession session = request.getSession();
		
		String username = account.getUsername();
		System.out.println("session: " + username);
		Boolean usernameTaken = true;

		System.out.println("new: " + usernameEntered);
		
		try {
			if(!username.matches(usernameEntered))
			{
				database.getAccountByUsername(usernameEntered);
			}
			else
			{
				System.out.println("same username as logged in");
				usernameTaken = false;
			}
		}
		catch(Exception e){
			System.out.println("no other accounts by this name");
			usernameTaken = false;
		}
		
		if(usernameTaken)
		{
			errorMsg += "Username already taken!";
			error = true;
		}
		if(usernameEntered.length() < 6)
		{
			error = true;
			errorMsg += "Username must be at least 6 characters long!<br/>";
		}
		
		 if(!email.contains("@") || email.length() < 3)
		{
			error = true;
			errorMsg += "Email be a valid address!<br/>";
		}
		if(phonenumber.length() < 10 || !phonenumber.matches("^[0-9]+$"))
		{
			error = true;
			errorMsg += "Phone must be a valid number!<br/>";
		}
		if(firstname == "")
		{
			error = true;
			errorMsg += "Please enter a first name!<br/>";
		}
		if(lastname == "")
		{
			error = true;
			errorMsg += "Please enter a last name!<br/>";
		}
		
		if(!error)
		{

			
			account.setUsername(usernameEntered);
			account.setEmail(email);
			account.setPhonenumber(phonenumber);
			account.setFirstnamecontact(firstname);
			account.setLastnamecontact(lastname);
			
			database.updateAccount(account);
			
			request.setAttribute("message", "Account information saved!");
			request.setAttribute("name", account.getFirstnamecontact() + account.getLastnamecontact());
			
			
	
			String oldUsername = (String) session.getAttribute("username");
			if(!oldUsername.matches(usernameEntered))
			{
				session.setAttribute("username", usernameEntered);
			}
			
			
			if(account.getClients().isEmpty())
			{
				Consultant consultant = account.getConsultants().get(0);
				//consultant 
				request.setAttribute("workphone", consultant.getWorkphone());
				request.setAttribute("admin", consultant.getIsadmin());
				request.getRequestDispatcher("./editConsultantAccount.jsp").forward(request, response);
			}
			else
			{
				Client client = account.getClients().get(0);
				//client
				request.setAttribute("companyName", client.getCompanyname());
				request.setAttribute("country", client.getCountry().getCountry());
				request.setAttribute("provinceState", client.getProvincestate().getName());
				
				request.setAttribute("address", client.getAddress());
				request.setAttribute("postalzipcode", client.getPostalzipcode());
				request.setAttribute("shippingaddress", client.getShippingaddress());
	
				request.getRequestDispatcher("./editClientAccount.jsp").forward(request, response);
			}
		}
		else
		{
	
			
			request.setAttribute("usernameEntered", usernameEntered);
			request.setAttribute("email", email);
			request.setAttribute("phonenumber", phonenumber);
			request.setAttribute("usernameEntered", firstname);
			request.setAttribute("lastname", lastname);
			request.setAttribute("error", errorMsg);
			request.getRequestDispatcher("./editAccount.jsp").forward(request, response);
		}
		

	}

}

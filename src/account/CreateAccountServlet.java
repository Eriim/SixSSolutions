package account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authentication.Hasher;
import businessObject.Account;
import database.Db;



/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
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
		Account account = new Account();
		
		Db database = new Db();
		
	
		String password = request.getParameter("password");
		String confirmation = request.getParameter("confirmation");
		String accountType = request.getParameter("accountType");
		
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String firstName = request.getParameter("firstN");
		String lastName = request.getParameter("lastN");
		
		Boolean error = false;
		String errorMsg = "";
		
		try {
			if(userName.length() < 6)
			{
				error = true;
				errorMsg += "Username must be at least 6 characters long!<br/>";
			}
			
			if(!password.equals(confirmation))
			{
				error = true;
				errorMsg += "Passwords do not match!<br/>";
			}
			 if(!email.contains("@") || email.length() < 3)
			{
				error = true;
				errorMsg += "Email be a valid address!<br/>";
			}
			if(phone.length() < 10 || !phone.matches("^[0-9]+$"))
			{
				error = true;
				errorMsg += "Phone must be a valid number!<br/>";
			}
			if(firstName == "")
			{
				error = true;
				errorMsg += "Please enter a first name!<br/>";
			}
			if(lastName == "")
			{
				error = true;
				errorMsg += "Please enter a last name!<br/>";
			}
			
			if(!error) {
				
				account.setUsername(userName);
				account.setEmail(email);
				account.setPhonenumber(phone);
				account.setFirstnamecontact(firstName);
				account.setLastnamecontact(lastName);
					
	
				HttpSession session = request.getSession();
				database.createConnection();
				
				Hasher hasher = new Hasher();
				account.setSalt(hasher.genSalt());
				account.setHashpass(hasher.hashedPassword(password, account.getSalt()));
				database.persistAccount(account);
				
				Account tempAccount = database.getAccountByUsername(userName);
				session.setAttribute("accountID", tempAccount.getAccountid());
				System.out.println("Account ID passed to session");
				request.setAttribute("name", tempAccount.getFirstnamecontact() + ", " + account.getLastnamecontact());
				System.out.println(account.getAccountid());
				
	
				if(accountType.equals("Client")) {
					request.getRequestDispatcher("/createClientAccount.jsp").forward(request, response);
				}
				if(accountType.equals("Consultant")) {
					request.getRequestDispatcher("/createConsultantAccount.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("accountUserName", userName);
				request.setAttribute("email", email);
				request.setAttribute("phonenumber", phone);
				request.setAttribute("usernameEntered", firstName);
				request.setAttribute("lastname", lastName);
				System.out.println("Errors!");
				request.setAttribute("error", errorMsg);
				request.getRequestDispatcher("/createAccount.jsp").forward(request, response);

				
				
			}
			
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

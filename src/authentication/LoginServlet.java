package authentication;

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
import businessObject.Role;
import database.Db;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Db database = new Db();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("") || password.equals(""))
		{
			request.setAttribute("error", "Please enter credentials");
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
		else
		{	
			
			try {
					HttpSession session = request.getSession();
					
					database.createConnection();
					
					Account account = database.getAccountByUsername(username);
					List<Consultant> consultants = account.getConsultants();
					List<Client> clients = account.getClients();
					
					
					Role role = new Role();
					if(!clients.isEmpty())
					{
						role.setRole("Client");
						
					}
					else if(!consultants.isEmpty())
					{
						if(consultants.get(0).getIsadmin()) {
							System.out.println(consultants.get(0).getAccount().getUsername());
							role.setRole("Admin");
						}
						else {
						role.setRole("Consultant");
						}
						
					}
					
					
					//set role
					session.setAttribute("Role", role);
					
					//get salt
					
					String salt = account.getSalt();
					
					
					Hasher hash = new Hasher();
					String hashed = hash.hashedPassword(password, salt);
					
					String hashPass = account.getHashpass();
					System.out.println(hashed);				
					
					if( account == null || !hashed.equals(hashPass))
					{
						request.setAttribute("error", "Incorrect credentials");
						request.getRequestDispatcher("./login.jsp").forward(request, response);
					}
					else {
						session.setAttribute("username", account.getUsername());
				
						request.setAttribute("hashPass", account.getHashpass());
						request.getRequestDispatcher("./index.jsp").forward(request, response);
						
					}	
					
					
					
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

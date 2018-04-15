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
import businessObject.Country;
import businessObject.Provincestate;
import database.Db;

/**
 * Servlet implementation class EditClientServlet
 */
@WebServlet("/EditClientServlet")
public class EditClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClientServlet() {
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
		
		int accountID = (int)session.getAttribute("accountID");

		
		String companyName = request.getParameter("companyName");
		
		String country = request.getParameter("country");
		String clientType = request.getParameter("clientType");
		String address = request.getParameter("address");
		String postalZipCode = request.getParameter("postalZipCode");
		String shippingAddress = request.getParameter("shippingAddress");
		String provinceState = request.getParameter("provinceState");
		
		Boolean error = false;
		String errorMsg = "";
		
		String canPostalCodeReg =  "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
		String usZipRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
		
		try {
			database.createConnection();
			if(companyName.equals("")){
				error = true;
				errorMsg += "Please enter a company name. <br/>";
			}
			 if(address.equals("") || address.length() < 4){
				error = true;
				errorMsg += "Please enter a proper address. <br/>";
			}
			 if(postalZipCode.equals("") || postalZipCode.length() < 5){
				error = true;
				errorMsg += "Please enter a valid postal/zip code. <br/>";
			}
			 if(country.equals(""))
			{
				error = true;
				errorMsg += "Please choose a country. <br/>";
			}
			 if(country.equals("CAN") && !postalZipCode.matches(canPostalCodeReg))
			{
				error = true;
				errorMsg += "Please enter a valid postal code. <br/>";
			}
			 if(country.equals("USA") && !postalZipCode.matches(usZipRegex))
			{
				error = true;
				errorMsg += "Please enter a valid zip code. <br/>";
			}
			 if(address.equals("") || address.length() < 4){
				error = true;
				errorMsg += "Please enter a proper address. <br/>";
			}
			if(shippingAddress.equals("") || shippingAddress.length() < 4){
				error = true;
				errorMsg += "Please enter a proper shipping address. <br/>";
			}
			
			
		
			if(error) {
				request.setAttribute("error", errorMsg);
				request.getRequestDispatcher("/createClientAccount.jsp").forward(request, response);
			}
			else
			{
			
			System.out.println("Account ID:" + accountID);
			Account account = database.getAccountByID(accountID);
			System.out.println("Database queried for account");
			System.out.println(account.getUsername());
			Provincestate provinceStateTemp = database.getProvinceStateByname(provinceState);
			
			Country countryTemp = database.getCountryByName(country);
		
			Client client = account.getClients().get(0);
			client.setAccount(account);
			client.setProvincestate(provinceStateTemp);
			client.setCountry(countryTemp);
			client.setCompanyname(companyName);
			client.setAddress(address);
			client.setPostalzipcode(postalZipCode);
			client.setShippingaddress(shippingAddress);
			
			database.UpdateClient(client);
			request.setAttribute("message", "Client " + account.getFirstnamecontact() + ", " + account.getLastnamecontact() + " updated.");
			
			List<Client> clients = database.getAllCLients();
			List<Consultant> consultants = database.getAllConsultants();
			List<Consultant> admins = database.getAllAdmins();
			
			
			request.setAttribute("clients", clients);
			request.setAttribute("consultants", consultants);	
			request.setAttribute("admins", admins);	
			request.getRequestDispatcher("/accounts.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			request.setAttribute("error", "Something went wrong.");
			request.getRequestDispatcher("/editClientAccount.jsp").forward(request, response);
		}	
		
	}
}



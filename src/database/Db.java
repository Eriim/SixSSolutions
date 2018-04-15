package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import businessObject.Account;
import businessObject.Answer;
import businessObject.Category;
import businessObject.Client;
import businessObject.Consultant;
import businessObject.Country;
import businessObject.Provincestate;
import businessObject.Question;
import businessObject.Questionanswer;
import businessObject.Questionnaire;

public class Db {

	public static final String PERSISTENCE_UNIT_NAME = "SixSSolutions";

	@PersistenceContext
	EntityManagerFactory tempEntityManagerFactory = null;

	@PersistenceContext
	EntityManager tempEntityManager = null;

	public EntityManager createConnection()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		try {

			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			tempEntityManager = tempEntityManagerFactory.createEntityManager();
			tempEntityManager.getTransaction().begin();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return tempEntityManager;

	}

	public void closeConnection() {

		try {

			if (tempEntityManager != null) {

				tempEntityManager.close();

			}

			if (tempEntityManagerFactory != null) {

				tempEntityManagerFactory.close();

			}

		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public Account getAccountByUsername(String username) throws Exception {
		List<Account> tempAccounts = new ArrayList<Account>();
		Account tempAccount = new Account();
		

			String tempJPLSelectQuery = "SELECT a FROM Account a WHERE a.username = :username";
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery).setParameter("username", username);

			tempAccounts = tempQuery.getResultList();

			tempAccount = tempAccounts.get(0);

		return tempAccount;

	}

	public Provincestate getProvinceStateByname(String name) {
		List<Provincestate> tempAccounts = new ArrayList<Provincestate>();
		Provincestate tempAccount = new Provincestate();
		try {

			String tempJPLSelectQuery = "SELECT a FROM Provincestate a WHERE a.name = :name";
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery).setParameter("name", name);

			tempAccounts = tempQuery.getResultList();

			tempAccount = tempAccounts.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ProvinceState Returned");
		return tempAccount;

	}

	public Country getCountryByName(String name) {
		List<Country> tempAccounts = new ArrayList<Country>();
		Country tempAccount = new Country();
		try {

			String tempJPLSelectQuery = "SELECT a FROM Country a WHERE a.country = :name";
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery).setParameter("name", name);

			tempAccounts = tempQuery.getResultList();

			tempAccount = tempAccounts.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Country Returned");
		return tempAccount;

	}

	public void persistAccount(Account account) {
		tempEntityManager.persist(account);
		tempEntityManager.getTransaction().commit();

	}

	public Account getAccountByID(int id) {
		List<Account> tempAccounts = new ArrayList<Account>();
		Account tempAccount = new Account();
		try {

			String tempJPLSelectQuery = "SELECT a FROM Account a WHERE a.accountid = :id";
			System.out.println(id);
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery).setParameter("id", id);

			tempAccounts = tempQuery.getResultList();

			tempAccount = tempAccounts.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempAccount;

	}

	public Client getClientByUsername(String username) {
		List<Client> tempClients = new ArrayList<Client>();
		Client tempClient = new Client();
		try {

			String tempJPLSelectQuery = "SELECT a FROM Client a WHERE a.account.username = :username";
			System.out.println(username);
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery).setParameter("username", username);

			tempClients = tempQuery.getResultList();

			tempClient = tempClients.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempClient;

	}

	public Answer getAnswerByText(String text) throws Exception {
		List<Answer> tempAnswers = new ArrayList<Answer>();
		Answer tempAnswer = new Answer();
		

			String tempJPLSelectQuery = "SELECT a FROM Answer a WHERE a.answertext = :text";
			System.out.println(text);
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery).setParameter("text", text);

			tempAnswers = tempQuery.getResultList();

			tempAnswer = tempAnswers.get(0);

		
		return tempAnswer;

	}

	public void persistClient(Client client) {
		tempEntityManager.persist(client);
		tempEntityManager.getTransaction().commit();
	}

	public Questionnaire persistQuestionnaire(Questionnaire questionnaire) {

		tempEntityManager.persist(questionnaire);

		return questionnaire;
	}

	public void persistQuestionAnswers(ArrayList<Questionanswer> qas) {
		for (Questionanswer questionanswer : qas) {
			tempEntityManager.persist(questionanswer);
		}
		tempEntityManager.getTransaction().commit();
	}

	public void persistConsultant(Consultant consultant) {
		tempEntityManager.persist(consultant);
		tempEntityManager.getTransaction().commit();
	}

	public Provincestate getProvinceStateByID(int id) {
		Provincestate tempPs = tempEntityManager.find(Provincestate.class, id);
		return tempPs;
	}

	public Country getCountryByID(int id) {
		Country tempCountry = tempEntityManager.find(Country.class, id);
		return tempCountry;
	}

	public List<Question> getSurveyQuestions() {
		String tempJPLSelect = "SELECT q FROM Question q";
		System.out.println("Survey categories retrieved");
		List<Question> questions = new ArrayList<Question>();
		try {
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelect);
			questions = tempQuery.getResultList();
			System.out.println("Survey Questions retrieved");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;

	}

	public List<Category> getSurveyCategories() {
		String tempJPLSelect = "SELECT c FROM Category c";
		System.out.println("Survey categories retrieved");
		List<Category> categories = new ArrayList<Category>();
		try {
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelect);
			categories = tempQuery.getResultList();
			System.out.println("Survey Categories retrieved");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;

	}

	public List<Questionnaire> getQuestionnaireByClient(Client client) {

		String tempJPLSelect = "SELECT q FROM Questionnaire q WHERE clientid = :client";
		System.out.println("Questionnaires retreived");
		List<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
		try {
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelect).setParameter("client", client.getClientid());
			questionnaires = tempQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionnaires;
	}

	public void persistAnswer(Answer answer) {
		tempEntityManager.persist(answer);
		tempEntityManager.getTransaction().commit();

	}

	public Questionnaire getQuestionnaireById(int id) {
		Questionnaire questionnaire = tempEntityManager.find(Questionnaire.class, id);
		return questionnaire;
	}


	public void deleteAccount(String accountID) {
	
		Account account = tempEntityManager.find(Account.class, Integer.parseInt(accountID));
		Consultant consultant = null;
		Client client = null;
		List<Questionnaire> questionnaires = new ArrayList<>();
		List<Questionanswer> questionAnswers = new ArrayList<>();
		
		System.out.println("ACCOUNT ID in DB: " + account.getAccountid());

		Boolean isConsultant = false;
		if (account.getClients().isEmpty()) {
			isConsultant = true;
			// consultant account
			String tempJPLSelectQuery = "SELECT c FROM Consultant c WHERE c.consultantid = :id";
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery).setParameter("id",
					account.getConsultants().get(0).getConsultantid());
			consultant = (Consultant) tempQuery.getResultList().get(0);

		} else {
			// client account
			String tempJPLSelectQuery = "SELECT c FROM Client c WHERE c.clientid = :id";
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery).setParameter("id",
					account.getClients().get(0).getClientid());
			client = (Client) tempQuery.getResultList().get(0);
			System.out.println("Get client");
			
			String tempJPLSelectQueryQA = "SELECT qa FROM Questionanswer qa WHERE qa.questionnaire.client.clientid = :id";
			Query tempQueryQA = tempEntityManager.createQuery(tempJPLSelectQueryQA).setParameter("id",
					account.getClients().get(0).getClientid());
			questionAnswers = tempQueryQA.getResultList();
			System.out.println(questionnaires.size());
			System.out.println("Get questionanswers");
			
			String tempJPLSelectQueryQ = "SELECT q FROM Questionnaire q WHERE q.client.clientid = :id";
			Query tempQueryQ = tempEntityManager.createQuery(tempJPLSelectQueryQ).setParameter("id",
					account.getClients().get(0).getClientid());
			questionnaires = tempQueryQ.getResultList();
			System.out.println("Get questionniares");

			for(Questionanswer qa : questionAnswers) {
				tempEntityManager.remove(qa);
				System.out.println("Delete questionanswers id:" + qa.getQuestionanswerid());
				
			}
			
			for(Questionnaire q : questionnaires) {
				tempEntityManager.remove(q);
				System.out.println("Delete qestionnaire id:" + q.getQuestionnaireid());
				
			}

		}
		
	
	
		if (isConsultant) {
			tempEntityManager.remove(consultant);

		} else {

			tempEntityManager.remove(client);
		}
		tempEntityManager.remove(account);
	

	}

	public void updateAccount(Account account) {

		tempEntityManager.persist(account);
		tempEntityManager.getTransaction().commit();
		System.out.println("account updated");

	}
	
	public void UpdateClient(Client client) {

		tempEntityManager.persist(client);
		tempEntityManager.getTransaction().commit();
		System.out.println("client updated");

	}
	
	public void UpdateConsultant(Consultant consultant) {

		tempEntityManager.persist(consultant);
		tempEntityManager.getTransaction().commit();
		System.out.println("consultant updated");

	}

	public List<Consultant> getAllConsultants() {
		List<Consultant> allConsultants = new ArrayList<Consultant>();

		try {
			String tempJPLSelectQuery = "SELECT c FROM Consultant c";
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery);
			allConsultants = tempQuery.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allConsultants;
	}

	public List<Consultant> getAllAdmins() {
		List<Consultant> allAdmins = new ArrayList<Consultant>();

		try {
			String tempJPLSelectQuery = "SELECT c FROM Consultant c WHERE isAdmin = true";
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery);
			allAdmins = tempQuery.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allAdmins;
	}

	public List<Client> getAllCLients() {
		List<Client> allClients = new ArrayList<Client>();

		try {
			String tempJPLSelectQuery = "SELECT c FROM Client c";
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery);
			allClients = tempQuery.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allClients;
	}
}

package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import businessObject.Account;
import businessObject.Client;
import businessObject.Consultant;
import businessObject.Country;
import businessObject.Provincestate;

public class Db {
	
public static final String PERSISTENCE_UNIT_NAME = "SixSSolutions";
	
	
	@PersistenceContext
	EntityManagerFactory tempEntityManagerFactory = null;
	
	@PersistenceContext 
	EntityManager tempEntityManager = null;
	
	public EntityManager createConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
					
			try {
					
					tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
					tempEntityManager = tempEntityManagerFactory.createEntityManager();
					tempEntityManager.getTransaction().begin();
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}	
		
		     return tempEntityManager;
			
		}
	
		public void closeConnection() {
				
				try {
					
		
		            if (tempEntityManager != null)
		            {
		
		                tempEntityManager.close();
		
		            }
		
		            if (tempEntityManagerFactory != null)
		            {
		
		                tempEntityManagerFactory.close();
		
		            }
					
				}
				
				catch(Exception e){
					
					e.printStackTrace();
				}
				
			} 
		
		public Account getAccountByUsername(String username) {
			List<Account> tempAccounts = new ArrayList<Account>();
			Account tempAccount = new Account();
			try {
			
			String tempJPLSelectQuery = "SELECT a FROM Account a WHERE a.username = :username";
			Query tempQuery = tempEntityManager.createQuery(tempJPLSelectQuery).setParameter("username", username);
			
			tempAccounts = tempQuery.getResultList();
			
			
			tempAccount = tempAccounts.get(0);
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
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
			
			}
			catch (Exception e) {
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
			
			}
			catch (Exception e) {
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
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return tempAccount;	
			
		}
		public void persistClient(Client client) {
			tempEntityManager.persist(client);
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
}

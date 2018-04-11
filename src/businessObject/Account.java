package businessObject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accountid;

	private String email;

	private String firstnamecontact;

	private String hashpass;

	private String lastnamecontact;

	private String phonenumber;

	private String salt;

	private String username;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="account")
	private List<Client> clients;

	//bi-directional many-to-one association to Consultant
	@OneToMany(mappedBy="account")
	private List<Consultant> consultants;

	public Account() {
	}

	public int getAccountid() {
		return this.accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstnamecontact() {
		return this.firstnamecontact;
	}

	public void setFirstnamecontact(String firstnamecontact) {
		this.firstnamecontact = firstnamecontact;
	}

	public String getHashpass() {
		return this.hashpass;
	}

	public void setHashpass(String hashpass) {
		this.hashpass = hashpass;
	}

	public String getLastnamecontact() {
		return this.lastnamecontact;
	}

	public void setLastnamecontact(String lastnamecontact) {
		this.lastnamecontact = lastnamecontact;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setAccount(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setAccount(null);

		return client;
	}

	public List<Consultant> getConsultants() {
		return this.consultants;
	}

	public void setConsultants(List<Consultant> consultants) {
		this.consultants = consultants;
	}

	public Consultant addConsultant(Consultant consultant) {
		getConsultants().add(consultant);
		consultant.setAccount(this);

		return consultant;
	}

	public Consultant removeConsultant(Consultant consultant) {
		getConsultants().remove(consultant);
		consultant.setAccount(null);

		return consultant;
	}

}
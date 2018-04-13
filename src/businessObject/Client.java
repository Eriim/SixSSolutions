package businessObject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CLIENT database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int clientid;

	private String address;

	private String companyname;

	private String postalzipcode;

	private String shippingaddress;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="ACCOUNTID")
	private Account account;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="COUNTRYID")
	private Country country;

	//bi-directional many-to-one association to Provincestate
	@ManyToOne
	@JoinColumn(name="PROVINCESTATEID")
	private Provincestate provincestate;

	//bi-directional many-to-one association to Consultantclient
	@OneToMany(mappedBy="client")
	private List<Consultantclient> consultantclients;

	//bi-directional many-to-one association to Questionnaire
	@OneToMany(mappedBy="client")
	private List<Questionnaire> questionnaires;

	public Client() {
	}

	public int getClientid() {
		return this.clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getPostalzipcode() {
		return this.postalzipcode;
	}

	public void setPostalzipcode(String postalzipcode) {
		this.postalzipcode = postalzipcode;
	}

	public String getShippingaddress() {
		return this.shippingaddress;
	}

	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Provincestate getProvincestate() {
		return this.provincestate;
	}

	public void setProvincestate(Provincestate provincestate) {
		this.provincestate = provincestate;
	}

	public List<Consultantclient> getConsultantclients() {
		return this.consultantclients;
	}

	public void setConsultantclients(List<Consultantclient> consultantclients) {
		this.consultantclients = consultantclients;
	}

	public Consultantclient addConsultantclient(Consultantclient consultantclient) {
		getConsultantclients().add(consultantclient);
		consultantclient.setClient(this);

		return consultantclient;
	}

	public Consultantclient removeConsultantclient(Consultantclient consultantclient) {
		getConsultantclients().remove(consultantclient);
		consultantclient.setClient(null);

		return consultantclient;
	}

	public List<Questionnaire> getQuestionnaires() {
		return this.questionnaires;
	}

	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

	public Questionnaire addQuestionnaire(Questionnaire questionnaire) {
		getQuestionnaires().add(questionnaire);
		questionnaire.setClient(this);

		return questionnaire;
	}

	public Questionnaire removeQuestionnaire(Questionnaire questionnaire) {
		getQuestionnaires().remove(questionnaire);
		questionnaire.setClient(null);

		return questionnaire;
	}

	public Client(int clientid, String address, String companyname, String postalzipcode, String shippingaddress,
			String uniquelinkid, Account account, Country country, Provincestate provincestate) {
		
		this.clientid = clientid;
		this.address = address;
		this.companyname = companyname;
		this.postalzipcode = postalzipcode;
		this.shippingaddress = shippingaddress;
		
		this.account = account;
		this.country = country;
		this.provincestate = provincestate;
		
	}

}
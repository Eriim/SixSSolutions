package businessObject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CONSULTANT database table.
 * 
 */
@Entity
@NamedQuery(name="Consultant.findAll", query="SELECT c FROM Consultant c")
public class Consultant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int consultantid;

	private Boolean isadmin;

	private String workphone;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="ACCOUNTID")
	private Account account;

	//bi-directional many-to-one association to Consultantclient
	@OneToMany(mappedBy="consultant")
	private List<Consultantclient> consultantclients;

	public Consultant() {
	}

	public int getConsultantid() {
		return this.consultantid;
	}

	public void setConsultantid(int consultantid) {
		this.consultantid = consultantid;
	}

	public Boolean getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}

	public String getWorkphone() {
		return this.workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Consultantclient> getConsultantclients() {
		return this.consultantclients;
	}

	public void setConsultantclients(List<Consultantclient> consultantclients) {
		this.consultantclients = consultantclients;
	}

	public Consultantclient addConsultantclient(Consultantclient consultantclient) {
		getConsultantclients().add(consultantclient);
		consultantclient.setConsultant(this);

		return consultantclient;
	}

	public Consultantclient removeConsultantclient(Consultantclient consultantclient) {
		getConsultantclients().remove(consultantclient);
		consultantclient.setConsultant(null);

		return consultantclient;
	}

}
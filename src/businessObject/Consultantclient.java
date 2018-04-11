package businessObject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CONSULTANTCLIENT database table.
 * 
 */
@Entity
@NamedQuery(name="Consultantclient.findAll", query="SELECT c FROM Consultantclient c")
public class Consultantclient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int consultantclientid;

	@Temporal(TemporalType.DATE)
	private Date dateinit;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="CLIENTID")
	private Client client;

	//bi-directional many-to-one association to Consultant
	@ManyToOne
	@JoinColumn(name="CONSULTANTID")
	private Consultant consultant;

	public Consultantclient() {
	}

	public int getConsultantclientid() {
		return this.consultantclientid;
	}

	public void setConsultantclientid(int consultantclientid) {
		this.consultantclientid = consultantclientid;
	}

	public Date getDateinit() {
		return this.dateinit;
	}

	public void setDateinit(Date dateinit) {
		this.dateinit = dateinit;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Consultant getConsultant() {
		return this.consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

}
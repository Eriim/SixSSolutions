package businessObject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROVINCESTATE database table.
 * 
 */
@Entity
@NamedQuery(name="Provincestate.findAll", query="SELECT p FROM Provincestate p")
public class Provincestate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int provincestateid;

	private String name;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="provincestate")
	private List<Client> clients;

	public Provincestate() {
	}

	public int getProvincestateid() {
		return this.provincestateid;
	}

	public void setProvincestateid(int provincestateid) {
		this.provincestateid = provincestateid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setProvincestate(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setProvincestate(null);

		return client;
	}

}
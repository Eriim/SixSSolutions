package businessObject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the QUESTIONNAIRE database table.
 * 
 */
@Entity
@NamedQuery(name="Questionnaire.findAll", query="SELECT q FROM Questionnaire q")
public class Questionnaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionnaireid;

	@Temporal(TemporalType.DATE)
	private Date datecompleted;

	private Boolean iscompleted;
	
	private int score;

	//bi-directional many-to-one association to Questionanswer
	@OneToMany(mappedBy="questionnaire")
	private List<Questionanswer> questionanswers;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="CLIENTID")
	private Client client;

	public Questionnaire() {
	}

	public int getQuestionnaireid() {
		return this.questionnaireid;
	}

	public void setQuestionnaireid(int questionnaireid) {
		this.questionnaireid = questionnaireid;
	}

	public Date getDatecompleted() {
		return this.datecompleted;
	}

	public void setDatecompleted(Date datecompleted) {
		this.datecompleted = datecompleted;
	}

	public Boolean getIscompleted() {
		return this.iscompleted;
	}

	public void setIscompleted(Boolean iscompleted) {
		this.iscompleted = iscompleted;
	}

	public List<Questionanswer> getQuestionanswers() {
		return this.questionanswers;
	}

	public void setQuestionanswers(List<Questionanswer> questionanswers) {
		this.questionanswers = questionanswers;
	}

	public Questionanswer addQuestionanswer(Questionanswer questionanswer) {
		getQuestionanswers().add(questionanswer);
		questionanswer.setQuestionnaire(this);

		return questionanswer;
	}

	public Questionanswer removeQuestionanswer(Questionanswer questionanswer) {
		getQuestionanswers().remove(questionanswer);
		questionanswer.setQuestionnaire(null);

		return questionanswer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
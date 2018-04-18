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
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionnaireid;

	@Temporal(TemporalType.DATE)
	private Date datecompleted;

	private Boolean iscompleted;
	
	private int score;
	
	private int category1;
	
	private int category2;
	
	private int category3;
	
	private int category4;
	
	private int category5;

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

	public int getCategory1() {
		return category1;
	}

	public void setCategory1(int category1) {
		this.category1 = category1;
	}

	public int getCategory2() {
		return category2;
	}

	public void setCategory2(int category2) {
		this.category2 = category2;
	}

	public int getCategory3() {
		return category3;
	}

	public void setCategory3(int category3) {
		this.category3 = category3;
	}

	public int getCategory4() {
		return category4;
	}

	public void setCategory4(int category4) {
		this.category4 = category4;
	}

	public int getCategory5() {
		return category5;
	}

	public void setCategory5(int category5) {
		this.category5 = category5;
	}

}
package businessObject;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the QUESTIONANSWER database table.
 * 
 */
@Entity
@NamedQuery(name="Questionanswer.findAll", query="SELECT q FROM Questionanswer q")
public class Questionanswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionanswerid;

	//bi-directional many-to-one association to Answer
	@ManyToOne
	@JoinColumn(name="ANSWERID")
	private Answer answer;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="QUESTIONID")
	private Question question;

	//bi-directional many-to-one association to Questionnaire
	@ManyToOne
	@JoinColumn(name="QUESTIONNAIREID")
	private Questionnaire questionnaire;

	public Questionanswer() {
	}

	public int getQuestionanswerid() {
		return this.questionanswerid;
	}

	public void setQuestionanswerid(int questionanswerid) {
		this.questionanswerid = questionanswerid;
	}

	public Answer getAnswer() {
		return this.answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Questionnaire getQuestionnaire() {
		return this.questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

}
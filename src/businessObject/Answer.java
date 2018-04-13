package businessObject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ANSWER database table.
 * 
 */
@Entity
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int answerid;

	private String answertext;

	//bi-directional many-to-one association to Weight
	@ManyToOne
	@JoinColumn(name="WEIGHT")
	private Weight weight;

	//bi-directional many-to-one association to Questionanswer
	@OneToMany(mappedBy="answer")
	private List<Questionanswer> questionanswers;

	public Answer() {
	}

	public int getAnswerid() {
		return this.answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public String getAnswertext() {
		return this.answertext;
	}

	public void setAnswertext(String answertext) {
		this.answertext = answertext;
	}

	public Weight getWeight() {
		return this.weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public List<Questionanswer> getQuestionanswers() {
		return this.questionanswers;
	}

	public void setQuestionanswers(List<Questionanswer> questionanswers) {
		this.questionanswers = questionanswers;
	}

	public Questionanswer addQuestionanswer(Questionanswer questionanswer) {
		getQuestionanswers().add(questionanswer);
		questionanswer.setAnswer(this);

		return questionanswer;
	}

	public Questionanswer removeQuestionanswer(Questionanswer questionanswer) {
		getQuestionanswers().remove(questionanswer);
		questionanswer.setAnswer(null);

		return questionanswer;
	}

}
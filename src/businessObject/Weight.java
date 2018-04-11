package businessObject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the WEIGHT database table.
 * 
 */
@Entity
@NamedQuery(name="Weight.findAll", query="SELECT w FROM Weight w")
public class Weight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int weightid;

	private String weight;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="weight")
	private List<Answer> answers;

	public Weight() {
	}

	public int getWeightid() {
		return this.weightid;
	}

	public void setWeightid(int weightid) {
		this.weightid = weightid;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setWeight(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setWeight(null);

		return answer;
	}

}
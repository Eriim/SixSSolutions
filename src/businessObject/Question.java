package businessObject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the QUESTION database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionid;

	private String questiontext;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CATEGORYID")
	private Category category;

	//bi-directional many-to-one association to Questionanswer
	@OneToMany(mappedBy="question")
	private List<Questionanswer> questionanswers;

	public Question() {
	}

	public int getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getQuestiontext() {
		return this.questiontext;
	}

	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Questionanswer> getQuestionanswers() {
		return this.questionanswers;
	}

	public void setQuestionanswers(List<Questionanswer> questionanswers) {
		this.questionanswers = questionanswers;
	}

	public Questionanswer addQuestionanswer(Questionanswer questionanswer) {
		getQuestionanswers().add(questionanswer);
		questionanswer.setQuestion(this);

		return questionanswer;
	}

	public Questionanswer removeQuestionanswer(Questionanswer questionanswer) {
		getQuestionanswers().remove(questionanswer);
		questionanswer.setQuestion(null);

		return questionanswer;
	}

}
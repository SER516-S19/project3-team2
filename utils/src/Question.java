package src;
import java.util.List;

/**
 * 
 * Bean class for Question
 * @author leharbhatt
 * @version 1.0
 *
 */
public class Question {
	private String title;
	private List<String> options;
	private String correctAnswer;
	
	public Question(String title, List<String> options, String correctAnswer) {
		this.title = title;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}

	public Question() {}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}

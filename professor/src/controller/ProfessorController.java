package professor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import utils.*;

/**
 * 
 * @author leharbhatt
 *
 */

public class ProfessorController implements ActionListener {
	private String actionType;
	private List<Question> questionList;
	private static final String absolutePath = System.getProperty("user.dir")+"/quiz/quiz1.txt";
	
	public ProfessorController(String actionType, List<Question> questionList){
		super();
		this.actionType = actionType;
		this.questionList = questionList;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (this.actionType.equals(ConstantTable.CONTROLER_IDENTIFIER_CREATE_QUIZ)) {
			System.out.println(this.actionType);

			String questionListString = JsonUtils.getJsonStringFromQuestions(questionList);
			JsonUtils.writeStringToFile(absolutePath, questionListString);
		}
	}
}

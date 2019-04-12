package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import src.*;

/**
 * 
 * @author leharbhatt
 *
 */

public class ProfessorController implements ActionListener {
	private String actionType;
	private ArrayList<Question> questionList;
	private static final String quizPath = System.getProperty("user.home")+"/quizabc/";
	
	public ProfessorController(String actionType, ArrayList<Question> questionList){
		super();
		this.actionType = actionType;
		this.questionList = questionList;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		File directory = new File(quizPath);
	    boolean exists = directory.exists();
	    String absolutePath;
	    if(!exists){
	    	boolean file = new File(quizPath).mkdir();
	    }
	    
	    absolutePath = quizPath + "/BJP.json";
	    
	    
		if (this.actionType.equals(ConstantTable.CONTROLER_IDENTIFIER_CREATE_QUIZ)) {
			String questionListString = JsonUtils.getJsonStringFromQuestions(questionList);
			JsonUtils.writeStringToFile(absolutePath, questionListString);
		}
	}
}

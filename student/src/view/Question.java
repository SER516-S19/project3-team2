package src.view;

import java.util.ArrayList;

public class Question {
	
	String questionTxt;
	ArrayList<String> ansOptions;
	Question prev;
	Question next;
	
	public Question(String questionTxt, ArrayList<String> answers) {
		
		this.questionTxt = questionTxt; 
		this.ansOptions = new ArrayList<>(answers);
		
	}

}

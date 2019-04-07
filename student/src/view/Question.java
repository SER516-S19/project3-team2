package src.view;

import java.util.ArrayList;

public class Question {
	
	String questionTxt;
	ArrayList<String> ansOptions;
	String correctAns;
	//Question prev;
	Question next;
	
	public Question(String questionTxt, ArrayList<String> answers, String correctAns) {
		
		this.questionTxt = questionTxt; 
		this.ansOptions = new ArrayList<>(answers);
		this.correctAns = correctAns;
		
	}

}

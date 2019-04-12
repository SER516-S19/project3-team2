package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import src.*;
import src.view.AddQuestionView;

/**
 * 
 * @author leharbhatt
 *
 */

public class ProfessorController implements ActionListener {
	private String actionType;
	private ArrayList<Question> questionList;
	private static final String quizPath = System.getProperty("user.home")+"/quiz/";
	private static String quizName;
	private static String quesTitle;
	private AddQuestionView addView;
	private Question newQues;
	
	public ProfessorController(String actionType, ArrayList<Question> questionList, String quizName){
		super();
		this.actionType = actionType;
		this.questionList = questionList;
		ProfessorController.quizName = quizName;
	}
	
	public ProfessorController(AddQuestionView addView, String toBeDeleted, String actionType, ArrayList<Question> questionList){
		super();
		this.actionType = actionType;
		this.questionList = questionList;
		this.quesTitle = toBeDeleted;
		this.addView = addView;
	}
	
	public ProfessorController(AddQuestionView addView, Question toBeAdded, String actionType, ArrayList<Question> questionList){
		super();
		this.actionType = actionType;
		this.questionList = questionList;
		this.newQues = toBeAdded;
		this.addView = addView;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		File directory = new File(quizPath);
	    boolean exists = directory.exists();
	    String absolutePath;
	    if(!exists){
	    	boolean file = new File(quizPath).mkdir();
	    }
	    
	    absolutePath = quizPath + quizName + ConstantTable.JSON_EXTENSION;
	    
		if (this.actionType.equals(ConstantTable.CONTROLER_IDENTIFIER_CREATE_QUIZ)) {
			String questionListString = JsonUtils.getJsonStringFromQuestions(questionList);
			JsonUtils.writeStringToFile(absolutePath, questionListString);
		}else if (this.actionType.equals(ConstantTable.CONTROLER_IDENTIFIER_DELETE_QUESTION)){
			
			boolean flag = false;
			// for testing
			for(Question q : questionList) {
				System.out.println(q.getTitle());
			}
			
			if (questionList != null) {
				Iterator<Question> iter = questionList.iterator();

				while (iter.hasNext()) {
					Question question = iter.next();
					if (question.getTitle().equalsIgnoreCase(quesTitle)) {
						iter.remove();
						flag = true;
					}else {
						// if quesTitle not in list..
						JOptionPane.showMessageDialog(null, "You are deleting a question which does not exist",
								"Delete Message", JOptionPane.INFORMATION_MESSAGE);

					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "You cannot delete as there are no questions left to delete",
						"Delete Message", JOptionPane.INFORMATION_MESSAGE);
			}
			
			// for testing
			for(Question q : questionList) {
				System.out.println(q.getTitle());
			}
			
			addView.dispose();
			new AddQuestionView().setVisible(true);
			
			if(flag) {
				JOptionPane.showMessageDialog(null, "Question has been sucessfully deleted!",
						"Delete Message", JOptionPane.INFORMATION_MESSAGE);
	
			}
			
		} else if (this.actionType.equals(ConstantTable.CONTROLER_IDENTIFIER_ADD_QUESTION)) {
			questionList.add(newQues);
			addView.dispose();
			new AddQuestionView().setVisible(true);
			JOptionPane.showMessageDialog(null, "Question has been successfully Added!", " Add Message",
					JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	

	
	
}

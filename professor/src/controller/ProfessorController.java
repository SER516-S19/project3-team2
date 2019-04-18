package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import src.*;
import src.model.ProfessorModel;
import src.view.ProfessorQuestionView;

/**
 * Professor Controller listens to the actions performed by the user at
 * ProfessorQuestionView for a quiz. It passes the control to ProfessorModel to
 * add a question, delete a question and create a quiz in JSON format.
 * 
 * @author Lehar Bhatt,Aneesh Dalvi
 * @version (1.0)
 * @param (Question)
 */
public class ProfessorController {
	private ArrayList<Question> questionList;
	private static final String quizPath = System.getProperty("user.home") + "/quiz/";
	private static String quizName;
	private String quesTitle;
	private ProfessorQuestionView addView;
	private Question ques;
	ProfessorModel model = new ProfessorModel();

	public ProfessorController(String quizName, ProfessorQuestionView addView) {
		super();
		this.addView = addView;
		ProfessorController.quizName = quizName;
		questionList = new ArrayList<Question>();
		this.addView.btnCreateQuizAnd.addActionListener(new CreateActionListener());
		this.addView.btnAddMoreQuestions.addActionListener(new AddQuestionListener());
		this.addView.btnDeleteQuestions.addActionListener(new DeleteQuestionListener());
	}
	/**
	 * This method listens to the action performed by the components on UI. like
	 * create quiz, add and delete questions
	 * 
	 * @param event 
	 */
	class AddQuestionListener implements ActionListener {	
		@Override
		public void actionPerformed(ActionEvent e) {
			ques = addView.fetchQuestionDetails();
			String addStatus = model.addQuestion(ques);
			if (ConstantTable.BLANK.equals(addStatus)) {
				JOptionPane.showMessageDialog(null, "Please fill all the details to add a question.", "Validation",
						JOptionPane.ERROR_MESSAGE);
			} else if (ConstantTable.NOT_FOUND.equals(addStatus)) {
				JOptionPane.showMessageDialog(null, "Your correct ans is not matching with any options", "Validation",
						JOptionPane.ERROR_MESSAGE);
			} else {
				questionList.add(ques);
				addView.questionField.setText("");
				addView.answerField.setText("");
				for(int i=0;i<4;i++) {
					addView.optionField[i].setText("");
				}
				JOptionPane.showMessageDialog(null, "Question has been successfully Added!", " Add Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	
	class DeleteQuestionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			addView.fetchQuestionDetails();
			String deleteStatus = model.deleteQuestion(questionList, addView.getQuesTitle());
			if (ConstantTable.NOT_FOUND.equals(deleteStatus)) {
				JOptionPane.showMessageDialog(null, "You are deleting a question which does not exist",
						"Delete Message", JOptionPane.INFORMATION_MESSAGE);
			} else if (ConstantTable.EMPTY.equals(deleteStatus)) {
				JOptionPane.showMessageDialog(null, "There are no questions to delete.", "Delete Message",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (ConstantTable.BLANK.equals(deleteStatus)) {
				JOptionPane.showMessageDialog(null, "The question title cannot be blank", "Delete Message",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Question has been sucessfully deleted!", "Delete Message",
						JOptionPane.INFORMATION_MESSAGE);
			}

			questionList.add(ques);
			addView.questionField.setText("");
			addView.answerField.setText("");
			for(int i=0;i<4;i++) {
				addView.optionField[i].setText("");
			}
			
		}
		
	}
	
	
	class CreateActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.print("I am here");
			File directory = new File(quizPath);
			boolean exists = directory.exists();
			String absolutePath;
			if (!exists) {
				boolean file = new File(quizPath).mkdir();
			}

			absolutePath = quizPath + quizName + ConstantTable.JSON_EXTENSION;
			String createStatus = model.createQuiz(questionList, absolutePath);
			if (ConstantTable.CREATED.equals(createStatus)) {
				JOptionPane.showMessageDialog(null, "Quiz successfully created at " + absolutePath, "Validation",
						JOptionPane.INFORMATION_MESSAGE);
				addView.dispose();
			} else {
				JOptionPane.showMessageDialog(null,
						"There is no questions added to quiz. Please add some question before creating a quiz",
						"Validation", JOptionPane.ERROR_MESSAGE);
			}
		}
		}
	

	
}

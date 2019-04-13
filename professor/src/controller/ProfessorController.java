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
public class ProfessorController implements ActionListener {
	private String actionType;
	private ArrayList<Question> questionList;
	private static final String quizPath = System.getProperty("user.home") + "/quiz/";
	private static String quizName;
	private String quesTitle;
	private ProfessorQuestionView addView;
	private Question ques;

	public ProfessorController(String actionType, ArrayList<Question> questionList, String quizName,
			ProfessorQuestionView addView) {
		super();
		this.actionType = actionType;
		this.questionList = questionList;
		this.addView = addView;
		ProfessorController.quizName = quizName;
	}

	public ProfessorController(ProfessorQuestionView addView, Question toBeAdded, String actionType,
			ArrayList<Question> questionList) {
		super();
		this.actionType = actionType;
		this.questionList = questionList;
		this.ques = toBeAdded;
		this.addView = addView;
	}

	/**
	 * This method listens to the action performed by the components on UI. like
	 * create quiz, add and delete questions
	 * 
	 * @param event 
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		ProfessorModel model = new ProfessorModel();
		File directory = new File(quizPath);
		boolean exists = directory.exists();
		String absolutePath;
		if (!exists) {
			boolean file = new File(quizPath).mkdir();
		}

		absolutePath = quizPath + quizName + ConstantTable.JSON_EXTENSION;

		if (this.actionType.equals(ConstantTable.CONTROLER_IDENTIFIER_CREATE_QUIZ)) {

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
		} else if (this.actionType.equals(ConstantTable.CONTROLER_IDENTIFIER_DELETE_QUESTION)) {
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

			addView.dispose();
			new ProfessorQuestionView().setVisible(true);

		} else if (this.actionType.equals(ConstantTable.CONTROLER_IDENTIFIER_ADD_QUESTION)) {

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
				addView.dispose();
				new ProfessorQuestionView().setVisible(true);
				JOptionPane.showMessageDialog(null, "Question has been successfully Added!", " Add Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

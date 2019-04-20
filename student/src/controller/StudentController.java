package student.controller;

import student.model.StudentModel;
import student.view.CompletionMessage;
import student.view.StudentMainWindow;
import student.view.TakeQuizView;
import utils.*;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Student controller to get questions from studentModel and populate
 * TakeQuizView window.
 * 
 * @author Subhradeep/Manikanta
 * @version 1.1
 * @date 04/09/2019
 */

public class StudentController {
	private StudentModel studentModel;
	private StudentMainWindow studentMainWin;
	private TakeQuizView takeQuiz;
	private CompletionMessage message;
	private ArrayList<Question> questionList;
	public JButton completionButton = new JButton("Ok");

	public StudentController(StudentModel theModel, StudentMainWindow mainWinView, TakeQuizView takeQuizView,
			CompletionMessage theMessage) {
		this.studentModel = theModel;
		this.studentMainWin = mainWinView;
		this.takeQuiz = takeQuizView;
		this.message = theMessage;
		mainWinView.setQuizNames(theModel.getQuizNames());
		String[] quizChoices = mainWinView.getQuizChoices();
		mainWinView.setQuizField(quizChoices);
		this.studentMainWin.selectQuizListener(new OkListener());
		this.takeQuiz.nextQuestionListener(new NextListener());
	}

	class OkListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String quizName;
			try {
				quizName = studentMainWin.getQuizName();
				questionList = studentModel.getQuestionList(quizName);
				takeQuiz.setQuizLabel(studentMainWin.getQuizName());
				takeQuiz.setQuestionField("<html>"+questionList.get(0).getTitle()+"</html>");
				for (int i = 0; i < 4; i++) {
					takeQuiz.setRadioOption(questionList.get(0).getOptions().get(i), i);
				}
				takeQuiz.setVisible(true);
			} catch (NumberFormatException ex) {
				System.out.println(ex);
				studentMainWin.displayErrorMessage("The quiz cannot be opened");
			}
		}
	}

	class NextListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String ans = "";
				for (int i = 0; i < 4; i++) {
					if (takeQuiz.getSelected(i)) {
						ans = takeQuiz.getRadioOption(i);
						break;
					}
				}
				checkQuiz(ans, questionList.get(0).getCorrectAnswer());
				if (!questionList.isEmpty()) {
					takeQuiz.setQuizLabel(studentMainWin.getQuizName());
					takeQuiz.setQuestionField("<html>"+questionList.get(0).getTitle()+"</html>");
					for (int i = 0; i < 4; i++) {
						takeQuiz.setRadioOption(questionList.get(0).getOptions().get(i), i);
					}
				} else {
					message.MessageDisplay(completionButton);
					message.setVisible(true);
					completionButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							StudentMainWindow DashBoard = new StudentMainWindow();
							message.dispose();
							takeQuiz.dispose();
						}
					});
				}
				takeQuiz.buttonGroup.clearSelection();
			} catch (NumberFormatException ex) {
				System.out.println(ex);
				takeQuiz.displayErrorMessage("The quiz cannot be opened");
			}
		}

		/**
		 * function to check for correct answers
		 * 
		 * @param selectedAnswer
		 * @param CorrectAnswer
		 */
		void checkQuiz(String selectedAnswer, String CorrectAnswer) {
			if (selectedAnswer == "") {
				Question firstQuestion = questionList.get(0);
				questionList.remove(0);
				questionList.add(firstQuestion);

			}
			if (selectedAnswer.equals(CorrectAnswer)) {
				questionList.remove(0);

			} else {
				Question firstQuestion = questionList.get(0);
				questionList.remove(0);
				questionList.add(firstQuestion);
			}
		}
	}
}

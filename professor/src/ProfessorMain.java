package src;

import src.controller.ProfessorController;
import src.view.ProfessorMainWindow;
import src.view.ProfessorQuestionView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * ProfessorMain is used to launch the Professor Quiz application.
 * 
 * @author Yuti Desai
 * @version (1.0)
 * @param (Question)
 */
public class ProfessorMain {

	private static String quizName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorMainWindow mainWindow = new ProfessorMainWindow();
					mainWindow.setVisible(true);
					ProfessorMainWindow.getCreatequiz().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String quizNameText = mainWindow.getQuizName().getText();
							if (!quizNameText.isEmpty()) {
								ProfessorMain.quizName = quizNameText;
								mainWindow.dispose();
								getQuestionPage();
							} else {
								JOptionPane.showMessageDialog(null, "Please provide a Quiz Title Please", "Validation",
										JOptionPane.ERROR_MESSAGE);
							}
						}

						private void getQuestionPage() {
							ProfessorQuestionView questionView = new ProfessorQuestionView(ProfessorMain.quizName);
							questionView.setVisible(true);
							ProfessorQuestionView.getBtnaddmorequestions()
									.addActionListener(new ProfessorController(questionView, questionView.getQuestion(),
											ConstantTable.CONTROLER_IDENTIFIER_ADD_QUESTION,
											questionView.getQuestionsList()));
							ProfessorQuestionView.getBtncreatequizand()
									.addActionListener(new ProfessorController(ConstantTable.CONTROLER_IDENTIFIER_CREATE_QUIZ,
											questionView.getQuestionsList(), quizName, questionView));
							ProfessorQuestionView.getBtndeletequestions()
									.addActionListener(new ProfessorController(questionView, questionView.getQuestion(),
											ConstantTable.CONTROLER_IDENTIFIER_DELETE_QUESTION,
											questionView.getQuestionsList()));
						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

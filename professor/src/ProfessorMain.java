package src;

import src.controller.ProfessorController;
import src.view.ProfessorMainWindow;
import src.view.ProfessorQuestionView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * ProfessorMain is used to launch the Professor Quiz application.
 * 
 * @author Yuti Desai
 * @version (1.0)
 * @param (Question)
 */
public class ProfessorMain {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorMainWindow mainWindow = new ProfessorMainWindow();
					mainWindow.setVisible(true);
					JButton createQuiz = mainWindow.getCreateQuiz();
					createQuiz.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String quizNameText = mainWindow.getQuizName().getText();
							if (!quizNameText.isEmpty()) {
								ProfessorQuestionView view = new ProfessorQuestionView(quizNameText);
								view.setVisible(true);
								mainWindow.dispose();
								addListeners(quizNameText,view);
							} else {
								JOptionPane.showMessageDialog(null, "Please provide a Quiz Title", "Validation",
										JOptionPane.ERROR_MESSAGE);
							}
						}

						private void addListeners(String quizNameText,ProfessorQuestionView view ) {
							ProfessorController controller = new ProfessorController(quizNameText, view);
							
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

import utils.*;
import student.view.*;
import student.model.*;
import student.controller.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the main to launch the student application
 *
 * @author Vaibhav/Surya
 * @version 1.1
 * @date 04/09/2019
 */

public class StudentMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMainWindow mainWindow = new StudentMainWindow();
					mainWindow.setVisible(true);
					TakeQuizView theView = new TakeQuizView();
					StudentModel theModel = new StudentModel();
					CompletionMessage theMessage = new CompletionMessage();
					StudentController theController = new StudentController(theModel, mainWindow, theView, theMessage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

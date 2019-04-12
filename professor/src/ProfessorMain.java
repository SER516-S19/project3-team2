package src;

import src.view.ProfessorMainWindow;
import java.awt.*;

public class ProfessorMain {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorMainWindow mainWindow = new ProfessorMainWindow();
					mainWindow.setVisible(true);								
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

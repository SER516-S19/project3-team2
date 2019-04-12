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
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int screenHeight = screenSize.height;
					int screenWidth = screenSize.width;
					mainWindow.setSize((7*screenWidth) / 15, (8*screenHeight) / 9);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

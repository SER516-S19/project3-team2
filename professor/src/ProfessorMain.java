import professor.view.ProfessorMainWindow;
import java.awt.*;

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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ProfMainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfMainWindow frame = new ProfMainWindow();
					frame.setVisible(true);
					frame.getContentPane().setBackground(new Color(255, 255, 204));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProfMainWindow() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1820, 900);
		setTitle("Professor Window For Quiz Application");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton createQuiz = new JButton("Click Here To Create Quiz");
		createQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddQuestions().setVisible(true);
			}
		});
		createQuiz.setFont(new Font("Courier", Font.BOLD, 25));
	    createQuiz.setBounds(700, 400, 420, 50);
	    createQuiz.setForeground(Color.BLACK);
	    createQuiz.setBackground(new Color(51, 204, 204));
	    createQuiz.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(createQuiz);
		
		JLabel welcomeLabel = new JLabel("Hello Professor!");
		welcomeLabel.setFont(new Font("Courier", Font.BOLD, 70));
	    welcomeLabel.setBounds(570, 200, 900, 80);
	    welcomeLabel.setForeground(Color.BLACK);
		contentPane.add(welcomeLabel);
	}

}

package src.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProfMainWindow extends JFrame {

	private JPanel contentPane;
	private Image image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfMainWindow frame = new ProfMainWindow();
					frame.setVisible(true);
					
					
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
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(490, 50, 900, 950);
		setTitle("Professor Window For Quiz Application");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));		
		setContentPane(contentPane);		
		setUndecorated(true);
		
		JButton createQuiz = new JButton(" Create Quiz");
		createQuiz.setToolTipText("Click Me");
		createQuiz.setIcon(new ImageIcon("C:\\Users\\desai\\Desktop\\SER516\\project3-team2\\image\\teacher.gif"));
		createQuiz.setBounds(238, 436, 434, 216);
		createQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddQuestions().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		createQuiz.setFont(new Font("Monospaced", Font.BOLD, 30));
	    createQuiz.setForeground(new Color(255, 255, 255));
	    createQuiz.setBackground(new Color(51, 204, 204));
		contentPane.add(createQuiz);
		
		JLabel welcomeLabel = new JLabel("Hello Professor!");
		welcomeLabel.setBounds(119, 239, 672, 80);
		welcomeLabel.setFont(new Font("Courier", Font.BOLD, 70));
	    welcomeLabel.setForeground(new Color(240, 248, 255));
		contentPane.add(welcomeLabel);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {				
				dispose();
			}
		});
		lblX.setBackground(new Color(255, 192, 203));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(816, 0, 84, 80);
		contentPane.add(lblX);
		
		JLabel lblNewLabel = new JLabel("Quiz Window For Professor");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(27, 0, 816, 61);
		contentPane.add(lblNewLabel);
		
	}	
}

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
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

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
		contentPane.setEnabled(false);
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));		
		setContentPane(contentPane);		
		setUndecorated(true);
		
		JButton createQuiz = new JButton(" Create Quiz");
		createQuiz.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		createQuiz.setToolTipText("Click Me");
		createQuiz.setIcon(new ImageIcon("image\\teacher.gif"));
		createQuiz.setBounds(238, 436, 434, 216);
		createQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddQuestions().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		createQuiz.setFont(new Font("Monospaced", Font.BOLD, 30));
	    createQuiz.setForeground(new Color(255, 255, 255));
	    createQuiz.setBackground(new Color(129, 207, 224));
		contentPane.add(createQuiz);
		
		JLabel welcomeLabel = new JLabel("Hello Professor!");
		welcomeLabel.setBounds(119, 239, 672, 80);
		welcomeLabel.setFont(new Font("Courier", Font.BOLD, 70));
	    welcomeLabel.setForeground(new Color(240, 248, 255));
		contentPane.add(welcomeLabel);
		
		JButton btnNewButton = new JButton("  Quiz Desktop Application - Professor Window");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(89, 171, 227));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 0, 823, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 102, 102));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(822, 0, 78, 41);
		contentPane.add(btnNewButton_1);
		
	}	
}

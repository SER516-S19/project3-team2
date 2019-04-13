package src.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

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
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;

public class ProfessorMainWindow extends JFrame {
	private Image image;
	private JPanel contentPane;
	int x, y;
	int screenHeight, screenWidth;
	int frameHeight, frameWidth;
	private JTextField quizName;

	/**
	 * Create the frame.
	 */
	public ProfessorMainWindow() {	
		getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		System.out.println(screenHeight +","+screenWidth);
		frameHeight = (7 * screenWidth) / 15;		
		frameWidth = (8 * screenHeight) / 9;
		setSize(1000, 1000);
		System.out.println(frameHeight +","+frameWidth);
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setEnabled(false);
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));		
		setContentPane(contentPane);		
		setUndecorated(true);
		
		JButton createQuiz = new JButton(" Create Quiz");
		createQuiz.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		createQuiz.setToolTipText("Click Me");
		createQuiz.setIcon(new ImageIcon("image\\teacher.gif"));
		createQuiz.setBounds(frameWidth/4, 510, 434, 216);
		createQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddQuestionView(quizName.getText()).setVisible(true);
				dispose();			
			}
		});
		contentPane.setLayout(null);
		createQuiz.setFont(new Font("Monospaced", Font.BOLD, 30));
	    createQuiz.setForeground(new Color(255, 255, 255));
	    createQuiz.setBackground(new Color(0, 181, 204));
		contentPane.add(createQuiz);
		
		JLabel welcomeLabel = new JLabel("Hello Professor!");
		welcomeLabel.setBounds(frameWidth/8, 212, 672, 80);
		welcomeLabel.setFont(new Font("Courier", Font.BOLD, 70));
	    welcomeLabel.setForeground(new Color(240, 248, 255));
		contentPane.add(welcomeLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(37, 116, 169));
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x, yy-y);
			}
		});
	
		panel.setBounds(0, 0, 900, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel closeLabel = new JLabel("X");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		
		
		closeLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setBounds(846, 0, 54, 43);
		panel.add(closeLabel);
		
		JLabel windowLabel = new JLabel("  Quiz Desktop Application - Professor Window");
		windowLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
		windowLabel.setForeground(Color.WHITE);
		windowLabel.setBounds(0, 0, 525, 43);
		panel.add(windowLabel);
		
		JLabel quizNameLabel = new JLabel("To Create Quiz Enter Quiz Title");
		quizNameLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
		quizNameLabel.setForeground(Color.WHITE);
		quizNameLabel.setBounds(frameWidth/6, 355, 563, 36);
		contentPane.add(quizNameLabel);
		
		quizName = new JTextField();
		quizName.setFont(new Font("Monospaced", Font.PLAIN, 24));
		quizName.setBounds(frameWidth/4, 420, 434, 43);
		contentPane.add(quizName);
		quizName.setColumns(10);
		
	}	
}

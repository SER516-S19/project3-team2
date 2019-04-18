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
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;

/**
 * ProfessorMainview displays the components of the first page of the
 * application.It captures the quiz title entered by the professor and passes
 * the control to ProfessorController for further action.
 * 
 * @author Yuti Desai, Palak Chugh
 * @version (1.0)
 * @param (Question)
 */
public class ProfessorMainWindow extends JFrame {
	private JPanel contentPane;
	private int positionX, positionY;
	private int screenHeight, screenWidth;
	private int frameHeight, frameWidth;	
	private JTextField quizName;

	private static final JButton createQuiz = new JButton(" Create Quiz");

	public ProfessorMainWindow() {
		getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		frameHeight = (7 * screenWidth) / 15;
		frameWidth = (8 * screenHeight) / 9;
		setBounds(450,20,frameHeight, frameWidth);
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setEnabled(false);
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		setUndecorated(true);

		createQuiz.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		createQuiz.setToolTipText("Click Me");
		createQuiz.setIcon(new ImageIcon("image\\teacher.gif"));
		createQuiz.setBounds(frameWidth / 4, (8 * frameHeight) / 14, (8 * frameWidth / 18), frameHeight / 4);
		contentPane.setLayout(null);
		createQuiz.setFont(new Font("Monospaced", Font.BOLD, frameWidth / 30));
		createQuiz.setForeground(new Color(255, 255, 255));
		createQuiz.setBackground(new Color(0, 181, 204));
		contentPane.add(createQuiz);

		JLabel welcomeLabel = new JLabel("Hello Professor!");
		welcomeLabel.setBounds(frameWidth / 8, frameHeight / 5, 672, 80);
		welcomeLabel.setFont(new Font("Courier", Font.BOLD, frameWidth / 14));
		welcomeLabel.setForeground(new Color(240, 248, 255));
		contentPane.add(welcomeLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(37, 116, 169));

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				positionX = e.getX();
				positionY = e.getY();
			}
		});

		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int dragPositionX = e.getXOnScreen();
				int dragPositionY = e.getYOnScreen();
				setLocation(dragPositionX - positionX, dragPositionY - positionY);
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
		closeLabel.setFont(new Font("Tahoma", Font.BOLD, frameWidth / 24));
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setBounds(90 * frameWidth / 102, 0, 54, 43);
		panel.add(closeLabel);

		JLabel windowLabel = new JLabel("  Quiz Desktop Application - Professor Window");
		windowLabel.setFont(new Font("Monospaced", Font.BOLD, frameWidth / 50));
		windowLabel.setForeground(Color.WHITE);
		windowLabel.setBounds(0, 0, (2 * frameWidth) / 3, frameHeight / 20);
		panel.add(windowLabel);

		JLabel quizNameLabel = new JLabel("To Create Quiz Enter Quiz Title");
		quizNameLabel.setFont(new Font("Monospaced", Font.BOLD, frameWidth / 31));
		quizNameLabel.setForeground(Color.WHITE);
		quizNameLabel.setBounds(frameWidth / 6, (11 * frameHeight) / 27, 563, 36);
		contentPane.add(quizNameLabel);

		quizName = new JTextField();
		quizName.setFont(new Font("Monospaced", Font.PLAIN, 24));
		quizName.setBounds(frameWidth / 4, (9 * frameHeight) / 19, (8 * frameWidth / 18), frameHeight / 19);
		contentPane.add(quizName);
		quizName.setColumns(10);
		setQuizName(quizName);
	}

	public JTextField getQuizName() {
		return quizName;
	}

	public void setQuizName(JTextField quizName) {
		this.quizName = quizName;
	}

	public static JButton getCreatequiz() {
		return createQuiz;
	}
}

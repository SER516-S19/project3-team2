package student.view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import student.model.StudentModel;
import student.view.TakeQuizView;
import student.controller.StudentController;

/**
 * Student's quiz selection view
 * 
 * @author Sakshi/Subhradeep
 * @version 1.2
 * @date 04/09/2019
 */

public class StudentMainWindow extends JFrame {
	private String[] choices = new String[100];
	private JComboBox<String> quizList = new JComboBox<String>();
	private JButton okBtn = new JButton("OK");
	private JLabel arrow = new JLabel("kjghkug");
	int x, y;
	int screenHeight, screenWidth;
	int frameHeight, frameWidth;

	public StudentMainWindow() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		frameHeight = (7 * screenWidth) / 15;		
		frameWidth = (8 * screenHeight) / 9;
		setSize(frameHeight, frameWidth);
		JPanel contentPane = new JPanel();
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, frameHeight, frameWidth);
		setTitle("Student Window For Quiz Application");
		setResizable(false);
		contentPane.setEnabled(false);
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		quizList.setVisible(true);
		contentPane.add(quizList);
		quizList.setFont(new Font("Monospaced", Font.BOLD, 30));
		quizList.setBounds(frameWidth/4, (7*frameHeight)/14, 305, 49);
		quizList.setForeground(new Color(255, 255, 255));
		quizList.setBackground(new Color(0, 181, 204));
		quizList.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		okBtn.setEnabled(false);
		contentPane.add(okBtn);
		okBtn.setFont(new Font("Monospaced", Font.BOLD, 24));
		okBtn.setBounds(frameWidth/4, (9*frameHeight)/14, 305, 49);
		okBtn.setForeground(Color.WHITE);
		okBtn.setBackground(new Color(0, 181, 204));
		okBtn.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		okBtn.setEnabled(true);
		contentPane.add(quizList);

		JLabel welcomeLabel = new JLabel("Hello Student!");
		welcomeLabel.setBounds(frameWidth/5, (4*frameHeight)/14, 700, 49);
		welcomeLabel.setFont(new Font("Courier", Font.BOLD, 50));
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
				setLocation(xx - x, yy - y);
			}
		});

		panel.setBounds(0, 0, 900, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel closeBtn = new JLabel("X");
		closeBtn.setForeground(Color.WHITE);
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 30));
		closeBtn.setHorizontalAlignment(SwingConstants.CENTER);
		closeBtn.setBounds(8*frameWidth/9, 0, 54, 43);
		panel.add(closeBtn);

		JLabel header = new JLabel("  Quiz Desktop Application - Student Window");
		header.setFont(new Font("Monospaced", Font.BOLD, 16));
		header.setForeground(Color.WHITE);
		header.setBounds(0, 0, (8*frameWidth/7), frameHeight/20);
		panel.add(header);
	}

	public void setQuizNames(String[] quizNames) {
		this.choices = quizNames;
	}

	public String[] getQuizChoices() {
		return this.choices;
	}

	public void setQuizField(String[] choices) {
		this.quizList.removeAll();
		for (int i = 0; i < choices.length; i++)
			this.quizList.addItem(choices[i]);
	}

	public String getQuizName() {
		return quizList.getSelectedItem().toString();
	}

	public void selectQuizListener(ActionListener listenForOkButton) {
		okBtn.addActionListener(listenForOkButton);
	}

	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}

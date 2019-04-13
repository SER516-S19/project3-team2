package src.view;

import src.model.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Class for Quiz Attempt window
 * 
 * @author Subhradeep/Manikanta
 * @version 1.1
 * @date 04/09/2019
 */

public class TakeQuizView extends JFrame {
	int pos_x, pos_y;
	private JLabel lblQuizName = new JLabel();
	private JLabel questionField = new JLabel();
	private JRadioButton[] optionField = new JRadioButton[4];
	JButton btnNext = new JButton("Next");
	public ButtonGroup buttonGroup = new ButtonGroup();
	int screenHeight, screenWidth;
	int frameHeight, frameWidth;

	public TakeQuizView() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		frameHeight = (7 * screenWidth) / 15;		
		frameWidth = (8 * screenHeight) / 9;
		setSize(frameHeight, frameWidth);
		JPanel contentPane;
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, frameHeight, frameWidth);
		setUndecorated(true);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 5, 1, 834);
		contentPane.add(layeredPane);

		lblQuizName.setFont(new Font("Courier", Font.BOLD, frameWidth/18));
		lblQuizName.setBounds(frameWidth/6, frameHeight/5, frameWidth/2, frameHeight/22);
		lblQuizName.setForeground(Color.WHITE);
		contentPane.add(lblQuizName);

		questionField.setFont(new Font("Courier", Font.BOLD, frameWidth/28));
		questionField.setBounds(frameWidth/6, (10*frameHeight)/34, (3*frameWidth)/5, frameHeight/5);
		questionField.setForeground(Color.WHITE);
		contentPane.add(questionField);

		for (int i = 0; i < 4; i++) {
			optionField[i] = new JRadioButton();
			optionField[i].setBounds(frameWidth/6, (10*frameHeight)/18 + (i * 60), (3*frameWidth)/5, frameHeight/25);
			optionField[i].setFont(new Font("Courier", Font.PLAIN, 24));
			buttonGroup.add(optionField[i]);
			contentPane.add(optionField[i]);
		}

		JButton btnGiveUp = new JButton("GiveUp");
		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
			}
		});

		btnGiveUp.setBounds(frameWidth/6, (9*frameHeight)/10, (10*frameWidth)/35,frameHeight/20);
		btnGiveUp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGiveUp.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnGiveUp.setForeground(new Color(255, 255, 255));
		btnGiveUp.setBackground(new Color(0, 181, 204));
		contentPane.add(btnGiveUp);
		questionField.setEnabled(false);
		btnNext.setBounds((20*frameWidth)/41, (9*frameHeight)/10, (10*frameWidth)/35,frameHeight/20);
		btnNext.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNext.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setBackground(new Color(0, 181, 204));
		contentPane.add(btnNext);

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 0, 900, 43);
		panel2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel2.setBackground(new Color(37, 116, 169));
		panel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pos_x = e.getX();
				pos_y = e.getY();
			}
		});

		panel2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int drag_x = e.getXOnScreen();
				int drag_y = e.getYOnScreen();
				setLocation(drag_x - pos_x, drag_y - pos_y);
			}
		});

		contentPane.add(panel2);
		panel2.setLayout(null);
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
		panel2.add(closeBtn);

		JLabel header = new JLabel("  Quiz Desktop Application - Student Window");
		header.setFont(new Font("Monospaced", Font.BOLD, 16));
		header.setForeground(Color.WHITE);
		header.setBounds(0, 0, (8*frameWidth/7), frameHeight/20);
		panel2.add(header);
	}

	public void setQuizLabel(String quizName) {
		this.lblQuizName.setText(quizName);
	}

	public void setQuestionField(String questionText) {
		this.questionField.setText(questionText);
	}

	public void setRadioOption(String ansOptionText, int index) {
		optionField[index].setText(ansOptionText);
	}

	public String getRadioOption(int index) {
		return optionField[index].getText();
	}

	public boolean getSelected(int index) {
		return optionField[index].isSelected();
	}

	public void nextQuestionListener(ActionListener listenForNextButton) {
		btnNext.addActionListener(listenForNextButton);
	}

	public void displayCompletionMessage(String completionMsg, String title) {
		JOptionPane.showMessageDialog(null, completionMsg, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}

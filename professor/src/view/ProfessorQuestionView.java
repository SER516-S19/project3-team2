package src.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.List;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;

import src.controller.ProfessorController;
import src.*;

/**
 * ProfessorQuestionView displays the components of the question view of the
 * application.It captures the question title,options and correct answer entered
 * by the professor and passes the control to ProfessorController for further
 * action.
 * 
 * @author Yuti Desai, Palak Chugh
 * @version (1.0)
 * @param (Question)
 */
@SuppressWarnings("serial")
public class ProfessorQuestionView extends JFrame {

	private static final JButton btnAddMoreQuestions = new JButton("Add Details");
	private static final JButton btnDeleteQuestions = new JButton("Delete Details");
	private static final JButton btnCreateQuizAnd = new JButton("Create Quiz And Exit");
	
	protected static final String MouseEvent = null;
	private JPanel contentPane;
	private JTextField questionField;
	private JTextField answerField;
	private JTextField[] optionField;
	private static String quizName;
	private String quesTitle;
	int screenHeight, screenWidth;
	private int positionX, positionY;
	int frameHeight, frameWidth;
	private Question question;
	
	private ArrayList<Question> questionsList = new ArrayList<Question>();


	public ProfessorQuestionView(String quizName) throws HeadlessException {
		this();
		ProfessorQuestionView.quizName = quizName;
	}

	
	public ProfessorQuestionView() {
		getContentPane().setLayout(null);
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		frameHeight = (7 * screenWidth) / 15;
		frameWidth = (8 * screenHeight) / 9;
		setBounds(450,20,frameHeight, frameWidth);
		getContentPane().setLayout(null);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddQuestionDetails = new JLabel("Add Question Details");
		lblAddQuestionDetails.setBounds(frameWidth / 5, frameHeight / 7, frameWidth / 2, frameHeight / 30);
		lblAddQuestionDetails.setFont(new Font("Courier", Font.BOLD, frameWidth / 24));
		lblAddQuestionDetails.setForeground(new Color(255, 255, 255));
		contentPane.add(lblAddQuestionDetails);

		questionField = new JTextField();
		questionField.setFont(new Font("Monospaced", Font.PLAIN, frameWidth / 40));
		questionField.setBounds((2 * frameWidth / 5), (10 * frameHeight) / 41, (11 * frameWidth) / 28,
				frameHeight / 22);
		contentPane.add(questionField);
		questionField.setColumns(10);

		optionField = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			optionField[i] = new JTextField();
			optionField[i].setBounds((2 * frameWidth / 5), (frameHeight) / 3 + (i * frameHeight/11), (11 * frameWidth) / 28,
					frameHeight / 22);
			optionField[i].setFont(new Font("Monospaced", Font.PLAIN, frameWidth / 40));
			contentPane.add(optionField[i]);
			optionField[i].setColumns(10);
		}

		answerField = new JTextField();
		answerField.setBounds((2 * frameWidth / 5), (13 * frameWidth) / 20, (11 * frameWidth) / 28, frameHeight / 22);
		answerField.setFont(new Font("Monospaced", Font.PLAIN, frameWidth / 40));
		contentPane.add(answerField);
		answerField.setColumns(10);

		btnAddMoreQuestions.setBounds((2 * frameWidth / 14), (10 * frameHeight) / 12, (10 * frameWidth) / 31,
				frameHeight / 17);
		btnAddMoreQuestions.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAddMoreQuestions.setFont(new Font("Monospaced", Font.BOLD, frameWidth / 38));
		btnAddMoreQuestions.setForeground(new Color(255, 255, 255));
		btnAddMoreQuestions.setBackground(new Color(0, 181, 204));

		setQuestion(fetchQuestionDetails());
		contentPane.add(btnAddMoreQuestions);

		btnDeleteQuestions.setBounds((8 * frameWidth / 17), (10 * frameHeight) / 12, (10 * frameWidth) / 31,
				frameHeight / 17);
		btnDeleteQuestions.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDeleteQuestions.setFont(new Font("Monospaced", Font.BOLD, frameWidth / 38));
		btnDeleteQuestions.setBackground(new Color(0, 181, 204));
		btnDeleteQuestions.setForeground(new Color(255, 255, 255));
		contentPane.add(btnDeleteQuestions);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds((2 * frameWidth / 14), (10 * frameHeight) / 41, (11 * frameWidth) / 28, frameHeight / 22);
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setFont(new Font("Monospaced", Font.BOLD, frameWidth / 35));
		contentPane.add(lblQuestion);

		JLabel label = new JLabel("");
		label.setBounds(509, 704, 46, 14);
		contentPane.add(label);
		JLabel[] answerChoice = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			answerChoice[i] = new JLabel("Option" + (i + 1));
			answerChoice[i].setBounds((2 * frameWidth / 14), (frameHeight) / 3 + (i * frameHeight/11), (11 * frameWidth) / 28,
					frameHeight / 22);
			answerChoice[i].setForeground(new Color(255, 255, 255));
			answerChoice[i].setFont(new Font("Monospaced", Font.BOLD, frameWidth / 35));
			contentPane.add(answerChoice[i]);
		}

		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds((2 * frameWidth / 14), (13 * frameWidth) / 20, (11 * frameWidth) / 28,
				frameHeight / 22);
		lblCorrectAnswer.setForeground(new Color(255, 255, 255));
		lblCorrectAnswer.setFont(new Font("Monospaced", Font.BOLD, frameWidth / 35));
		contentPane.add(lblCorrectAnswer);
		btnCreateQuizAnd.setBounds((2 * frameWidth / 14), (20 * frameHeight) / 22, (15 * frameWidth) / 23,
				frameHeight / 17);
		btnCreateQuizAnd.setForeground(Color.WHITE);
		btnCreateQuizAnd.setFont(new Font("Monospaced", Font.BOLD, frameWidth / 38));
		btnCreateQuizAnd.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCreateQuizAnd.setBackground(new Color(0, 181, 204));
		contentPane.add(btnCreateQuizAnd);

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 0, 900, 43);
		panel2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel2.setBackground(new Color(37, 116, 169));
		panel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				positionX = e.getX();
				positionY = e.getY();
			}
		});

		panel2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int dragPositionX = e.getXOnScreen();
				int dragPositionY = e.getYOnScreen();
				setLocation(dragPositionX - positionX, dragPositionY - positionY);
			}
		});
		contentPane.add(panel2);
		panel2.setLayout(null);
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
		panel2.add(closeLabel);

		JLabel pquizTitleLabel = new JLabel("  Quiz Desktop Application - Professor Window");
		pquizTitleLabel.setFont(new Font("Monospaced", Font.BOLD, frameWidth / 50));
		pquizTitleLabel.setForeground(Color.WHITE);
		pquizTitleLabel.setBounds(0, 0, (8 * frameWidth / 7), frameHeight / 20);
		panel2.add(pquizTitleLabel);
	}

	/*
	 * This method is used to fetch the question details entered by the professor
	 * and adds them to the Question list.
	 */
	public Question fetchQuestionDetails() {
		String strQuestionField = questionField.getText();
		String strAnswerField = answerField.getText();
		setQuesTitle(strQuestionField);

		List<String> optionsList = new ArrayList<String>();

		for (int i = 0; i < 4; i++) {
			optionsList.add(optionField[i].getText());
		}
		Question newQues = new Question(strQuestionField, optionsList, strAnswerField);
		return newQues;
	}

	public String getQuesTitle() {
		return quesTitle;
	}

	public void setQuesTitle(String quesTitle) {
		this.quesTitle = quesTitle;
	}

	public ArrayList<Question> getQuestionsList() {
		return questionsList;
	}


	public void setQuestionsList(ArrayList<Question> questionsList) {
		this.questionsList = questionsList;
	}


	public static JButton getBtnaddmorequestions() {
		return btnAddMoreQuestions;
	}


	public static JButton getBtndeletequestions() {
		return btnDeleteQuestions;
	}


	public static JButton getBtncreatequizand() {
		return btnCreateQuizAnd;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}
}

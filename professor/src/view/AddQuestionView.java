package src.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.border.BevelBorder;

import src.controller.ProfessorController;
import src.*;

@SuppressWarnings("serial")
public class AddQuestionView extends JFrame {

	public AddQuestionView(String quizName) throws HeadlessException {
		this();
		AddQuestionView.quizName = quizName;
	}

	protected static final String MouseEvent = null;
	private JPanel contentPane;
	private JTextField questionField;
	private JTextField answerField;
	private JTextField[] optionField;
	

	private static String quizName;
	private String quesTitle;
	int screenHeight, screenWidth;
	private int x1, y1;
	int frameHeight, frameWidth;
	// This is the list which has questions..
	private static ArrayList<Question> questionsList = new ArrayList<Question>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestionView frame = new AddQuestionView();
					frame.setVisible(true);
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int screenHeight = screenSize.height;
					int screenWidth = screenSize.width;
					frame.setSize((7 * screenWidth) / 15, (8 * screenHeight) / 9);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddQuestionView() {
		getContentPane().setLayout(null);
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		//System.out.println(screenHeight +","+screenWidth);
		frameHeight = (7 * screenWidth) / 15;		
		frameWidth = (8 * screenHeight) / 9;
		setSize(frameHeight, frameWidth);
		//System.out.println(frameHeight +","+frameWidth);
		getContentPane().setLayout(null);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddQuestionDetails = new JLabel("Add Question Details");
		lblAddQuestionDetails.setBounds(frameWidth/5, 112, 607, 80);
		lblAddQuestionDetails.setFont(new Font("Courier", Font.BOLD, 40));
		lblAddQuestionDetails.setForeground(new Color(255, 255, 255));
		contentPane.add(lblAddQuestionDetails);

		questionField = new JTextField();
		questionField.setFont(new Font("Monospaced", Font.PLAIN, 22));
		questionField.setBounds((2*frameWidth/5), 250, 372, 35);
		contentPane.add(questionField);
		questionField.setColumns(10);

		optionField = new JTextField[4];

		for (int i = 0; i < 4; i++) {
			optionField[i] = new JTextField();
			optionField[i].setBounds((2*frameWidth/5), 330 + (i * 81), 372, 38);
			contentPane.add(optionField[i]);
			optionField[i].setColumns(10);
		}

		answerField = new JTextField();
		answerField.setBounds((2*frameWidth/5), 650, 372, 38);
		answerField.setFont(new Font("Monospaced", Font.PLAIN, 22));
		contentPane.add(answerField);
		answerField.setColumns(10);

		JButton btnAddMoreQuestions = new JButton("Add Question");
		btnAddMoreQuestions.setBounds((2*frameWidth/14), 742, 305, 49);
		btnAddMoreQuestions.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAddMoreQuestions.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnAddMoreQuestions.setForeground(new Color(255, 255, 255));
		btnAddMoreQuestions.setBackground(new Color(0, 181, 204));
		
		// this will fetch the question details and check for validations
		Question newQuestion = fetchQuestionDetails();
		
		btnAddMoreQuestions.addActionListener(new ProfessorController(this, newQuestion , ConstantTable.CONTROLER_IDENTIFIER_ADD_QUESTION, questionsList));
	
		contentPane.add(btnAddMoreQuestions);

		JButton btnDeleteQuestions = new JButton("Delete Question");
		btnDeleteQuestions.setBounds((8*frameWidth/17), 742, 305, 49);
		btnDeleteQuestions.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDeleteQuestions.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnDeleteQuestions.setBackground(new Color(0, 181, 204));
		btnDeleteQuestions.setForeground(new Color(255, 255, 255));

		btnDeleteQuestions.addActionListener(new ProfessorController(this, getQuesTitle(), ConstantTable.CONTROLER_IDENTIFIER_DELETE_QUESTION, questionsList));
		contentPane.add(btnDeleteQuestions);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds((2*frameWidth/14), 247, 125, 38);
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblQuestion);

		JLabel label = new JLabel("");
		label.setBounds(509, 704, 46, 14);
		contentPane.add(label);
		JLabel[] answerChoice = new JLabel[4];
		for(int i=0; i<4;i++) {
			answerChoice[i] = new JLabel("Option"+(i+1));
			answerChoice[i].setBounds((2*frameWidth/14), 327+(81*i), 125, 38);
			answerChoice[i].setForeground(new Color(255, 255, 255));
			answerChoice[i].setFont(new Font("Monospaced", Font.BOLD, 25));
			contentPane.add(answerChoice[i]);
		}
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds((2*frameWidth/14), 649, 210, 38);
		lblCorrectAnswer.setForeground(new Color(255, 255, 255));
		lblCorrectAnswer.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblCorrectAnswer);

		JButton btnCreateQuizAnd = new JButton("Create Quiz And Exit");
		btnCreateQuizAnd.setBounds((2*frameWidth/14), 807, 620, 49);

		btnCreateQuizAnd.addActionListener(new ProfessorController(ConstantTable.CONTROLER_IDENTIFIER_CREATE_QUIZ, questionsList,quizName));
		btnCreateQuizAnd.setForeground(Color.WHITE);
		btnCreateQuizAnd.setFont(new Font("Monospaced", Font.BOLD, 24));
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
				x1 = e.getX();
				y1 = e.getY();
			}
		});

		panel2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx1 = e.getXOnScreen();
				int yy1 = e.getYOnScreen();
				setLocation(xx1 - x1, yy1 - y1);
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
		
		closeLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setBounds(846, 0, 54, 43);
		panel2.add(closeLabel);

		JLabel pquizTitleLabel = new JLabel("  Quiz Desktop Application - Professor Window");
		pquizTitleLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
		pquizTitleLabel.setForeground(Color.WHITE);
		pquizTitleLabel.setBounds(0, 0, 525, 43);
		panel2.add(pquizTitleLabel);
	}

	private Question fetchQuestionDetails() {
		// fetching the question details
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

	
}

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
	private int x1, y1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(490, 50, 900, 950);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Professor Window For Quiz Application");
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddQuestionDetails = new JLabel("Add Question Details Here");
		lblAddQuestionDetails.setBounds(144, 112, 607, 80);
		lblAddQuestionDetails.setFont(new Font("Courier", Font.BOLD, 40));
		lblAddQuestionDetails.setForeground(new Color(255, 255, 255));
		contentPane.add(lblAddQuestionDetails);

		questionField = new JTextField();
		questionField.setFont(new Font("Monospaced", Font.PLAIN, 22));
		questionField.setBounds(393, 250, 358, 35);
		contentPane.add(questionField);
		questionField.setColumns(10);

		optionField = new JTextField[4];

		for (int i = 0; i < 4; i++) {
			optionField[i] = new JTextField();
			optionField[i].setBounds(393, 330 + (i * 81), 358, 38);
			contentPane.add(optionField[i]);
			optionField[i].setColumns(10);
		}

		answerField = new JTextField();
		answerField.setBounds(393, 650, 358, 38);
		answerField.setFont(new Font("Monospaced", Font.PLAIN, 22));
		contentPane.add(answerField);
		answerField.setColumns(10);

		JButton btnAddMoreQuestions = new JButton("Add Question");
		btnAddMoreQuestions.setBounds(144, 742, 305, 49);
		btnAddMoreQuestions.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAddMoreQuestions.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnAddMoreQuestions.setForeground(new Color(255, 255, 255));
		btnAddMoreQuestions.setBackground(new Color(0, 181, 204));
		btnAddMoreQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String strQuestionField = questionField.getText();
				List<String> optionsList = new ArrayList<String>();

				for (int i = 0; i < 4; i++) {
					optionsList.add(optionField[i].getText());
				}
				String strAnswerField = answerField.getText();

				Question question = new Question(strQuestionField, optionsList, strAnswerField);
				questionsList.add(question);
				dispose();
				new AddQuestionView().setVisible(true);
				JOptionPane.showMessageDialog(null, "Question has been successfully Added!", " Add Message",
						JOptionPane.INFORMATION_MESSAGE);
		}});
		contentPane.add(btnAddMoreQuestions);

		JButton btnDeleteQuestions = new JButton("Delete Question");
		btnDeleteQuestions.setBounds(459, 742, 292, 49);
		btnDeleteQuestions.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDeleteQuestions.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnDeleteQuestions.setBackground(new Color(0, 181, 204));
		btnDeleteQuestions.setForeground(new Color(255, 255, 255));
		btnDeleteQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strQuestionField = questionField.getText();

				if (questionsList != null) {
					Iterator<Question> iter = questionsList.iterator();

					while (iter.hasNext()) {
						Question question = iter.next();
						if (question.getTitle().equalsIgnoreCase(strQuestionField)) {
							iter.remove();
							JOptionPane.showMessageDialog(null, "Question has been sucessfully deleted!",
									"Delete Message", JOptionPane.INFORMATION_MESSAGE);
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "You cannot delete as there are no questions left to delete",
							"Delete Message", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		contentPane.add(btnDeleteQuestions);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(144, 247, 125, 38);
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblQuestion);

		JLabel label = new JLabel("");
		label.setBounds(509, 704, 46, 14);
		contentPane.add(label);
		JLabel[] answerChoice = new JLabel[4];
		for(int i=0; i<4;i++) {
			answerChoice[i] = new JLabel("Option"+(i+1));
			answerChoice[i].setBounds(144, 327+(81*i), 125, 38);
			answerChoice[i].setForeground(new Color(255, 255, 255));
			answerChoice[i].setFont(new Font("Monospaced", Font.BOLD, 25));
			contentPane.add(answerChoice[i]);
		}
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds(144, 649, 210, 38);
		lblCorrectAnswer.setForeground(new Color(255, 255, 255));
		lblCorrectAnswer.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblCorrectAnswer);

		JButton btnCreateQuizAnd = new JButton("Create Quiz And Exit");
		btnCreateQuizAnd.setBounds(144, 807, 607, 49);

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
}

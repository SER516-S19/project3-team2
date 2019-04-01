package src.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AddQuestions extends JFrame {

	private JPanel contentPane;
	private JTextField questionField;
	private JTextField answerField;
	private JTextField option1Field;
	private JTextField option2Field;
	private JTextField option3Field;
	private JTextField option4Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestions frame = new AddQuestions();
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
	public AddQuestions() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(43, 50, 1825, 900);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Professor Window For Quiz Application");
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 5, 1, 834);
		contentPane.add(layeredPane);
		
		JLabel lblAddQuestionDetails = new JLabel("Add Question Details Here");
		lblAddQuestionDetails.setFont(new Font("Courier", Font.BOLD, 40));
		lblAddQuestionDetails.setBounds(560, 130, 900, 80);
		lblAddQuestionDetails.setForeground(Color.BLACK);
		contentPane.add(lblAddQuestionDetails);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(555, 279, 69, 20);
		contentPane.add(lblQuestion);
		
		JLabel lblOption_1 = new JLabel("Option1");
		lblOption_1.setBounds(555, 338, 69, 20);
		contentPane.add(lblOption_1);
		
		JLabel lblOption_2 = new JLabel("Option2");
		lblOption_2.setBounds(555, 392, 69, 20);
		contentPane.add(lblOption_2);
		
		JLabel lblOption_3 = new JLabel("Option3");
		lblOption_3.setBounds(555, 443, 69, 20);
		contentPane.add(lblOption_3);
		
		JLabel lblOption_4 = new JLabel("Option4");
		lblOption_4.setBounds(555, 496, 69, 20);
		contentPane.add(lblOption_4);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds(555, 546, 125, 20);
		contentPane.add(lblCorrectAnswer);
		
		questionField = new JTextField();
		questionField.setBounds(712, 276, 544, 26);
		contentPane.add(questionField);
		questionField.setColumns(10);
		
		option1Field = new JTextField();
		option1Field.setBounds(711, 335, 146, 26);
		contentPane.add(option1Field);
		option1Field.setColumns(10);
		
		option2Field = new JTextField();
		option2Field.setBounds(711, 389, 146, 26);
		contentPane.add(option2Field);
		option2Field.setColumns(10);
		
		option3Field = new JTextField();
		option3Field.setBounds(711, 440, 146, 26);
		contentPane.add(option3Field);
		option3Field.setColumns(10);
		
		option4Field = new JTextField();
		option4Field.setBounds(711, 493, 146, 26);
		contentPane.add(option4Field);
		option4Field.setColumns(10);
		
		answerField = new JTextField();
		answerField.setBounds(711, 543, 146, 26);
		contentPane.add(answerField);
		answerField.setColumns(10);
		
		JButton btnAddMoreQuestions = new JButton("Add More Questions");
		btnAddMoreQuestions.setBounds(555, 614, 177, 29);
		contentPane.add(btnAddMoreQuestions);
		
		JButton btnDeleteQuestions = new JButton("Delete Questions");
		btnDeleteQuestions.setBounds(763, 614, 182, 29);
		contentPane.add(btnDeleteQuestions);
		
		}
}

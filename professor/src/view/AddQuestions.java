package src.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Question;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddQuestions extends JFrame {

	private JPanel contentPane;
	private JTextField questionField;
	private JTextField answerField;
	private JTextField option1Field;
	private JTextField option2Field;
	private JTextField option3Field;
	private JTextField option4Field;
	
	// this is the list which has questions..
	private ArrayList<Question> questionsList = new ArrayList<Question>();

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
		getContentPane().setLayout(null);
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
		questionField.setBounds(712, 276, 391, 35);
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
		
		JButton btnAddMoreQuestions = new JButton("Add Question");
		btnAddMoreQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: actions to be performed on add button clicked..
				
				String strQuestionField = questionField.getText();
				String strOption1Field = option1Field.getText();
				String strOption2Field = option1Field.getText();
				String strOption3Field = option1Field.getText();
				String strOption4Field = option1Field.getText();
				String strAnswerField = answerField.getText();
				
				List<String> optionsList = new ArrayList<String>();
				optionsList.add(strOption1Field);
				optionsList.add(strOption2Field);
				optionsList.add(strOption3Field);
				optionsList.add(strOption4Field);
			
				// creating a new question object
				Question q1 =  new Question(strQuestionField, optionsList, strAnswerField);
				
				// adding question object to arraylist of questions whenever add button is clicked
				questionsList.add(q1);
				
			}
		});
		btnAddMoreQuestions.setBounds(555, 614, 177, 29);
		contentPane.add(btnAddMoreQuestions);
		
		JButton btnDeleteQuestions = new JButton("Delete Question");
		btnDeleteQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: actions to be performed on delete button clicked..
				
				// building the current question to be deleted..
				String strQuestionField = questionField.getText();
				String strOption1Field = option1Field.getText();
				String strOption2Field = option1Field.getText();
				String strOption3Field = option1Field.getText();
				String strOption4Field = option1Field.getText();
				String strAnswerField = answerField.getText();
				
				List<String> optionsList = new ArrayList<String>();
				optionsList.add(strOption1Field);
				optionsList.add(strOption2Field);
				optionsList.add(strOption3Field);
				optionsList.add(strOption4Field);
			
				// creating a new question object to be deleted..
				Question q1 =  new Question(strQuestionField, optionsList, strAnswerField);
				
				// removing the question object to arraylist of questions whenever add button is clicked
				if (questionsList != null) {
					questionsList.remove(q1);
				}else {
					System.out.print("You cannot delete as there are no questions left to delete");
				}
				
				
				// creating temp list of questions.
				//System.out.println("Creating temp list for delete functionality");
				
				List<String> tempQ1Options = new ArrayList<String>();
				tempQ1Options.add("OptionQ1 1");
				tempQ1Options.add("OptionQ1 2");
				tempQ1Options.add("OptionQ1 3");
				tempQ1Options.add("OptionQ1 4");
				
				List<String> tempQ2Options = new ArrayList<String>();
				tempQ2Options.add("OptionQ2 1");
				tempQ2Options.add("OptionQ2 2");
				tempQ2Options.add("OptionQ2 3");
				tempQ2Options.add("OptionQ2 4");

				List<String> tempQ3Options = new ArrayList<String>();
				tempQ2Options.add("OptionQ3 1");
				tempQ2Options.add("OptionQ3 2");
				tempQ2Options.add("OptionQ3 3");
				tempQ2Options.add("OptionQ3 4");
				
				
				//Question q1 = new Question("Ques 1", tempQ1Options, "OptionQ1 2");
				Question q2 = new Question("Ques 2", tempQ2Options, "OptionQ2 4");
				Question q3 = new Question("Ques 3", tempQ3Options, "OptionQ3 3");
				ArrayList<Question> tempList  = new ArrayList<Question>();
				
				//tempList.add(q1);
				tempList.add(q2);
				tempList.add(q3);
				
				for (Question q : tempList) {
					//System.out.println(q.getTitle());
				}
				//System.out.println("After Deleting the selected question.....");
				//System.out.println("Assuming to delete ques2 from the list");
				
				// get quest2
				
				// when delete button is clicked.. delete the question from this templist list
				
				tempList.remove(q2);
				for (Question q : tempList) {
					//System.out.println(q.getTitle());
				}
				
			}
		});
		btnDeleteQuestions.setBounds(763, 614, 182, 29);
		contentPane.add(btnDeleteQuestions);
		
		JLabel label = new JLabel("");
		label.setBounds(509, 704, 46, 14);
		contentPane.add(label);
		
		}
}

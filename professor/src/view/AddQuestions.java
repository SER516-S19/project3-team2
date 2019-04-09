package src.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utils.Question;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;

public class AddQuestions extends JFrame {

	protected static final String MouseEvent = null;
	private JPanel contentPane;
	private JTextField questionField;
	private JTextField questionField_1;
	private JTextField answerField;
	private JTextField option1Field;
	private JTextField option2Field;
	private JTextField option3Field;
	private JTextField option4Field;
	int x1, y1;
	
	// this is the list which has questions..
	ProfMainWindow mwobject = new ProfMainWindow();
	private static ArrayList<Question> questionsList = new ArrayList<Question>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestions frame = new AddQuestions();
					frame.setVisible(true);
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int screenHeight = screenSize.height;
					int screenWidth = screenSize.width;
					frame.setSize((7*screenWidth) / 15, (8*screenHeight) / 9);
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
		
		JLabel lblOption_1 = new JLabel("Option1");
		lblOption_1.setBounds(144, 327, 125, 38);
		lblOption_1.setForeground(new Color(255, 255, 255));
		lblOption_1.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblOption_1);
		
		questionField = new JTextField();
		questionField.setBounds(393, 252, 358, 35);
		contentPane.add(lblOption_1);
		
		questionField_1 = new JTextField();
		questionField_1.setBounds(393, 250, 358, 35);
		contentPane.add(questionField_1);
		questionField_1.setColumns(10);
		
		option1Field = new JTextField();
		option1Field.setBounds(393, 330, 358, 38);
		contentPane.add(option1Field);
		option1Field.setColumns(10);
		
		option2Field = new JTextField();
		option2Field.setBounds(393, 411, 358, 38);
		contentPane.add(option2Field);
		option2Field.setColumns(10);
		
		option3Field = new JTextField();
		option3Field.setBounds(393, 489, 358, 38);
		contentPane.add(option3Field);
		option3Field.setColumns(10);
		
		option4Field = new JTextField();
		option4Field.setBounds(393, 569, 358, 38);
		contentPane.add(option4Field);
		option4Field.setColumns(10);
		
		answerField = new JTextField();
		answerField.setBounds(393, 650, 358, 38);
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
			
				Question q1 =  new Question(strQuestionField, optionsList, strAnswerField);
				
				questionsList.add(q1);
				dispose();
			    new AddQuestions().setVisible(true);
				JOptionPane.showMessageDialog(null,"Question has been successfully Added!","Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
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
						Question q = iter.next();
					    if (q.getTitle().equalsIgnoreCase(strQuestionField)) {
					    	iter.remove();
					    }
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"You cannot delete as there are no questions left to delete","Delete Message", JOptionPane.INFORMATION_MESSAGE);
				}
		
			}
		});
		contentPane.add(btnDeleteQuestions);
		
		JLabel label = new JLabel("");
		label.setBounds(509, 704, 46, 14);
		contentPane.add(label);
		
		JLabel lblOption = new JLabel("Option2");
		lblOption.setBounds(144, 408, 125, 38);
		lblOption.setForeground(new Color(255, 255, 255));
		lblOption.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblOption);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(144, 247, 125, 38);
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblQuestion);
		
		JLabel lblOption_2 = new JLabel("Option3");
		lblOption_2.setBounds(144, 486, 125, 38);
		lblOption_2.setForeground(new Color(255, 255, 255));
		lblOption_2.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblOption_2);
		
		JLabel lblOption_3 = new JLabel("Option4");
		lblOption_3.setBounds(144, 569, 125, 38);
		lblOption_3.setForeground(new Color(255, 255, 255));
		lblOption_3.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblOption_3);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds(144, 649, 210, 38);
		lblCorrectAnswer.setForeground(new Color(255, 255, 255));
		lblCorrectAnswer.setFont(new Font("Monospaced", Font.BOLD, 25));
		contentPane.add(lblCorrectAnswer);
		
		JButton btnCreateQuizAnd = new JButton("Create Quiz And Exit");
		btnCreateQuizAnd.setBounds(144, 807, 607, 49);
		btnCreateQuizAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
			
				Question q1 =  new Question(strQuestionField, optionsList, strAnswerField);
				questionsList.add(q1);
				JOptionPane.showMessageDialog(null,"Quiz has been successfully Created!","Message", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
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
				setLocation(xx1-x1, yy1-y1);
			}
		});
		contentPane.add(panel2);
		panel2.setLayout(null);
	
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
	
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(846, 0, 54, 43);
		panel2.add(lblNewLabel_2);
	
		JLabel lblNewLabel2 = new JLabel("  Quiz Desktop Application - Professor Window");
		lblNewLabel2.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNewLabel2.setForeground(Color.WHITE);
		lblNewLabel2.setBounds(0, 0, 525, 43);
		panel2.add(lblNewLabel2);
	}
}

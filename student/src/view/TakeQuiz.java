package student.view;

import student.controller.StudentController;
import student.model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import utility.utils.*;

public class TakeQuiz extends JFrame {
    private JPanel contentPane;
    private JTextField questionField;
    private JRadioButton option1Field;
    private JRadioButton option2Field;
    private JRadioButton option3Field;
    private JRadioButton option4Field;
    ArrayList<Question> questionList;
    Question currQuestion;
    int quesIdx = 0;

    
    public TakeQuiz(ArrayList<Question> questionList) {
    	
    	//boolean nextPressed = false;
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(43, 50, 1825, 900);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Quiz 1");
        setResizable(false);
        setVisible(true);

        if (questionList.isEmpty()) {
        	contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        JLabel lblQuestion = new JLabel("No question available in this quiz!");
	        contentPane.add(lblQuestion);
        
	        JButton returnBtn = new JButton("Return");
	        returnBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            }
	        });
	        returnBtn.setBounds(650, 614, 140, 29);
	        contentPane.add(returnBtn);

        }
        else {
        	
	        	
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	
	        JLayeredPane layeredPane = new JLayeredPane();
	        layeredPane.setBounds(5, 5, 1, 834);
	        contentPane.add(layeredPane);
	
	        JLabel lblAddQuestionDetails = new JLabel("Quiz 1");
	        lblAddQuestionDetails.setFont(new Font("Courier", Font.BOLD, 40));
	        lblAddQuestionDetails.setBounds(660, 130, 900, 80);
	        lblAddQuestionDetails.setForeground(Color.BLACK);
	        contentPane.add(lblAddQuestionDetails);

        	currQuestion = questionList.get(quesIdx);
		
	        JLabel lblQuestion = new JLabel(currQuestion.getTitle());
	        lblQuestion.setBounds(600, 279, 69, 20);
	        contentPane.add(lblQuestion);
	
	        questionField = new JTextField();
	        questionField.setBounds(700, 276, 391, 35);
	        contentPane.add(questionField);
	        questionField.setColumns(10);
	        
	        for (int i = 0; i < currQuestion.getOptions().size(); i++) {
		        option1Field = new JRadioButton(currQuestion.getOptions().get(i));
		        option1Field.setBounds(711, 335, 146, 26);
		        contentPane.add(option1Field);
	        }
	        
	        JButton btnPrevious = new JButton("Previous");
	        btnPrevious.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // TODO: actions to be performed on add button clicked..
	            }
	        });
	        btnPrevious.setBounds(400, 614, 140, 29);
	        contentPane.add(btnPrevious);
	
	        JButton btnGiveUp = new JButton("GiveUp");
	        btnGiveUp.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // TODO: actions to be performed on add button clicked..
	            }
	        });
	        btnGiveUp.setBounds(650, 614, 140, 29);
	        contentPane.add(btnGiveUp);
	
	        JButton btnSubmit = new JButton("Submit");
	        btnSubmit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // TODO: actions to be performed on add button clicked..
	            }
	        });
	        btnSubmit.setBounds(900, 614, 140, 29);
	        contentPane.add(btnSubmit);
	
	        questionField.setEnabled(false);
	        JButton btnNext = new JButton("Next");
	        btnNext.setBounds(1150, 614, 140, 29);
	        contentPane.add(btnNext);
	        btnNext.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                // TODO: actions to be performed on delete button clicked..
	            	
	            	questionList.add(questionList.get(quesIdx));
	            	questionList.remove(quesIdx);
	            	
	            	
	            }
	        });
		     
        }
    }
}

package src.view;

import src.model.*;
import utils.Question;
import utils.JsonUtils;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TakeQuiz extends JFrame {
    private JPanel contentPane;
    private JTextField questionField;
    private JRadioButton [] optionField = new JRadioButton[4];
    String quizName;
    List<Question> Questions;
    public TakeQuiz(String quizName) {
    	this.quizName = quizName;
    	Questions = new ArrayList<Question>();
    	JsonUtils utils = new JsonUtils();
    	Questions = utils.getQuestionsFromJsonString(quizName);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(43, 50, 1825, 900);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(quizName);
        setResizable(false);
        setVisible(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(5, 5, 1, 834);
        contentPane.add(layeredPane);

        JLabel lblAddQuestionDetails = new JLabel(quizName);
        lblAddQuestionDetails.setFont(new Font("Courier", Font.BOLD, 40));
        lblAddQuestionDetails.setBounds(660, 130, 900, 80);
        lblAddQuestionDetails.setForeground(Color.BLACK);
        contentPane.add(lblAddQuestionDetails);

        JLabel lblQuestion = new JLabel("Question");
        lblQuestion.setBounds(600, 279, 69, 20);
        contentPane.add(lblQuestion);

        questionField = new JTextField();
        questionField.setBounds(700, 276, 391, 35);
        contentPane.add(questionField);
        questionField.setColumns(10);
        
        for(int i = 0; i < 4; i++) {
        	optionField[i] = new JRadioButton("Option " + i);
            optionField[i].setBounds(711, 335, 146, 26);
            contentPane.add(optionField[i]);
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
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO: actions to be performed on delete button clicked..
                if(Questions.size()==0) {
                	
                }
                
            	String ans = "";
                for(int i = 0; i < 4; i++) {
                	if(optionField[i].isSelected()) {
                		ans = optionField[i].getText();
                	}
                }
            	checkQuiz(ans, Questions.get(0).getCorrectAnswer());
                
            }
        });
        btnNext.setBounds(1150, 614, 140, 29);
        contentPane.add(btnNext);

    }
    
    void checkQuiz(String selectedAnswer, String CorrectAnswer) {
    	if(selectedAnswer == "") {
    		Question firstQuestion = Questions.get(0);
    		Questions.add(firstQuestion);
    		
    	}
    	if(selectedAnswer == CorrectAnswer) {
    		Questions.remove(0);
    		
    	}
    	else {
    		Question firstQuestion = Questions.get(0);
    		Questions.add(firstQuestion);
    	}
    }
}

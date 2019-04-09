/* 
Student's view for taking the quiz
@author Sakshi/Subhradeep 
@version 1.2
@date 04/09/2019
*/

package student.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TakeQuiz extends JFrame {	
	private JLabel lblQuizName = new JLabel();
    private JLabel questionField = new JLabel();;
    private JRadioButton option1Field = new JRadioButton();
    private JRadioButton option2Field = new JRadioButton();
    private JRadioButton option3Field = new JRadioButton();
    private JRadioButton option4Field = new JRadioButton();
    JButton btnNext = new JButton("Next");

    public TakeQuiz() {
    	
    	JPanel contentPane;
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(25, 25, 1025, 500);
        
        setResizable(false);
	        	
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(5, 5, 1, 834);
        contentPane.add(layeredPane);

        lblQuizName.setFont(new Font("Courier", Font.BOLD, 40));
        lblQuizName.setBounds(310, 50, 600, 80);
        lblQuizName.setForeground(Color.BLACK);
        contentPane.add(lblQuizName);

        questionField.setBounds(320, 186, 300, 50);
        questionField.setForeground(Color.BLACK);
        contentPane.add(questionField);
        
        option1Field.setBounds(320, 230, 146, 26);
        option2Field.setBounds(320, 265, 146, 26);
        option3Field.setBounds(320, 295, 146, 26);
        option4Field.setBounds(320, 325, 146, 26);
        contentPane.add(option1Field);
        contentPane.add(option2Field);
        contentPane.add(option3Field);
        contentPane.add(option4Field);
        
        JButton btnGiveUp = new JButton("GiveUp");
        btnGiveUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JComponent comp = (JComponent) e.getSource();
            	Window win = SwingUtilities.getWindowAncestor(comp);
            	win.dispose();
            }
        });
        btnGiveUp.setBounds(300, 414, 140, 29);
        contentPane.add(btnGiveUp);

        questionField.setEnabled(false);
        
        btnNext.setBounds(500, 414, 140, 29);
        contentPane.add(btnNext);
    }
    
    public void setQuizLabel(String quizName) {
    	this.lblQuizName.setText(quizName);
    }
    
    public void setQuestionField(String questionText) {
    	this.questionField.setText(questionText);
    }
    public void setRadioOption1(String ansOptionText) {
    	option1Field.setText(ansOptionText);
    }
    public void setRadioOption2(String ansOptionText) {
    	option2Field.setText(ansOptionText);
    }
    public void setRadioOption3(String ansOptionText) {
    	option3Field.setText(ansOptionText);
    }
    public void setRadioOption4(String ansOptionText) {
    	option4Field.setText(ansOptionText);
    }
    
    public void nextQuestionListener(ActionListener listenForNextButton){
    	btnNext.addActionListener(listenForNextButton);
    }
    
    public void displayCompletionMessage(String completionMsg, String title){
    	JOptionPane.showMessageDialog(null,completionMsg,title, JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
